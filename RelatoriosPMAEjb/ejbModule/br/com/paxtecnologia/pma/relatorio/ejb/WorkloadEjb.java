package br.com.paxtecnologia.pma.relatorio.ejb;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;

import br.com.paxtecnologia.pma.relatorio.dao.WorkloadDAO;
import br.com.paxtecnologia.pma.relatorio.vo.GraficoMetricaVO;
import br.com.paxtecnologia.pma.relatorio.vo.TimeFrameVO;
import br.com.paxtecnologia.pma.relatorio.vo.WorkloadGraficoVO;

@Stateless
public class WorkloadEjb {

	private WorkloadDAO workloadDao = new WorkloadDAO();

	private String label;

	public String getLabel(Integer idCliente, String mesRelatorio,
			Integer idGrafico, Integer idLabel) {
		// TODO Auto-generated method stub
		return label;
	}

	public String getTf(Integer idCliente, String mesRelatorio,
			Integer idGrafico, Integer idTf) {
		String tf = null;
		WorkloadGraficoVO grafico = workloadDao
				.getGrafico(idCliente, idGrafico);
		switch (grafico.getTipo_calculo()) {
		case 1:
			tf = geraTfCalculoSoMetrica(mesRelatorio, idTf, grafico);
			break;
		case 2:
			tf = geraTfCalculoSoMetrica(mesRelatorio, idTf, grafico);
			break;
		default:
			break;
		}
		return tf;
	}

	private String geraTfCalculoSoMetrica(String mesRelatorio, Integer idTf,
			WorkloadGraficoVO grafico) {
		String tf = null;
		GraficoMetricaVO graficoMetrica = workloadDao.getMetrica(grafico, idTf);
		switch (graficoMetrica.getTipo_horario()) {
		case 1:
			tf = getTfCalculo8as18(graficoMetrica.getMetrica(), mesRelatorio);
			break;
		 case 2:
		 tf = getTfCalculo24horas(graficoMetrica.getMetrica(), mesRelatorio);
		 break;
		 case 3:
		 tf = getTfCalculo0a8e23a24(graficoMetrica.getMetrica(),
		 mesRelatorio);
		 break;
		 case 4:
		 tf = getTfCalculo18a23(graficoMetrica.getMetrica(), mesRelatorio);
		 break;
		default:
			break;
		}

		return tf;
	}

	private String getTfCalculo18a23(Integer metrica, String mesRelatorio) {
		List<TimeFrameVO> timeFrameList = workloadDao.getTimeFrame18a23(
				metrica, mesRelatorio);

		return formataTimeFram(timeFrameList);
	}

	private String getTfCalculo0a8e23a24(Integer metrica, String mesRelatorio) {
		List<TimeFrameVO> timeFrameList = workloadDao.getTimeFrame0a8e23a24(
				metrica, mesRelatorio);

		return formataTimeFram(timeFrameList);
	}

	private String getTfCalculo24horas(Integer metrica, String mesRelatorio) {
		List<TimeFrameVO> timeFrameList = workloadDao.getTimeFrame24horas(
				metrica, mesRelatorio);

		return formataTimeFram(timeFrameList);
	}

	private String getTfCalculo8as18(Integer metrica, String mesRelatorio) {
		List<TimeFrameVO> timeFrameList = workloadDao.getTimeFrame8a18(metrica,
				mesRelatorio);

		return formataTimeFram(timeFrameList);

	}

	private String formataTimeFram(List<TimeFrameVO> timeFrameList) {
		String saida;
		Iterator<TimeFrameVO> itTime = timeFrameList.iterator();
		saida = "[";
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
		DecimalFormat df = new DecimalFormat("###");
		while (itTime.hasNext()) {
			TimeFrameVO timeFrame = itTime.next();
			try {
				saida = saida
						+ "["
						+ sdf2.format(sdf1.parse(timeFrame.getData()).getTime())
						+ "," + df.format(timeFrame.getValor()) + "],";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		saida = saida + "]";

		return saida;
	}

}
