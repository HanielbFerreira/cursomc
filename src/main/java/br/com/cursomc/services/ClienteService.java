package br.com.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.cursomc.domains.Cliente;
import br.com.cursomc.dto.ClienteDTO;
import br.com.cursomc.exceptions.ObjectNotFoundException;
import br.com.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente find(Integer id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente insert(Cliente obj) {
		return clienteRepository.save(obj);
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}

	public void delete(Integer id) {
		clienteRepository.deleteById(id);

	}

	public Cliente update(Cliente obj, Integer id) {
		Cliente c = find(id);
		updateData(obj, c);
		return clienteRepository.save(c);
	}

	private void updateData(Cliente obj, Cliente c) {
		c.setNome(obj.getNome());
		c.setEmail(obj.getEmail());
	}

}
