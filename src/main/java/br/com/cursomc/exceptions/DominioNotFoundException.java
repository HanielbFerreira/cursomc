package br.com.cursomc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DominioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DominioNotFoundException(String msg) {
		super(msg);
	}
	
	
	public static DominioNotFoundException build() {
		return new DominioNotFoundException("Dominio não encontrado.");
	}
	
	
}
