package br.com.paxtecnologia.pma.relatorio.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.paxtecnologia.pma.relatorio.dao.AtendimentoDAO;
import br.com.paxtecnologia.pma.relatorio.vo.ChamadoVO;
import br.com.paxtecnologia.pma.relatorio.vo.HostVO;
import br.com.paxtecnologia.pma.relatorio.vo.SolicitantesVO;
import br.com.paxtecnologia.pma.relatorio.vo.TipoChamadosVO;

@Stateless
public class AtendimentoEjb {

	private AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

	private Integer qtdeChamadoAberto;
	private Double porcentagemChamadosAbertos;
	private Integer qtdeChamadoFechado;
	private Integer qtdeChamadoEmAberto;
	private List<ChamadoVO> listaChamadoAberto;
	private List<ChamadoVO> listaChamadoFechado;
	private List<ChamadoVO> listaChamadoEmAberto;
	private List<SolicitantesVO> listaSolicitante;
	private List<TipoChamadosVO> listaTipoChamado;

	// Conta Porcentagem
	private Double getPorcentagem(Integer valor1, Integer valor2) {
		Double porcentagem = valor2.doubleValue() / valor1.doubleValue();
		return porcentagem;
	}

	// Quantidade de Chamados Abertos
	public Integer getQtdeChamadosAbertos(Integer idCliente, String mesRelatorio) {
		if (qtdeChamadoAberto == null) {
			if (listaChamadoAberto == null) {
				getChamadosAbertos(idCliente, mesRelatorio);
			}
			qtdeChamadoAberto = listaChamadoAberto.size();
		}
		return qtdeChamadoAberto;
	}

	// Quantidade de Chamdos Fechados
	public Integer getQtdeChamadosFechados(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadoFechado == null) {
			if (listaChamadoFechado == null) {
				getChamadosFechados(idCliente, mesRelatorio);
			}
			qtdeChamadoFechado = listaChamadoFechado.size();
		}
		return qtdeChamadoFechado;
	}

	// Quantidade de Chamados em Aberto
	public Integer getQtdeChamadosEmAberto(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadoEmAberto == null) {
			if (listaChamadoEmAberto == null) {
				listaChamadoEmAberto = getChamadosEmAberto(idCliente,
						mesRelatorio);
			}
			qtdeChamadoEmAberto = listaChamadoEmAberto.size();
		}
		return qtdeChamadoEmAberto;
	}

	public Integer getQtdeChamadosFechadosComHost(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getQtdeChamadosAbertosComHost(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	// ////////////////////////////////

	public Double getPorcentoFechadosComHost(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPorcentoAbertosComHost(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	// Porcentagem em Aberto
	public Double getPorcentagemChamadosAbertos(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosAbertos == null) {
			if (qtdeChamadoAberto == null) {
				getQtdeChamadosAbertos(idCliente, mesRelatorio);
			}
			if (qtdeChamadoFechado == null) {
				getQtdeChamadosFechados(idCliente, mesRelatorio);
			}
			porcentagemChamadosAbertos = getPorcentagem(qtdeChamadoFechado,
					qtdeChamadoAberto);
		}
		return porcentagemChamadosAbertos;
	}

	public Double getPorcentagemChamadosEmAbertos(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPorcentagemChamadosFechados(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	// ////////////////////////////////

	public Double getTempoMedio(Integer idCliente, String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	// ////////////////////////////////

	// Lista de Chamados Abertos
	public List<ChamadoVO> getChamadosAbertos(Integer idCliente,
			String mesRelatorio) {
		if (listaChamadoAberto == null) {
			listaChamadoAberto = atendimentoDAO.getChamadosAbertos(idCliente,
					mesRelatorio);
		}
		return listaChamadoAberto;
	}

	// Lista de Chamados Fechados
	public List<ChamadoVO> getChamadosFechados(Integer idCliente,
			String mesRelatorio) {
		if (listaChamadoFechado == null) {
			listaChamadoFechado = atendimentoDAO.getChamadosFechados(idCliente,
					mesRelatorio);
		}
		return listaChamadoFechado;
	}

	// Lista de Chamados em Aberto
	public List<ChamadoVO> getChamadosEmAberto(Integer idCliente,
			String mesRelatorio) {
		if (listaChamadoEmAberto == null) {
			listaChamadoEmAberto = atendimentoDAO.getChamadosEmAberto(
					idCliente, mesRelatorio);
		}
		return listaChamadoEmAberto;
	}

	public List<SolicitantesVO> getListaSolicitantes() {
		listaSolicitante = new ArrayList<SolicitantesVO>();

		SolicitantesVO a = new SolicitantesVO();
		a.setSolictante("Marcelo");
		a.setQtdeAberto(2);
		a.setPorcentoAberto(20.00);
		a.setQtdeFechado(5);
		a.setPorcentoFechado(23.56);
		listaSolicitante.add(a);

		SolicitantesVO b = new SolicitantesVO();
		b.setSolictante("PAX");
		b.setQtdeAberto(7);
		b.setPorcentoAberto(70.00);
		b.setQtdeFechado(4);
		b.setPorcentoFechado(58.56);
		listaSolicitante.add(b);

		SolicitantesVO c = new SolicitantesVO();
		c.setSolictante("Sérgio");
		c.setQtdeAberto(7);
		c.setPorcentoAberto(70.00);
		c.setQtdeFechado(4);
		c.setPorcentoFechado(58.56);
		listaSolicitante.add(c);
		return listaSolicitante;
	}

	public List<TipoChamadosVO> getListaTipoChamado() {
		listaTipoChamado = new ArrayList<TipoChamadosVO>();

		TipoChamadosVO a = new TipoChamadosVO();
		a.setTipo("Incidente");
		a.setQtdeAberto(16);
		a.setPorcentoAberto(50.00);
		a.setQtdeFechado(14);
		a.setPorcentoFechado(54.56);
		listaTipoChamado.add(a);

		TipoChamadosVO b = new TipoChamadosVO();
		b.setTipo("Mudança");
		b.setQtdeAberto(1);
		b.setPorcentoAberto(7.14);
		b.setQtdeFechado(2);
		b.setPorcentoFechado(4.56);
		listaTipoChamado.add(b);

		TipoChamadosVO c = new TipoChamadosVO();
		c.setTipo("Task");
		c.setQtdeAberto(11);
		c.setPorcentoAberto(35.71);
		c.setQtdeFechado(10);
		c.setPorcentoFechado(44.56);
		listaTipoChamado.add(c);

		return listaTipoChamado;
	}

	public List<ChamadoVO> getListaChamadoEmAberto() {
		listaChamadoEmAberto = new ArrayList<ChamadoVO>();

		ChamadoVO a = new ChamadoVO();
		a.setIdChamado("VERZANI-219");
		a.setTitulo("[oracle3] Criação relatório");
		a.setDataAbertura("09 Jan 2013");
		a.setStatus("Open");
		a.setTipoChamado("Task");
		listaChamadoEmAberto.add(a);

		ChamadoVO b = new ChamadoVO();
		b.setIdChamado("VERZANI-220");
		b.setTitulo("[oracle3] Criação relatório");
		b.setDataAbertura("12 Jan 2013");
		b.setStatus("Open");
		b.setTipoChamado("Task");
		listaChamadoEmAberto.add(b);

		ChamadoVO c = new ChamadoVO();
		c.setIdChamado("VERZANI-221");
		c.setTitulo("[oracle3] Criação relatório");
		c.setDataAbertura("15 Jan 2013");
		c.setStatus("Reopened");
		c.setTipoChamado("Task");
		listaChamadoEmAberto.add(c);

		return listaChamadoEmAberto;
	}

	public List<ChamadoVO> getListaChamadoFechado() {
		listaChamadoFechado = new ArrayList<ChamadoVO>();

		ChamadoVO a = new ChamadoVO();
		a.setIdChamado("VERZANI-219");
		a.setTitulo("[oracle3] Criação relatório");
		a.setDataAbertura("09 Jan 2013");
		a.setStatus("Open");
		a.setTipoChamado("Task");
		listaChamadoFechado.add(a);

		ChamadoVO b = new ChamadoVO();
		b.setIdChamado("VERZANI-220");
		b.setTitulo("[oracle3] Criação relatório");
		b.setDataAbertura("12 Jan 2013");
		b.setStatus("Open");
		b.setTipoChamado("Task");
		listaChamadoFechado.add(b);

		ChamadoVO c = new ChamadoVO();
		c.setIdChamado("VERZANI-221");
		c.setTitulo("[oracle3] Criação relatório");
		c.setDataAbertura("15 Jan 2013");
		c.setStatus("Reopened");
		c.setTipoChamado("Task");
		listaChamadoFechado.add(c);

		return listaChamadoFechado;
	}

	public List<HostVO> getListaHost(Integer idCliente, String mesRelatorio) {
		// TODO Auto-generated method stub
		ArrayList<HostVO> listaHost = new ArrayList<HostVO>();

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

	public String getGraficoFechados(Integer idCliente, String mesRelatorio) {
		// TODO Auto-generated method stub
		String saida = new String();
		saida = "[{ label: \"Series1\",  data: 10},{ label: \"Series2\",  data: 30},{ label: \"Series6\",  data: 110}]";
		return saida;
	}

	public String getGraficoAbertos(Integer idCliente, String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

}
