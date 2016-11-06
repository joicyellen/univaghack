package br.com.hackunivag.action;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.com.hackunivag.util.CheckPermission;

@Name("relatorioFrequenciaAcao")
@Scope(ScopeType.CONVERSATION)
@CheckPermission
public class RelatorioFrequenciaAcao {

}
