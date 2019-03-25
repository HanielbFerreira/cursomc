package br.com.cursomc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.dto.CidadeDTO;
import br.com.cursomc.dto.EstadoDTO;
import br.com.cursomc.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeService cidadeService;

	public List<EstadoDTO> findEstadoById() {
		return estadoRepository.findAllByOrderByNome().stream().map(EstadoDTO::build).collect(Collectors.toList());
	}

	public List<CidadeDTO> findCidadesPorEstado(Integer id) {
		return cidadeService.findCidadesByEstado(id);
	}

}
