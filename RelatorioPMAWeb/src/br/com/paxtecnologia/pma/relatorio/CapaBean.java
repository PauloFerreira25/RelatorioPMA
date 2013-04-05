package br.com.paxtecnologia.pma.relatorio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "capaBean")
public class CapaBean {

	@ManagedProperty(value = "#{clientesBean.idCliente}")
	private Integer idCliente;

	@ManagedProperty(value = "#{clientesBean.mesRelatorio}")
	private String mesRelatorio;

	private String tituloRelatorio = "SUPORTE";
	private String subtituloRelatorio;
	private String dataCriacao;
	private String textoVersao = "Versao 1.0";

	public String getTituloRelatorio() {
		return tituloRelatorio;
	}

	public String getSubtituloRelatorio() {
		if (subtituloRelatorio == null) {
			subtituloRelatorio = "- Fevereiro / 2013-";
		}
		return subtituloRelatorio;
	}

	public String getDataCriacao() {
		if (dataCriacao == null) {
			dataCriacao = "Data de criaçao: 01 de março de 2013";
		}
		return dataCriacao;
	}

	public String getTextoVersao() {
		return textoVersao;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public void setMesRelatorio(String mesRelatorio) {
		this.mesRelatorio = mesRelatorio;
	}

	
	
}
