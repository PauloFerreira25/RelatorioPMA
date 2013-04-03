package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "clientesBean")
@SessionScoped
public class ClientesBean {

	private String cliente;
	private String mes;
	private List<ItemVO> listaIdClientes;
	private List<ItemVO> listaIdMes;

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

	public String getIdCliente() {
		return cliente;
	}

	public String getIdMes() {
		return mes;
	}

	public List<ItemVO> getListaIdClientes() {
		listaIdClientes = new ArrayList<ItemVO>();
		listaIdClientes.add(new ItemVO("Alatur", 1));
		listaIdClientes.add(new ItemVO("Verzani", 2));
		return listaIdClientes;
	}

	public List<ItemVO> getListaIdMes() {
		listaIdMes = new ArrayList<ItemVO>();
		listaIdMes.add(new ItemVO("Jan", 1));
		listaIdMes.add(new ItemVO("Fev", 2));
		return listaIdMes;
	}

	public void setIdCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setIdMes(String mes) {
		this.mes = mes;
	}

}
