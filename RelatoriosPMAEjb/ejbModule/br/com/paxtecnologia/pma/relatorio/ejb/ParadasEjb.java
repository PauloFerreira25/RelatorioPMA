package br.com.paxtecnologia.pma.relatorio.ejb;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.paxtecnologia.pma.relatorio.dao.ParadasDAO;
import br.com.paxtecnologia.pma.relatorio.vo.ParadasPorTipoVO;
import br.com.paxtecnologia.pma.relatorio.vo.UltimoAnoVO;

@Stateless
public class ParadasEjb {

	private ParadasDAO paradasDao = new ParadasDAO();
	private List<UltimoAnoVO> listaUltimosAnosHoras;
	private List<ParadasPorTipoVO> listaParadasEvitadas;
	private List<ParadasPorTipoVO> listaParadasNaoProgramadas;
	private List<ParadasPorTipoVO> listaParadasProgramadasEstrategicas;
	private List<ParadasPorTipoVO> listaParadasProgramadas;
	private Integer qtdeParadaProgramadas;
	private Integer qtdeProgramadasEstrategicas;
	private Integer qtdeParadaNaoProgramadas;
	private Integer qtdeParadaEvitadas;

	public Integer getDiasTrabalhados(Integer idCliente, String mesRelatorio) {
		Calendar gc = paradasDao.getDataUltimoPNP(idCliente, mesRelatorio);
		Calendar gregorianCalendar = new GregorianCalendar();
		DateTime start = new DateTime(gc.getTime());
		DateTime end = new DateTime(gregorianCalendar);
		int days = Days.daysBetween(start, end).getDays();
		System.out.println("Days Between " + gc.getTime() + " : "
				+ gregorianCalendar.getTime() + " - " + days);
		return days;
	}

	public List<UltimoAnoVO> getListaUltimosAnosHoras(Integer idCliente,
			String mesRelatorio) {
		if (listaUltimosAnosHoras == null) {
			listaUltimosAnosHoras = paradasDao.getListaUltimosAnosHoras(
					idCliente, mesRelatorio);
		}
		return listaUltimosAnosHoras;

	}

	public Integer getQtdeParadaProgramadas(Integer idCliente,
			String mesRelatorio) {
		if (qtdeParadaProgramadas == null){
			if (listaParadasProgramadas==null){
				getListaParadasProgramadas(idCliente, mesRelatorio);
			}
			qtdeParadaProgramadas=listaParadasProgramadas.size();
		}
		return qtdeParadaProgramadas;
	}

	public Integer getQtdeProgramadasEstrategicas(Integer idCliente,
			String mesRelatorio) {
		if (qtdeProgramadasEstrategicas == null){
			if (listaParadasProgramadas==null){
				getListaParadasProgramadasEstrategicas(idCliente, mesRelatorio);
			}
			qtdeProgramadasEstrategicas=listaParadasProgramadasEstrategicas.size();
		}
		return qtdeProgramadasEstrategicas;
	}

	public Integer getQtdeParadaNaoProgramadas(Integer idCliente,
			String mesRelatorio) {
		if (qtdeParadaNaoProgramadas == null){
			if (listaParadasProgramadas==null){
				getListaParadasNaoProgramadas(idCliente, mesRelatorio);
			}
			qtdeParadaNaoProgramadas=listaParadasNaoProgramadas.size();
		}
		return qtdeParadaNaoProgramadas;
	}

	public Integer getQtdeParadaEvitadas(Integer idCliente, String mesRelatorio) {
		if (qtdeParadaEvitadas == null){
			if (listaParadasEvitadas==null){
				getListaParadasEvitadas(idCliente, mesRelatorio);
			}
			qtdeParadaEvitadas=listaParadasEvitadas.size();
		}
		return qtdeParadaEvitadas;
	}

	public List<ParadasPorTipoVO> getListaParadasEvitadas(Integer idCliente,
			String mesRelatorio) {
		if (listaParadasEvitadas == null) {
			listaParadasEvitadas = paradasDao.getListaParadasEvitadas(
					idCliente, mesRelatorio);
		}
		return listaParadasEvitadas;

	}

	public List<ParadasPorTipoVO> getListaParadasNaoProgramadas(
			Integer idCliente, String mesRelatorio) {
		if (listaParadasNaoProgramadas == null) {
			listaParadasNaoProgramadas = paradasDao
					.getListaParadasNaoProgramadas(idCliente, mesRelatorio);
		}
		return listaParadasNaoProgramadas;

	}

	public List<ParadasPorTipoVO> getListaParadasProgramadasEstrategicas(
			Integer idCliente, String mesRelatorio) {
		if (listaParadasProgramadasEstrategicas == null) {
			listaParadasProgramadasEstrategicas = paradasDao
					.getListaParadasProgramadasEstrategicas(idCliente,
							mesRelatorio);
		}
		return listaParadasProgramadasEstrategicas;

	}

	public List<ParadasPorTipoVO> getListaParadasProgramadas(Integer idCliente,
			String mesRelatorio) {
		if (listaParadasProgramadas == null) {
			listaParadasProgramadas = paradasDao.getListaParadasProgramadas(
					idCliente, mesRelatorio);
		}
		return listaParadasProgramadas;

	}
}
