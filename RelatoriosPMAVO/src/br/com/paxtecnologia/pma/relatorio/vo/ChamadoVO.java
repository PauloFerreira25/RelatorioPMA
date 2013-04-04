package br.com.paxtecnologia.pma.relatorio.vo;

public class ChamadoVO {

	private String idChamado;
	private String titulo;
	private String dataAbertura;
	private String status;
	private String tipoChamado;

	public String getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(String idChamado) {
		this.idChamado = idChamado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoChamado() {
		return tipoChamado;
	}

	public void setTipoChamado(String tipoChamado) {
		this.tipoChamado = tipoChamado;
	}

}
