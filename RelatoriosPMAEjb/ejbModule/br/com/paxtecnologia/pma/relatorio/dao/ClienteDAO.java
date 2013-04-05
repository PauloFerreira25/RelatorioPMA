package br.com.paxtecnologia.pma.relatorio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.paxtecnologia.pma.relatorio.vo.ClienteVO;
import br.com.paxtecnologia.pma.relatorio.vo.MesRelatorioVO;

public class ClienteDAO {
	private DataSourcePMA connection;

	public List<ClienteVO> getListaClientes() {
		List<ClienteVO> retorno = new ArrayList<ClienteVO>();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT cliente_id, cliente FROM pmp_cliente";
		pstmt = connection.getPreparedStatement(sql);
		ResultSet rs = connection.executaQuery(pstmt);
		ClienteVO temp;
		try {
			while (rs.next()) {
				temp = new ClienteVO();
				temp.setId(rs.getInt("cliente_id"));
				temp.setNome(rs.getString("cliente"));
				retorno.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return retorno;

	}

	public List<MesRelatorioVO> getListaMes(Integer idCliente) {
		List<MesRelatorioVO> retorno = new ArrayList<MesRelatorioVO>();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT data_insercao FROM pmp_task WHERE cliente_id = ? GROUP BY data_insercao";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idCliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		MesRelatorioVO temp;
		try {
			while (rs.next()) {
				temp = new MesRelatorioVO();
				temp.setLabelMes(rs.getString("data_insercao"));
				temp.setMesString(rs.getString("data_insercao"));
				retorno.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return retorno;
	}

}
