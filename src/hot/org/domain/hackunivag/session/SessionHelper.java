package org.domain.hackunivag.session;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Identity;

import br.com.hackunivag.entidade.Usuario;
import br.com.hackunivag.util.Validador;


@Name("sessionHelper")
@Scope(ScopeType.SESSION)
@SuppressWarnings("unused")
public class SessionHelper {

	@In(required = true)
	private Identity identity;

	@In(create = false, required = false, value = "usuarioLogado")
	private Usuario usuarioLogado;
	
	@Logger
	private Log log;
	
	@Out(required = false)
	private boolean esqueciMinhaSenha;
	
	@In(value = "#{facesContext}", required = false)
	protected FacesContext facesContext;

	@Observer("org.jboss.seam.security.loginSuccessful")
	public void atribuirFuncionarioLogado() throws Exception {
		setEsqueciMinhaSenha(false);
		//listarRecursos(usuarioLogado);
	}
	
	@Observer("org.jboss.seam.security.loginFailed")
	public void exibirEsqueciMinhaSenha(){
		setEsqueciMinhaSenha(true);
	}
	
	
	/*
	public void listarRecursos(Usuario usuario) {
		if(Validador.isCollectionValida(usuario.getListaPermissao())){
			for (String recurso : usuario.getListaPermissao()) {
				identity.addRole(recurso);
			}
		}
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        usuarioLogado.setTempoSessao(session.getMaxInactiveInterval());
	}
	*/
	public boolean isEsqueciMinhaSenha() {
		return esqueciMinhaSenha;
	}

	public void setEsqueciMinhaSenha(boolean esqueciMinhaSenha) {
		this.esqueciMinhaSenha = esqueciMinhaSenha;
	}
	
	public String getNomeUsuario(){
		if(usuarioLogado != null){
			return usuarioLogado.getPessoa().getNomeCompleto();
		}
		return null;
	}
}
