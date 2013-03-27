package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.paxtecnologia.pma.relatorio.vo.ParadasPorTipoVO;
import br.com.paxtecnologia.pma.relatorio.vo.ParadasVO;
import br.com.paxtecnologia.pma.relatorio.vo.UltimoAnoVO;

@ViewScoped
@ManagedBean(name = "paradasBean")
public class ParadasBean {

	private List<ParadasVO> listaItem;
	private List<UltimoAnoVO> listaUltimosAnosHoras;
	private List<ParadasPorTipoVO> listaParadasEvitadas;
	private List<ParadasPorTipoVO> listaParadasNaoProgramadas;
	private List<ParadasPorTipoVO> listaParadasProgramadasEstrategicas;
	private List<ParadasPorTipoVO> listaParadasProgramadas;

	public List<UltimoAnoVO> getListaUltimosAnosHoras(){
		
		listaUltimosAnosHoras = new ArrayList<UltimoAnoVO>();				
		
		UltimoAnoVO a = new UltimoAnoVO();
		a.setAno("2012");
		a.setHoras(9.0);
		listaUltimosAnosHoras.add(a);
		
		UltimoAnoVO b = new UltimoAnoVO();
		b.setAno("2011");
		b.setHoras(19.0);
		listaUltimosAnosHoras.add(b);
		
		return listaUltimosAnosHoras;
	}
	
	
	public List<ParadasVO> getListaResumo() {
		listaItem = new ArrayList<ParadasVO>();
		
		ParadasVO a = new ParadasVO();
		a.setTipo("Paradas Evitadas");
		a.setSigla("PE");
		a.setQtde(0);
		listaItem.add(a);
		
		ParadasVO b = new ParadasVO();
		b.setTipo("Paradas Não Programadas");
		b.setSigla("PNP");
		b.setQtde(2);
		listaItem.add(b);
		
		ParadasVO c = new ParadasVO();
		c.setTipo("Paradas Programadas Estratégicas");
		c.setSigla("PPE");
		c.setQtde(0);
		listaItem.add(c);
		
		ParadasVO d = new ParadasVO();
		d.setTipo("Paradas Programadas");
		d.setSigla("PP");
		d.setQtde(0);
		listaItem.add(d);
		return listaItem;
	}
	
	
	public List<ParadasPorTipoVO> getListaParadasEvitadas() {
		listaParadasEvitadas = new ArrayList<ParadasPorTipoVO>();
		
		
		ParadasPorTipoVO a = new ParadasPorTipoVO();
		a.setIdchamado("VERZANI-250");
		a.setData("19/02/2013");
		a.setHoras(0.34);
		a.setHost("oracle2");
		a.setDescricao("Parti��o /u01 deu problema");
		listaParadasEvitadas.add(a);
		
		return listaParadasEvitadas;
	
	}
	
	public List<ParadasPorTipoVO> getListaParadasNaoProgramadas() {
		listaParadasNaoProgramadas = new ArrayList<ParadasPorTipoVO>();
		
		ParadasPorTipoVO a = new ParadasPorTipoVO();
		a.setIdchamado("VERZANI-245");
		a.setData("13/02/2013");
		a.setHoras(0.50);
		a.setHost("oracle2");
		a.setDescricao("Lentid�o");
		listaParadasNaoProgramadas.add(a);
		
		return listaParadasNaoProgramadas;
	
	}
	
	public List<ParadasPorTipoVO> getListaParadasProgramadasEstrategicas() {
		listaParadasProgramadasEstrategicas = new ArrayList<ParadasPorTipoVO>();
		
		ParadasPorTipoVO a = new ParadasPorTipoVO();
		a.setIdchamado("VERZANI-246");
		a.setData("13/02/2013");
		a.setHoras(0.80);
		a.setHost("oracle3");
		a.setDescricao("Backup");
		listaParadasProgramadasEstrategicas.add(a);
		
		return listaParadasProgramadasEstrategicas;
	
	}
	
	public List<ParadasPorTipoVO> getListaParadasProgramadas() {
		listaParadasProgramadas = new ArrayList<ParadasPorTipoVO>();
		
		ParadasPorTipoVO a = new ParadasPorTipoVO();
		a.setIdchamado("VERZANI-247");
		a.setData("13/02/2013");
		a.setHoras(0.89);
		a.setHost("oracle3");
		a.setDescricao("Backup urgente");
		listaParadasProgramadas.add(a);
		
		return listaParadasProgramadas;
	
	}
}
