package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.paxtecnologia.pma.relatorio.ejb.ParadasEjb;
import br.com.paxtecnologia.pma.relatorio.vo.ParadasPorTipoVO;
import br.com.paxtecnologia.pma.relatorio.vo.ParadasVO;
import br.com.paxtecnologia.pma.relatorio.vo.UltimoAnoVO;

@ViewScoped
@ManagedBean(name = "paradasBean")
public class ParadasBean {

	@EJB
	private ParadasEjb paradasEjb;

	@ManagedProperty(value = "#{clientesBean.idCliente}")
	private Integer idCliente;

	@ManagedProperty(value = "#{clientesBean.mesRelatorio}")
	private String mesRelatorio;

	private List<ParadasVO> listaItem;
	private List<UltimoAnoVO> listaUltimosAnosHoras;
	private List<ParadasPorTipoVO> listaParadasEvitadas;
	private List<ParadasPorTipoVO> listaParadasNaoProgramadas;
	private List<ParadasPorTipoVO> listaParadasProgramadasEstrategicas;
	private List<ParadasPorTipoVO> listaParadasProgramadas;
	private Integer diasTrabalhados;
	private Integer qtdeParadasEvitadasTotal;

	public Integer getDiasTrabalhados() {
		if (diasTrabalhados == null) {
			diasTrabalhados = paradasEjb.getDiasTrabalhados(idCliente,
					mesRelatorio);
		}
		return diasTrabalhados;
	}

	public Integer getQtdeParadasEvitadasTotal() {
		if (qtdeParadasEvitadasTotal == null) {
			qtdeParadasEvitadasTotal = paradasEjb.getQtdeParadaEvitadasTotal(
					idCliente, mesRelatorio);
		}
		return qtdeParadasEvitadasTotal;
	}

	public void setMesRelatorio(String mesRelatorio) {
		this.mesRelatorio = mesRelatorio;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public List<UltimoAnoVO> getListaUltimosAnosHoras() {

		if (listaUltimosAnosHoras == null) {
			listaUltimosAnosHoras = paradasEjb.getListaUltimosAnosHoras(
					idCliente, mesRelatorio);
		}

		return listaUltimosAnosHoras;
	}

	public List<ParadasVO> getListaResumo() {
		if (listaItem == null) {

			listaItem = new ArrayList<ParadasVO>();

			ParadasVO a = new ParadasVO();
			a.setTipo("Paradas Evitadas");
			a.setSigla("PE");
			a.setQtde(paradasEjb.getQtdeParadaEvitadas(idCliente, mesRelatorio));
			listaItem.add(a);

			ParadasVO b = new ParadasVO();
			b.setTipo("Paradas Não Programadas");
			b.setSigla("PNP");
			b.setQtde(paradasEjb.getQtdeParadaNaoProgramadas(idCliente,
					mesRelatorio));
			listaItem.add(b);

			ParadasVO c = new ParadasVO();
			c.setTipo("Paradas Programadas Estratégicas");
			c.setSigla("PPE");
			c.setQtde(paradasEjb.getQtdeProgramadasEstrategicas(idCliente,
					mesRelatorio));
			listaItem.add(c);

			ParadasVO d = new ParadasVO();
			d.setTipo("Paradas Programadas");
			d.setSigla("PP");
			d.setQtde(paradasEjb.getQtdeParadaProgramadas(idCliente,
					mesRelatorio));
			listaItem.add(d);
		}
		return listaItem;
	}

	public List<ParadasPorTipoVO> getListaParadasEvitadas() {
		if (listaParadasEvitadas == null) {
			listaParadasEvitadas = paradasEjb.getListaParadasEvitadas(
					idCliente, mesRelatorio);
		}
		return listaParadasEvitadas;
	}

	public List<ParadasPorTipoVO> getListaParadasNaoProgramadas() {
		if (listaParadasNaoProgramadas == null) {
			listaParadasNaoProgramadas = paradasEjb
					.getListaParadasNaoProgramadas(idCliente, mesRelatorio);
		}
		return listaParadasNaoProgramadas;
	}

	public List<ParadasPorTipoVO> getListaParadasProgramadasEstrategicas() {
		if (listaParadasProgramadasEstrategicas == null) {
			listaParadasProgramadasEstrategicas = paradasEjb
					.getListaParadasProgramadasEstrategicas(idCliente,
							mesRelatorio);
		}
		return listaParadasProgramadasEstrategicas;
	}

	public List<ParadasPorTipoVO> getListaParadasProgramadas() {
		if (listaParadasProgramadas == null) {
			listaParadasProgramadas = paradasEjb.getListaParadasProgramadas(
					idCliente, mesRelatorio);
		}
		return listaParadasProgramadas;
	}
}
