package br.com.hackunivag.action;

import java.util.Iterator;

import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;

import br.com.hackunivag.util.Mensagens;
import br.com.hackunivag.entidade.Usuario;

public abstract class BaseAcao {

	@Logger
	protected Log log;

	@In(required = false)
	protected StatusMessages facesMessages;
	
	@In(required = false)
	protected String campoPesquisaPrincipal;

	@In(create = true, required = false, value = "usuarioLogado")
	@Out(required = false, scope = ScopeType.SESSION)
	private Usuario usuarioLogado;

	public abstract void init();

	public abstract void limpar();


	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	protected void addMsg(Mensagens msg) {
		StatusMessages.instance().addFromResourceBundle(msg.getSeverity(), msg.getKey());
	}

	public void redirecionarPagina(String url) {
		FacesContext context = FacesContext.getCurrentInstance();
		NavigationHandler navHandler = context.getApplication().getNavigationHandler();
		navHandler.handleNavigation(context, null, url);
	}

	/**
	 * Metodo responssavel por atualizar a pagina atual
	 */
	protected void refreshPage() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String refreshpage = fc.getViewRoot().getViewId();
		ViewHandler ViewH = fc.getApplication().getViewHandler();
		UIViewRoot UIV = ViewH.createView(fc, refreshpage);
		UIV.setViewId(refreshpage);
		fc.setViewRoot(UIV);
	}
	
	@SuppressWarnings("rawtypes")
	public static UIComponent findComponent(UIComponent base, String id) {
		if (id.equals(base.getId()))
			return base;

		UIComponent children = null;
		UIComponent result = null;
		Iterator childrens = base.getFacetsAndChildren();
		while (childrens.hasNext() && (result == null)) {
			children = (UIComponent) childrens.next();
			if (id.equals(children.getId())) {
				result = children;
				break;
			}
			result = findComponent(children, id);
			if (result != null) {
				break;
			}
		}
		return result;
	}
	
}
