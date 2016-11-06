package br.com.hackunivag.dao;

import java.util.List;

import org.hibernate.Query;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.primefaces.model.SortOrder;

import br.com.hackunivag.dao.BaseDAO;
import br.com.hackunivag.entidade.Usuario;
import br.com.hackunivag.util.Validador;

@AutoCreate
@Name("usuarioDAO")
@Scope(ScopeType.CONVERSATION)
public class UsuarioDAO extends BaseDAO<Usuario> {
	
	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarPorPagina(int primeiro, int tamanhoPagina, String sortField,
			SortOrder sortOrder, Usuario usuario) {
		
		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append(" SELECT DISTINCT u FROM Usuario u");
		sbQuery.append(" INNER JOIN u.pessoa p");
		sbQuery.append(" WHERE 1 = 1 ");
		if (usuario != null && usuario.getPessoa() != null && Validador.isStringValida(usuario.getPessoa().getNomeCompleto())) {
			sbQuery.append(" AND lower(p.nome) LIKE lower( :nome ) ");
		}
		if (usuario != null && Validador.isStringValida(usuario.getLogin())) {
			sbQuery.append(" AND lower(u.login) LIKE lower( :login ) ");
		}
		if(sortField != null){
			switch (sortOrder) {
			case ASCENDING:
				sbQuery.append(" ORDER BY "+ sortField +" ASC ");
				break;
			case DESCENDING:
				sbQuery.append(" ORDER BY "+ sortField +" DESC ");
				break;
			case UNSORTED:
				sbQuery.append(" ORDER BY u.idUsuario ASC ");
				break;
			}
		} else{
			sbQuery.append(" ORDER BY u.idUsuario ASC ");
		}
		Query query = (Query) getSession().createQuery(sbQuery.toString());
		if (usuario != null && usuario.getPessoa() != null && Validador.isStringValida(usuario.getPessoa().getNomeCompleto())) {
			query.setParameter("nome", "%" + usuario.getPessoa().getNomeCompleto() + "%");
		}
		if (usuario != null && Validador.isStringValida(usuario.getLogin())) {
			query.setParameter("login", "%" + usuario.getLogin() + "%");
		}
		query.setFirstResult(primeiro);
		query.setMaxResults(tamanhoPagina);

		return query.list();
	}
	
	public Long contador(Usuario usuario) {
		StringBuilder hql = new StringBuilder();
		hql.append(" SELECT COUNT(DISTINCT u) from Usuario u");
		hql.append(" INNER JOIN u.pessoa p ");
		hql.append(" WHERE 1 = 1 ");
		if (usuario != null && usuario.getPessoa() != null && Validador.isStringValida(usuario.getPessoa().getNomeCompleto())) {
			hql.append(" AND lower(p.nome) LIKE lower( :nome ) ");
		}
		if (usuario != null && Validador.isStringValida(usuario.getLogin())) {
			hql.append(" AND lower(u.login) LIKE lower( :login ) ");
		}
		Query query = (Query) getSession().createQuery(hql.toString());
		if (usuario != null && usuario.getPessoa() != null && Validador.isStringValida(usuario.getPessoa().getNomeCompleto())) {
			query.setParameter("nome", "%" + usuario.getPessoa().getNomeCompleto() + "%");
		}
		if (usuario != null && Validador.isStringValida(usuario.getLogin())) {
			query.setParameter("login", "%" + usuario.getLogin() + "%");
		}
		return (Long) query.uniqueResult();
	}	
	
	@SuppressWarnings("unchecked")
	public Usuario consultarPorLoginSenha(String login, String senha) throws Exception {
		StringBuilder hql = new StringBuilder();
		hql.append(" FROM Usuario usu ");
		hql.append(" WHERE usu.login = :login ");
		if (senha != null) {
			hql.append(" AND usu.senha = :senha ");
		}

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("login", login.trim());
		if (senha != null) {
			query.setParameter("senha", senha.trim());
		}

		List<Usuario> lista = query.list();

		Usuario usuario = null;

		for (Usuario u : lista) {
			usuario = u;
		}

		if (lista.size() > 1) {
			log.error("Usuario Duplicado ::" + usuario.getLogin());
		}

		return usuario;
	}

}
