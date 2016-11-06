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

import br.com.hackunivag.negocio.BaseNegocioEntidade;
import br.com.hackunivag.entidade.Usuario;
import br.com.hackunivag.dao.UsuarioDAO;
import br.com.hackunivag.util.Criptografia;
import br.com.hackunivag.util.Validador;
import br.com.hackunivag.util.Mensagens;

@AutoCreate
@Name("usuarioNegocio")
@Scope(ScopeType.EVENT)
public class UsuarioNegocio extends BaseNegocioEntidade<Usuario> {
	
	private static final long serialVersionUID = 1L;

	@In
	private UsuarioDAO usuarioDAO;

	@Override
	public boolean incluir(Usuario usuario) {
		log.info("XXXX método incluir XXXX");

		try {
			if (Validador.isStringValida(usuario.getSenha())) {
				if (!usuario.getSenha().equals(usuario.getSenhaConfirmar())) {
					super.addMsg(Mensagens.SENHA_CONFIRMACAO_INVALIDA);
					return false;
				}
				usuario.setSenha(Criptografia.encrypt(usuario.getLogin(), usuario.getSenha()));
			}
			if (validarDuplicado(usuario)) {
				super.addMsg(Mensagens.REGISTRO_DUPLICADO);
				return false;
			}
			usuarioDAO.insert(usuario);
			usuarioDAO.flush();

			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("XXXX GRAVACAO_ERRO XXXX");
			super.addMsg(Mensagens.CADASTRO_ERRO);
		}

		return false;
	}

	@Override
	public boolean alterar(Usuario usuario) {
		log.info("XXXX método alterar XXXX");

		try {
			if (Validador.isStringValida(usuario.getSenhaAlterar())) {
				usuario.setSenha(Criptografia.encrypt(usuario.getLogin(), usuario.getSenhaAlterar()));
			}
//			if (!validarDuplicado(usuario)) {
//				super.addMsg(Mensagens.REGISTRO_DUPLICADO);
//				return false;
//			}

			usuarioDAO.update(usuario);
			usuarioDAO.flush();
			super.addMsg(Mensagens.GRAVACAO_SUCESSO);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			log.info("XXXX GRAVACAO_ERRO XXXX");
			super.tratarMensagensExcecao(e, Mensagens.GRAVACAO_ERRO);
		}

		return false;
	}

	@Override
	public boolean excluir(Usuario usuario) {

		log.info("XXX método excluir XXX");
		log.info("Id..............: " + usuario.getIdUsuario());

		try {
			usuarioDAO.delete(usuario);
			usuarioDAO.flush();
			log.info("XXX EXCLUSAO_SUCESSO XXX");
			super.addMsg(Mensagens.EXCLUSAO_SUCESSO);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			log.info("XXXX GRAVACAO_ERRO XXXX");
			super.tratarMensagensExcecao(e, Mensagens.EXCLUSAO_ERRO);
		}
		return false;
	}

	@Override
	public Usuario buscar(Serializable id) {

		Usuario usuario = null;
		try {
			usuario = usuarioDAO.loadById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public List<Usuario> pesquisar(Usuario usuario) {

		log.info("XXX metodo pesquisa  XXX");

		List<Usuario> lista = new ArrayList<Usuario>();

		if (!validarPesquisar(usuario)) {
			addMsg(Mensagens.PESQUISA_SEM_FILTRO_INFORMADO);
			return lista;
		}

		try {
			lista = usuarioDAO.findByExample(usuario);

			if (lista.isEmpty()) {
				super.addMsg(Mensagens.PESQUISA_SEM_RESULTADO);
			}

		} catch (Exception e) {
			super.tratarMensagensExcecao(e, Mensagens.PESQUISA_ERRO);
		}
		log.info("lista" + lista.size());
		return lista;
	}

	public List<Usuario> listarPorPagina(int primeiro, int tamanhoPagina,
			String sortField, SortOrder sortOrder, Usuario usuario) {

		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			if (!"".equals(sortField)) {
				lista = usuarioDAO.listarPorPagina(primeiro, tamanhoPagina,
						sortField, sortOrder, usuario);
			} else {
				lista = usuarioDAO.listarPorPagina(primeiro, tamanhoPagina,
						sortField, sortOrder, usuario);
			}

			log.info("lista.size():: " + lista.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Long contador(Usuario usuario) {

		Long contador = null;

		try {
			contador = usuarioDAO.contador(usuario);
			log.info("contadorFornecedor:: " + contador);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return contador;
	}

	@Override
	public List<Usuario> listarTodos() {
		
		List<Usuario> lista = new ArrayList<Usuario>();

		try {
			lista = usuarioDAO.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("lista total ::  " + lista.size());
		return lista;
	}

	@Override
	protected boolean validarPesquisar(Usuario usuario) {

		log.info("XXXX validarPesquisar XXXX");
		/**
		log.info("Descricao...........: " + usuario.getDescricao());

		if (!StringUtils.EMPTY.equals(usuario.getDescricao()))
			return true;
*/
		return false;
	}

	@Override
	protected boolean validarDuplicado(Usuario usuario) {

		return false;
	}
	
	public boolean isLoginSenhaValidos(String login, String senha){
		if(StringUtils.EMPTY.equals(login)
				|| StringUtils.EMPTY.equals(senha)){
			super.addMsg(Mensagens.LOGIN_OU_SENHA_VAZIO);
			return false;
		}
		return true;
	}
	
	public Usuario consultarPorLoginSenha(String login, String senha){
		Usuario usuario = null;
		try {
			usuario = usuarioDAO.consultarPorLoginSenha(login, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
}
