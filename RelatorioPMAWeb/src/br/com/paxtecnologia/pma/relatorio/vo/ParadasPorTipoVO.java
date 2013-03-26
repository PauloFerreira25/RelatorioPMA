package br.com.paxtecnologia.pma.relatorio.vo;

public class ParadasPorTipoVO {
	
	private String idchamado;
	private String data;
	private Double horas;
	private String host;
	private String descricao;
	
	public String getIdchamado() {
		return idchamado;
	}
	public void setIdchamado(String idchamado) {
		this.idchamado = idchamado;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Double getHoras() {
		return horas;
	}
	public void setHoras(Double horas) {
		this.horas = horas;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
