package br.com.paxtecnologia.pma.relatorio.ejb;

import java.util.ArrayList;
import java.util.Iterator;
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
	private Integer idCliente;

	// Conta Porcentagem
	private Double getPorcentagem(Integer valor1, Integer valor2) {
		Double porcentagem = valor2.doubleValue() / valor1.doubleValue();
		return porcentagem;
	}

	// Quantidade de Chamados Abertos
	public Integer getQtdeChamadosAbertos(Integer idCliente, String mesRelatorio) {
		if (qtdeChamadoAberto == null || this.idCliente != idCliente) {
			this.idCliente = idCliente;
			if (listaChamadoAberto == null || this.idCliente != idCliente) {
				this.idCliente = idCliente;
				getListaChamadosAbertos(idCliente, mesRelatorio);
			}
			qtdeChamadoAberto = listaChamadoAberto.size();
		}
		return qtdeChamadoAberto;
	}

	// Quantidade de Chamdos Fechados
	public Integer getQtdeChamadosFechados(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadoFechado == null || this.idCliente != idCliente) {
			this.idCliente = idCliente;
			if (listaChamadoFechado == null || this.idCliente != idCliente) {
				this.idCliente = idCliente;
				getListaChamadosFechados(idCliente, mesRelatorio);
			}
			qtdeChamadoFechado = listaChamadoFechado.size();
		}
		return qtdeChamadoFechado;
	}

	// Quantidade de Chamados em Aberto
	public Integer getQtdeChamadosEmAberto(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadoEmAberto == null || this.idCliente != idCliente) {
			this.idCliente = idCliente;
			if (listaChamadoEmAberto == null || this.idCliente != idCliente) {
				this.idCliente = idCliente;
				getListaChamadosEmAbertos(idCliente, mesRelatorio);
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
		if (porcentagemChamadosAbertos == null || this.idCliente != idCliente) {
			this.idCliente = idCliente;
			if (qtdeChamadoAberto == null || this.idCliente != idCliente) {
				this.idCliente = idCliente;
				getQtdeChamadosAbertos(idCliente, mesRelatorio);
			}
			if (qtdeChamadoFechado == null || this.idCliente != idCliente) {
				this.idCliente = idCliente;
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
	public List<ChamadoVO> getListaChamadosAbertos(Integer idCliente,
			String mesRelatorio) {
		if (listaChamadoAberto == null || this.idCliente != idCliente) {
			this.idCliente = idCliente;
			listaChamadoAberto = atendimentoDAO.getChamadosAbertos(idCliente,
					mesRelatorio);
		}
		return listaChamadoAberto;
	}

	// Lista de Chamados Fechados
	public List<ChamadoVO> getListaChamadosFechados(Integer idCliente,
			String mesRelatorio) {
		if (listaChamadoFechado == null || this.idCliente != idCliente) {
			this.idCliente = idCliente;
			listaChamadoFechado = atendimentoDAO.getChamadosFechados(idCliente,
					mesRelatorio);
		}
		return listaChamadoFechado;
	}

	// Lista de Chamados em Aberto
	public List<ChamadoVO> getListaChamadosEmAbertos(Integer idCliente,
			String mesRelatorio) {
		if (listaChamadoEmAberto == null || this.idCliente != idCliente) {
			this.idCliente = idCliente;
			listaChamadoEmAberto = atendimentoDAO.getChamadosEmAberto(
					idCliente, mesRelatorio);
		}
		return listaChamadoEmAberto;
	}

	public List<SolicitantesVO> getListaSolicitantes(Integer idCliente,
			String mesRelatorio) {

		if (listaSolicitante == null || this.idCliente != idCliente) {
			this.idCliente = idCliente;
			if (listaChamadoAberto == null || this.idCliente != idCliente) {
				this.idCliente = idCliente;
				listaChamadoAberto = atendimentoDAO.getChamadosAbertos(
						idCliente, mesRelatorio);
			}
			if (listaChamadoFechado == null || this.idCliente != idCliente) {
				this.idCliente = idCliente;
				atendimentoDAO.getChamadosFechados(idCliente, mesRelatorio);
			}

			listaSolicitante = new ArrayList<SolicitantesVO>();
			Iterator<ChamadoVO> itChamado;
			Iterator<SolicitantesVO> itSolicitante;
			ChamadoVO chamado;
			Integer achou;

			itChamado = listaChamadoAberto.iterator();

			while (itChamado.hasNext()) {
				chamado = itChamado.next();
				itSolicitante = listaSolicitante.iterator();
				achou = 0;
				while (itSolicitante.hasNext()) {
					SolicitantesVO solicitante = itSolicitante.next();
					if (solicitante.getSolictante().equals(
							chamado.getSolicitante())) {
						solicitante
								.setQtdeAberto(solicitante.getQtdeAberto() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					SolicitantesVO solicitante = new SolicitantesVO();
					solicitante.setSolictante(chamado.getSolicitante());
					solicitante.setQtdeAberto(1);
					solicitante.setQtdeFechado(0);
					listaSolicitante.add(solicitante);
				}
			}

			itChamado = listaChamadoFechado.iterator();
			while (itChamado.hasNext()) {
				chamado = itChamado.next();
				itSolicitante = listaSolicitante.iterator();
				achou = 0;
				while (itSolicitante.hasNext()) {
					SolicitantesVO solicitante = itSolicitante.next();
					if (solicitante.getSolictante().equals(
							chamado.getSolicitante())) {
						solicitante
								.setQtdeFechado(solicitante.getQtdeFechado() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					SolicitantesVO solicitante = new SolicitantesVO();
					solicitante.setSolictante(chamado.getSolicitante());
					solicitante.setQtdeAberto(0);
					solicitante.setQtdeFechado(1);
					listaSolicitante.add(solicitante);
				}

			}
		}
		return listaSolicitante;
	}

	public List<TipoChamadosVO> getListaTipoChamado(Integer idCliente,
			String mesRelatorio) {

		if (listaTipoChamado == null || this.idCliente != idCliente) {
			this.idCliente = idCliente;
			if (listaChamadoAberto == null || this.idCliente != idCliente) {
				this.idCliente = idCliente;
				atendimentoDAO.getChamadosAbertos(idCliente, mesRelatorio);
			}
			if (listaChamadoFechado == null || this.idCliente != idCliente) {
				this.idCliente = idCliente;
				atendimentoDAO.getChamadosFechados(idCliente, mesRelatorio);
			}

			listaTipoChamado = new ArrayList<TipoChamadosVO>();
			Iterator<ChamadoVO> itChamado;
			Iterator<TipoChamadosVO> itTipoChamado;
			ChamadoVO chamado;
			Integer achou;

			itChamado = listaChamadoAberto.iterator();

			while (itChamado.hasNext()) {
				chamado = itChamado.next();
				itTipoChamado = listaTipoChamado.iterator();
				achou = 0;
				while (itTipoChamado.hasNext()) {
					TipoChamadosVO tipoChamados = itTipoChamado.next();
					if (tipoChamados.getTipo().equals(chamado.getTipoChamado())) {
						tipoChamados
								.setQtdeAberto(tipoChamados.getQtdeAberto() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					TipoChamadosVO tipoChamados = new TipoChamadosVO();
					tipoChamados.setTipo(chamado.getTipoChamado());
					tipoChamados.setQtdeAberto(1);
					tipoChamados.setQtdeFechado(0);
					listaTipoChamado.add(tipoChamados);
				}
			}

			itChamado = listaChamadoFechado.iterator();
			while (itChamado.hasNext()) {
				chamado = itChamado.next();
				itTipoChamado = listaTipoChamado.iterator();
				achou = 0;
				while (itTipoChamado.hasNext()) {
					TipoChamadosVO tipoChamados = itTipoChamado.next();
					if (tipoChamados.getTipo().equals(chamado.getTipoChamado())) {
						tipoChamados.setQtdeFechado(tipoChamados
								.getQtdeFechado() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					TipoChamadosVO tipoChamados = new TipoChamadosVO();
					tipoChamados.setTipo(chamado.getTipoChamado());
					tipoChamados.setQtdeAberto(1);
					tipoChamados.setQtdeFechado(0);
					listaTipoChamado.add(tipoChamados);
				}

			}
			itTipoChamado = listaTipoChamado.iterator();
			while (itTipoChamado.hasNext()) {
				TipoChamadosVO tipoChamados = itTipoChamado.next();
				// Calcula a porcentagem;
//				if (tipoChamados.getTipo().equals(chamado.getTipoChamado())) {
//					tipoChamados
//							.setQtdeFechado(tipoChamados.getQtdeFechado() + 1);
//					achou = 1;
//				}
			}
		}

		return listaTipoChamado;
	}

	public List<HostVO> getListaHost(Integer idCliente, String mesRelatorio) {
		// TODO Auto-generated method stub
		ArrayList<HostVO> listaHost = new ArrayList<HostVO>();

		// HostVO a = new HostVO();
		// a.setHostname("oracle1");
		// a.setQtdeAberto(16);
		// a.setPorcentoAberto(50.00);
		// a.setQtdeFechado(14);
		// a.setPorcentoFechado(54.56);
		// listaHost.add(a);
		//
		// HostVO b = new HostVO();
		// b.setHostname("oracle2");
		// b.setQtdeAberto(10);
		// b.setPorcentoAberto(55.00);
		// b.setQtdeFechado(11);
		// b.setPorcentoFechado(44.56);
		// listaHost.add(b);
		//
		// HostVO c = new HostVO();
		// c.setHostname("oracle3");
		// c.setQtdeAberto(5);
		// c.setPorcentoAberto(25.00);
		// c.setQtdeFechado(7);
		// c.setPorcentoFechado(56.00);
		// listaHost.add(c);
		return listaHost;
	}

	public String getGraficoFechados(Integer idCliente, String mesRelatorio) {
		// TODO Auto-generated method stub
		String saida = new String();
		saida = "[{ label: \"Series1\",  data: 10},{ label: \"Series2\",  data: 30},{ label: \"Series6\",  data: 110}]";
		return saida;
	}

	public String getGraficoAbertos(Integer idCliente, String mesRelatorio) {
		String saida = new String();
		saida = "[{ label: \"Series1\",  data: 10},{ label: \"Series2\",  data: 30},{ label: \"Series6\",  data: 110}]";
		return saida;
	}

}
