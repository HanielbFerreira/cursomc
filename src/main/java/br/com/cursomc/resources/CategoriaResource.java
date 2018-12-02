
package br.com.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursomc.domains.Categoria;
import br.com.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<Categoria> listar() {

		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(1, "Escritório");

		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);

		return lista;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		return new ResponseEntity<Categoria>(categoriaService.buscar(id), HttpStatus.OK);
	}

}
