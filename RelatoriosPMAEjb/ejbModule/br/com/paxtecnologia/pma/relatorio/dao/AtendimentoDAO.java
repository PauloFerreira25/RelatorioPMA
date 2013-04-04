package br.com.paxtecnologia.pma.relatorio.dao;

import java.util.List;

import br.com.paxtecnologia.pma.relatorio.vo.ChamadoVO;

public class AtendimentoDAO {

	private List<ChamadoVO> listaChamadoAberto;
	private List<ChamadoVO> listaChamadoFechado;
	private List<ChamadoVO> listaChamadoEmAberto;

	public List<ChamadoVO> getChamadosAbertos(Integer idCliente,
			String mesRelatorio) {
		// listaChamadosAbertos = query
		return listaChamadoAberto;
	}

	public List<ChamadoVO> getChamadosFechados(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return listaChamadoFechado;
	}

	public List<ChamadoVO> getChamadosEmAberto(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return listaChamadoEmAberto;
	}

}
