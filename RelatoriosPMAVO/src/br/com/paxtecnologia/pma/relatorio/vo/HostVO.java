package br.com.paxtecnologia.pma.relatorio.vo;

public class HostVO {

	private String hostname;
	private Integer qtdeAberto;
	private Double porcentoAberto;
	private Integer qtdeFechado;
	private Double porcentoFechado;

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
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
