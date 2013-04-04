package br.com.paxtecnologia.pma.relatorio.ejb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.paxtecnologia.pma.relatorio.dao.ParadasDAO;
import br.com.paxtecnologia.pma.relatorio.vo.ParadasPorTipoVO;

@Stateless
public class ParadasEjb {

	private ParadasDAO paradasDao = new ParadasDAO();
	private List<ParadasPorTipoVO> listaParadasEvitadas;

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

	public List<ParadasPorTipoVO> getListaParadasEvitadas(Integer idCliente,
			String mesRelatorio) {
		if (listaParadasEvitadas == null) {
			listaParadasEvitadas = paradasDao.getListaParadasEvitadas(
					idCliente, mesRelatorio);
		}
		return listaParadasEvitadas;

	}
}
