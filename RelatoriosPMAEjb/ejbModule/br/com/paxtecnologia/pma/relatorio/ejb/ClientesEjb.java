package br.com.paxtecnologia.pma.relatorio.ejb;

import java.util.List;

import javax.ejb.Stateless;

import br.com.paxtecnologia.pma.relatorio.dao.ClienteDAO;
import br.com.paxtecnologia.pma.relatorio.vo.ClienteVO;
import br.com.paxtecnologia.pma.relatorio.vo.MesRelatorioVO;

@Stateless
public class ClientesEjb {
	private ClienteDAO clienteDAO = new ClienteDAO();
	private List<ClienteVO> listaClientes;
	private List<MesRelatorioVO> listaMesRelatorio;

	public List<ClienteVO> getListaClientes() {
		if (listaClientes == null) {
			listaClientes = clienteDAO.getListaClientes();
		}
		return listaClientes;
	}

	public List<MesRelatorioVO> getListaMes(Integer idCliente) {

		if (listaMesRelatorio == null) {
			listaMesRelatorio = clienteDAO.getListaMes(idCliente);
		}
		return listaMesRelatorio;

	}

}
