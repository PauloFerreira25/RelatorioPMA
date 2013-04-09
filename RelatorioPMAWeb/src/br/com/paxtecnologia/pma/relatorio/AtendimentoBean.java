package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.paxtecnologia.pma.relatorio.ejb.AtendimentoEjb;
import br.com.paxtecnologia.pma.relatorio.vo.ChamadoVO;
import br.com.paxtecnologia.pma.relatorio.vo.IndicacoresQtdVO;
import br.com.paxtecnologia.pma.relatorio.vo.SolicitantesVO;
import br.com.paxtecnologia.pma.relatorio.vo.TipoChamadosVO;

@ViewScoped
@ManagedBean(name = "atendimentoBean")
public class AtendimentoBean {

	@EJB
	private AtendimentoEjb atendimentoEjb;

	@ManagedProperty(value = "#{clientesBean.idCliente}")
	private Integer idCliente;

	@ManagedProperty(value = "#{clientesBean.mesRelatorio}")
	private String mesRelatorio;

	// private List<IndicacoresQtdVO> listaGeral;
	// private List<SolicitantesVO> listaSolicitante;
	// private List<TipoChamadosVO> listaTipoChamado;
	// private List<ChamadoVO> listaChamadoAberto;
	// private List<ChamadoVO> listaChamadoFechado;
	// private Integer qtdeChamadosAbertos;
	// private Integer qtdeChamadosEmAbertos;
	// private Integer qtdeChamadosFechados;
	// private Double porcentoAbertos;
	// private Double porcentoEmAbertos;
	// private Double porcentoFechados;

	public void setMesRelatorio(String mesRelatorio) {
		this.mesRelatorio = mesRelatorio;
		System.out.println("Seta Mes:" + mesRelatorio.toString());
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
		System.out.println("Seta Cliente:" + idCliente.toString());
	}

	public Integer getQtdeChamadosAbertos() {
		// if (qtdeChamadosAbertos == null) {
		// qtdeChamadosAbertos =
		// }
		return atendimentoEjb.getQtdeChamadosAbertos(idCliente, mesRelatorio);
	}

	public Integer getQtdeChamadosFechados() {
		// if (qtdeChamadosFechados == null) {
		// qtdeChamadosFechados = atendimentoEjb.getQtdeChamadosFechados(
		// idCliente, mesRelatorio);
		// }
		return atendimentoEjb.getQtdeChamadosFechados(idCliente, mesRelatorio);
	}

	private Object getQtdeChamadosEmAberto() {
		// if (qtdeChamadosEmAbertos == null) {
		// qtdeChamadosEmAbertos = atendimentoEjb.getQtdeChamadosEmAberto(
		// idCliente, mesRelatorio);
		// }
		return atendimentoEjb.getQtdeChamadosEmAberto(idCliente, mesRelatorio);
	}

	public Double getPorcentoAbertos() {
		// if (porcentoAbertos == null) {
		// porcentoAbertos = atendimentoEjb.getPorcentagemChamadosAbertos(
		// idCliente, mesRelatorio);
		// }
		return atendimentoEjb.getPorcentagemChamadosAbertos(idCliente,
				mesRelatorio);
	}

	public Double getPorcentoFechados() {
		// if (porcentoFechados == null) {
		// porcentoFechados = atendimentoEjb.getPorcentagemChamadosFechados(
		// idCliente, mesRelatorio);
		// }
		return atendimentoEjb.getPorcentagemChamadosFechados(idCliente,
				mesRelatorio);
	}

	public Double getPorcentoEmAbertos() {
		// if (porcentoEmAbertos == null) {
		// porcentoEmAbertos = atendimentoEjb.getPorcentagemChamadosEmAbertos(
		// idCliente, mesRelatorio);
		// }
		return atendimentoEjb.getPorcentagemChamadosEmAbertos(idCliente,
				mesRelatorio);
	}

	public List<SolicitantesVO> getListaSolicitante() {
		// if (listaSolicitante == null) {
		// listaSolicitante = atendimentoEjb.getListaSolicitantes(idCliente,
		// mesRelatorio);
		// }
		return atendimentoEjb.getListaSolicitantes(idCliente, mesRelatorio);
	}

	public List<TipoChamadosVO> getListaTipoChamado() {
		// if (listaTipoChamado == null) {
		// listaTipoChamado = atendimentoEjb.getListaTipoChamado(idCliente,
		// mesRelatorio);
		// }
		return atendimentoEjb.getListaTipoChamado(idCliente, mesRelatorio);
	}

	public List<ChamadoVO> getListaChamadosEmAbertos() {
		return atendimentoEjb
				.getListaChamadosEmAbertos(idCliente, mesRelatorio);
	}

	public List<ChamadoVO> getListaChamadosFechados() {
		// if (listaChamadoFechado == null) {
		// listaChamadoFechado = atendimentoEjb.getListaChamadosFechados(
		// idCliente, mesRelatorio);
		// // }
		return atendimentoEjb.getListaChamadosFechados(idCliente, mesRelatorio);
	}

	public List<IndicacoresQtdVO> getListaGeral() {
		List<IndicacoresQtdVO> listaGeral = new ArrayList<IndicacoresQtdVO>();

		IndicacoresQtdVO a = new IndicacoresQtdVO();
		a.setTexto("Número de Chamados Abertos");
		a.setValor(getQtdeChamadosAbertos());
		listaGeral.add(a);

		IndicacoresQtdVO b = new IndicacoresQtdVO();
		b.setTexto("Número de Chamados Solucionados");
		b.setValor(getQtdeChamadosFechados());
		listaGeral.add(b);

		IndicacoresQtdVO c = new IndicacoresQtdVO();
		c.setTexto("% de Chamados Solucionados");
		c.setValor(getPorcentoFechados());
		listaGeral.add(c);

		IndicacoresQtdVO d = new IndicacoresQtdVO();
		d.setTexto("Tempo Médio para solucionar (em Horas)");
		d.setValor(atendimentoEjb.getTempoMedio(idCliente, mesRelatorio));
		listaGeral.add(d);

		IndicacoresQtdVO e = new IndicacoresQtdVO();
		e.setTexto("Número de Chamados em Aberto");
		e.setValor(getQtdeChamadosEmAberto());

		listaGeral.add(e);

		IndicacoresQtdVO f = new IndicacoresQtdVO();
		f.setTexto("% de Chamados em Aberto");
		f.setValor(getPorcentoEmAbertos());
		listaGeral.add(f);

		return listaGeral;
	}

	public Double getPorcentagemAbertoTipo() {
		List<TipoChamadosVO> listaTipoChamado = getListaTipoChamado();

		Iterator<TipoChamadosVO> itTipoChamado;
		Double porcentagem;

		itTipoChamado = listaTipoChamado.iterator();
		porcentagem = 0.0;
		while (itTipoChamado.hasNext()) {
			TipoChamadosVO tipoChamados = itTipoChamado.next();
			porcentagem = porcentagem + tipoChamados.getPorcentoAberto();
		}
		return porcentagem;

	}
}
