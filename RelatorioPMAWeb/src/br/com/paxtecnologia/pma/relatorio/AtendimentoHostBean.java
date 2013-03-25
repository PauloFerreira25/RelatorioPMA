package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.paxtecnologia.pma.relatorio.vo.HostVO;

@ViewScoped
@ManagedBean(name = "atendimentoHostBean")
public class AtendimentoHostBean {
	private List<HostVO> listaHost;
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

	public List<HostVO> getListaHost() {
		listaHost = new ArrayList<HostVO>();

		HostVO a = new HostVO();
		a.setHostname("oracle1");
		a.setQtdeAberto(16);
		a.setPorcentoAberto(50.00);
		a.setQtdeFechado(14);
		a.setPorcentoFechado(54.56);
		listaHost.add(a);

		HostVO b = new HostVO();
		b.setHostname("oracle2");
		b.setQtdeAberto(10);
		b.setPorcentoAberto(55.00);
		b.setQtdeFechado(11);
		b.setPorcentoFechado(44.56);
		listaHost.add(b);

		HostVO c = new HostVO();
		c.setHostname("oracle3");
		c.setQtdeAberto(5);
		c.setPorcentoAberto(25.00);
		c.setQtdeFechado(7);
		c.setPorcentoFechado(56.00);
		listaHost.add(c);

		return listaHost;
	}

}
