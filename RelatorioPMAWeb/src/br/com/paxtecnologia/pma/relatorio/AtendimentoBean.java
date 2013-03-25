package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.paxtecnologia.pma.relatorio.vo.IncidacoresGeralVO;
import br.com.paxtecnologia.pma.relatorio.vo.SolicitantesVO;

@ViewScoped
@ManagedBean(name = "atendimentoBean")
public class AtendimentoBean {

	private List<IncidacoresGeralVO> listaGeral;
	private List<SolicitantesVO> listaSolicitante;
	
	public List<IncidacoresGeralVO> getListaGeral() {
		listaGeral = new ArrayList<IncidacoresGeralVO>();
		IncidacoresGeralVO a = new IncidacoresGeralVO();
		a.setTexto("Número de Chamados Abertos");
		a.setValor("10");
		listaGeral.add(a);

		IncidacoresGeralVO b = new IncidacoresGeralVO();
		b.setTexto("Número de Chamados Solucionados");
		b.setValor("10");
		listaGeral.add(b);

		IncidacoresGeralVO c = new IncidacoresGeralVO();
		c.setTexto("% de Chamados Solucionados");
		c.setValor("100.00%");
		listaGeral.add(c);

		IncidacoresGeralVO d = new IncidacoresGeralVO();
		d.setTexto("Tempo Médio para solucionar (em Horas)");
		d.setValor("2.00");
		listaGeral.add(d);

		IncidacoresGeralVO e = new IncidacoresGeralVO();
		e.setTexto("Número de Chamados em Aberto");
		e.setValor("1");
		listaGeral.add(e);

		IncidacoresGeralVO f = new IncidacoresGeralVO();
		f.setTexto("% de Chamados em Aberto");
		f.setValor("10.00%");
		listaGeral.add(f);

		IncidacoresGeralVO g = new IncidacoresGeralVO();
		g.setTexto("Número de Chamados Abertos");
		g.setValor("10");
		listaGeral.add(g);

		return listaGeral;
	}
	
	
	
	
	public List<SolicitantesVO> getListaSolicitante(){
		listaSolicitante = new ArrayList<SolicitantesVO>();
		
		SolicitantesVO a = new SolicitantesVO();
		a.setSolictante("Marcelo");
		a.setQtdeAberto(2);
		a.setPorcentoAberto(20.00);
		a.setQtdeFechado(5);
		a.setPorcentoFechado(23.56);
		listaSolicitante.add(a);
		
		SolicitantesVO b = new SolicitantesVO();
		b.setSolictante("PAX");
		b.setQtdeAberto(7);
		b.setPorcentoAberto(70.00);
		b.setQtdeFechado(4);
		b.setPorcentoFechado(58.56);
		listaSolicitante.add(b);
		
		SolicitantesVO c = new SolicitantesVO();
		c.setSolictante("Sérgio");
		c.setQtdeAberto(7);
		c.setPorcentoAberto(70.00);
		c.setQtdeFechado(4);
		c.setPorcentoFechado(58.56);
		listaSolicitante.add(c);
		
		SolicitantesVO d = new SolicitantesVO();
		d.setSolictante("Total");
		d.setQtdeAberto(10);
		d.setPorcentoAberto(100.00);
		d.setQtdeFechado(4);
		d.setPorcentoFechado(58.56);
		listaSolicitante.add(d);
		
		return listaSolicitante;
	}
}
