package br.com.paxtecnologia.pma.relatorio;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.paxtecnologia.pma.relatorio.ejb.WorkloadEjb;

@ViewScoped
@ManagedBean(name = "workloadBean")
public class WorkloadBean {

	@EJB
	private WorkloadEjb workloadEjb;

	@ManagedProperty(value = "#{clientesBean.idCliente}")
	private Integer idCliente;

	@ManagedProperty(value = "#{clientesBean.mesRelatorio}")
	private String mesRelatorio;

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public void setMesRelatorio(String mesRelatorio) {
		this.mesRelatorio = mesRelatorio;
	}

	public String getTf(Integer idGrafico, Integer idTf) {
		return workloadEjb.getTf(idCliente, mesRelatorio, idGrafico, idTf);
	}

	public String getLabel(Integer idGrafico, Integer idTf) {
		return workloadEjb.getLabel(idCliente, mesRelatorio, idGrafico, idTf);
	}

}
