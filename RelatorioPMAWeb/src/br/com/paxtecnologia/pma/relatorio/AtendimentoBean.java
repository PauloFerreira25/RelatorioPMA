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
	private Integer totalChamadosAbertos;
	private Double totalPorcentoAbertos;
	private Double totalPorcentoFechados;
	private Integer totalChamadosFechados;

	public void setMesRelatorio(String mesRelatorio) {
		this.mesRelatorio = mesRelatorio;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public Integer getTotalChamadosAbertos() {
		if (totalChamadosAbertos == null){
			totalChamadosAbertos = atendimentoEjb.getQtdeChamadosAbertos(idCliente,mesRelatorio);
		}
		return totalChamadosAbertos;
	}

	public Double getTotalPorcentoAbertos() {
		if (totalPorcentoAbertos == null){
			totalPorcentoAbertos = atendimentoEjb.getPorcentagemChamadosAbertos(idCliente, mesRelatorio);
		}
		return totalPorcentoAbertos;
	}

	public Double getTotalPorcentoFechados() {
		if (totalPorcentoFechados == null){
			totalPorcentoFechados = atendimentoEjb.getPorcentagemChamadosFechados(idCliente, mesRelatorio);
		}
		return totalPorcentoFechados;
	}

	public Integer getTotalChamadosFechados() {
		if (totalChamadosFechados == null){
			totalChamadosFechados = atendimentoEjb.getQtdeChamadosFechados(idCliente,mesRelatorio);
		}
		return totalChamadosFechados;
	}

	public List<IndicacoresQtdVO> getListaGeral() {
		listaGeral = new ArrayList<IndicacoresQtdVO>();

		IndicacoresQtdVO a = new IndicacoresQtdVO();
		a.setTexto("Número de Chamados Abertos");
		a.setValor(getTotalChamadosAbertos());
		listaGeral.add(a);

		IndicacoresQtdVO b = new IndicacoresQtdVO();
		b.setTexto("Número de Chamados Solucionados");
		b.setValor(getTotalChamadosFechados());
		listaGeral.add(b);

		IndicacoresQtdVO c = new IndicacoresQtdVO();
		c.setTexto("% de Chamados Solucionados");
		c.setValor(getTotalPorcentoFechados());
		listaGeral.add(c);

		IndicacoresQtdVO d = new IndicacoresQtdVO();
		d.setTexto("Tempo Médio para solucionar (em Horas)");
		d.setValor(atendimentoEjb.getTempoMedio(idCliente,mesRelatorio));
		listaGeral.add(d);

		IndicacoresQtdVO e = new IndicacoresQtdVO();
		e.setTexto("Número de Chamados em Aberto");
		e.setValor(atendimentoEjb.getQtdeChamadosEmAberto(idCliente,mesRelatorio));
		listaGeral.add(e);

		IndicacoresQtdVO f = new IndicacoresQtdVO();
		f.setTexto("% de Chamados em Aberto");
		f.setValor(atendimentoEjb.getPorcentagemChamadosEmAberto(idCliente,mesRelatorio));
		listaGeral.add(f);

		return listaGeral;
	}

	public List<SolicitantesVO> getListaSolicitante() {
		if(listaSolicitante == null){
			listaSolicitante = atendimentoEjb.getListaSolicitantes();
		}
		return listaSolicitante;
	}

	public List<TipoChamadosVO> getListaTipoChamado() {
		if(listaTipoChamado == null){
			listaTipoChamado = atendimentoEjb.getListaTipoChamado();
		}
		return listaTipoChamado;
	}

	public List<ChamadoVO> getListaChamadoEmAberto() {
		if(listaChamadoAberto == null){
			listaChamadoAberto = atendimentoEjb.getListaChamadoEmAberto();
		}
		return listaChamadoAberto;
	}

	public List<ChamadoVO> getListaChamadoFechado() {
		if(listaChamadoFechado == null){
			listaChamadoFechado = atendimentoEjb.getListaChamadoFechado();
		}
		return listaChamadoFechado;
	}

}
