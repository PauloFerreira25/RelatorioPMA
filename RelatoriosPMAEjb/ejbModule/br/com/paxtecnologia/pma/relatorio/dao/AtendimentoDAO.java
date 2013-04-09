package br.com.paxtecnologia.pma.relatorio.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.paxtecnologia.pma.relatorio.vo.ChamadoVO;

public class AtendimentoDAO {

	private DataSourcePMA connection;

	public List<ChamadoVO> getChamadosAbertos(Integer idCliente,
			String mesRelatorio) {
		List<ChamadoVO> retorno = new ArrayList<ChamadoVO>();
		Date data = null;
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT chamado, titulo, solicitante, tipo_chamado, status, data_criacao, data_fechamento FROM pmp_task WHERE cliente_id = ? AND data_insercao = ?";
		pstmt = connection.getPreparedStatement(sql);
		try {
			data = new Date(
					(new SimpleDateFormat("yyyy-MM-dd").parse(mesRelatorio)
							.getTime()));
			pstmt.setInt(1, idCliente);
			pstmt.setDate(2, data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pstmt.toString().toString());

		ResultSet rs = connection.executaQuery(pstmt);
		ChamadoVO temp;
		try {
			while (rs.next()) {
				temp = new ChamadoVO();
				temp.setDataAbertura(new SimpleDateFormat("yyyy-MM-dd")
						.format(rs.getDate("data_criacao")));
				if (rs.getDate("data_fechamento") != null) {
					temp.setDataFechamento(new SimpleDateFormat("yyyy-MM-dd")
							.format(rs.getDate("data_fechamento")));
				}
				temp.setIdChamado(rs.getString("chamado"));
				temp.setTitulo(rs.getString("titulo"));
				temp.setStatus(rs.getString("status"));
				temp.setTipoChamado(rs.getString("tipo_chamado"));
				temp.setSolicitante(rs.getString("solicitante"));
				retorno.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return retorno;
	}

	public List<ChamadoVO> getChamadosFechados(Integer idCliente,
			String mesRelatorio) {
		List<ChamadoVO> retorno = new ArrayList<ChamadoVO>();
		Date data = null;
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT chamado, titulo, solicitante, tipo_chamado, status, data_criacao, data_fechamento FROM pmp_task WHERE cliente_id = ? and data_insercao = ? and data_criacao >= ? AND data_fechamento IS NOT NULL";
		pstmt = connection.getPreparedStatement(sql);
		try {
			java.util.Date dataJava = new SimpleDateFormat("yyyy-MM-dd")
					.parse(mesRelatorio);
			System.out.println(dataJava.toString());
			System.out.println(mesRelatorio);
			data = new Date(
					(new SimpleDateFormat("yyyy-MM-dd").parse(mesRelatorio)
							.getTime()));
			pstmt.setInt(1, idCliente);
			pstmt.setDate(2, data);
			pstmt.setDate(3, data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		ChamadoVO temp;
		try {
			while (rs.next()) {
				temp = new ChamadoVO();
				temp.setDataAbertura(new SimpleDateFormat("yyyy-MM-dd")
						.format(rs.getDate("data_criacao")));
				temp.setDataFechamento(new SimpleDateFormat("yyyy-MM-dd")
						.format(rs.getDate("data_fechamento")));
				temp.setIdChamado(rs.getString("chamado"));
				temp.setTitulo(rs.getString("titulo"));
				temp.setStatus(rs.getString("status"));
				temp.setTipoChamado(rs.getString("tipo_chamado"));
				temp.setSolicitante(rs.getString("solicitante"));
				retorno.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return retorno;
	}

	public List<ChamadoVO> getChamadosEmAberto(Integer idCliente,
			String mesRelatorio) {
		List<ChamadoVO> retorno = new ArrayList<ChamadoVO>();
		Date data = null;
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT chamado, titulo, solicitante, tipo_chamado, status, data_criacao, data_fechamento FROM pmp_task WHERE cliente_id = ? and data_insercao = ? and data_criacao >= ? AND data_fechamento IS NULL";
		pstmt = connection.getPreparedStatement(sql);
		try {
			data = new Date(
					(new SimpleDateFormat("yyyy-MM-dd").parse(mesRelatorio)
							.getTime()));
			pstmt.setInt(1, idCliente);
			pstmt.setDate(2, data);
			pstmt.setDate(3, data);
			System.out.println(data.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		ChamadoVO temp;
		try {
			while (rs.next()) {
				System.out.println("oi");
				temp = new ChamadoVO();
				temp.setDataAbertura(new SimpleDateFormat("yyyy-MM-dd")
						.format(rs.getDate("data_criacao")));
				if (rs.getDate("data_fechamento") != null) {
					temp.setDataFechamento(new SimpleDateFormat("yyyy-MM-dd")
							.format(rs.getDate("data_fechamento")));
				}
				temp.setIdChamado(rs.getString("chamado"));
				temp.setTitulo(rs.getString("titulo"));
				temp.setStatus(rs.getString("status"));
				temp.setTipoChamado(rs.getString("tipo_chamado"));
				temp.setSolicitante(rs.getString("solicitante"));
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
