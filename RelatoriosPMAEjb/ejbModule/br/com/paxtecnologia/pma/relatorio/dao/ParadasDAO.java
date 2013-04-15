package br.com.paxtecnologia.pma.relatorio.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.paxtecnologia.pma.relatorio.vo.ParadasPorTipoVO;
import br.com.paxtecnologia.pma.relatorio.vo.UltimoAnoVO;

public class ParadasDAO {
	private DataSourcePMA connection;
	private List<ParadasPorTipoVO> listaParadasEvitadas;
	private List<ParadasPorTipoVO> listaParadasNaoProgramadas;
	private List<ParadasPorTipoVO> listaParadasProgramadasEstrategicas;
	private List<ParadasPorTipoVO> listaParadasProgramadas;
	private List<UltimoAnoVO> listaUltimosAnosHoras;

	public Calendar getDataUltimoPNP(Integer idCliente, String mesRelatorio) {
		Date data = null;
		Calendar cal = Calendar.getInstance();
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT data_ult_parada FROM pmp_sem_parada WHERE cliente_id = ?";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idCliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		try {
			while (rs.next()) {
				data = rs.getDate("data_ult_parada");

				cal.setTimeInMillis(data.getTime());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		connection.closeConnection(pstmt);
		return cal;
	}

	public Integer getQtdeParadaEvitadasTotal(Integer idCliente,
			String mesRelatorio) {
		Integer retorno = null;
		connection = new DataSourcePMA();
		PreparedStatement pstmt;
		String sql = "SELECT qtd_pe FROM pmp_sem_parada WHERE cliente_id = ?";
		pstmt = connection.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, idCliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = connection.executaQuery(pstmt);
		try {
			while (rs.next()) {
				retorno = rs.getInt("qtd_pe");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection(pstmt);
		return retorno;
	}

	public List<ParadasPorTipoVO> getListaParadasEvitadas(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		listaParadasEvitadas = new ArrayList<ParadasPorTipoVO>();
		ParadasPorTipoVO a = new ParadasPorTipoVO();
		a.setIdchamado("VERZANI-250");
		a.setData("19/02/2013");
		a.setHoras(0.34);
		a.setHost("oracle2");
		a.setDescricao("Parti��o /u01 deu problema");
		listaParadasEvitadas.add(a);

		ParadasPorTipoVO b = new ParadasPorTipoVO();
		b.setIdchamado("VERZANI-251");
		b.setData("19/02/2013");
		b.setHoras(0.34);
		b.setHost("oracle2");
		b.setDescricao("Parti��o /u01 deu problema");
		listaParadasEvitadas.add(b);

		return listaParadasEvitadas;
	}

	public List<ParadasPorTipoVO> getListaParadasNaoProgramadas(
			Integer idCliente, String mesRelatorio) {
		// TODO Auto-generated method stub

		listaParadasNaoProgramadas = new ArrayList<ParadasPorTipoVO>();

		ParadasPorTipoVO a = new ParadasPorTipoVO();
		a.setIdchamado("VERZANI-245");
		a.setData("13/02/2013");
		a.setHoras(0.50);
		a.setHost("oracle2");
		a.setDescricao("Lentid�o");
		listaParadasNaoProgramadas.add(a);
		return listaParadasNaoProgramadas;
	}

	public List<ParadasPorTipoVO> getListaParadasProgramadasEstrategicas(
			Integer idCliente, String mesRelatorio) {
		listaParadasProgramadasEstrategicas = new ArrayList<ParadasPorTipoVO>();

		ParadasPorTipoVO a = new ParadasPorTipoVO();
		a.setIdchamado("VERZANI-246");
		a.setData("13/02/2013");
		a.setHoras(0.80);
		a.setHost("oracle3");
		a.setDescricao("Backup");
		listaParadasProgramadasEstrategicas.add(a);
		return listaParadasProgramadasEstrategicas;
	}

	public List<ParadasPorTipoVO> getListaParadasProgramadas(Integer idCliente,
			String mesRelatorio) {
		listaParadasProgramadas = new ArrayList<ParadasPorTipoVO>();

		ParadasPorTipoVO a = new ParadasPorTipoVO();
		a.setIdchamado("VERZANI-247");
		a.setData("13/02/2013");
		a.setHoras(0.89);
		a.setHost("oracle3");
		a.setDescricao("Backup urgente");
		listaParadasProgramadas.add(a);
		return listaParadasProgramadas;
	}

	public List<UltimoAnoVO> getListaUltimosAnosHoras(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		listaUltimosAnosHoras = new ArrayList<UltimoAnoVO>();

		UltimoAnoVO a = new UltimoAnoVO();
		a.setAno("2012");
		a.setHoras(9.0);
		listaUltimosAnosHoras.add(a);

		UltimoAnoVO b = new UltimoAnoVO();
		b.setAno("2011");
		b.setHoras(19.0);
		listaUltimosAnosHoras.add(b);
		// TODO Auto-generated method stub
		return listaUltimosAnosHoras;
	}

}
