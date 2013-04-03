package br.com.paxtecnologia.pma.relatorio.ejb;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.paxtecnologia.pma.relatorio.dao.ParadasDAO;

@Stateless
public class ParadasEjb {

	private ParadasDAO paradasDao = new ParadasDAO();

	public Integer getDiasTrabalhados() {
		Calendar gc = paradasDao.getDataUltimoPNP();
		Calendar gregorianCalendar = new GregorianCalendar();
		DateTime start = new DateTime(gc.getTime());
		DateTime end = new DateTime(gregorianCalendar.getTime());
		int days = Days.daysBetween(start, end).getDays();
		System.out.println("Days Between " + gc.getTime() + " : "
				+ gregorianCalendar.getTime() + " - " + days);
		return days;
	}

	public Map<Integer, Map> getListaParadasEvitadas() {
		Map<Integer, Map> c = new HashMap<Integer, Map>();

		Map<String, Object> a = new HashMap<String, Object>();
		a.put("Idchamado", "VERZANI-1985");
		a.put("Data", "19/02/2013");
		a.put("Horas", 0.34);
		a.put("Host", "oracle2");
		a.put("Descricao", "Parti��o /u01 deu problema");

		Map<String, Object> b = new HashMap<String, Object>();
		b.put("Idchamado", "VERZANI-251");
		b.put("Data", "19/02/2013");
		b.put("Horas", 0.34);
		b.put("Host", "oracle2");
		b.put("Descricao", "Parti��o /u01 deu problema");

		c.put(1, a);
		c.put(2, b);

		return c;
	}
}
