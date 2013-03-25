package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.paxtecnologia.pma.relatorio.vo.ChamadoVO;
import br.com.paxtecnologia.pma.relatorio.vo.IncidacoresGeralVO;
import br.com.paxtecnologia.pma.relatorio.vo.SolicitantesVO;
import br.com.paxtecnologia.pma.relatorio.vo.TipoChamadosVO;

@ViewScoped
@ManagedBean(name = "atendimentoBean")
public class AtendimentoBean {

	private List<IncidacoresGeralVO> listaGeral;
	private List<SolicitantesVO> listaSolicitante;
	private List<TipoChamadosVO> listaTipoChamado;
	private List<ChamadoVO> listaChamadoAberto;
	private List<ChamadoVO> listaChamadoFechado;
	private Integer totalChamadosAbertos = 50;
	private Double totalPorcentoAbertos = 50.00;
	private Double totalPorcentoFechados = 33.33;
	private Integer totalChamadosFechados = 45;

	public Integer getTotalChamadosAbertos() {
		return totalChamadosAbertos;
	}

	public Double getTotalPorcentoAbertos() {
		return totalPorcentoAbertos;
	}

	public Double getTotalPorcentoFechados() {
		return totalPorcentoFechados;
	}

	public Integer getTotalChamadosFechados() {
		return totalChamadosFechados;
	}

	public List<IncidacoresGeralVO> getListaGeral() {
		listaGeral = new ArrayList<IncidacoresGeralVO>();

		IncidacoresGeralVO a = new IncidacoresGeralVO();
		a.setTexto("NÃºmero de Chamados Abertos");
		a.setValor("10");
		listaGeral.add(a);

		IncidacoresGeralVO b = new IncidacoresGeralVO();
		b.setTexto("NÃºmero de Chamados Solucionados");
		b.setValor("10");
		listaGeral.add(b);

		IncidacoresGeralVO c = new IncidacoresGeralVO();
		c.setTexto("% de Chamados Solucionados");
		c.setValor("100.00%");
		listaGeral.add(c);

		IncidacoresGeralVO d = new IncidacoresGeralVO();
		d.setTexto("Tempo MÃ©dio para solucionar (em Horas)");
		d.setValor("2.00");
		listaGeral.add(d);

		IncidacoresGeralVO e = new IncidacoresGeralVO();
		e.setTexto("NÃºmero de Chamados em Aberto");
		e.setValor("1");
		listaGeral.add(e);

		IncidacoresGeralVO f = new IncidacoresGeralVO();
		f.setTexto("% de Chamados em Aberto");
		f.setValor("10.00%");
		listaGeral.add(f);

		IncidacoresGeralVO g = new IncidacoresGeralVO();
		g.setTexto("NÃºmero de Chamados Abertos");
		g.setValor("10");
		listaGeral.add(g);

		return listaGeral;
	}

	public List<SolicitantesVO> getListaSolicitante() {
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
		c.setSolictante("SÃ©rgio");
		c.setQtdeAberto(7);
		c.setPorcentoAberto(70.00);
		c.setQtdeFechado(4);
		c.setPorcentoFechado(58.56);
		listaSolicitante.add(c);

		return listaSolicitante;
	}

	public List<TipoChamadosVO> getListaTipoChamado() {
		listaTipoChamado = new ArrayList<TipoChamadosVO>();

		TipoChamadosVO a = new TipoChamadosVO();
		a.setTipo("Incidente");
		a.setQtdeAberto(16);
		a.setPorcentoAberto(50.00);
		a.setQtdeFechado(14);
		a.setPorcentoFechado(54.56);
		listaTipoChamado.add(a);

		TipoChamadosVO b = new TipoChamadosVO();
		b.setTipo("Mudança");
		b.setQtdeAberto(1);
		b.setPorcentoAberto(7.14);
		b.setQtdeFechado(2);
		b.setPorcentoFechado(4.56);
		listaTipoChamado.add(b);

		TipoChamadosVO c = new TipoChamadosVO();
		c.setTipo("Task");
		c.setQtdeAberto(11);
		c.setPorcentoAberto(35.71);
		c.setQtdeFechado(10);
		c.setPorcentoFechado(44.56);
		listaTipoChamado.add(c);

		return listaTipoChamado;
	}

	public List<ChamadoVO> getListaChamadoAberto() {
		listaChamadoAberto = new ArrayList<ChamadoVO>();

		ChamadoVO a = new ChamadoVO();
		a.setIdChamado("VERZANI-219");
		a.setTitulo("[oracle3] Criação relatório");
		a.setDataAbertura("09 Jan 2013");
		a.setStatus("Open");
		a.setTipoChamado("Task");
		listaChamadoAberto.add(a);

		ChamadoVO b = new ChamadoVO();
		b.setIdChamado("VERZANI-220");
		b.setTitulo("[oracle2] Criação relatório");
		b.setDataAbertura("12 Jan 2013");
		b.setStatus("Open");
		b.setTipoChamado("Task");
		listaChamadoAberto.add(b);

		ChamadoVO c = new ChamadoVO();
		c.setIdChamado("VERZANI-221");
		c.setTitulo("[oracle1] Criação relatório");
		c.setDataAbertura("15 Jan 2013");
		c.setStatus("Reopened");
		c.setTipoChamado("Task");
		listaChamadoAberto.add(c);

		return listaChamadoAberto;
	}

	public List<ChamadoVO> getListaChamadoFechado() {
		listaChamadoFechado = new ArrayList<ChamadoVO>();

		ChamadoVO a = new ChamadoVO();
		a.setIdChamado("VERZANI-219");
		a.setTitulo("[oracle3] Criação relatório");
		a.setDataAbertura("09 Jan 2013");
		a.setStatus("Open");
		a.setTipoChamado("Task");
		listaChamadoFechado.add(a);

		ChamadoVO b = new ChamadoVO();
		b.setIdChamado("VERZANI-220");
		b.setTitulo("[oracle2] Criação relatório");
		b.setDataAbertura("12 Jan 2013");
		b.setStatus("Open");
		b.setTipoChamado("Task");
		listaChamadoFechado.add(b);

		ChamadoVO c = new ChamadoVO();
		c.setIdChamado("VERZANI-221");
		c.setTitulo("[oracle1] Criação relatório");
		c.setDataAbertura("15 Jan 2013");
		c.setStatus("Reopened");
		c.setTipoChamado("Task");
		listaChamadoFechado.add(c);

		return listaChamadoFechado;
	}

}
