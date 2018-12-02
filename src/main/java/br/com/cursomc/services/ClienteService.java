package br.com.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domains.Cliente;
import br.com.cursomc.exceptions.ObjectNotFoundException;
import br.com.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

//	public Cliente buscar(Integer id) {
//		return clienteRepository.findById(id).orElseThrow(() -> ObjectNotFoundException.build());
//	}

//	public Cliente buscar(Integer id) {
//		Optional<Cliente> c = clienteRepository.findById(id);
//
//		return clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
//				"Objeto não encontrado! id:" + id + ", Tipo: " + Cliente.class.getName()));
//	}

	public Cliente buscar(Integer id) {

		return clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" + id + ", Tipo: " + Cliente.class.getName()));
	}

}
