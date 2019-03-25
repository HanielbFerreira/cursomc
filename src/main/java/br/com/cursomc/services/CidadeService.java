package br.com.cursomc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.dto.CidadeDTO;
import br.com.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	public List<CidadeDTO> findCidadesByEstado(Integer id) {
		return cidadeRepository.findCidadesByEstadoId(id).stream().map(CidadeDTO::build).collect(Collectors.toList());
	}

}
