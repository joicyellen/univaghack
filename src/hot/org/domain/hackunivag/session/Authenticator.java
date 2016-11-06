package org.domain.hackunivag.session;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import br.com.hackunivag.entidade.Usuario;
import br.com.hackunivag.negocio.UsuarioNegocio;
import br.com.hackunivag.util.Criptografia;


@Name("authenticator")
public class Authenticator {
	@Logger
	private Log log;

	@In
	Identity identity;
	@In
	Credentials credentials;
	
	@In(create = true, required = false, value = "usuarioLogado")
	@Out(required = false, scope = ScopeType.SESSION)
	private Usuario usuarioLogado;
	
	@In(create = true, required = true)
	private UsuarioNegocio usuarioNegocio;

	public boolean authenticate() {
		log.info("authenticating {0}", credentials.getUsername());
		String test = Criptografia.encrypt(credentials.getUsername(), credentials.getPassword());
		if(!usuarioNegocio.isLoginSenhaValidos(credentials.getUsername(), credentials.getPassword())){
			return false;
		}
		String senhaCriptografada = Criptografia.encrypt(credentials.getUsername(), credentials.getPassword());
		usuarioLogado = usuarioNegocio.consultarPorLoginSenha(credentials.getUsername(), senhaCriptografada);
		if (usuarioLogado != null) {
			return true;
		}
		return false;
	}

}
