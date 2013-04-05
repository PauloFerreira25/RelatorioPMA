package br.com.paxtecnologia.pma.relatorio.ejb;

import javax.ejb.Stateless;

import br.com.paxtecnologia.pma.relatorio.dao.WorkloadDAO;

@Stateless
public class WorkloadEjb {
	
	private WorkloadDAO workloadDao = new WorkloadDAO();
	
	private String label;
	private String tf;

	public String getLabel(Integer idCliente, String mesRelatorio, Integer idGrafico, Integer idLabel) {
		// TODO Auto-generated method stub
		return label;
	}

	public String getTf(Integer idCliente, String mesRelatorio,Integer idGrafico, Integer idTf) {
		// TODO Auto-generated method stub
		return tf;
	}


}
