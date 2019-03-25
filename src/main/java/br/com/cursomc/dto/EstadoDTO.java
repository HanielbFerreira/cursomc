package br.com.cursomc.dto;

import java.io.Serializable;

import br.com.cursomc.domains.Estado;

public class EstadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idEstado;
	private String nome;

	public EstadoDTO(Integer idEstado, String nome) {
		this.idEstado = idEstado;
		this.nome = nome;
	}

	public EstadoDTO() {
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static EstadoDTO build(Estado e) {
		return new EstadoDTO(e.getId(), e.getNome());
	}

}
