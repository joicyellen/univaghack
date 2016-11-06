package br.com.hackunivag.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.primefaces.model.SortOrder;

import br.com.hackunivag.dao.ProfessorDAO;
import br.com.hackunivag.entidade.Professor;
import br.com.hackunivag.util.Mensagens;

@AutoCreate
@Name("professorNegocio")
@Scope(ScopeType.EVENT)
public class ProfessorNegocio extends BaseNegocioEntidade<Professor> {

	private static final long serialVersionUID = 1L;

	@In
	private ProfessorDAO professorDAO;

	@Override
	public boolean incluir(Professor professor) {

		log.info("XXXX método incluir XXXX");

		try {
			if (!validarDuplicado(professor)) {
				super.addMsg(Mensagens.REGISTRO_DUPLICADO);
				return false;
			}

			professorDAO.insert(professor);
			professorDAO.flush();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean alterar(Professor professor) {
		log.info("XXXX método alterar XXXX");

		try {

			if (!validarDuplicado(professor)) {
				super.addMsg(Mensagens.REGISTRO_DUPLICADO);
				return false;
			}

			professorDAO.update(professor);
			professorDAO.flush();
			super.addMsg(Mensagens.GRAVACAO_SUCESSO);

			return true;

		} catch (Exception e) {
			super.tratarMensagensExcecao(e, Mensagens.GRAVACAO_ERRO);
		}

		return false;
	}

	@Override
	public boolean excluir(Professor professor) {

		log.info("XXX método excluir XXX");
		log.info("Id..............: " + professor.getIdProfessor());

		try {
			professorDAO.delete(professor);
			professorDAO.flush();
			log.info("XXX EXCLUSAO_SUCESSO XXX");
			super.addMsg(Mensagens.EXCLUSAO_SUCESSO);
			return true;

		} catch (Exception e) {
			super.tratarMensagensExcecao(e, Mensagens.EXCLUSAO_ERRO);
		}
		return false;
	}

	@Override
	public Professor buscar(Serializable id) {

		Professor professor = null;
		try {
			professor = professorDAO.loadById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professor;
	}

	@Override
	public List<Professor> pesquisar(Professor professor) {

		log.info("XXX metodo pesquisa  XXX");

		List<Professor> lista = new ArrayList<Professor>();

		if (!validarPesquisar(professor)) {
			addMsg(Mensagens.PESQUISA_SEM_FILTRO_INFORMADO);
			return lista;
		}

		try {
			lista = professorDAO.findByExample(professor);

			if (lista.isEmpty()) {
				super.addMsg(Mensagens.PESQUISA_SEM_RESULTADO);
			}

		} catch (Exception e) {
			super.tratarMensagensExcecao(e, Mensagens.PESQUISA_ERRO);
		}
		log.info("lista" + lista.size());
		return lista;
	}

	public List<Professor> listarPorPagina(int primeiro, int tamanhoPagina, String sortField, SortOrder sortOrder,
			Professor professor) {

		List<Professor> lista = new ArrayList<Professor>();
		try {
			if (!"".equals(sortField)) {
				lista = professorDAO.listarPorPagina(primeiro, tamanhoPagina, sortField, sortOrder, professor);
			} else {
				lista = professorDAO.listarPorPagina(primeiro, tamanhoPagina, sortField, sortOrder, professor);
			}

			log.info("lista.size():: " + lista.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Long contador(Professor professor) {

		Long contador = null;

		try {
			contador = professorDAO.contador(professor);
			log.info("contadorFornecedor:: " + contador);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return contador;
	}

	@Override
	public List<Professor> listarTodos() {

		List<Professor> lista = new ArrayList<Professor>();

		try {
			lista = professorDAO.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("lista total ::  " + lista.size());
		return lista;
	}

	@Override
	protected boolean validarPesquisar(Professor professor) {

		log.info("XXXX validarPesquisar XXXX");
		log.info("Descricao...........: " + professor.getMatricula());

		if (!StringUtils.EMPTY.equals(professor.getPessoa().getNomeCompleto()))
			return true;

		return false;
	}

	@Override
	protected boolean validarDuplicado(Professor professor) {

		log.info("XXXX validarDuplicado XXXX");
		log.info("Descricao...........: " + professor.getMatricula());

		String[] listaCampos = new String[] { "descricao" };
		Object[] listaValores = new Object[] { professor.getPessoa().getNomeCompleto() };

		try {
			Professor obj = professorDAO.loadByField(listaCampos, listaValores);

			if (obj == null)
				return true;

			if (obj != null && obj.getIdProfessor() == professor.getIdProfessor())
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
