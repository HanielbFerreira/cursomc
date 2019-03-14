package br.com.cursomc.dto;

import java.util.ArrayList;
import java.util.List;

public class PaginaDTO {

	private List<?> listagem = new ArrayList<>();

	private Integer paginaAtual;
	private Integer qtdItens;
	private Integer paginaFinal;
	private Integer quantidadeDePaginas;
	private Integer proxPagina;
	private Integer paginaAnterior;

	public PaginaDTO(List<?> listagem, Integer paginaAtual, Integer paginaFinal, Integer quantidadeDePaginas,
			Integer proxPagina, Integer paginaAnterior) {
		this.listagem = listagem;
		this.paginaAtual = paginaAtual;
		this.paginaFinal = paginaFinal;
		this.quantidadeDePaginas = quantidadeDePaginas;
		this.proxPagina = proxPagina;
		this.paginaAnterior = paginaAnterior;
	}

	public PaginaDTO() {
	}

	public List<?> getListagem() {
		return listagem;
	}

	public void setListagem(List<?> listagem) {
		this.listagem = listagem;
	}

	public Integer getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(Integer paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	public Integer getPaginaFinal() {
		return paginaFinal;
	}

	public void setPaginaFinal(Integer paginaFinal) {
		this.paginaFinal = paginaFinal;
	}

	public Integer getQuantidadeDePaginas() {
		return quantidadeDePaginas;
	}

	public void setQuantidadeDePaginas(Integer quantidadeDePaginas) {
		this.quantidadeDePaginas = quantidadeDePaginas;
	}

	public Integer getProxPagina() {
		return proxPagina;
	}

	public void setProxPagina(Integer proxPagina) {
		this.proxPagina = proxPagina;
	}

	public Integer getPaginaAnterior() {
		return paginaAnterior;
	}

	public void setPaginaAnterior(Integer paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}

	public Integer getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(Integer qtdItens) {
		this.qtdItens = qtdItens;
	}

}
