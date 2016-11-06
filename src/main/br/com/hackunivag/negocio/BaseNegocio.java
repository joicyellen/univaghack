package br.com.hackunivag.negocio;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;

import br.com.hackunivag.entidade.Usuario;
import br.com.hackunivag.util.Mensagens;
import br.com.hackunivag.util.MensagensFcon;

public abstract class BaseNegocio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Logger
	protected Log log;

	@In(required = false)
	protected StatusMessages facesMessages;
	
	@In(create = true, required = false, value = "usuarioLogado")
	@Out(required = false, scope = ScopeType.SESSION)
	private Usuario usuarioLogado;
	
	@In
	protected EntityManager entityManager;

	/**
	 * Atributo usado para integra��es da camada de neg�cio.
	 * 
	 * Exemplo para injetar um BO setar o controleTrasacional igual a false que um m�todo n�o vai chamar persistir(flush) no banco de dados e vai se tornar parte de uma transa��o.
	 * 
	 */
	private boolean controleTransacional = true;
	
	
	protected void addMsg(Mensagens msg) {

		StatusMessages.instance().addFromResourceBundle(msg.getSeverity(), msg.getKey());
	}
	
	protected void addMsg(MensagensFcon msg) {

		StatusMessages.instance().addFromResourceBundle(msg.getSeverity(), msg.getKey());
	}

	protected void addMsg(Mensagens msg, String valor) {

		StatusMessages.instance().addFromResourceBundle(msg.getSeverity(), msg.getKey(), valor);
	}
	
	protected void addMsg(MensagensFcon msg, Object... valor) {

		StatusMessages.instance().addFromResourceBundle(msg.getSeverity(), msg.getKey(), valor);
	}

	
	/**
	 * M�todo para Tratar Exce��es do Sistema. Logar Pilha de Erro!
	 * 
	 * @param e
	 */
	protected void tratarMensagensExcecao(Exception e, Mensagens msg) {

		log.info("XXXX m�todo tratarException XXXX");
		log.info("toString...........: " + e.toString());
		log.info("getCause...........: " + e.getCause());
		log.info("getMessage.........: " + e.getMessage());

		e.printStackTrace();

		if (e instanceof NullPointerException) {
			addMsg(Mensagens.CAMPO_OBRIGATORIO);
			return;
		}

		if (e instanceof org.hibernate.exception.ConstraintViolationException) {

			switch (msg) {

			case GRAVACAO_ERRO:
				addMsg(Mensagens.EXCLUSAO_ERRO);
				break;
			case REGISTRO_DUPLICADO:
				addMsg(Mensagens.REGISTRO_DUPLICADO);
				break;
			default:
				addMsg(msg);
			}
			return;
		}

		if (e instanceof org.hibernate.StaleObjectStateException) {
			addMsg(Mensagens.CONCORRENCIA_MESMO_REGISTRO);
			return;
		}

		if (e instanceof javax.persistence.EntityNotFoundException) {
			addMsg(Mensagens.REGISTRO_EXCLUIDO);
			return;
		}

		if (e instanceof Exception) {
			addMsg(msg);
			return;
		}
	}

	public boolean isControleTransacional() {
		return controleTransacional;
	}

	public void setControleTransacional(boolean controleTransacional) {
		this.controleTransacional = controleTransacional;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}
