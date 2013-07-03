package br.com.paxtecnologia.pma.relatorio.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.paxtecnologia.pma.relatorio.dao.AtendimentoDAO;
import br.com.paxtecnologia.pma.relatorio.vo.ChamadoVO;
import br.com.paxtecnologia.pma.relatorio.vo.ChamadoQuantidadeVO;

@Stateless
public class AtendimentoEjb {

	private AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

	private Double porcentagemChamadosAbertos;
	private Double porcentagemChamadosEmAbertos;
	private Double porcentagemChamadosFechados;
	private Double porcentagemChamadosAbertosTipo;
	private Double porcentagemChamadosEmAbertosTipo;
	private Double porcentagemChamadosFechadosTipo;
	private Double porcentagemChamadosAbertosSolicitante;
	private Double porcentagemChamadosEmAbertosSolicitante;
	private Double porcentagemChamadosFechadosSolicitante;
	private Double porcentagemChamadosAbertosHost;
	private Double porcentagemChamadosEmAbertosHost;
	private Double porcentagemChamadosFechadosHost;
	private Integer qtdeChamadosAbertos;
	private Integer qtdeChamadosFechados;
	private Integer qtdeChamadosEmAberto;
	private Integer qtdeChamadosFechadosHost;
	private Integer qtdeChamadosAbertosHost;
	private Integer qtdeChamadosEmAbertosHost;
	private Integer qtdeChamadosAbertosSolicitante;
	private Integer qtdeChamadosFechadosSolicitante;
	private Integer qtdeChamadosEmAbertosSolicitante;
	private Integer qtdeChamadosAbertosTipo;
	private Integer qtdeChamadosFechadosTipo;
	private Integer qtdeChamadosEmAbertosTipo;
	private Double tempoMedioChamadoFechado;
	private List<ChamadoVO> listaChamadoAberto;
	private List<ChamadoVO> listaChamadoFechado;
	private List<ChamadoVO> listaChamadoEmAberto;
	private List<ChamadoQuantidadeVO> listaChamadoSolicitante;
	private List<ChamadoQuantidadeVO> listaChamadoTipo;
	private List<String> listaAbertosHost;
	private List<String> listaFechadosHost;
	private List<String> listaEmAbertosHost;
	private List<ChamadoQuantidadeVO> listaChamadosHost;
	private Map<String, Integer> controleIdCliente = new HashMap<String, Integer>();
	private List<String> listaGraficoAbertosHost;
	private List<String> listaGraficoFechadosHost;
	private List<String> listaGraficoEmAbertosHost;

	// Conta Porcentagem
	private Double getPorcentagem(Integer valor, Integer total) {
		Double porcentagem = valor.doubleValue() / total.doubleValue();
		return porcentagem;
	}

	// Quantidade de Chamados Abertos - OK
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

	// Quantidade de Chamdos Fechados - OK
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

	// Quantidade de Chamados em Aberto - OK
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

	// Quantidade de Chamados Aberto Solicitante - OK
	public Integer getQtdeChamadosAbertosSolicitante(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosAbertosSolicitante == null
				|| controleIdCliente.get("getQtdeChamadosAbertosSolicitante") != idCliente) {
			if (listaChamadoSolicitante == null
					|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
				getListaSolicitantes(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosAbertosSolicitante",
					idCliente);
		}
		return qtdeChamadosAbertosSolicitante;
	}

	// Quantidade de Chamados Fechado Solicitante - OK
	public Integer getQtdeChamadosFechadosSolicitante(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosFechadosSolicitante == null
				|| controleIdCliente.get("getQtdeChamadosFechadosSolicitante") != idCliente) {
			if (listaChamadoSolicitante == null
					|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
				getListaSolicitantes(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosFechadosSolicitante",
					idCliente);
		}
		return qtdeChamadosFechadosSolicitante;
	}

	// Quantidade de Chamados Em Aberto Solicitante - OK
	public Integer getQtdeChamadosEmAbertosSolicitante(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosEmAbertosSolicitante == null
				|| controleIdCliente.get("getQtdeChamadosEmAbertosSolicitante") != idCliente) {
			if (listaChamadoSolicitante == null
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
			if (listaChamadoTipo == null
					|| controleIdCliente.get("getListaChamadoTipo") != idCliente) {
				getListaChamadoTipo(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosAbertosTipo", idCliente);
		}
		return qtdeChamadosAbertosTipo;
	}

	public Integer getQtdeChamadosFechadosTipo(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosFechadosTipo == null
				|| controleIdCliente.get("getQtdeChamadosFechadosTipo") != idCliente) {
			if (listaChamadoTipo == null
					|| controleIdCliente.get("getListaChamadoTipo") != idCliente) {
				getListaChamadoTipo(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosFechadosTipo", idCliente);
		}
		return qtdeChamadosFechadosTipo;
	}

	public Integer getQtdeChamadosEmAbertosTipo(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosEmAbertosTipo == null
				|| controleIdCliente.get("getQtdeChamadosEmAbertosTipo") != idCliente) {
			if (listaChamadoTipo == null
					|| controleIdCliente.get("getListaChamadoTipo") != idCliente) {
				getListaChamadoTipo(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosEmAbertosTipo", idCliente);
		}
		return qtdeChamadosEmAbertosTipo;
	}

	public Integer getQtdeChamadosAbertosHost(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosAbertosHost == null
				|| controleIdCliente.get("getQtdeChamadosAbertosHost") != idCliente) {
			if (listaChamadosHost == null
					|| controleIdCliente.get("getListaChamadoHost") != idCliente) {
				getListaChamadoHost(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosAbertosHost", idCliente);
		}
		return qtdeChamadosAbertosHost;
	}

	public Integer getQtdeChamadosFechadosHost(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosFechadosHost == null
				|| controleIdCliente.get("getQtdeChamadosFechadosHost") != idCliente) {
			if (listaChamadosHost == null
					|| controleIdCliente.get("getListaChamadoHost") != idCliente) {
				getListaChamadoHost(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosFechadosHost", idCliente);
		}
		return qtdeChamadosFechadosHost;
	}

	public Integer getQtdeChamadosEmAbertosHost(Integer idCliente,
			String mesRelatorio) {
		if (qtdeChamadosEmAbertosHost == null
				|| controleIdCliente.get("getQtdeChamadosEmAbertosHost") != idCliente) {
			if (listaChamadosHost == null
					|| controleIdCliente.get("getListaChamadoHost") != idCliente) {
				getListaChamadoHost(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getQtdeChamadosEmAbertosHost", idCliente);
		}
		return qtdeChamadosEmAbertosHost;
	}

	// Porcentagem em Aberto
	public Double getPorcentagemChamadosAbertos(Integer idCliente,
			String mesRelatorio) {
		porcentagemChamadosAbertos = 1.00;
		return porcentagemChamadosAbertos;
	}

	public Double getPorcentagemChamadosEmAbertos(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosEmAbertos == null
				|| controleIdCliente.get("getPorcentagemChamadosAbertos") != idCliente) {
			if (qtdeChamadosAbertos == null
					|| controleIdCliente.get("getQtdeChamadosAbertos") != idCliente) {
				getQtdeChamadosAbertos(idCliente, mesRelatorio);
			}
			if (qtdeChamadosEmAberto == null
					|| controleIdCliente.get("getQtdeChamadosEmAberto") != idCliente) {
				getQtdeChamadosEmAberto(idCliente, mesRelatorio);
			}
			porcentagemChamadosEmAbertos = getPorcentagem(qtdeChamadosEmAberto,
					qtdeChamadosAbertos);
		}
		return porcentagemChamadosEmAbertos;
	}

	public Double getPorcentagemChamadosFechados(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosFechados == null
				|| controleIdCliente.get("getPorcentagemChamadosAbertos") != idCliente) {
			if (qtdeChamadosAbertos == null
					|| controleIdCliente.get("getQtdeChamadosAbertos") != idCliente) {
				getQtdeChamadosAbertos(idCliente, mesRelatorio);
			}
			if (qtdeChamadosFechados == null
					|| controleIdCliente.get("getQtdeChamadosFechados") != idCliente) {
				getQtdeChamadosFechados(idCliente, mesRelatorio);
			}
			porcentagemChamadosFechados = getPorcentagem(qtdeChamadosFechados,
					qtdeChamadosAbertos);
		}
		return porcentagemChamadosFechados;
	}

	public Double getPorcentoAbertosSolicitante(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosAbertosSolicitante == null
				|| controleIdCliente.get("getPorcentoAbertosSolicitante") != idCliente) {
			if (listaChamadoSolicitante == null
					|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
				getListaSolicitantes(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getPorcentoAbertosSolicitante", idCliente);
		}
		return porcentagemChamadosAbertosSolicitante;
	}

	public Double getPorcentoFechadosSolicitante(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosFechadosSolicitante == null
				|| controleIdCliente.get("getPorcentoFechadosSolicitante") != idCliente) {
			if (listaChamadoSolicitante == null
					|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
				getListaSolicitantes(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getPorcentoFechadosSolicitante", idCliente);
		}
		return porcentagemChamadosFechadosSolicitante;
	}

	public Double getPorcentoEmAbertosSolicitante(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosEmAbertosSolicitante == null
				|| controleIdCliente.get("getPorcentoEmAbertosSolicitante") != idCliente) {
			if (listaChamadoSolicitante == null
					|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
				getListaSolicitantes(idCliente, mesRelatorio);
			}
			controleIdCliente.put("porcentagemChamadosEmAbertosSolicitante",
					idCliente);
		}
		return porcentagemChamadosFechadosSolicitante;
	}

	public Double getPorcentoAbertosTipo(Integer idCliente, String mesRelatorio) {
		if (porcentagemChamadosAbertosTipo == null
				|| controleIdCliente.get("getPorcentoAbertosTipo") != idCliente) {
			if (listaChamadoSolicitante == null
					|| controleIdCliente.get("getListaChamadoTipo") != idCliente) {
				getListaChamadoTipo(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getPorcentoAbertosTipo", idCliente);
		}
		return porcentagemChamadosAbertosTipo;
	}

	public Double getPorcentoFechadosTipo(Integer idCliente, String mesRelatorio) {
		if (porcentagemChamadosFechadosTipo == null
				|| controleIdCliente.get("getPorcentoFechadosTipo") != idCliente) {
			if (listaChamadoSolicitante == null
					|| controleIdCliente.get("getListaChamadoTipo") != idCliente) {
				getListaChamadoTipo(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getPorcentoFechadosTipo", idCliente);
		}
		return porcentagemChamadosFechadosTipo;
	}

	public Double getPorcentoEmAbertosTipo(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosEmAbertosTipo == null
				|| controleIdCliente.get("getPorcentoEmAbertosTipo") != idCliente) {
			if (listaChamadoSolicitante == null
					|| controleIdCliente.get("getListaChamadoTipo") != idCliente) {
				getListaChamadoTipo(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getPorcentoEmAbertosTipo", idCliente);
		}
		return porcentagemChamadosEmAbertosTipo;
	}

	public Double getPorcentoFechadosComHost(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosFechadosHost == null
				|| controleIdCliente.get("getPorcentoFechadosComHost") != idCliente) {
			if (listaChamadoSolicitante == null
					|| controleIdCliente.get("getListaChamadoHost") != idCliente) {
				getListaChamadoHost(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getPorcentoFechadosComHost", idCliente);
		}
		return porcentagemChamadosFechadosHost;
	}

	public Double getPorcentoAbertosComHost(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosAbertosHost == null
				|| controleIdCliente.get("getPorcentoAbertosComHost") != idCliente) {
			if (listaChamadoSolicitante == null
					|| controleIdCliente.get("getListaChamadoHost") != idCliente) {
				getListaChamadoHost(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getPorcentoAbertosComHost", idCliente);
		}
		return porcentagemChamadosAbertosHost;
	}

	public Double getPorcentoEmAbertosComHost(Integer idCliente,
			String mesRelatorio) {
		if (porcentagemChamadosEmAbertosHost == null
				|| controleIdCliente.get("getPorcentoEmAbertosComHost") != idCliente) {
			if (listaChamadoSolicitante == null
					|| controleIdCliente.get("getListaChamadoHost") != idCliente) {
				getListaChamadoHost(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getPorcentoEmAbertosComHost", idCliente);
		}
		return porcentagemChamadosEmAbertosHost;
	}

	// ////////////////////////////////

	public Double getTempoMedio(Integer idCliente, String mesRelatorio) {
		if (tempoMedioChamadoFechado == null
				|| controleIdCliente.get("getTempoMedio") != idCliente) {
			if (listaChamadoFechado == null
					|| controleIdCliente.get("getListaChamadosFechados") != idCliente) {
				getListaChamadosFechados(idCliente, mesRelatorio);
			}
			if (qtdeChamadosFechados == null
					|| controleIdCliente.get("getListaChamadosFechados") != idCliente) {
				getQtdeChamadosFechados(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getTempoMedio", idCliente);
			tempoMedioChamadoFechado=0.0;
			Iterator<ChamadoVO> itChamado;
			ChamadoVO chamado;

			itChamado = listaChamadoFechado.iterator();

			while (itChamado.hasNext()) {
				chamado = itChamado.next();
				tempoMedioChamadoFechado = tempoMedioChamadoFechado
						+ chamado.getSegundosTrabalhos();
			}
			// Converte para horas
			tempoMedioChamadoFechado = tempoMedioChamadoFechado
					/ qtdeChamadosFechados / 60 / 60;
		}

		return tempoMedioChamadoFechado;

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
		if (listaChamadoEmAberto == null
				|| controleIdCliente.get("getListaChamadosEmAbertos") != idCliente) {
			controleIdCliente.put("getListaChamadosEmAbertos", idCliente);
		}
		return listaChamadoEmAberto;
	}

	public List<ChamadoQuantidadeVO> getListaSolicitantes(Integer idCliente,
			String mesRelatorio) {
		if (listaChamadoSolicitante == null
				|| controleIdCliente.get("getListaSolicitantes") != idCliente) {
			if (listaChamadoAberto == null
					|| controleIdCliente.get("getListaChamadosAbertos") != idCliente) {
				getListaChamadosAbertos(idCliente, mesRelatorio);
			}
			if (listaChamadoFechado == null
					|| controleIdCliente.get("getListaChamadosFechados") != idCliente) {
				getListaChamadosFechados(idCliente, mesRelatorio);
			}
			if (listaChamadoEmAberto == null
					|| controleIdCliente.get("getListaChamadosEmAbertos") != idCliente) {
				getListaChamadosEmAbertos(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getListaSolicitantes", idCliente);

			listaChamadoSolicitante = new ArrayList<ChamadoQuantidadeVO>();
			Iterator<ChamadoVO> itChamado;
			Iterator<ChamadoQuantidadeVO> itSolicitante;
			ChamadoVO chamado;
			Integer achou;

			itChamado = listaChamadoAberto.iterator();

			while (itChamado.hasNext()) {
				chamado = itChamado.next();
				itSolicitante = listaChamadoSolicitante.iterator();
				achou = 0;
				while (itSolicitante.hasNext()) {
					ChamadoQuantidadeVO solicitante = itSolicitante.next();
					if (solicitante.getNome().equals(chamado.getSolicitante())) {
						solicitante
								.setQtdeAberto(solicitante.getQtdeAberto() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					ChamadoQuantidadeVO solicitante = new ChamadoQuantidadeVO();
					solicitante.setNome(chamado.getSolicitante());
					solicitante.setQtdeAberto(1);
					solicitante.setQtdeFechado(0);
					solicitante.setQtdeEmAberto(0);
					listaChamadoSolicitante.add(solicitante);
				}
			}

			itChamado = listaChamadoFechado.iterator();
			while (itChamado.hasNext()) {
				chamado = itChamado.next();
				itSolicitante = listaChamadoSolicitante.iterator();
				achou = 0;
				while (itSolicitante.hasNext()) {
					ChamadoQuantidadeVO solicitante = itSolicitante.next();
					if (solicitante.getNome().equals(chamado.getSolicitante())) {
						solicitante
								.setQtdeFechado(solicitante.getQtdeFechado() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					ChamadoQuantidadeVO solicitante = new ChamadoQuantidadeVO();
					solicitante.setNome(chamado.getSolicitante());
					solicitante.setQtdeAberto(0);
					solicitante.setQtdeFechado(1);
					solicitante.setQtdeEmAberto(0);
					listaChamadoSolicitante.add(solicitante);
				}
			}

			itChamado = listaChamadoEmAberto.iterator();
			while (itChamado.hasNext()) {
				chamado = itChamado.next();
				itSolicitante = listaChamadoSolicitante.iterator();
				achou = 0;
				while (itSolicitante.hasNext()) {
					ChamadoQuantidadeVO solicitante = itSolicitante.next();
					if (solicitante.getNome().equals(chamado.getSolicitante())) {
						solicitante.setQtdeEmAberto(solicitante
								.getQtdeEmAberto() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					ChamadoQuantidadeVO solicitante = new ChamadoQuantidadeVO();
					solicitante.setNome(chamado.getSolicitante());
					solicitante.setQtdeAberto(0);
					solicitante.setQtdeFechado(0);
					solicitante.setQtdeEmAberto(1);
					listaChamadoSolicitante.add(solicitante);
				}
			}
			Integer aberto = 0;
			Integer fechado = 0;
			Integer emAberto = 0;
			itSolicitante = listaChamadoSolicitante.iterator();
			while (itSolicitante.hasNext()) {
				ChamadoQuantidadeVO solicitante = itSolicitante.next();
				aberto = aberto + solicitante.getQtdeAberto();
				fechado = fechado + solicitante.getQtdeFechado();
				emAberto = emAberto + solicitante.getQtdeEmAberto();
			}

			setQtdeChamadosAbertosSolicitante(aberto);
			setQtdeChamadosEmAbertosSolicitante(emAberto);
			setQtdeChamadosFechadosSolicitante(fechado);

			Double porcentagemAberto = 0.0;
			Double porcentagemEmAberto = 0.0;
			Double porcentagemFechado = 0.0;
			itSolicitante = listaChamadoSolicitante.iterator();
			while (itSolicitante.hasNext()) {
				ChamadoQuantidadeVO solicitante = itSolicitante.next();
				solicitante.setPorcentoAberto(getPorcentagem(
						solicitante.getQtdeAberto(), aberto));
				solicitante.setPorcentoFechado(getPorcentagem(
						solicitante.getQtdeFechado(), fechado));
				solicitante.setPorcentoEmAberto(getPorcentagem(
						solicitante.getQtdeEmAberto(), emAberto));
				porcentagemAberto = porcentagemAberto
						+ solicitante.getPorcentoAberto();
				porcentagemEmAberto = porcentagemEmAberto
						+ solicitante.getPorcentoEmAberto();
				porcentagemFechado = porcentagemFechado
						+ solicitante.getPorcentoFechado();
			}

			setPorcentagemChamadosAbertosSolicitante(porcentagemAberto);
			setPorcentagemChamadosEmAbertosSolicitante(porcentagemEmAberto);
			setPorcentagemChamadosFechadosSolicitante(porcentagemFechado);
		}
		return listaChamadoSolicitante;
	}

	public List<ChamadoQuantidadeVO> getListaChamadoTipo(Integer idCliente,
			String mesRelatorio) {

		if (listaChamadoTipo == null
				|| controleIdCliente.get("getListaChamadoTipo") != idCliente) {
			if (listaChamadoAberto == null
					|| controleIdCliente.get("getListaChamadoTipo") != idCliente) {
				atendimentoDAO.getChamadosAbertos(idCliente, mesRelatorio);
			}
			if (listaChamadoFechado == null
					|| controleIdCliente.get("getListaChamadoTipo") != idCliente) {
				atendimentoDAO.getChamadosFechados(idCliente, mesRelatorio);
			}
			if (listaChamadoEmAberto == null
					|| controleIdCliente.get("getChamadosEmAberto") != idCliente) {
				atendimentoDAO.getChamadosEmAbertos(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getListaChamadoTipo", idCliente);
			listaChamadoTipo = new ArrayList<ChamadoQuantidadeVO>();
			Iterator<ChamadoVO> itChamado;
			Iterator<ChamadoQuantidadeVO> itTipoChamado;
			ChamadoVO chamado;
			Integer achou;

			itChamado = listaChamadoAberto.iterator();

			while (itChamado.hasNext()) {
				chamado = itChamado.next();
				itTipoChamado = listaChamadoTipo.iterator();
				achou = 0;
				while (itTipoChamado.hasNext()) {
					ChamadoQuantidadeVO tipoChamados = itTipoChamado.next();
					if (tipoChamados.getNome().equals(chamado.getTipoChamado())) {
						tipoChamados
								.setQtdeAberto(tipoChamados.getQtdeAberto() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					ChamadoQuantidadeVO tipoChamados = new ChamadoQuantidadeVO();
					tipoChamados.setNome(chamado.getTipoChamado());
					tipoChamados.setQtdeAberto(1);
					tipoChamados.setQtdeFechado(0);
					tipoChamados.setQtdeEmAberto(0);
					listaChamadoTipo.add(tipoChamados);
				}
			}

			itChamado = listaChamadoFechado.iterator();
			while (itChamado.hasNext()) {
				chamado = itChamado.next();
				itTipoChamado = listaChamadoTipo.iterator();
				achou = 0;
				while (itTipoChamado.hasNext()) {
					ChamadoQuantidadeVO tipoChamados = itTipoChamado.next();
					if (tipoChamados.getNome().equals(chamado.getTipoChamado())) {
						tipoChamados.setQtdeFechado(tipoChamados
								.getQtdeFechado() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					ChamadoQuantidadeVO tipoChamados = new ChamadoQuantidadeVO();
					tipoChamados.setNome(chamado.getTipoChamado());
					tipoChamados.setQtdeAberto(0);
					tipoChamados.setQtdeFechado(1);
					tipoChamados.setQtdeEmAberto(0);
					listaChamadoTipo.add(tipoChamados);
				}

			}

			itChamado = listaChamadoEmAberto.iterator();
			while (itChamado.hasNext()) {
				chamado = itChamado.next();
				itTipoChamado = listaChamadoTipo.iterator();
				achou = 0;
				while (itTipoChamado.hasNext()) {
					ChamadoQuantidadeVO tipoChamados = itTipoChamado.next();
					if (tipoChamados.getNome().equals(chamado.getTipoChamado())) {
						tipoChamados.setQtdeEmAberto(tipoChamados
								.getQtdeEmAberto() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					ChamadoQuantidadeVO tipoChamados = new ChamadoQuantidadeVO();
					tipoChamados.setNome(chamado.getTipoChamado());
					tipoChamados.setQtdeAberto(0);
					tipoChamados.setQtdeFechado(0);
					tipoChamados.setQtdeEmAberto(1);
					listaChamadoTipo.add(tipoChamados);
				}
			}

			Integer aberto = 0;
			Integer fechado = 0;
			Integer emAberto = 0;
			itTipoChamado = listaChamadoTipo.iterator();
			while (itTipoChamado.hasNext()) {
				ChamadoQuantidadeVO tipoChamados = itTipoChamado.next();
				aberto = aberto + tipoChamados.getQtdeAberto();
				fechado = fechado + tipoChamados.getQtdeFechado();
				emAberto = emAberto + tipoChamados.getQtdeEmAberto();
			}

			setQtdeChamadosAbertosTipo(aberto);
			setQtdeChamadosEmAbertosTipo(emAberto);
			setQtdeChamadosFechadosTipo(fechado);

			Double porcentagemAberto = 0.0;
			Double porcentagemEmAberto = 0.0;
			Double porcentagemFechado = 0.0;
			itTipoChamado = listaChamadoTipo.iterator();
			while (itTipoChamado.hasNext()) {
				ChamadoQuantidadeVO tipoChamados = itTipoChamado.next();
				tipoChamados.setPorcentoAberto(getPorcentagem(
						tipoChamados.getQtdeAberto(), aberto));
				tipoChamados.setPorcentoFechado(getPorcentagem(
						tipoChamados.getQtdeFechado(), fechado));
				tipoChamados.setPorcentoEmAberto(getPorcentagem(
						tipoChamados.getQtdeEmAberto(), emAberto));
				porcentagemAberto = porcentagemAberto
						+ tipoChamados.getPorcentoAberto();
				porcentagemEmAberto = porcentagemEmAberto
						+ tipoChamados.getPorcentoEmAberto();
				porcentagemFechado = porcentagemFechado
						+ tipoChamados.getPorcentoFechado();
			}

			setPorcentagemChamadosAbertosTipo(porcentagemAberto);
			setPorcentagemChamadosEmAbertosTipo(porcentagemEmAberto);
			setPorcentagemChamadosFechadosTipo(porcentagemFechado);

		}

		return listaChamadoTipo;
	}

	public List<String> getListaChamadoAbertosHost(Integer idCliente,
			String mesRelatorio) {
		if (listaAbertosHost == null
				|| controleIdCliente.get("getListaChamadoAbertosHost") != idCliente) {
			controleIdCliente.put("getListaChamadoAbertosHost", idCliente);
			listaAbertosHost = atendimentoDAO.getListaAbertosComHosts(
					idCliente, mesRelatorio);
		}
		return listaAbertosHost;
	}

	public List<String> getListaChamadoFechadosHost(Integer idCliente,
			String mesRelatorio) {
		if (listaFechadosHost == null
				|| controleIdCliente.get("getListaChamadoFechadosHost") != idCliente) {
			controleIdCliente.put("getListaChamadoFechadosHost", idCliente);
			listaFechadosHost = atendimentoDAO.getListaFechadosComHosts(
					idCliente, mesRelatorio);
		}
		return listaAbertosHost;
	}

	public List<String> getListaChamadoEmAbertosHost(Integer idCliente,
			String mesRelatorio) {
		if (listaEmAbertosHost == null
				|| controleIdCliente.get("getListaChamadoEmAbertosHost") != idCliente) {
			controleIdCliente.put("getListaChamadoEmAbertosHost", idCliente);
			listaEmAbertosHost = atendimentoDAO.getListaEmAbertosComHosts(
					idCliente, mesRelatorio);
		}
		return listaEmAbertosHost;
	}

	public List<ChamadoQuantidadeVO> getListaChamadoHost(Integer idCliente,
			String mesRelatorio) {
		if (listaChamadosHost == null
				|| controleIdCliente.get("getListaChamadoHost") != idCliente) {
			if (listaAbertosHost == null
					|| controleIdCliente.get("getListaChamadoAbertosHost") != idCliente) {
				getListaChamadoAbertosHost(idCliente, mesRelatorio);
			}
			if (listaFechadosHost == null
					|| controleIdCliente.get("getListaChamadoFechadosHost") != idCliente) {
				getListaChamadoFechadosHost(idCliente, mesRelatorio);
			}
			if (listaEmAbertosHost == null
					|| controleIdCliente.get("getListaChamadoEmAbertosHost") != idCliente) {
				getListaChamadoEmAbertosHost(idCliente, mesRelatorio);
			}
			controleIdCliente.put("getListaChamadoHost", idCliente);
			listaChamadosHost = new ArrayList<ChamadoQuantidadeVO>();
			Iterator<String> itHost;
			Iterator<ChamadoQuantidadeVO> itHostList;
			String host;
			Integer achou;

			itHost = listaAbertosHost.iterator();

			while (itHost.hasNext()) {
				host = itHost.next();
				itHostList = listaChamadosHost.iterator();
				achou = 0;
				while (itHostList.hasNext()) {
					ChamadoQuantidadeVO hostVO = itHostList.next();
					if (hostVO.getNome().equals(host)) {
						hostVO.setQtdeAberto(hostVO.getQtdeAberto() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					ChamadoQuantidadeVO hostVO = new ChamadoQuantidadeVO();
					hostVO.setNome(host);
					hostVO.setQtdeAberto(1);
					hostVO.setQtdeFechado(0);
					hostVO.setQtdeEmAberto(0);
					listaChamadosHost.add(hostVO);
				}
			}

			itHost = listaFechadosHost.iterator();
			while (itHost.hasNext()) {
				host = itHost.next();
				itHostList = listaChamadosHost.iterator();
				achou = 0;
				while (itHostList.hasNext()) {
					ChamadoQuantidadeVO hostVO = itHostList.next();
					if (hostVO.getNome().equals(host)) {
						hostVO.setQtdeFechado(hostVO.getQtdeFechado() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					ChamadoQuantidadeVO hostVO = new ChamadoQuantidadeVO();
					hostVO.setNome(host);
					hostVO.setQtdeAberto(0);
					hostVO.setQtdeFechado(1);
					hostVO.setQtdeEmAberto(0);
					listaChamadosHost.add(hostVO);
				}

			}
			itHost = listaEmAbertosHost.iterator();
			while (itHost.hasNext()) {
				host = itHost.next();
				itHostList = listaChamadosHost.iterator();
				achou = 0;
				while (itHostList.hasNext()) {
					ChamadoQuantidadeVO hostVO = itHostList.next();
					if (hostVO.getNome().equals(host)) {
						hostVO.setQtdeEmAberto(hostVO.getQtdeEmAberto() + 1);
						achou = 1;
					}
				}
				if (achou == 0) {
					ChamadoQuantidadeVO hostVO = new ChamadoQuantidadeVO();
					hostVO.setNome(host);
					hostVO.setQtdeAberto(0);
					hostVO.setQtdeFechado(0);
					hostVO.setQtdeEmAberto(1);
					listaChamadosHost.add(hostVO);
				}

			}

			Integer aberto = 0;
			Integer fechado = 0;
			Integer emAberto = 0;
			List<String> hostGraficoAberto = new ArrayList<String>();
			List<String> hostGraficoFechado = new ArrayList<String>();
			List<String> hostGraficoEmAberto = new ArrayList<String>();
			itHostList = listaChamadosHost.iterator();
			while (itHostList.hasNext()) {
				ChamadoQuantidadeVO hostVO = itHostList.next();
				aberto = aberto + hostVO.getQtdeAberto();
				fechado = fechado + hostVO.getQtdeFechado();
				emAberto = emAberto + hostVO.getQtdeEmAberto();
				hostGraficoAberto.add("{label: \"" + hostVO.getNome()
						+ "\",  data: " + hostVO.getQtdeAberto() + "}");
				hostGraficoFechado.add("{label: \"" + hostVO.getNome()
						+ "\",  data: " + hostVO.getQtdeFechado() + "}");
				hostGraficoEmAberto.add("{label: \"" + hostVO.getNome()
						+ "\",  data: " + hostVO.getQtdeEmAberto() + "}");
			}
			setListaGraficoAbertosHost(hostGraficoAberto);
			setListaGraficoFechadosHost(hostGraficoFechado);
			setListaGraficoEmAbertosHost(hostGraficoEmAberto);

			setQtdeChamadosAbertosHost(aberto);
			setQtdeChamadosEmAbertosHost(emAberto);
			setQtdeChamadosFechadosHost(fechado);

			Double porcentagemAberto = 0.0;
			Double porcentagemEmAberto = 0.0;
			Double porcentagemFechado = 0.0;
			itHostList = listaChamadosHost.iterator();
			while (itHostList.hasNext()) {
				ChamadoQuantidadeVO hostVO = itHostList.next();
				hostVO.setPorcentoAberto(getPorcentagem(hostVO.getQtdeAberto(),
						aberto));
				hostVO.setPorcentoFechado(getPorcentagem(
						hostVO.getQtdeFechado(), fechado));
				hostVO.setPorcentoEmAberto(getPorcentagem(
						hostVO.getQtdeEmAberto(), emAberto));
				porcentagemAberto = porcentagemAberto
						+ hostVO.getPorcentoAberto();
				porcentagemEmAberto = porcentagemEmAberto
						+ hostVO.getPorcentoEmAberto();
				porcentagemFechado = porcentagemFechado
						+ hostVO.getPorcentoFechado();
			}

			setPorcentagemChamadosAbertosHost(porcentagemAberto);
			setPorcentagemChamadosEmAbertosHost(porcentagemEmAberto);
			setPorcentagemChamadosFechadosHost(porcentagemFechado);

		}
		return listaChamadosHost;
	}

	public String getGraficoFechadosHost(Integer idCliente, String mesRelatorio) {
		String saida = new String();
		if (listaGraficoFechadosHost == null
				|| controleIdCliente.get("getGraficoFechadosHost") != idCliente) {
			getListaChamadoHost(idCliente, mesRelatorio);
			controleIdCliente.put("getGraficoFechadosHost", idCliente);
			Iterator<String> itHost = listaGraficoFechadosHost.iterator();
			saida = "[";
			while (itHost.hasNext()) {
				String host = itHost.next();
				saida = saida + host + ",";
			}
			saida = saida + "]";

		}
		return saida;
	}

	public String getGraficoAbertosHost(Integer idCliente, String mesRelatorio) {
		String saida = new String();
		if (listaGraficoAbertosHost == null
				|| controleIdCliente.get("getGraficoAbertosHost") != idCliente) {
			getListaChamadoHost(idCliente, mesRelatorio);
			controleIdCliente.put("getGraficoAbertosHost", idCliente);
			Iterator<String> itHost = listaGraficoAbertosHost.iterator();
			saida = "[";
			while (itHost.hasNext()) {
				String host = itHost.next();
				saida = saida + host + ",";
			}
			saida = saida + "]";

		}
		return saida;
	}

	public String getGraficoEmAbertosHost(Integer idCliente, String mesRelatorio) {
		String saida = new String();
		if (listaGraficoEmAbertosHost == null
				|| controleIdCliente.get("getGraficoEmAbertosHost") != idCliente) {
			getListaChamadoHost(idCliente, mesRelatorio);
			controleIdCliente.put("getGraficoEmAbertosHost", idCliente);
			Iterator<String> itHost = listaGraficoEmAbertosHost.iterator();
			saida = "[";
			while (itHost.hasNext()) {
				String host = itHost.next();
				saida = saida + host + ",";
			}
			saida = saida + "]";

		}

		// saida =
		// "[{ label: \"Series1\",  data: 10},{ label: \"Series2\",  data: 30},{ label: \"Series6\",  data: 110}]";
		return saida;
	}

	public Double getPorcentagemChamadosAbertosTipo(Integer idCliente,
			String mesRelatorio) {
		Double porcentagem = 0.0;
		Iterator<ChamadoQuantidadeVO> itTipoChamado;

		if (porcentagemChamadosAbertosTipo == null
				|| controleIdCliente.get("getPorcentagemChamadosAbertosTipo") != idCliente) {
			controleIdCliente.put("getPorcentagemChamadosAbertosTipo",
					idCliente);
			if (listaChamadoTipo == null
					|| controleIdCliente.get("getListaChamadoTipo") != idCliente) {
				getListaChamadoTipo(idCliente, mesRelatorio);
			}
			itTipoChamado = listaChamadoTipo.iterator();

			while (itTipoChamado.hasNext()) {
				ChamadoQuantidadeVO tipoChamados = itTipoChamado.next();
				porcentagem = porcentagem + tipoChamados.getPorcentoAberto();
			}

		}

		return porcentagem;
	}

	public Double getPorcentagemChamadosFechadosTipo(Integer idCliente,
			String mesRelatorio) {
		Double porcentagem = 0.0;
		Iterator<ChamadoQuantidadeVO> itTipoChamado;

		if (porcentagemChamadosFechadosTipo == null
				|| controleIdCliente.get("getPorcentagemChamadosFechadosTipo") != idCliente) {
			controleIdCliente.put("getPorcentagemChamadosFechadosTipo",
					idCliente);
			if (listaChamadoTipo == null
					|| controleIdCliente.get("getListaChamadoTipo") != idCliente) {
				getListaChamadoTipo(idCliente, mesRelatorio);
			}
			itTipoChamado = listaChamadoTipo.iterator();

			while (itTipoChamado.hasNext()) {
				ChamadoQuantidadeVO tipoChamados = itTipoChamado.next();
				porcentagem = porcentagem + tipoChamados.getPorcentoFechado();
			}
		}

		return porcentagem;
	}

	private void setQtdeChamadosAbertosSolicitante(
			Integer qtdeChamadosAbertosSolicitante) {
		this.qtdeChamadosAbertosSolicitante = qtdeChamadosAbertosSolicitante;
	}

	private void setQtdeChamadosFechadosSolicitante(
			Integer qtdeChamadosFechadosSolicitante) {
		this.qtdeChamadosFechadosSolicitante = qtdeChamadosFechadosSolicitante;
	}

	private void setQtdeChamadosEmAbertosSolicitante(
			Integer qtdeChamadosEmAbertosSolicitante) {
		this.qtdeChamadosEmAbertosSolicitante = qtdeChamadosEmAbertosSolicitante;
	}

	private void setPorcentagemChamadosAbertosSolicitante(
			Double porcentagemChamadosAbertosSolicitante) {
		this.porcentagemChamadosAbertosSolicitante = porcentagemChamadosAbertosSolicitante;
	}

	private void setPorcentagemChamadosEmAbertosSolicitante(
			Double porcentagemChamadosEmAbertosSolicitante) {
		this.porcentagemChamadosEmAbertosSolicitante = porcentagemChamadosEmAbertosSolicitante;
	}

	private void setPorcentagemChamadosFechadosSolicitante(
			Double porcentagemChamadosFechadosSolicitante) {
		this.porcentagemChamadosFechadosSolicitante = porcentagemChamadosFechadosSolicitante;
	}

	private void setPorcentagemChamadosAbertosTipo(
			Double porcentagemChamadosAbertosTipo) {
		this.porcentagemChamadosAbertosTipo = porcentagemChamadosAbertosTipo;
	}

	private void setPorcentagemChamadosEmAbertosTipo(
			Double porcentagemChamadosEmAbertosTipo) {
		this.porcentagemChamadosEmAbertosTipo = porcentagemChamadosEmAbertosTipo;
	}

	private void setPorcentagemChamadosFechadosTipo(
			Double porcentagemChamadosFechadosTipo) {
		this.porcentagemChamadosFechadosTipo = porcentagemChamadosFechadosTipo;
	}

	private void setQtdeChamadosAbertosTipo(Integer qtdeChamadosAbertosTipo) {
		this.qtdeChamadosAbertosTipo = qtdeChamadosAbertosTipo;
	}

	private void setQtdeChamadosFechadosTipo(Integer qtdeChamadosFechadosTipo) {
		this.qtdeChamadosFechadosTipo = qtdeChamadosFechadosTipo;
	}

	private void setQtdeChamadosEmAbertosTipo(Integer qtdeChamadosEmAbertosTipo) {
		this.qtdeChamadosEmAbertosTipo = qtdeChamadosEmAbertosTipo;
	}

	private void setPorcentagemChamadosAbertosHost(
			Double porcentagemChamadosAbertosHost) {
		this.porcentagemChamadosAbertosHost = porcentagemChamadosAbertosHost;
	}

	private void setPorcentagemChamadosEmAbertosHost(
			Double porcentagemChamadosEmAbertosHost) {
		this.porcentagemChamadosEmAbertosHost = porcentagemChamadosEmAbertosHost;
	}

	private void setPorcentagemChamadosFechadosHost(
			Double porcentagemChamadosFechadosHost) {
		this.porcentagemChamadosFechadosHost = porcentagemChamadosFechadosHost;
	}

	private void setQtdeChamadosFechadosHost(Integer qtdeChamadosFechadosHost) {
		this.qtdeChamadosFechadosHost = qtdeChamadosFechadosHost;
	}

	private void setQtdeChamadosAbertosHost(Integer qtdeChamadosAbertosHost) {
		this.qtdeChamadosAbertosHost = qtdeChamadosAbertosHost;
	}

	private void setQtdeChamadosEmAbertosHost(Integer qtdeChamadosEmAbertosHost) {
		this.qtdeChamadosEmAbertosHost = qtdeChamadosEmAbertosHost;
	}

	private void setListaGraficoAbertosHost(List<String> listaGraficoAbertosHost) {
		this.listaGraficoAbertosHost = listaGraficoAbertosHost;
	}

	private void setListaGraficoFechadosHost(
			List<String> listaGraficoFechadosHost) {
		this.listaGraficoFechadosHost = listaGraficoFechadosHost;
	}

	private void setListaGraficoEmAbertosHost(
			List<String> listaGraficoEmAbertosHost) {
		this.listaGraficoEmAbertosHost = listaGraficoEmAbertosHost;
	}

}
