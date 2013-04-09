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
	private Integer diasTrabalhados;
	private Integer idCliente;

	public Integer getDiasTrabalhados(Integer idCliente, String mesRelatorio) {
		if (diasTrabalhados == null || this.idCliente != idCliente)  {
			 this.idCliente = idCliente;
			Calendar gc = paradasDao.getDataUltimoPNP(idCliente, mesRelatorio);
			Calendar gregorianCalendar = new GregorianCalendar();
			DateTime start = new DateTime(gc.getTime());
			DateTime end = new DateTime(gregorianCalendar);
			int days = Days.daysBetween(start, end).getDays();
			System.out.println("Days Between " + gc.getTime() + " : "
					+ gregorianCalendar.getTime() + " - " + days);
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
		if (listaUltimosAnosHoras == null || this.idCliente != idCliente)  {
			 this.idCliente = idCliente;
			listaUltimosAnosHoras = paradasDao.getListaUltimosAnosHoras(
					idCliente, mesRelatorio);
		}
		return listaUltimosAnosHoras;

	}

	public Integer getQtdeParadaProgramadas(Integer idCliente,
			String mesRelatorio) {
		if (qtdeParadaProgramadas == null|| this.idCliente != idCliente)  {
			 this.idCliente = idCliente;
			if (listaParadasProgramadas == null|| this.idCliente != idCliente)  {
				 this.idCliente = idCliente;
				getListaParadasProgramadas(idCliente, mesRelatorio);
			}
			qtdeParadaProgramadas = listaParadasProgramadas.size();
		}
		return qtdeParadaProgramadas;
	}

	public Integer getQtdeProgramadasEstrategicas(Integer idCliente,
			String mesRelatorio) {
		if (qtdeProgramadasEstrategicas == null|| this.idCliente != idCliente)  {
			 this.idCliente = idCliente;
			if (listaParadasProgramadas == null|| this.idCliente != idCliente)  {
				 this.idCliente = idCliente;
				getListaParadasProgramadasEstrategicas(idCliente, mesRelatorio);
			}
			qtdeProgramadasEstrategicas = listaParadasProgramadasEstrategicas
					.size();
		}
		return qtdeProgramadasEstrategicas;
	}

	public Integer getQtdeParadaNaoProgramadas(Integer idCliente,
			String mesRelatorio) {
		if (qtdeParadaNaoProgramadas == null|| this.idCliente != idCliente)  {
			 this.idCliente = idCliente;
			if (listaParadasProgramadas == null|| this.idCliente != idCliente)  {
				 this.idCliente = idCliente;
				getListaParadasNaoProgramadas(idCliente, mesRelatorio);
			}
			qtdeParadaNaoProgramadas = listaParadasNaoProgramadas.size();
		}
		return qtdeParadaNaoProgramadas;
	}

	public Integer getQtdeParadaEvitadas(Integer idCliente, String mesRelatorio) {
		if (qtdeParadaEvitadas == null|| this.idCliente != idCliente)  {
			 this.idCliente = idCliente;
			if (listaParadasEvitadas == null|| this.idCliente != idCliente)  {
				 this.idCliente = idCliente;
				getListaParadasEvitadas(idCliente, mesRelatorio);
			}
			qtdeParadaEvitadas = listaParadasEvitadas.size();
		}
		return qtdeParadaEvitadas;
	}

	public List<ParadasPorTipoVO> getListaParadasEvitadas(Integer idCliente,
			String mesRelatorio) {
		if (listaParadasEvitadas == null|| this.idCliente != idCliente)  {
			 this.idCliente = idCliente;
			listaParadasEvitadas = paradasDao.getListaParadasEvitadas(
					idCliente, mesRelatorio);
		}
		return listaParadasEvitadas;

	}

	public List<ParadasPorTipoVO> getListaParadasNaoProgramadas(
			Integer idCliente, String mesRelatorio) {
		if (listaParadasNaoProgramadas == null|| this.idCliente != idCliente)  {
			 this.idCliente = idCliente;
			listaParadasNaoProgramadas = paradasDao
					.getListaParadasNaoProgramadas(idCliente, mesRelatorio);
		}
		return listaParadasNaoProgramadas;

	}

	public List<ParadasPorTipoVO> getListaParadasProgramadasEstrategicas(
			Integer idCliente, String mesRelatorio) {
		if (listaParadasProgramadasEstrategicas == null|| this.idCliente != idCliente)  {
			 this.idCliente = idCliente;
			listaParadasProgramadasEstrategicas = paradasDao
					.getListaParadasProgramadasEstrategicas(idCliente,
							mesRelatorio);
		}
		return listaParadasProgramadasEstrategicas;

	}

	public List<ParadasPorTipoVO> getListaParadasProgramadas(Integer idCliente,
			String mesRelatorio) {
		if (listaParadasProgramadas == null|| this.idCliente != idCliente)  {
			 this.idCliente = idCliente;
			listaParadasProgramadas = paradasDao.getListaParadasProgramadas(
					idCliente, mesRelatorio);
		}
		return listaParadasProgramadas;

	}

}
