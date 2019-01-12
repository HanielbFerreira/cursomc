package br.com.cursomc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cursomc.domains.Cliente;
import br.com.cursomc.domains.ItemPedido;
import br.com.cursomc.domains.PagamentoComBoleto;
import br.com.cursomc.domains.Pedido;
import br.com.cursomc.domains.Produto;
import br.com.cursomc.enums.EstadoPagamento;
import br.com.cursomc.exceptions.ObjectNotFoundException;
import br.com.cursomc.repositories.ItemPedidoRepository;
import br.com.cursomc.repositories.PagamentoRepository;
import br.com.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoService produtoSerive;
	
	@Autowired
	private ClienteService clienteService;
	
	public Pedido find(Integer id) {
		return pedidoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" + id + ", Tipo: " + Pedido.class.getName()));
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		Cliente c = clienteService.find(obj.getCliente().getId());
		obj.setId(null);
		obj.setCliente(c);
		obj.setInstante(new Date());
		obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		} 
		
		obj = pedidoRepository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			Produto produto = produtoSerive.find(ip.getProduto().getId());
			ip.setPreco(produto.getPreco());
			ip.getProduto().setNome(produto.getNome());
			ip.setPedido(obj);
		}
		
		System.out.println(obj);
		
		itemPedidoRepository.saveAll(obj.getItens());
		
		return obj;
	}

}
