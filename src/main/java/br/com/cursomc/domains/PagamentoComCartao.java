package br.com.cursomc.domains;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.cursomc.enums.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento, Integer numeroDeParcelas, Pedido pedido) {
		super(id, estadoPagamento, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

}

/*
 * { "cliente" : {"id" : 1}, "enderecoDeEntrega" : {"id" : 1}, "pagamento" : {
 * "numeroDeParcelas" : 10, "@type": "pagamentoComCartao" }, "itens" : [ {
 * "quantidade" : 2, "produto" : {"id" : 3} }, { "quantidade" : 1, "produto" :
 * {"id" : 1} } ] }
 */
