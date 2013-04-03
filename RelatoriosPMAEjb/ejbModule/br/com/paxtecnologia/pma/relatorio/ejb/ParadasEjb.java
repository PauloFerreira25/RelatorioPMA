package br.com.paxtecnologia.pma.relatorio.ejb;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
		System.out.println("Days Between " + gc.getTime() + " : " + gregorianCalendar.getTime() + " - " + days);
		return days;
	}
}
