package br.com.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domains.Categoria;
import br.com.cursomc.exceptions.DominioNotFoundException;
import br.com.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		return categoriaRepository.findById(id).orElseThrow(() -> DominioNotFoundException.build());
	}
	
}
