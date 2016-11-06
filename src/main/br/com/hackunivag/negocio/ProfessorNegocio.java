package br.com.hackunivag.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.com.hackunivag.dao.ProfessorDAO;
import br.com.hackunivag.entidade.Pessoa;
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
	public boolean incluir(Professor obj) {
		log.info("XXX método incluir XXX");

		try {

			professorDAO.insert(obj);

			if (isControleTransacional()) {
				professorDAO.flush();
				super.addMsg(Mensagens.GRAVACAO_SUCESSO);
			}

			log.info("XXXX GRAVACAO_SUCESSO XXXX");
			return true;

		} catch (Exception e) {
			log.info("XXXX GRAVACAO_ERRO XXXX");
			super.addMsg(Mensagens.GRAVACAO_ERRO);
		}
		return false;
	}

	@Override
	public boolean alterar(Professor obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Professor obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Professor buscar(Serializable id) {
		entityManager.find(Professor.class, id);
		
		// TODO
		
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Professor> pesquisar(Professor obj) {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Professor.class);
		
		criteria.addOrder(Order.asc("idProfessor"));
		
		return criteria.list();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> pesquisar(Pessoa obj) {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Professor.class);
		
		criteria.createAlias("pessoa.nomeCompleto", "nome");
		criteria.add(Restrictions.eq("nome", obj.getNomeCompleto()));
		
		criteria.addOrder(Order.asc("idProfessor"));
		
		return criteria.list();
		
	}

	@Override
	public List<Professor> listarTodos() {
		List<Professor> lista = new ArrayList<Professor>();

		try {
			lista = professorDAO.listAll();
			log.info("lista.size():: " + lista.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public List<Professor> listarProfessor(Professor professor) {
		List<Professor> lista = new ArrayList<Professor>();

		try {
			lista = professorDAO.listarProfessor(professor);
			log.info("lista.size():: " + lista.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	protected boolean validarPesquisar(Professor obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean validarDuplicado(Professor obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
