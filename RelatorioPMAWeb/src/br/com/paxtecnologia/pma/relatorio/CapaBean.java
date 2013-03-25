package br.com.paxtecnologia.pma.relatorio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "capaBean")
public class CapaBean {

	private String logoCliente = "logo_alatur.png";
	private String tituloRelatorio = "SUPORTE";
	private String subtituloRelatorio = "- Fevereiro / 2013-";
	private String dataCriacao = "Data de criaçao: 01 de março de 2013";
	private String textoVersao = "Versao 1.0";
	

	public String getLogoCliente() {
		return logoCliente;
	}

	public String getTituloRelatorio() {
		return tituloRelatorio;
	}

	public String getSubtituloRelatorio() {
		return subtituloRelatorio;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public String getTextoVersao() {
		return textoVersao;
	}

}
