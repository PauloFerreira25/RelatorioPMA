package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
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

	private List<IndicacoresQtdVO> listaGeral;
	private List<SolicitantesVO> listaSolicitante;
	private List<TipoChamadosVO> listaTipoChamado;
	private List<ChamadoVO> listaChamadoAberto;
	private List<ChamadoVO> listaChamadoFechado;
	private Integer qtdeChamadosAbertos;
	private Integer qtdeChamadosEmAbertos;
	private Integer qtdeChamadosFechados;
	private Double porcentoAbertos;
	private Double porcentoEmAbertos;
	private Double porcentoFechados;

	public void setMesRelatorio(String mesRelatorio) {
		this.mesRelatorio = mesRelatorio;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getQtdeChamadosAbertos() {
		if (qtdeChamadosAbertos == null) {
			qtdeChamadosAbertos = atendimentoEjb.getQtdeChamadosAbertos(
					idCliente, mesRelatorio);
		}
		return qtdeChamadosAbertos;
	}

	public Integer getQtdeChamadosFechados() {
		if (qtdeChamadosFechados == null) {
			qtdeChamadosFechados = atendimentoEjb.getQtdeChamadosFechados(
					idCliente, mesRelatorio);
		}
		return qtdeChamadosFechados;
	}

	private Object getQtdeChamadosEmAberto() {
		if (qtdeChamadosEmAbertos == null) {
			qtdeChamadosEmAbertos = atendimentoEjb.getQtdeChamadosEmAberto(
					idCliente, mesRelatorio);
		}
		return qtdeChamadosEmAbertos;
	}

	public Double getPorcentoAbertos() {
		if (porcentoAbertos == null) {
			porcentoAbertos = atendimentoEjb.getPorcentagemChamadosAbertos(
					idCliente, mesRelatorio);
		}
		return porcentoAbertos;
	}

	public Double getPorcentoFechados() {
		if (porcentoFechados == null) {
			porcentoFechados = atendimentoEjb.getPorcentagemChamadosFechados(
					idCliente, mesRelatorio);
		}
		return porcentoFechados;
	}

	public Double getPorcentoEmAbertos() {
		if (porcentoEmAbertos == null) {
			porcentoEmAbertos = atendimentoEjb.getPorcentagemChamadosEmAbertos(
					idCliente, mesRelatorio);
		}
		return porcentoEmAbertos;
	}

	public List<SolicitantesVO> getListaSolicitante() {
		if (listaSolicitante == null) {
			listaSolicitante = atendimentoEjb.getListaSolicitantes(idCliente,
					mesRelatorio);
		}
		return listaSolicitante;
	}

	public List<TipoChamadosVO> getListaTipoChamado() {
		if (listaTipoChamado == null) {
			listaTipoChamado = atendimentoEjb.getListaTipoChamado(idCliente,
					mesRelatorio);
		}
		return listaTipoChamado;
	}

	public List<ChamadoVO> getListaChamadosEmAbertos() {
		if (listaChamadoAberto == null) {
			listaChamadoAberto = atendimentoEjb.getListaChamadosEmAbertos(
					idCliente, mesRelatorio);
		}
		return listaChamadoAberto;
	}

	public List<ChamadoVO> getListaChamadosFechados() {
		if (listaChamadoFechado == null) {
			listaChamadoFechado = atendimentoEjb.getListaChamadosFechados(
					idCliente, mesRelatorio);
		}
		return listaChamadoFechado;
	}

	public List<IndicacoresQtdVO> getListaGeral() {
		listaGeral = new ArrayList<IndicacoresQtdVO>();

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

}
