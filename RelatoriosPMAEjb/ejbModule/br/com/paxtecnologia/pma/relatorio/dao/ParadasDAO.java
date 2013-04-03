package br.com.paxtecnologia.pma.relatorio.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ParadasDAO {
	private DataSourcePMA connection;

	public Calendar getDataUltimoPNP() {
		connection = new DataSourcePMA();
		//query com o banco
		java.sql.Date data = new java.sql.Date(1985, 01, 25);
		Calendar gc = new GregorianCalendar();
		gc.setTime(data);
		// devolve resultado da query
		return gc;
	}

}
