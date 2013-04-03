package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "clientesBean")
@SessionScoped
public class ClientesBean {

	private String idCliente;
	private String mesRelatorio;
	private List<ItemVO> listaIdClientes;
	private List<MesVO> listaIdMes;

	public static class ItemVO {
		public String label;
		public Integer value;

		public ItemVO(String label, Integer value) {
			this.label = label;
			this.value = value;
		}

		public String getLabel() {
			return label;
		}

		public Integer getValue() {
			return value;
		}

	}

	public static class MesVO {
		public String label;
		public String value;

		public MesVO(String label, String value) {
			this.label = label;
			this.value = value;
		}

		public String getLabel() {
			return label;
		}

		public String getValue() {
			return value;
		}

	}

	public List<ItemVO> getListaIdClientes() {
		listaIdClientes = new ArrayList<ItemVO>();
		listaIdClientes.add(new ItemVO("Alatur", 1));
		listaIdClientes.add(new ItemVO("Verzani", 2));
		return listaIdClientes;
	}

	public List<MesVO> getListaIdMes() {
		listaIdMes = new ArrayList<MesVO>();
		listaIdMes.add(new MesVO("Jan", "2013-01-01"));
		listaIdMes.add(new MesVO("Fev", "2013-02-01"));
		return listaIdMes;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getMesRelatorio() {
		return mesRelatorio;
	}

	public void setMesRelatorio(String mesRelatorio) {

		this.mesRelatorio = mesRelatorio;
	}

}
