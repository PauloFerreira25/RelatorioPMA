package br.com.paxtecnologia.pma.relatorio.vo;

public class SolicitantesVO {

	private String solictante;
	private Integer qtdeAberto;
	private Double porcentoAberto;
	private Integer qtdeFechado;
	private Double porcentoFechado;

	public String getSolictante() {
		return solictante;
	}

	public void setSolictante(String solictante) {
		this.solictante = solictante;
	}

	public Integer getQtdeAberto() {
		return qtdeAberto;
	}

	public void setQtdeAberto(Integer qtdeAberto) {
		this.qtdeAberto = qtdeAberto;
	}

	public Double getPorcentoAberto() {
		return porcentoAberto;
	}

	public void setPorcentoAberto(Double porcentoAberto) {
		this.porcentoAberto = porcentoAberto;
	}

	public Integer getQtdeFechado() {
		return qtdeFechado;
	}

	public void setQtdeFechado(Integer qtdeFechado) {
		this.qtdeFechado = qtdeFechado;
	}

	public Double getPorcentoFechado() {
		return porcentoFechado;
	}

	public void setPorcentoFechado(Double porcentoFechado) {
		this.porcentoFechado = porcentoFechado;
	}

}
