package br.com.paxtecnologia.pma.relatorio.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.paxtecnologia.pma.relatorio.dao.AtendimentoDAO;
import br.com.paxtecnologia.pma.relatorio.vo.ChamadoVO;
import br.com.paxtecnologia.pma.relatorio.vo.HostListVO;
import br.com.paxtecnologia.pma.relatorio.vo.SolicitantesVO;
import br.com.paxtecnologia.pma.relatorio.vo.TipoChamadosVO;

@Stateless
public class AtendimentoEjb {

	private AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

	private Double porcentagemChamadosAbertos;
	private Double porcentagemChamadosFechados;
	private Double porcentagemChamadosAbertosTipo;
	private Double porcentagemChamadosFechadosTipo;
	private Integer qtdeChamadosAbertos;
	private Integer qtdeChamadosFechados;
	private Integer qtdeChamadosEmAberto;
	private Integer qtdeHostFechados;
	private Integer qtdeHostAbertos;
	private Integer qtdeHostEmAbertos;
	private Integer qtdeChamadosAbertosSolicitante;
	private Integer qtdeChamadosFechadosSolicitante;
	private Integer qtdeChamadosEmAbertosSolicitante;
	private Integer qtdeChamadosAbertosTipo;
	private Integer qtdeChamadosFechadosTipo;
	private Integer qtdeChamadosEmAbertosTipo;
	private List<ChamadoVO> listaChamadoAberto;
	private List<ChamadoVO> listaChamadoFechado;
	private List<ChamadoVO> listaChamadoEmAberto;
	private List<SolicitantesVO> listaSolicitante;
	private List<TipoChamadosVO> listaTipoChamado;
	private List<String> listaHostAbertos;
	private List<String> listaHostFechados;
	private List<HostListVO> listaChamadosHost;
	private Map<String, Integer> controleIdCliente = new HashMap<String, Integer>();

	// Conta Porcentagem
	private Double getPorcentagem(Integer valor, Integer total) {
		Double porcentagem = valor.doubleValue() / total.doubleValue();
		return porcentagem;
	}

	// Quantidade de Chamados Abertos
	public Integer getQtdeChamadosAbertos(Integer idCliente, String mesRelatorio) {
		if (qtdeChamadosAbertos == null
				|| controleIdCliente.get("getQtdeChamadosAbertos") != idCliente) {
			if (listaChamadoAberto == null
					|| controleIdCliente.get("getListaChamadosAbertos") != idCliente) {
				getListaChamadosAbertos(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosAbertos", idCliente);
			qtdeChamadosAbertos = listaChamadoAberto.size();
		}
		return qtdeChamadosAbertos;
	}

	// Quantidade de Chamdos Fechados
	public Integer getQtdeChamadosFechados(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosFechados == null
				|| controleIdCliente.get("getQtdeChamadosFechados") != idCliente) {
			if (listaChamadoFechado == null
					|| controleIdCliente.get("getListaChamadosFechados") != idCliente) {
				getListaChamadosFechados(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosFechados", idCliente);
			qtdeChamadosFechados = listaChamadoFechado.size();
		}
		return qtdeChamadosFechados;
	}

	// Quantidade de Chamados em Aberto
	public Integer getQtdeChamadosEmAberto(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosEmAberto == null
				|| controleIdCliente.get("getQtdeChamadosEmAberto") != idCliente) {
			if (listaChamadoEmAberto == null
					|| controleIdCliente.get("getListaChamadosEmAbertos") != idCliente) {
				getListaChamadosEmAbertos(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosEmAberto", idCliente);
			qtdeChamadosEmAberto = listaChamadoEmAberto.size();
		}
		return qtdeChamadosEmAberto;
	}

	public Integer getQtdeChamadosAbertosSolicitante(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosAbertosSolicitante == null
				|| controleIdCliente.get("getQtdeChamadosAbertosSolicitante") != idCliente) {
			if (listaSolicitante == null
					|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
				getListaSolicitantes(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosAbertosSolicitante",
					idCliente);
		}
		return qtdeChamadosAbertosSolicitante;
	}

	public Integer getQtdeChamadosFechadosSolicitante(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosFechadosSolicitante == null
				|| controleIdCliente.get("getQtdeChamadosFechadosSolicitante") != idCliente) {
			if (listaSolicitante == null
					|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
				getListaSolicitantes(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosFechadosSolicitante",
					idCliente);
		}
		return qtdeChamadosFechadosSolicitante;
	}

	public Integer getQtdeChamadosEmAbertosSolicitante(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosEmAbertosSolicitante == null
				|| controleIdCliente.get("getQtdeChamadosEmAbertosSolicitante") != idCliente) {
			if (listaSolicitante == null
					|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
				getListaSolicitantes(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosEmAbertosSolicitante",
					idCliente);
		}
		return qtdeChamadosEmAbertosSolicitante;
	}

	public Integer getQtdeChamadosAbertosTipo(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosAbertosTipo == null
				|| controleIdCliente.get("getQtdeChamadosAbertosTipo") != idCliente) {
			if (listaSolicitante == null
					|| controleIdCliente.get("getListaTipoChamado") != idCliente) {
				getListaTipoChamado(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosAbertosTipo", idCliente);
		}
		return qtdeChamadosAbertosTipo;
	}

	public Integer getQtdeChamadosFechadosTipo(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosFechadosTipo == null
				|| controleIdCliente.get("getQtdeChamadosFechadosTipo") != idCliente) {
			if (listaSolicitante == null
					|| controleIdCliente.get("getListaTipoChamado") != idCliente) {
				getListaTipoChamado(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosFechadosTipo", idCliente);
		}
		return qtdeChamadosFechadosTipo;
	}

	public Integer getQtdeChamadosEmAbertosTipo(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosEmAbertosTipo == null
				|| controleIdCliente.get("getQtdeChamadosEmAbertosTipo") != idCliente) {
			if (listaSolicitante == null
					|| controleIdCliente.get("getListaTipoChamado") != idCliente) {
				getListaTipoChamado(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosEmAbertosTipo", idCliente);
		}
		return qtdeChamadosEmAbertosTipo;
	}

	public Integer getQtdeHostAbertos(Integer idCliente, String mesRelatorio) {
		if (qtdeHostAbertos == null
				|| controleIdCliente.get("getQtdeHostAbertos") != idCliente) {
			if (listaChamadosHost == null
					|| controleIdCliente.get("getListaHost") != idCliente) {
				getListaHost(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeHostAbertos", idCliente);
		}
		return qtdeHostAbertos;
	}

	public Integer getQtdeHostFechados(Integer idCliente, String mesRelatorio) {
		if (qtdeHostFechados == null
				|| controleIdCliente.get("getQtdeHostFechados") != idCliente) {
			if (listaChamadosHost == null
					|| controleIdCliente.get("getListaHost") != idCliente) {
				getListaHost(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeHostFechados", idCliente);
		}
		return qtdeHostFechados;
	}

	public Integer getQtdeHostEmAbertos(Integer idCliente, String mesRelatorio) {
		if (qtdeHostEmAbertos == null
				|| controleIdCliente.get("getQtdeHostEmAbertos") != idCliente) {
			if (listaChamadosHost == null
					|| controleIdCliente.get("getListaHost") != idCliente) {
				getListaHost(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeHostEmAbertos", idCliente);
		}
		return qtdeHostEmAbertos;
	}

	// Porcentagem em Aberto
	public Double getPorcentagemChamadosAbertos(Integer idCliente,
			String mesRelatorio) {
		return null;

	}

	public Double getPorcentagemChamadosEmAbertos(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosAbertos == null
				|| controleIdCliente.get("getPorcentagemChamadosAbertos") != idCliente) {
			if (qtdeChamadosAbertos == null
					|| controleIdCliente.get("getQtdeChamadosAbertos") != idCliente) {
				getQtdeChamadosAbertos(idCliente, mesRelatorio);
			}
			if (qtdeChamadosEmAberto == null
					|| controleIdCliente.get("getQtdeChamadosEmAberto") != idCliente) {
				getQtdeChamadosEmAberto(idCliente, mesRelatorio);
			}
			porcentagemChamadosAbertos = getPorcentagem(qtdeChamadosEmAberto,
					qtdeChamadosAbertos);
		}
		return porcentagemChamadosAbertos;
	}

	public Double getPorcentagemChamadosFechados(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosAbertos == null
				|| controleIdCliente.get("getPorcentagemChamadosAbertos") != idCliente) {
			if (qtdeChamadosAbertos == null
					|| controleIdCliente.get("getQtdeChamadosAbertos") != idCliente) {
				getQtdeChamadosAbertos(idCliente, mesRelatorio);
			}
			if (qtdeChamadosFechados == null
					|| controleIdCliente.get("getQtdeChamadosFechados") != idCliente) {
				getQtdeChamadosFechados(idCliente, mesRelatorio);
			}
			porcentagemChamadosAbertos = getPorcentagem(qtdeChamadosFechados,
					qtdeChamadosAbertos);
		}
		return porcentagemChamadosAbertos;
	}

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

	public Double getPorcentoEmAbertosComHost(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPorcentoAbertosSolicitante(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPorcentoFechadosSolicitante(Integer idCliente,
			String mesRelatorio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPorcentoEmAbertosSolicitante(Integer idCliente,
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
		if (listaChamadoAberto == null
				|| controleIdCliente.get("getListaChamadosAbertos") != idCliente) {
			controleIdCliente.put("getListaChamadosAbertos", idCliente);
			listaChamadoAberto = atendimentoDAO.getChamadosAbertos(idCliente,
					mesRelatorio);
		}
		return listaChamadoAberto;
	}

	// Lista de Chamados Fechados
	public List<ChamadoVO> getListaChamadosFechados(Integer idCliente,
			String mesRelatorio) {
		if (listaChamadoFechado == null
				|| controleIdCliente.get("getListaChamadosFechados") != idCliente) {
			controleIdCliente.put("getListaChamadosFechados", idCliente);
			listaChamadoFechado = atendimentoDAO.getChamadosFechados(idCliente,
					mesRelatorio);
		}
		return listaChamadoFechado;
	}

	// Lista de Chamados em Aberto
	public List<ChamadoVO> getListaChamadosEmAbertos(Integer idCliente,
			String mesRelatorio) {
		System.out.println("getListaChamadosEmAbertos " + listaChamadoEmAberto);
		if (listaChamadoEmAberto == null
				|| controleIdCliente.get("getListaChamadosEmAbertos") != idCliente) {
			controleIdCliente.put("getListaChamadosEmAbertos", idCliente);
			System.out.println("Entrei");
			listaChamadoEmAberto = atendimentoDAO.getChamadosEmAberto(
					idCliente, mesRelatorio);
		}
		return listaChamadoEmAberto;
	}

	public List<SolicitantesVO> getListaSolicitantes(Integer idCliente,
			String mesRelatorio) {

		if (listaSolicitante == null
				|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
			if (listaChamadoAberto == null
					|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
				controleIdCliente.put("getListaSolicitantes", idCliente);
				listaChamadoAberto = atendimentoDAO.getChamadosAbertos(
						idCliente, mesRelatorio);
			}
			if (listaChamadoFechado == null
					|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
				controleIdCliente.put("getListaSolicitantes", idCliente);
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

		if (listaTipoChamado == null
				|| controleIdCliente.get("getListaTipoChamado") != idCliente) {
			if (listaChamadoAberto == null
					|| controleIdCliente.get("getListaTipoChamado") != idCliente) {
				controleIdCliente.put("getListaTipoChamado", idCliente);
				atendimentoDAO.getChamadosAbertos(idCliente, mesRelatorio);
			}
			if (listaChamadoFechado == null
					|| controleIdCliente.get("getListaTipoChamado") != idCliente) {
				controleIdCliente.put("getListaTipoChamado", idCliente);
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
			if (qtdeChamadosAbertos == null
					|| controleIdCliente.get("getQtdeChamadosAbertos") != idCliente) {
				getQtdeChamadosAbertos(idCliente, mesRelatorio);
			}
			if (qtdeChamadosFechados == null
					|| controleIdCliente.get("getQtdeChamadosFechados") != idCliente) {
				getQtdeChamadosFechados(idCliente, mesRelatorio);
			}
			itTipoChamado = listaTipoChamado.iterator();
			while (itTipoChamado.hasNext()) {
				TipoChamadosVO tipoChamados = itTipoChamado.next();
				tipoChamados.setPorcentoAberto(getPorcentagem(
						tipoChamados.getQtdeAberto(), qtdeChamadosAbertos));
				tipoChamados.setPorcentoFechado(getPorcentagem(
						tipoChamados.getQtdeFechado(), qtdeChamadosFechados));
			}
		}

		return listaTipoChamado;
	}

	public List<String> getListaHostAbertos(Integer idCliente,
			String mesRelatorio) {
		if (listaHostAbertos == null
				|| controleIdCliente.get("getListaChamadosHostAbertos") != idCliente) {
			controleIdCliente.put("getListaChamadosHostAbertos", idCliente);
			listaHostAbertos = atendimentoDAO.getListaAbertosComHosts(
					idCliente, mesRelatorio);
		}
		return listaHostAbertos;
	}

	public List<String> getListaHostFechados(Integer idCliente,
			String mesRelatorio) {
		if (listaHostFechados == null
				|| controleIdCliente.get("getListaHostFechados") != idCliente) {
			controleIdCliente.put("getListaHostFechados", idCliente);
			listaHostFechados = atendimentoDAO.getListaFechadosComHosts(
					idCliente, mesRelatorio);
		}
		return listaHostAbertos;
	}

	public List<HostListVO> getListaHost(Integer idCliente, String mesRelatorio) {
		if (listaChamadosHost == null
				|| controleIdCliente.get("getListaHost") != idCliente) {
			controleIdCliente.put("getListaHost", idCliente);
			if (listaHostAbertos == null
					|| controleIdCliente.get("getListaChamadosHostAbertos") != idCliente) {
				getListaHostAbertos(idCliente, mesRelatorio);
			}
			if (listaHostFechados == null
					|| controleIdCliente.get("getListaHostFechados") != idCliente) {
				getListaHostFechados(idCliente, mesRelatorio);
			}
			listaChamadosHost = new ArrayList<HostListVO>();
			Iterator<String> itHost;
			Iterator<HostListVO> itHostList;
			String host;
			Integer achou;

			itHost = listaHostAbertos.iterator();

			while (itHost.hasNext()) {
				host = itHost.next();
				itHostList = listaChamadosHost.iterator();
				achou = 0;
				while (itHostList.hasNext()) {
					HostListVO hostVO = itHostList.next();
					if (hostVO.getHostname().equals(host)) {
						hostVO.setQtdeAberto(hostVO.getQtdeAberto() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					HostListVO hostVO = new HostListVO();
					hostVO.setHostname(host);
					hostVO.setQtdeAberto(1);
					hostVO.setQtdeFechado(0);
					listaChamadosHost.add(hostVO);
				}
			}

			itHost = listaHostFechados.iterator();
			while (itHost.hasNext()) {
				host = itHost.next();
				itHostList = listaChamadosHost.iterator();
				achou = 0;
				while (itHostList.hasNext()) {
					HostListVO hostVO = itHostList.next();
					if (hostVO.getHostname().equals(host)) {
						hostVO.setQtdeFechado(hostVO.getQtdeFechado() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					HostListVO hostVO = new HostListVO();
					hostVO.setHostname(host);
					hostVO.setQtdeAberto(0);
					hostVO.setQtdeFechado(1);
					listaChamadosHost.add(hostVO);
				}

			}
			if (qtdeHostAbertos == null
					|| controleIdCliente.get("getQtdeHostAbertos") != idCliente) {
				getQtdeHostAbertos(idCliente, mesRelatorio);
			}
			if (qtdeHostFechados == null
					|| controleIdCliente.get("getQtdeHostFechados") != idCliente) {
				getQtdeHostFechados(idCliente, mesRelatorio);
			}
			itHostList = listaChamadosHost.iterator();
			while (itHostList.hasNext()) {
				HostListVO hostVO = itHostList.next();
				hostVO.setPorcentoAberto(getPorcentagem(hostVO.getQtdeAberto(),
						qtdeHostAbertos));
				hostVO.setPorcentoFechado(getPorcentagem(
						hostVO.getQtdeFechado(), qtdeHostAbertos));
			}
		}
		return listaChamadosHost;
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

	public Double getPorcentagemChamadosAbertosTipo(Integer idCliente,
			String mesRelatorio) {
		Double porcentagem = 0.0;
		Iterator<TipoChamadosVO> itTipoChamado;

		if (porcentagemChamadosAbertosTipo == null
				|| controleIdCliente.get("getPorcentagemChamadosAbertosTipo") != idCliente) {
			controleIdCliente.put("getPorcentagemChamadosAbertosTipo",
					idCliente);
			if (listaTipoChamado == null
					|| controleIdCliente.get("getListaTipoChamado") != idCliente) {
				getListaTipoChamado(idCliente, mesRelatorio);
			}
			itTipoChamado = listaTipoChamado.iterator();

			while (itTipoChamado.hasNext()) {
				TipoChamadosVO tipoChamados = itTipoChamado.next();
				porcentagem = porcentagem + tipoChamados.getPorcentoAberto();
			}

		}

		return porcentagem;
	}

	public Double getPorcentagemChamadosFechadosTipo(Integer idCliente,
			String mesRelatorio) {
		Double porcentagem = 0.0;
		Iterator<TipoChamadosVO> itTipoChamado;

		if (porcentagemChamadosFechadosTipo == null
				|| controleIdCliente.get("getPorcentagemChamadosFechadosTipo") != idCliente) {
			controleIdCliente.put("getPorcentagemChamadosFechadosTipo",
					idCliente);
			if (listaTipoChamado == null
					|| controleIdCliente.get("getListaTipoChamado") != idCliente) {
				getListaTipoChamado(idCliente, mesRelatorio);
			}
			itTipoChamado = listaTipoChamado.iterator();

			while (itTipoChamado.hasNext()) {
				TipoChamadosVO tipoChamados = itTipoChamado.next();
				porcentagem = porcentagem + tipoChamados.getPorcentoFechado();
			}
		}

		return porcentagem;
	}

}
