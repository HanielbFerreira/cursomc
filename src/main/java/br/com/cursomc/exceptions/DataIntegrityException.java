package br.com.cursomc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DataIntegrityException(String msg) {
		super(msg);
	}

	public static DataIntegrityException build() {
		return new DataIntegrityException("Dominio não encontrado.");
	}

}
