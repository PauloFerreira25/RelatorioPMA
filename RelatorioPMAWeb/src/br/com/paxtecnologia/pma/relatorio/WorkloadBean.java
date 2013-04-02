package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.paxtecnologia.pma.relatorio.vo.TimeframeVO;

@ViewScoped
@ManagedBean(name = "workloadBean")
public class WorkloadBean {
	
	private List<TimeframeVO> listaPrincipalXtimeframe_mesTF1;
	
	
	public List <TimeframeVO> getListaPrincipalXtimeframe_mes() {
		
		listaPrincipalXtimeframe_mesTF1 = new ArrayList<TimeframeVO>();
				
		TimeframeVO a = new TimeframeVO();
		a.setTf("[{ label: \"TF1: 8 - 18 Horas\",  data: 25}");
		listaPrincipalXtimeframe_mesTF1.add(a);
		
		TimeframeVO b = new TimeframeVO();
		b.setTf(",{ label: \"TF1: 8 - 18 Horas\",  data: 20}");
		listaPrincipalXtimeframe_mesTF1.add(b);
		
		TimeframeVO c = new TimeframeVO();
		b.setTf(",{ label: \"TF1: 8 - 18 Horas\",  data: 25}]");
		listaPrincipalXtimeframe_mesTF1.add(c);
		
	return listaPrincipalXtimeframe_mesTF1;
	} 
	
	public String getPrincipal_tf1(){
		String saida = new String();
		saida = "[{ label: \"TF1: 8 - 18 Horas\",  data: 25},{ label: \"TF1: 8 - 18 Horas\",  data: 20},{ label: \"TF1: 8 - 18 Horas\",  data: 25}]";
		return saida;
	}
	
	
}
