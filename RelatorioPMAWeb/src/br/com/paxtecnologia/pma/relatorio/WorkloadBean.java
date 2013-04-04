package br.com.paxtecnologia.pma.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.paxtecnologia.pma.relatorio.vo.TimeframeVO;

@ViewScoped
@ManagedBean(name = "workloadBean")
public class WorkloadBean {

//	private String valor1;
//	private String valor2;
//	private String valor3;

	public String getValor1() {
		return "[[1,19],[2,7],[3,28],[4,10],"
				+ "[5,4],[6,10],[7,18],[8,16],[9,28],[10,9],"
				+ "[11,14],[12,15],[13,15],[14,27],[15,8],[16,11],"
				+ "[17,7],[18,5],[19,15],[20,12],[21,10],[22,2],[23,25]"
				+ ",[24,19], [25,7],[26,22],[27,8],[28,1],[29,27],[30,15],[31,15]]";
	}

	public String getValor2() {
		return "[[1,19],[2,7],[3,28],[4,10],"
				+ "[5,4],[6,10],[7,18],[8,16],[9,28],[10,9],"
				+ "[11,14],[12,15],[13,15],[14,27],[15,8],[16,11],"
				+ "[17,7],[18,5],[19,15],[20,12],[21,10],[22,2],[23,25]"
				+ ",[24,19], [25,7],[26,22],[27,8],[28,1],[29,27],[30,15],[31,15]]";
	}

	public String getValor3() {
		return "[[1,19],[2,7],[3,28],[4,10],"
				+ "[5,4],[6,10],[7,18],[8,16],[9,28],[10,9],"
				+ "[11,14],[12,15],[13,15],[14,27],[15,8],[16,11],"
				+ "[17,7],[18,5],[19,15],[20,12],[21,10],[22,2],[23,25]"
				+ ",[24,19], [25,7],[26,22],[27,8],[28,1],[29,27],[30,15],[31,15]]";
	}

}
