package br.com.paxtecnologia.pma.relatorio.vo;

public class TipoChamadosVO {

	private String tipo;
	private Integer qtdeAberto;
	private Double porcentoAberto;
	private Integer qtdeFechado;
	private Double porcentoFechado;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
