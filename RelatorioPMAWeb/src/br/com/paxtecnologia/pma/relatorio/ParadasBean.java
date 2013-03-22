package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.paxtecnologia.pma.relatorio.vo.ParadasVO;

@ViewScoped
@ManagedBean(name = "paradasBean")
public class ParadasBean {

	private List<ParadasVO> listaItem;

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
}
