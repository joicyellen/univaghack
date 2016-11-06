package br.com.hackunivag.negocio;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.com.hackunivag.entidade.Pessoa;

@AutoCreate
@Scope(ScopeType.CONVERSATION)
@Name(value="pessoaNegocio")
public class PessoaNegocio extends BaseNegocioEntidade<Pessoa>{

	private static final long serialVersionUID = 1L;

	@Override
	public boolean incluir(Pessoa obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Pessoa obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Pessoa obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pessoa buscar(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> pesquisar(Pessoa obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Pessoa> listarTodos() {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Pessoa.class);
		
		criteria.addOrder(Order.asc("nomeCompleto"));
		
		return criteria.list();
	}

	@Override
	protected boolean validarPesquisar(Pessoa obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean validarDuplicado(Pessoa obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
