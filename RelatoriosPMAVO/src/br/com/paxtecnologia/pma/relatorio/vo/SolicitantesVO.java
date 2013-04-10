package br.com.paxtecnologia.pma.relatorio.vo;

public class SolicitantesVO {

	private String solictante;
	private Integer qtdeAberto;
	private Integer qtdeFechado;
	private Integer qtdeEmAberto;
	private Double porcentoFechado;
	private Double porcentoAberto;
	private Double porcentoEmAberto;

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

	public Integer getQtdeEmAberto() {
		return qtdeEmAberto;
	}

	public void setQtdeEmAberto(Integer qtdeEmAberto) {
		this.qtdeEmAberto = qtdeEmAberto;
	}

	public Double getPorcentoEmAberto() {
		return porcentoEmAberto;
	}

	public void setPorcentoEmAberto(Double porcentoEmAberto) {
		this.porcentoEmAberto = porcentoEmAberto;
	}

}
