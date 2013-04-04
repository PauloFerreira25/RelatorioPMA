package br.com.paxtecnologia.pma.relatorio.ejb;

import javax.ejb.Stateless;
import java.util.List;

import br.com.paxtecnologia.pma.relatorio.dao.AtendimentoDAO;
import br.com.paxtecnologia.pma.relatorio.vo.IndicacoresQtdVO;

@Stateless
public class AtendimentoEjb {
	
	private AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
    private Integer qtdeChamadosAberto;
    private List<IndicacoresQtdVO>  listaChamadosAbertos;
    
    
    public Integer getQtdeChamadoAberto(Integer clienteID, String mesRelatorio){
    	if (qtdeChamadosAberto == null){
    		if (listaChamadosAbertos == null){
//    			listaChamadosAbertos = getChamadosAbertos(clienteID, mesRelatorio);
    			getChamadosAbertos(clienteID, mesRelatorio);
    		} 
    		qtdeChamadosAberto=listaChamadosAbertos.size();
    	}
    	return qtdeChamadosAberto;
    }

    
	void getChamadosAbertos(Integer clienteID, String mesRelatorio) {
		if (listaChamadosAbertos == null){
			listaChamadosAbertos = atendimentoDAO.getNumChamadosAbertos(clienteID, mesRelatorio);
		}
		return listaChamadosAbertos;
	}

	
}
