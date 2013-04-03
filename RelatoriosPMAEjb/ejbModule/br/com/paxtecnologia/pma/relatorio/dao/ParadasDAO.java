package br.com.paxtecnologia.pma.relatorio.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Date;

public class ParadasDAO {
	private DataSourcePMA connection;

	public Calendar getDataUltimoPNP() {
		connection = new DataSourcePMA();
		// query com o banco
		Date data = new Date(0);
		data.valueOf("1985-1-25");
		System.out.println("Data Nova " + data);
		Calendar cal = new GregorianCalendar(data.getYear(), data.getMonth(),
				data.getDate());
		// devolve resultado da query
		return cal;
	}

}
