package br.com.hackunivag.util;

import org.jboss.seam.international.StatusMessage.Severity;


public enum MensagensFcon {
	
	ADMINISTRADORA_NAO_SELECIONADA(Severity.WARN, "administradora.naoSelecionada"),
	BOLETO_PAGAMENTO_NAO_ANEXADO(Severity.WARN, "boletoPagamento.naoAnexado"),
	CNPJ_CADASTRADO(Severity.WARN, "cnpj.cadastrado"),
	CNPJ_NAO_CADASTRADO(Severity.INFO, "cnpj.naoCadastrado"),
	CPF_CADASTRADO(Severity.WARN, "cpf.cadastrado"),
	CPF_NAO_CADASTRADO(Severity.INFO, "cpf.naoCadastrado"),
	COMPROVANTE_DEVOLUCAO_NAO_ANEXADO(Severity.WARN, "notificacao.documentoNaoAnexado"),
	CAPTCHA_INCORRETO(Severity.WARN, "captcha.incorreto"),
	DADO_BANCARIO_DUPLICADO(Severity.ERROR, "dadoBancario.duplicado");


	
	
	private String key;
	private Severity severity;
	
	private MensagensFcon(Severity severity, String key){
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
