package br.com.paxtecnologia.pma.relatorio;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import br.com.paxtecnologia.pma.relatorio.ejb.ClientesEjb;
import br.com.paxtecnologia.pma.relatorio.vo.ClienteVO;
import br.com.paxtecnologia.pma.relatorio.vo.MesRelatorioVO;

@ManagedBean(name = "clientesBean")
@SessionScoped
public class ClientesBean {

	@EJB
	private ClientesEjb clientesEjb;

	private Integer idCliente;
	private String mesRelatorio;
	private List<ClienteVO> listaClientes;
	private List<MesRelatorioVO> listaMes;

	public List<ClienteVO> getListaClientes() {
		if (listaClientes == null) {
			listaClientes = clientesEjb.getListaClientes();
		}
		return listaClientes;
	}

	public void updateListaMes(ValueChangeEvent e) {
		// This will return you the newly selected
		// value as an object. You'll have to cast it.
		Object newValue = e.getNewValue();

		// The rest of your processing logic goes here...
		setListaMes(generateListaMes((Integer) newValue));
	}

	private List<MesRelatorioVO> generateListaMes(Integer idCliente) {
		listaMes = clientesEjb.getListaMes(idCliente);
		return listaMes;
	}

	public List<MesRelatorioVO> getListaMes() {
		return listaMes;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getMesRelatorio() {
		return mesRelatorio;
	}

	public void setMesRelatorio(String mesRelatorio) {
		this.mesRelatorio = mesRelatorio;
	}

	public void setListaClientes(List<ClienteVO> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void setListaMes(List<MesRelatorioVO> listaMes) {
		this.listaMes = listaMes;
	}

}
