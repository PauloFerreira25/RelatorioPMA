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
	
	private String label;
	private String tf;
	
	public String getTf(Integer idCliente, String mesRelatorio, Integer idGrafico, Integer idTf) {
		tf = workloadEjb.getTf(idCliente, mesRelatorio, idGrafico, idTf);
		tf = "[[1,19],[2,7],[3,28],[4,10],"
				+ "[5,4],[6,10],[7,18],[8,16],[9,28],[10,9],"
				+ "[11,14],[12,15],[13,15],[14,27],[15,8],[16,11],"
				+ "[17,7],[18,5],[19,15],[20,12],[21,10],[22,2],[23,25]"
				+ ",[24,19], [25,7],[26,22],[27,8],[28,1],[29,27],[30,15],[31,15]]";
		return tf;
	}
	
	public String getLabel(Integer idCliente, String mesRelatorio, Integer idGrafico, Integer idTf){
		label = workloadEjb.getLabel(idCliente, mesRelatorio, idGrafico, idTf);
		return label;
	}

}
