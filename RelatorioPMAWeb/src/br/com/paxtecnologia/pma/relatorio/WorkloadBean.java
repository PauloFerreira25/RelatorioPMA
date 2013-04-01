package br.com.paxtecnologia.pma.relatorio;

import java.util.List;

import br.com.paxtecnologia.pma.relatorio.vo.TimeframeVO;


public class WorkloadBean {
	
	private List <TimeframeVO> listaPrincipalXtimeframe_mesTF1;
	private List <TimeframeVO> listaPrincipalXtimeframe_mesTF2;
	private List <TimeframeVO> listaPrincipalXtimeframe_mesTF3;
	
	
	public List <TimeframeVO> getListaPrincipalXtimeframe_mesTF1() {
		TimeframeVO a = new TimeframeVO();
		a.settF(15.0);
		listaPrincipalXtimeframe_mesTF1.add(a);
		TimeframeVO b = new TimeframeVO();
		b.settF(15.0);
		listaPrincipalXtimeframe_mesTF1.add(b);
		TimeframeVO c = new TimeframeVO();
		c.settF(15.0);
		listaPrincipalXtimeframe_mesTF1.add(c);
	return listaPrincipalXtimeframe_mesTF1;
	} 
	
	public List <TimeframeVO> getListaPrincipalXtimeframe_meTF2s() {
		TimeframeVO a = new TimeframeVO();
		a.settF(15.0);
		listaPrincipalXtimeframe_mesTF2.add(a);
		TimeframeVO b = new TimeframeVO();
		b.settF(15.0);
		listaPrincipalXtimeframe_mesTF2.add(b);
		TimeframeVO c = new TimeframeVO();
		c.settF(15.0);
		listaPrincipalXtimeframe_mesTF2.add(c);
	return listaPrincipalXtimeframe_mesTF2;
	}
	
	public List <TimeframeVO> getListaPrincipalXtimeframe_mesTF3() {
		TimeframeVO a = new TimeframeVO();
		a.settF(15.0);
		listaPrincipalXtimeframe_mesTF3.add(a);
		TimeframeVO b = new TimeframeVO();
		b.settF(15.0);
		listaPrincipalXtimeframe_mesTF3.add(b);
		TimeframeVO c = new TimeframeVO();
		c.settF(15.0);
		listaPrincipalXtimeframe_mesTF3.add(c);
	return listaPrincipalXtimeframe_mesTF3;
	}
}
