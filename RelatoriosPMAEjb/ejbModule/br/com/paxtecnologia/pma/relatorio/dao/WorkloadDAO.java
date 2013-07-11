package br.com.paxtecnologia.pma.relatorio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.paxtecnologia.pma.relatorio.vo.GraficoMetricaVO;
import br.com.paxtecnologia.pma.relatorio.vo.TimeFrameVO;
import br.com.paxtecnologia.pma.relatorio.vo.WorkloadGraficoVO;
import br.com.paxtecnologia.pma.relatorio.util.FormataData;

public class WorkloadDAO {
	private DataSourcePMA connection;

	public WorkloadGraficoVO getGrafico(Integer idCliente, Integer idGrafico) {
		WorkloadGraficoVO retorno = new WorkloadGraficoVO();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT grafico_id, titulo, mes_ano, tipo_calculo_id FROM pmp_grafico WHERE cliente_id = ? AND grafico_controle_id = ?";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idCliente);
			pstmt.setInt(2, idGrafico);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		try {
			while (rs.next()) {
				retorno.setGraficoId(rs.getInt("grafico_Id"));
				retorno.setTitulo(rs.getString("titulo"));
				retorno.setMes_ano(rs.getInt("mes_ano"));
				retorno.setTipo_calculo(rs.getInt("tipo_calculo_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return retorno;
	}

	public GraficoMetricaVO getMetrica(WorkloadGraficoVO grafico, Integer idTf) {
		GraficoMetricaVO retorno = new GraficoMetricaVO();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT metrica_link_id, tipo_horario_id FROM pmp_time_frame a WHERE grafico_id = ? AND time_frame_controle_id = ?";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, grafico.getGraficoId());
			pstmt.setInt(2, idTf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		try {
			while (rs.next()) {
				retorno.setMetrica(rs.getInt("metrica_link_id"));
				retorno.setTipo_horario(rs.getInt("tipo_horario_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return retorno;
	}

	public List<TimeFrameVO> getTimeFrame24horas(Integer metrica, String mesRelatorio) {
		List<TimeFrameVO> timeFrame = new ArrayList<TimeFrameVO>();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT to_char(data, 'dd/mm/yyyy') data, avg(valor) valor "
				+ "FROM fato_coleta "
				+ "WHERE data between ? and ? "
				+ "AND metrica_link_id = ? "
				+ "GROUP BY to_char(data, 'dd/mm/yyyy') " + "ORDER BY data";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setDate(1, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(2, FormataData.formataDataFim(mesRelatorio));
			pstmt.setInt(3, metrica);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		TimeFrameVO temp;
		try {
			while (rs.next()) {
				temp = new TimeFrameVO();
				temp.setData(rs.getString("data"));
				temp.setValor(rs.getDouble("valor"));
				timeFrame.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return timeFrame;
	}
	
	public List<TimeFrameVO> getTimeFrameAno24horas(Integer metrica, String mesRelatorio) {
		List<TimeFrameVO> timeFrame = new ArrayList<TimeFrameVO>();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT to_char(data, 'mm/yyyy') data, avg(valor) valor "
				+ "FROM fato_coleta "
				+ "WHERE data between ? and ? "
				+ "AND metrica_link_id = ? "
				+ "GROUP BY to_char(data, 'mm/yyyy') " + "ORDER BY data";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setDate(1, FormataData.formataAnoInicio(mesRelatorio));
			pstmt.setDate(2, FormataData.formataDataFim(mesRelatorio));
			pstmt.setInt(3, metrica);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		TimeFrameVO temp;
		try {
			while (rs.next()) {
				temp = new TimeFrameVO();
				temp.setData(rs.getString("data"));
				temp.setValor(rs.getDouble("valor"));
				timeFrame.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return timeFrame;
	}	
	
	public List<TimeFrameVO> getTimeFrame(Integer metrica, String mesRelatorio, List<String> periodo) {
		List<TimeFrameVO> timeFrame = new ArrayList<TimeFrameVO>();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		List<String> possibleValues = periodo;
		StringBuilder builder = new StringBuilder();
		for( int i = 0 ; i < possibleValues.size(); i++ ) {
		    builder.append("?,");
		}
		String sql = "SELECT to_char(data, 'dd/mm/yyyy') data, avg(valor) valor "
				+ "FROM fato_coleta "
				+ "WHERE data between ? and ? "
				+ "AND metrica_link_id = ? "
				+ "AND to_char(data,'hh24') in (" + builder.deleteCharAt( builder.length() -1 ).toString() + ") "
				+ "GROUP BY to_char(data, 'dd/mm/yyyy') ORDER BY data";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setDate(1, FormataData.formataDataInicio(mesRelatorio));
			pstmt.setDate(2, FormataData.formataDataFim(mesRelatorio));
			pstmt.setInt(3, metrica);
			int index = 4;
			for( String o : possibleValues ) {
			   pstmt.setString(  index++, o ); // or whatever it applies 
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		TimeFrameVO temp;
		try {
			while (rs.next()) {
				temp = new TimeFrameVO();
				temp.setData(rs.getString("data"));
				temp.setValor(rs.getDouble("valor"));
				timeFrame.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return timeFrame;
	}

	public List<TimeFrameVO> getTimeFrameAno(Integer metrica, String mesRelatorio, List<String> periodo) {
		List<TimeFrameVO> timeFrame = new ArrayList<TimeFrameVO>();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		List<String> possibleValues = periodo;
		StringBuilder builder = new StringBuilder();
		for( int i = 0 ; i < possibleValues.size(); i++ ) {
		    builder.append("?,");
		}
		String sql = "SELECT to_char(data, 'mm/yyyy') data, avg(valor) valor "
				+ "FROM fato_coleta "
				+ "WHERE data between ? and ? "
				+ "AND metrica_link_id = ? "
				+ "AND to_char(data,'hh24') in (" + builder.deleteCharAt( builder.length() -1 ).toString() + ") "
				+ "GROUP BY to_char(data, 'mm/yyyy') " + "ORDER BY data";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setDate(1, FormataData.formataAnoInicio(mesRelatorio));
			pstmt.setDate(2, FormataData.formataDataFim(mesRelatorio));
			pstmt.setInt(3, metrica);
			int index = 4;
			for( String o : possibleValues ) {
			   pstmt.setString(  index++, o ); // or whatever it applies 
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		TimeFrameVO temp;
		try {
			while (rs.next()) {
				temp = new TimeFrameVO();
				temp.setData(rs.getString("data"));
				temp.setValor(rs.getDouble("valor"));
				timeFrame.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return timeFrame;
	}		
	
	public String getLabel(Integer idGrafico, Integer idTf) {
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT legenda "
				+ "FROM pmp_time_frame "
				+ "WHERE grafico_id = ? "
				+ "AND time_frame_controle_id = ? ";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idGrafico);
			pstmt.setInt(2, idTf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		String label = null;
		try {
			while (rs.next()) {
				label = rs.getString("legenda");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return label;
	}	

	public String getLabelTitulo(Integer idGrafico) {
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT titulo "
				+ "FROM pmp_grafico "
				+ "WHERE grafico_id = ?";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idGrafico);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		String labelTitulo = null;
		try {
			while (rs.next()) {
				labelTitulo = rs.getString("titulo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return labelTitulo;
	}	
}
