package br.com.paxtecnologia.pma.relatorio;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.paxtecnologia.pma.relatorio.ejb.AtendimentoEjb;
import br.com.paxtecnologia.pma.relatorio.vo.HostVO;

@ViewScoped
@ManagedBean(name = "atendimentoHostBean")
public class AtendimentoHostBean {

	@EJB
	private AtendimentoEjb atendimentoEjb;

	@ManagedProperty(value = "#{clientesBean.idCliente}")
	private Integer idCliente;

	@ManagedProperty(value = "#{clientesBean.mesRelatorio}")
	private String mesRelatorio;

	private List<HostVO> listaHost;
	private Integer qtdeChamadosAbertosComHost;
	private Double porcentoAbertosComHost;
	private Double porcentoFechadosComHost;
	private Integer qtdeChamadosFechadosComHost;
	private String graficoAbertos;
	private String graficoFechados;

	
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public void setMesRelatorio(String mesRelatorio) {
		this.mesRelatorio = mesRelatorio;
	}

	public Integer getQtdeChamadosAbertosComHost() {
		if (qtdeChamadosAbertosComHost == null) {
			qtdeChamadosAbertosComHost = atendimentoEjb
					.getQtdeChamadosAbertosComHost(idCliente, mesRelatorio);
		}
		return qtdeChamadosAbertosComHost;
	}

	public Double getPorcentoAbertosComHost() {
		if (porcentoAbertosComHost == null) {
			porcentoAbertosComHost = atendimentoEjb.getPorcentoAbertosComHost(
					idCliente, mesRelatorio);
		}
		return porcentoAbertosComHost;
	}

	public Double getPorcentoFechadosComHost() {
		if (porcentoFechadosComHost == null) {
			porcentoFechadosComHost = atendimentoEjb
					.getPorcentoFechadosComHost(idCliente, mesRelatorio);
		}
		return porcentoFechadosComHost;
	}

	public Integer getQtdeChamadosFechadosComHost() {
		if (qtdeChamadosFechadosComHost == null) {
			qtdeChamadosFechadosComHost = atendimentoEjb
					.getQtdeChamadosFechadosComHost(idCliente, mesRelatorio);
		}
		return qtdeChamadosFechadosComHost;
	}

	public List<HostVO> getListaHost() {
		if (listaHost == null) {
			listaHost = atendimentoEjb.getListaHost(idCliente, mesRelatorio);
		}

		return listaHost;
	}

	public String getGraficoAbertos() {
		if (graficoAbertos == null) {
			graficoAbertos = atendimentoEjb.getGraficoAbertos(idCliente,
					mesRelatorio);
		}
		return graficoAbertos;

	}

	public String getGraficoFechados() {
		if (graficoFechados == null) {
			graficoFechados = atendimentoEjb.getGraficoFechados(idCliente,
					mesRelatorio);
		}
		return graficoFechados;

	}

}
