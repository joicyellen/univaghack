package br.com.hackunivag.util;

import org.jboss.seam.international.StatusMessage.Severity;

public enum Mensagens {

	CAPTCHA_INVALIDO(Severity.ERROR , "captcha.invalido"),
	CAMPO_OBRIGATORIO(Severity.WARN, "javax.faces.component.UIInput.REQUIRED"),
	CONCORRENCIA_MESMO_REGISTRO(Severity.ERROR ,"concorrencia.mesmo.registro"),
	DATA_INICIAL_ANTERIOR_ATUAL(Severity.ERROR, "data.inicialAnteriorAtual"),
	DATA_INICIAL_MAIOR_DATA_FINAL(Severity.ERROR, "data.inicialMaiorFinal"),
	DATA_FINAL_ANTERIOR_ATUAL(Severity.WARN, "data.finalAnteriorAtual"),
	DATA_FINAL_ANTERIOR_DATA_INICIAL(Severity.WARN, "data.final.anterior.data.inicial"),
	DATA_PREVISTA_FINAL_ANTERIOR_DATA_INICIAL(Severity.WARN, "data.prevista.final.anterior.data.inicial"),
	ERRO_GENERICO(Severity.ERROR, "erro.generico"),
	ERRO_ENVIO_EMAIL(Severity.ERROR, "erro.naoFoiPossivelEnviarEmail"),
	EXCLUSAO_ERRO(Severity.ERROR ,"exclusao.erro"),
	EXCLUSAO_SUCESSO(Severity.INFO ,"exclusao.sucesso"), 
	GRAVACAO_ERRO(Severity.ERROR ,"gravacao.erro"),
	GRAVACAO_SUCESSO(Severity.INFO ,"gravacao.sucesso"),
	LOGIN_FALHOU(Severity.ERROR, "org.jboss.seam.loginFailed"),
	LOGIN_JA_ATIVO(Severity.ERROR, "org.jboss.seam.security.alreadyLoggedIn"),
	LOGIN_SUCESSO(Severity.INFO, "org.jboss.seam.loginSuccessful"),
	PESQUISA_ERRO(Severity.ERROR ,"pesquisa.erro"),
	PESQUISA_FILTRO_EXIGE_3_CARECTERES(Severity.WARN, "pesquisa.min.lenght"),
	PESQUISA_FILTRO_EXIGE_N_CARECTERES(Severity.WARN, "pesquisa.min.lenght.escolha"),	
	PESQUISA_SEM_FILTRO_INFORMADO(Severity.WARN, "pesquisa.semFiltroInformado"),
	PESQUISA_SEM_RESULTADO(Severity.WARN ,"pesquisa.semResultado"),
	REGISTRO_DUPLICADO(Severity.ERROR ,"registro.duplicado"),
	REGISTRO_EXCLUIDO(Severity.ERROR ,"registro.excluido"),
	SENHA_INCORRETA(Severity.ERROR ,"senha.incorreta"),
	CADASTRO_ERRO(Severity.ERROR ,"cadastro.erro"),
	CADASTRO_SUCESSO(Severity.INFO ,"cadastro.sucesso"),
	LOGIN_OU_SENHA_VAZIO(Severity.ERROR ,"login.ou.senha.vazio"),
	SENHA_CONFIRMACAO_INVALIDA(Severity.WARN, "confirmar.senha.erro"),
	ERRO_CATEGORIA_NOME(Severity.WARN, "erro.categoria.nome");
		
	private String key;
	private Severity severity;
	
	private Mensagens(Severity severity, String key){
		this.severity = severity;
		this.key = key;
	}

	public Severity getSeverity() {
		return severity;
	}

	public String getKey() {
		return key;
	}
}
