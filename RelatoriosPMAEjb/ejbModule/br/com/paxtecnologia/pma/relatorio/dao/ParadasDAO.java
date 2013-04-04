package br.com.paxtecnologia.pma.relatorio.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.sql.Date;

import br.com.paxtecnologia.pma.relatorio.vo.ParadasPorTipoVO;

public class ParadasDAO {
	private DataSourcePMA connection;
	private List<ParadasPorTipoVO> listaParadasEvitadas;

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

	public List<ParadasPorTipoVO> getListaParadasEvitadas(Integer idCliente,
			String mesRelatorio) {
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

}
