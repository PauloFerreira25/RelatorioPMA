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
	private List<ParadasPorTipoVO> listaParadasEvitadasMes;
	private List<ParadasPorTipoVO> listaParadasNaoProgramadasMes;
	private List<ParadasPorTipoVO> listaParadasProgramadasEstrategicasMes;
	private List<ParadasPorTipoVO> listaParadasProgramadasMes;
	private Integer diasTrabalhados;
	private Integer qtdeParadasEvitadasTotal;

	private static String PARADAS_EVITADAS = "PE";
	private static String PARADAS_NAO_PROGRAMADAS = "PNP";
	private static String PARADAS_PROGRAMADAS_ESTRATEGICAS = "PPE";
	private static String PARADAS_PROGRAMADAS = "PP";
	
	public Integer getDiasTrabalhados() {
		if (diasTrabalhados == null) {
			diasTrabalhados = paradasEjb.getDiasTrabalhados(idCliente, mesRelatorio);
		}
		return diasTrabalhados;
	}

	public Integer getQtdeParadasEvitadasTotal() {
		if (qtdeParadasEvitadasTotal == null) {
			qtdeParadasEvitadasTotal = paradasEjb.getQtdeParadaEvitadasTotal(idCliente, mesRelatorio);
		}
		return qtdeParadasEvitadasTotal;
	}

	public void setMesRelatorio(String mesRelatorio) {
		this.mesRelatorio = mesRelatorio;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public List<UltimoAnoVO> getListaUltimosAnosHoras(String tipo) {
		if (listaUltimosAnosHoras == null) {
			listaUltimosAnosHoras = paradasEjb.getListaUltimosAnosHoras(idCliente, tipo, mesRelatorio);
		}
		return listaUltimosAnosHoras;
	}

	public List<ParadasVO> getListaResumo() {
		if (listaItem == null) {

			listaItem = new ArrayList<ParadasVO>();

			ParadasVO a = new ParadasVO();
			a.setTipo("Paradas Evitadas");
			a.setSigla(PARADAS_EVITADAS);
			a.setQtde(paradasEjb.getQtdeParadaEvitadas(idCliente, mesRelatorio, PARADAS_EVITADAS));
			listaItem.add(a);

			ParadasVO b = new ParadasVO();
			b.setTipo("Paradas N�o Programadas");
			b.setSigla(PARADAS_NAO_PROGRAMADAS);
			b.setQtde(paradasEjb.getQtdeParadaNaoProgramadas(idCliente,	mesRelatorio, PARADAS_NAO_PROGRAMADAS));
			listaItem.add(b);

			ParadasVO c = new ParadasVO();
			c.setTipo("Paradas Programadas Estrat�gicas");
			c.setSigla(PARADAS_PROGRAMADAS_ESTRATEGICAS);
			c.setQtde(paradasEjb.getQtdeProgramadasEstrategicas(idCliente, mesRelatorio, PARADAS_PROGRAMADAS_ESTRATEGICAS));
			listaItem.add(c);

			ParadasVO d = new ParadasVO();
			d.setTipo("Paradas Programadas");
			d.setSigla(PARADAS_PROGRAMADAS);
			d.setQtde(paradasEjb.getQtdeParadaProgramadas(idCliente, mesRelatorio, PARADAS_PROGRAMADAS));
			listaItem.add(d);
		}
		return listaItem;
	}

	public List<ParadasPorTipoVO> getListaParadasEvitadasMes() {
		if (listaParadasEvitadasMes == null) {
			listaParadasEvitadasMes = paradasEjb.getListaParadasEvitadasMes(idCliente, mesRelatorio, PARADAS_EVITADAS);
		}
		return listaParadasEvitadasMes;
	}

	public List<ParadasPorTipoVO> getListaParadasNaoProgramadasMes() {
		if (listaParadasNaoProgramadasMes == null) {
			listaParadasNaoProgramadasMes = paradasEjb.getListaParadasNaoProgramadasMes(idCliente, mesRelatorio, PARADAS_NAO_PROGRAMADAS);
		}
		return listaParadasNaoProgramadasMes;
	}

	public List<ParadasPorTipoVO> getListaParadasProgramadasEstrategicasMes() {
		if (listaParadasProgramadasEstrategicasMes == null) {
			listaParadasProgramadasEstrategicasMes = paradasEjb.getListaParadasProgramadasEstrategicasMes(idCliente, mesRelatorio, PARADAS_PROGRAMADAS_ESTRATEGICAS);
		}
		return listaParadasProgramadasEstrategicasMes;
	}

	public List<ParadasPorTipoVO> getListaParadasProgramadasMes() {
		if (listaParadasProgramadasMes == null) {
			listaParadasProgramadasMes = paradasEjb.getListaParadasProgramadasMes(idCliente, mesRelatorio, PARADAS_PROGRAMADAS);
		}
		return listaParadasProgramadasMes;
	}
	
	public String getParadas(String tipo) {
		return paradasEjb.getParadas(tipo,mesRelatorio);
	}
	
	public Double getTempoParadasMes(String tipo) {
		return paradasEjb.getTempoParadasMes(tipo,mesRelatorio);
	}
}
