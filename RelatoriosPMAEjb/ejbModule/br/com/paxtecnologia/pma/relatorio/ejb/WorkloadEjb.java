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

	public String getLabel(Integer idGrafico, Integer idTf) {
		return workloadDao.getLabel(idGrafico, idTf);
	}

	public String getLabelTitulo(Integer idGrafico) {
		return workloadDao.getLabelTitulo(idGrafico);
	}

	public String getTf(Integer idCliente, String mesRelatorio,
			Integer idGrafico, Integer idTf) {
		WorkloadGraficoVO grafico = workloadDao.getGrafico(idCliente, idGrafico);
		return geraTfCalculoSoMetrica(mesRelatorio, idTf, grafico);
	}

	private String geraTfCalculoSoMetrica(String mesRelatorio, Integer idTf,
			WorkloadGraficoVO grafico) {
		String tf = null;
		GraficoMetricaVO graficoMetrica = workloadDao.getMetrica(grafico, idTf);
		switch (graficoMetrica.getTipo_horario()) {
		case 1:
			tf = getTfCalculo8as18(graficoMetrica.getMetrica(), mesRelatorio, grafico.getGraficoId());
			break;
		 case 2:
		 tf = getTfCalculo24horas(graficoMetrica.getMetrica(), mesRelatorio, grafico.getGraficoId());
		 	break;
		 case 3:
		 tf = getTfCalculo0a8e23a24(graficoMetrica.getMetrica(), mesRelatorio, grafico.getGraficoId());
		 	break;
		 case 4:
		 tf = getTfCalculo18a23(graficoMetrica.getMetrica(), mesRelatorio, grafico.getGraficoId());
		 	break;
		default:
			break;
		}

		return tf;
	}

	private String getTfCalculo18a23(Integer metrica, String mesRelatorio, Integer idGrafico) {
		List<TimeFrameVO> timeFrameList = null;
		if (idGrafico%2!=0) { //impar = mensal
			 timeFrameList = workloadDao.getTimeFrame18a23(metrica, mesRelatorio);
			return formataTimeFram(timeFrameList);
		} else{ //par = mensal
			timeFrameList = workloadDao.getTimeFrameAno18a23(metrica, mesRelatorio);
			return formataTimeFramAno(timeFrameList);
		}	
	}

	private String getTfCalculo0a8e23a24(Integer metrica, String mesRelatorio, Integer idGrafico) {
		List<TimeFrameVO> timeFrameList = null;
		if (idGrafico%2!=0) { //impar
			timeFrameList = workloadDao.getTimeFrame0a8e23a24(
					metrica, mesRelatorio);
			return formataTimeFram(timeFrameList);
		} else { //impar
			timeFrameList = workloadDao.getTimeFrameAno0a8e23a24(
					metrica, mesRelatorio);
			return formataTimeFramAno(timeFrameList);
		}
	}

	private String getTfCalculo24horas(Integer metrica, String mesRelatorio, Integer idGrafico) {
		List<TimeFrameVO> timeFrameList = null;
		if (idGrafico%2!=0) { //impar
			timeFrameList = workloadDao.getTimeFrame24horas(
					metrica, mesRelatorio);
			return formataTimeFram(timeFrameList);
		} else { //par
			timeFrameList = workloadDao.getTimeFrameAno24horas(
					metrica, mesRelatorio);
			return formataTimeFramAno(timeFrameList);
		}
	}

	private String getTfCalculo8as18(Integer metrica, String mesRelatorio, Integer idGrafico) {
		List<TimeFrameVO> timeFrameList = null;
		if (idGrafico%2!=0) { //impar
			timeFrameList = workloadDao.getTimeFrame8a18(metrica,
					mesRelatorio);
			return formataTimeFram(timeFrameList);
		} else { //par
			timeFrameList = workloadDao.getTimeFrameAno8a18(metrica,
					mesRelatorio);
			return formataTimeFramAno(timeFrameList);
		}
	}

	private String formataTimeFram(List<TimeFrameVO> timeFrameList) {
		String saida = "[";
		Iterator<TimeFrameVO> itTime = timeFrameList.iterator();
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
		saida = saida.substring(0,saida.length()-1);
		saida = saida + "]";
		return saida;
	}

	private String formataTimeFramAno(List<TimeFrameVO> timeFrameList) {
		String saida = "[";
		Iterator<TimeFrameVO> itTime = timeFrameList.iterator();
		DecimalFormat df = new DecimalFormat("###");
		while (itTime.hasNext()) {
			TimeFrameVO timeFrame = itTime.next();
				saida = saida
						+ "["
						+ "(new Date("+timeFrame.getData().substring(3, 7) +","+(Integer.parseInt(timeFrame.getData().substring(0, 2))-1)+")).getTime()"
						+ "," + df.format(timeFrame.getValor()) + "],";
		}
		saida = saida.substring(0,saida.length()-1);
		saida = saida + "]";
		return saida;
	}	
}
