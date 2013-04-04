package br.com.paxtecnologia.pma.relatorio.ejb;

import javax.ejb.Stateless;
import java.util.List;

import br.com.paxtecnologia.pma.relatorio.dao.AtendimentoDAO;
import br.com.paxtecnologia.pma.relatorio.vo.IndicacoresQtdVO;

@Stateless
public class AtendimentoEjb {

	private AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
	private Integer qtdeChamadosAberto;
	private List<IndicacoresQtdVO> listaChamadosAbertos;

	// public Integer getQtdeChamadoAberto(Integer clienteID, String
	// mesRelatorio){
	// if (qtdeChamadosAberto == null){
	// if (listaChamadosAbertos == null){
	// // listaChamadosAbertos = getChamadosAbertos(clienteID, mesRelatorio);
	// getChamadosAbertos(clienteID, mesRelatorio);
	// }
	// qtdeChamadosAberto=listaChamadosAbertos.size();
	// }
	// return qtdeChamadosAberto;
	// }

	public Double getPorcentagemChamadosAbertos(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getTempoMedio(Integer idCliente, String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPorcentagemChamadosEmAberto(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getQtdeChamadosAbertos(Integer idCliente, String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getQtdeChamadosFechados(Integer idCliente, String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getQtdeChamadosEmAberto(Integer idCliente, String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

}
