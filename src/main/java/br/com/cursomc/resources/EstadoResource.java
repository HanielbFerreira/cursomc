package br.com.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursomc.dto.CidadeDTO;
import br.com.cursomc.dto.EstadoDTO;
import br.com.cursomc.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;

	@GetMapping()
	public ResponseEntity<List<EstadoDTO>> oberEstados() {
		return new ResponseEntity<List<EstadoDTO>>(estadoService.findEstadoById(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/cidades")
	public ResponseEntity<List<CidadeDTO>> oberCidadesPorEstado(@PathVariable Integer id) {
		return new ResponseEntity<List<CidadeDTO>>(estadoService.findCidadesPorEstado(id), HttpStatus.OK);
	}

}
