package br.com.paxtecnologia.pma.relatorio.ejb;

import javax.ejb.Stateless;

import br.com.paxtecnologia.pma.relatorio.dao.WorkloadDAO;

@Stateless
public class WorkloadEjb {
	
	private WorkloadDAO workloadDao = new WorkloadDAO();


}
