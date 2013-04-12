package br.com.paxtecnologia.pma.relatorio.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.paxtecnologia.pma.relatorio.vo.GraficoMetricaVO;
import br.com.paxtecnologia.pma.relatorio.vo.TimeFrameVO;
import br.com.paxtecnologia.pma.relatorio.vo.WorkloadGraficoVO;

public class WorkloadDAO {
	private DataSourcePMA connection;

	// public List<TimeFrameVO> getTimeFrame(Integer idCliente,
	// String mesRelatorio, Date dataInicio, Date dataFim, String metrica) {
	// List<TimeFrameVO> timeFrame = new ArrayList<TimeFrameVO>();
	// connection = new DataSourcePMA();
	// PreparedStatement pstmt;
	// String sql =
	// "SELECT data, valor FROM fato_coleta a, pmp_metrica b, pmp_cliente c WHERE a.metrica_id = b.metrica_id AND a.cliente_id = c.cliente_id AND a.cliente_id = ? AND data between ? and ? AND b.arquivo_metrica = ?";
	// pstmt = connection.getPreparedStatement(sql);
	// try {
	// pstmt.setInt(1, idCliente);
	// pstmt.setDate(2, dataInicio);
	// pstmt.setDate(3, dataFim);
	// pstmt.setString(4, metrica);
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// ResultSet rs = connection.executaQuery(pstmt);
	// TimeFrameVO temp;
	// try {
	// while (rs.next()) {
	// temp = new TimeFrameVO();
	// temp.setData(rs.getDate("data"));
	// temp.setValor(rs.getDouble("valor"));
	// timeFrame.add(temp);
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return timeFrame;
	// }

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
		return retorno;
	}

	public GraficoMetricaVO getMetrica(WorkloadGraficoVO grafico, Integer idTf) {
		GraficoMetricaVO retorno = new GraficoMetricaVO();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT metrica_id, tipo_horario_id FROM pmp_time_frame a WHERE grafico_id = ? AND time_frame_controle_id = ?";
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
				retorno.setMetrica(rs.getInt("metrica_id"));
				retorno.setTipo_horario(rs.getInt("tipo_horario_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}

	public List<TimeFrameVO> getTimeFrame18a23(Integer metrica,
			String mesRelatorio) {
		return null;

	}

	public List<TimeFrameVO> getTimeFrame0a8e23a24(Integer metrica,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TimeFrameVO> getTimeFrame24horas(Integer metrica,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TimeFrameVO> getTimeFrame8a18(Integer metrica,
			String mesRelatorio) {
		List<TimeFrameVO> timeFrame = new ArrayList<TimeFrameVO>();
		connection = new DataSourcePMA();
		Date dataMes = null;
		Date dataMesMaisUm = null;
		PreparedStatement pstmt;
		String sql = "SELECT to_char(data, 'dd/mm/yyyy') data, avg(valor) valor "
				+ "FROM fato_coleta "
				+ "WHERE data between '01/03/2013' and '01/04/2013' "
				+ "AND to_char(data,'hh24') in ('08','09','10','11','12','13','14','15','16','17') "
				+ "AND metrica_id = 6658 "
				+ "GROUP BY to_char(data, 'dd/mm/yyyy') "
				+ "ORDER BY to_char(data, 'dd/mm/yyyy')";
		pstmt = connection.getPreparedStatement(sql);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dataMes = new Date((sdf.parse(mesRelatorio).getTime()));
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(mesRelatorio));
			c.add(Calendar.MONTH, 1);
			dataMesMaisUm = new Date(
					(sdf.parse(sdf.format(c.getTime())).getTime()));
//			pstmt.setDate(1, dataMes);
//			pstmt.setDate(2, dataMesMaisUm);
//			pstmt.setInt(3, metrica);
//			pstmt.setInt(1, metrica);
			System.out.println("**" + dataMes + " : " + dataMesMaisUm + " - metrica: "+ metrica);
		} catch (ParseException e) {
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
		return timeFrame;
	}
}
