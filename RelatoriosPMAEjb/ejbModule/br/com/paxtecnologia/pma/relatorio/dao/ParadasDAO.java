package br.com.paxtecnologia.pma.relatorio.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Date;

public class ParadasDAO {
	private DataSourcePMA connection;

	public Calendar getDataUltimoPNP(Integer clienteID, String mesRelatorio) {
		connection = new DataSourcePMA();
		// query com o banco
		Date data = new Date(0);
		data.setDate(25);
		data.setMonth(1);
		data.setYear(1985);
		Calendar cal = new GregorianCalendar(data.getYear(), data.getMonth(),
				data.getDate());
		// devolve resultado da query
		return cal;
	}

}
