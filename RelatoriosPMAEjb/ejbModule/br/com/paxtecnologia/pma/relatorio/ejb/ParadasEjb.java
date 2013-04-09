package br.com.paxtecnologia.pma.relatorio.ejb;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Integer diasTrabalhados;
	Map<String, Integer> controleIdCliente = new HashMap<String, Integer>();

	public Integer getDiasTrabalhados(Integer idCliente, String mesRelatorio) {
		if (diasTrabalhados == null || controleIdCliente.get("getDiasTrabalhados") != idCliente) {
			Calendar gc = paradasDao.getDataUltimoPNP(idCliente, mesRelatorio);
			Calendar gregorianCalendar = new GregorianCalendar();
			DateTime start = new DateTime(gc.getTime());
			DateTime end = new DateTime(gregorianCalendar);
			int days = Days.daysBetween(start, end).getDays();
			diasTrabalhados = days;
		}
		return diasTrabalhados;
	}

	public Integer getQtdeParadaEvitadasTotal(Integer idCliente,
			String mesRelatorio) {
		return paradasDao.getQtdeParadaEvitadasTotal(idCliente, mesRelatorio);
	}

	public List<UltimoAnoVO> getListaUltimosAnosHoras(Integer idCliente,
			String mesRelatorio) {
		if (listaUltimosAnosHoras == null || controleIdCliente.get("getListaUltimosAnosHoras") != idCliente) {
			listaUltimosAnosHoras = paradasDao.getListaUltimosAnosHoras(
					idCliente, mesRelatorio);
			controleIdCliente.put("getListaUltimosAnosHoras", idCliente);
		}
		return listaUltimosAnosHoras;

	}

	public Integer getQtdeParadaProgramadas(Integer idCliente,
			String mesRelatorio) {
		if (qtdeParadaProgramadas == null || controleIdCliente.get("getQtdeParadaProgramadas") != idCliente) {
			if (listaParadasProgramadas == null || controleIdCliente.get("getQtdeParadaProgramadas") != idCliente) {
				getListaParadasProgramadas(idCliente, mesRelatorio);
				controleIdCliente.put("getQtdeParadaProgramadas", idCliente);
			}
			qtdeParadaProgramadas = listaParadasProgramadas.size();
		}
		return qtdeParadaProgramadas;
	}

	public Integer getQtdeProgramadasEstrategicas(Integer idCliente,
			String mesRelatorio) {
		if (qtdeProgramadasEstrategicas == null || controleIdCliente.get("getQtdeProgramadasEstrategicas") != idCliente) {
			if (listaParadasProgramadas == null || controleIdCliente.get("getQtdeProgramadasEstrategicas") != idCliente) {
				getListaParadasProgramadasEstrategicas(idCliente, mesRelatorio);
				controleIdCliente.put("getQtdeProgramadasEstrategicas", idCliente);
			}
			qtdeProgramadasEstrategicas = listaParadasProgramadasEstrategicas
					.size();
		}
		return qtdeProgramadasEstrategicas;
	}

	public Integer getQtdeParadaNaoProgramadas(Integer idCliente,
			String mesRelatorio) {
		if (qtdeParadaNaoProgramadas == null || controleIdCliente.get("getQtdeParadaNaoProgramadas") != idCliente) {
			if (listaParadasProgramadas == null || controleIdCliente.get("getQtdeParadaNaoProgramadas") != idCliente) {
				getListaParadasNaoProgramadas(idCliente, mesRelatorio);
				controleIdCliente.put("getQtdeParadaNaoProgramadas", idCliente);
			}
			qtdeParadaNaoProgramadas = listaParadasNaoProgramadas.size();
		}
		return qtdeParadaNaoProgramadas;
	}

	public Integer getQtdeParadaEvitadas(Integer idCliente, String mesRelatorio) {
		if (qtdeParadaEvitadas == null || controleIdCliente.get("getQtdeParadaEvitadas") != idCliente) {
			if (listaParadasEvitadas == null || controleIdCliente.get("getQtdeParadaEvitadas") != idCliente) {
				getListaParadasEvitadas(idCliente, mesRelatorio);
				controleIdCliente.put("getQtdeParadaEvitadas", idCliente);
			}
			qtdeParadaEvitadas = listaParadasEvitadas.size();
		}
		return qtdeParadaEvitadas;
	}

	public List<ParadasPorTipoVO> getListaParadasEvitadas(Integer idCliente,
			String mesRelatorio) {
		if (listaParadasEvitadas == null || controleIdCliente.get("getListaParadasEvitadas") != idCliente) {
			listaParadasEvitadas = paradasDao.getListaParadasEvitadas(idCliente, mesRelatorio);
			controleIdCliente.put("getListaParadasEvitadas", idCliente);
		}
		return listaParadasEvitadas;

	}

	public List<ParadasPorTipoVO> getListaParadasNaoProgramadas(
			Integer idCliente, String mesRelatorio) {
		if (listaParadasNaoProgramadas == null || controleIdCliente.get("getListaParadasNaoProgramadas") != idCliente) {
			listaParadasNaoProgramadas = paradasDao
					.getListaParadasNaoProgramadas(idCliente, mesRelatorio);
			controleIdCliente.put("getListaParadasNaoProgramadas", idCliente);
		}
		return listaParadasNaoProgramadas;

	}

	public List<ParadasPorTipoVO> getListaParadasProgramadasEstrategicas(
			Integer idCliente, String mesRelatorio) {
		if (listaParadasProgramadasEstrategicas == null || controleIdCliente.get("getListaParadasProgramadasEstrategicas") != idCliente) {
			listaParadasProgramadasEstrategicas = paradasDao
					.getListaParadasProgramadasEstrategicas(idCliente,
							mesRelatorio);
			controleIdCliente.put("getListaParadasProgramadasEstrategicas", idCliente);
		}
		return listaParadasProgramadasEstrategicas;

	}

	public List<ParadasPorTipoVO> getListaParadasProgramadas(Integer idCliente,
			String mesRelatorio) {
		if (listaParadasProgramadas == null || controleIdCliente.get("getListaParadasProgramadas") != idCliente) {
			listaParadasProgramadas = paradasDao.getListaParadasProgramadas(
					idCliente, mesRelatorio);
			controleIdCliente.put("getListaParadasProgramadas", idCliente);
		}
		return listaParadasProgramadas;

	}

}
