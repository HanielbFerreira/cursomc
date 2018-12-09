package br.com.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domains.Categoria;
import br.com.cursomc.exceptions.ObjectNotFoundException;
import br.com.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria find(Integer id) {
		return categoriaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		return categoriaRepository.save(obj);
	}

	public Categoria update(Categoria obj, Integer id) {
		find(id);
		return categoriaRepository.save(obj);
	}

}
