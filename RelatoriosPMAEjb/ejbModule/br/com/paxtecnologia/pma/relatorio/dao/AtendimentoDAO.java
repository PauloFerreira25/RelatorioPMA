package br.com.paxtecnologia.pma.relatorio.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.paxtecnologia.pma.relatorio.util.FormataData;
import br.com.paxtecnologia.pma.relatorio.vo.ChamadoVO;

public class AtendimentoDAO {

	private DataSourcePMA connection;

	public List<ChamadoVO> getChamadosAbertos(Integer idCliente,
			String mesRelatorio) {
		List<ChamadoVO> retorno = new ArrayList<ChamadoVO>();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT chamado, titulo, solicitante, tipo_chamado, status, segundos_trabalhados, data_criacao, data_fechamento FROM pmp_task WHERE cliente_id = ? AND trunc(data_insercao,'MM') = trunc(?,'MM') AND trunc(data_criacao,'MM') = trunc(?,'MM')";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idCliente);
			pstmt.setDate(2, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(3, FormataData.formataDataInicio(mesRelatorio));
		} catch (SQLException e) {
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
				if (rs.getDate("data_fechamento") != null) {
					temp.setDataFechamento(new SimpleDateFormat("yyyy-MM-dd")
							.format(rs.getDate("data_fechamento")));
				}
				temp.setIdChamado(rs.getString("chamado"));
				temp.setTitulo(rs.getString("titulo"));
				temp.setStatus(rs.getString("status"));
				temp.setTipoChamado(rs.getString("tipo_chamado"));
				temp.setSolicitante(rs.getString("solicitante"));
				temp.setSegundosTrabalhos(rs.getInt("segundos_trabalhados"));
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
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT chamado, titulo, solicitante, tipo_chamado, status, segundos_trabalhados, data_criacao, data_fechamento FROM pmp_task WHERE cliente_id = ? AND trunc(data_insercao,'MM') = trunc(?,'MM') AND trunc(data_fechamento,'MM') = trunc(?,'MM')";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idCliente);
			pstmt.setDate(2, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(3, FormataData.formataDataInicio(mesRelatorio));
		} catch (SQLException e) {
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
				temp.setSegundosTrabalhos(rs.getInt("segundos_trabalhados"));
				retorno.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return retorno;
	}

	public List<ChamadoVO> getChamadosEmAbertos(Integer idCliente,
			String mesRelatorio) {
		List<ChamadoVO> retorno = new ArrayList<ChamadoVO>();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "select p.chamado, "+
				"       p.titulo, "+
				"       p.solicitante, "+
				"       p.tipo_chamado, "+
				"       p.status, "+
				"       p.segundos_trabalhados, "+
				"       p.data_criacao "+
				"  from pmp_task p, "+
				"       ( "+    
				"        SELECT  p.chamado, "+
				"                max(p.data_insercao) data_insercao "+
				"          FROM pmp_task p "+ 
				"         WHERE cliente_id = ? "+
				"           and trunc(data_insercao, 'MM') <= trunc(?, 'MM') "+
				"           and trunc(data_criacao, 'MM') <= trunc(?, 'MM') "+
				"        	 and chamado in "+
				"        		 (select chamado "+ 
				"        			from pmp_task "+
				"        		   WHERE cliente_id = p.cliente_id "+
				"        			 and data_fechamento IS NULL "+
				"        		  union "+
				"        		  select chamado "+
				"        			from pmp_task "+
				"        		   WHERE cliente_id = p.cliente_id "+
				"        			 and trunc(data_fechamento,'MM') >= trunc(?, 'MM')) "+
				"        	 and chamado not in "+
				"        		 (select chamado "+
				"        			from pmp_task "+
				"        		   where cliente_id = p.cliente_id "+
				"        			 and trunc(data_fechamento, 'MM') <= trunc(?, 'MM')) "+
				"        group by p.chamado) x "+
				" where p.chamado = x.chamado "+
				"   and p.data_insercao = x.data_insercao";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idCliente);
			pstmt.setDate(2, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(3, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(4, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(5, FormataData.formataDataInicio(mesRelatorio));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		ChamadoVO temp;
		try {
			while (rs.next()) {
				temp = new ChamadoVO();
				temp.setDataAbertura(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("data_criacao")));
				temp.setIdChamado(rs.getString("chamado"));
				temp.setTitulo(rs.getString("titulo"));
				temp.setStatus(rs.getString("status"));
				temp.setTipoChamado(rs.getString("tipo_chamado"));
				temp.setSolicitante(rs.getString("solicitante"));
				temp.setSegundosTrabalhos(rs.getInt("segundos_trabalhados"));
				retorno.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return retorno;
	}

	public List<String> getListaFechadosComHosts(Integer idCliente,
			String mesRelatorio) {
		List<String> retorno = new ArrayList<String>();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT c.nome_fantasia "
					+"  FROM pmp_task a, pmp_task_host b, pmp_host c "
					+" WHERE a.task_id = b.task_id "
					+"   AND c.host_id = b.host_id "
					+"   AND a.cliente_id = ? "
					+"   AND a.data_insercao = ? "
					+"   AND trunc(a.data_fechamento,'MM') = trunc(?,'MM')";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idCliente);
			pstmt.setDate(2, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(3, FormataData.formataDataInicio(mesRelatorio));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		String temp;
		try {
			while (rs.next()) {
				temp = new String();
				temp = rs.getString("nome_fantasia");
				retorno.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return retorno;
	}

	public List<String> getListaAbertosComHosts(Integer idCliente,
			String mesRelatorio) {
		List<String> retorno = new ArrayList<String>();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT c.nome_fantasia "
					+"  FROM pmp_task a, pmp_task_host b, pmp_host c "
					+" WHERE a.task_id = b.task_id "
					+"   AND c.host_id = b.host_id "
					+"   AND a.cliente_id = ? "
					+"   AND a.data_insercao = ?"
					+"   AND a.data_criacao >= ?";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idCliente);
			pstmt.setDate(2, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(3, FormataData.formataDataInicio(mesRelatorio));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		String temp;
		try {
			while (rs.next()) {
				temp = new String();
				temp = rs.getString("nome_fantasia");
				retorno.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return retorno;
	}

	public List<String> getListaEmAbertosComHosts(Integer idCliente,
			String mesRelatorio) {
		List<String> retorno = new ArrayList<String>();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "select c.nome_fantasia "+
					 "  from pmp_task a, pmp_task_host b, pmp_host c, "+
					 "       ( "+    
					 "        SELECT  p.chamado, "+
					 "                max(p.data_insercao) data_insercao "+
					 "          FROM pmp_task p "+ 
					 "         WHERE cliente_id = ? "+
					 "           and trunc(data_insercao, 'MM') <= trunc(?, 'MM') "+
					 "           and trunc(data_criacao, 'MM') <= trunc(?, 'MM') "+
					 "        	 and chamado in "+
					 "        		 (select chamado "+ 
					 "        			from pmp_task "+
					 "        		   WHERE cliente_id = p.cliente_id "+
					 "        			 and data_fechamento IS NULL "+
					 "        		  union "+
					 "        		  select chamado "+
					 "        			from pmp_task "+
					 "        		   WHERE cliente_id = p.cliente_id "+
					 "        			 and trunc(data_fechamento,'MM') >= trunc(?, 'MM')) "+
					 "        	 and chamado not in "+
					 "        		 (select chamado "+
					 "        			from pmp_task "+
					 "        		   where cliente_id = p.cliente_id "+
					 "        			 and trunc(data_fechamento, 'MM') <= trunc(?, 'MM')) "+
					 "        group by p.chamado) x "+
					 " where a.chamado = x.chamado "+
					 "   and a.data_insercao = x.data_insercao "+
					 "   and a.task_id = b.task_id "+
					 "   AND c.host_id = b.host_id";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idCliente);
			pstmt.setDate(2, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(3, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(4, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(5, FormataData.formataDataInicio(mesRelatorio));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		String temp;
		try {
			while (rs.next()) {
				temp = new String();
				temp = rs.getString("nome_fantasia");
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
