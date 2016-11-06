package br.com.hackunivag.dao;

import java.util.List;

import org.hibernate.Query;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.primefaces.model.SortOrder;

import br.com.hackunivag.entidade.Professor;
import br.com.hackunivag.util.Validador;

@AutoCreate
@Name("professorDAO")
@Scope(ScopeType.CONVERSATION)
public class ProfessorDAO extends BaseDAO<Professor> {
	
	@SuppressWarnings("unchecked")
	
	public List<Professor> listarPorPagina(int primeiro, int tamanhoPagina, String sortField, SortOrder sortOrder, Professor professor) {
		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append(" SELECT DISTINCT u FROM Professor u ");
		sbQuery.append(" INNER JOIN u.pessoa p");
		sbQuery.append(" WHERE u.escola = :escola ");
		
		if (professor != null && professor.getPessoa() != null && Validador.isStringValida(professor.getPessoa().getNomeCompleto())) {
			sbQuery.append(" AND lower(p.nome) LIKE lower( :nome ) ");
		}
		if (professor != null && professor.getPessoa() != null && Validador.isStringValida(professor.getPessoa().getCpf())) {
			sbQuery.append(" AND lower(p.cpf) LIKE lower( :cpf ) ");
		}
		
		Query query = (Query) getSession().createQuery(sbQuery.toString());
		if (professor != null && professor.getPessoa() != null && Validador.isStringValida(professor.getPessoa().getNomeCompleto())) {
			query.setParameter("nome", "%" + professor.getPessoa().getNomeCompleto() + "%");
		}
		if (professor != null && professor.getPessoa() != null && Validador.isStringValida(professor.getPessoa().getCpf())) {
			query.setParameter("login", "%" + professor.getPessoa().getCpf() + "%");
		}
		
		if (professor.getEscola() != null) {
			query.setParameter("escola", professor.getEscola());
		}

		return query.list();
	}

public Long contador(Professor professor) {
		
		StringBuilder hql = new StringBuilder();
		
		hql.append(" select COUNT(c) from Categoria c WHERE 1=1 ");
		hql.append(" AND c.dominioAtivoInativo = :situacao ");

		Query query = (Query) getSession().createQuery(hql.toString());
		query.setParameter("situacao", br.com.hackunivag.util.Dominios.DOMINIO_ATIVO_INATIVO.ATIVO);
		
		return (Long) query.uniqueResult();
	}	
}
