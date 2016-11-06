package br.com.hackunivag.negocio;

import java.io.Serializable;
import java.util.List;

public abstract class BaseNegocioEntidade<T> extends BaseNegocio {
	
	private static final long serialVersionUID = 1L;
	
	public abstract boolean incluir(T obj);

	public abstract boolean alterar(T obj);

	public abstract boolean excluir(T obj);

	public abstract T buscar(Serializable id);

	public abstract List<T> pesquisar(T obj);

	public abstract List<T> listarTodos();

	protected abstract boolean validarPesquisar(T obj);

	protected abstract boolean validarDuplicado(T obj);
	
	

}
