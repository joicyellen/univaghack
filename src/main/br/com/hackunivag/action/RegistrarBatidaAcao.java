package br.com.hackunivag.action;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.com.hackunivag.util.CheckPermission;

@Name("registrarBatidaAcaoAcao")
@Scope(ScopeType.CONVERSATION)
@CheckPermission
public class RegistrarBatidaAcao extends BaseAcao {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub
		
	}

}
