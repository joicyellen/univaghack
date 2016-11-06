package br.com.hackunivag.util;

public class Dominios {

	public enum DOMINIO_ATIVO_INATIVO implements DominioInterface<DOMINIO_ATIVO_INATIVO> {

		ATIVO("ATIVO"), INATIVO("INATIVO");

		private String descricao;
		private String longDesc;
		private String description;

		DOMINIO_ATIVO_INATIVO(String desc) {
			this.descricao = desc;
			this.description = desc;
			this.longDesc = desc;
		}

		DOMINIO_ATIVO_INATIVO(String desc, String longDesc) {
			this.descricao = desc;
			this.description = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_ATIVO_INATIVO valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getDescription() {
			return this.description;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_DIA_SEMANA implements DominioInterface<DOMINIO_DIA_SEMANA> {

		SEGUNDA("Segunda-feira"), TERCA("Ter�a-feira"), QUARTA("Quarta-feira"), QUINTA("Quinta-feira"), SEXTA(
				"Sexta-feira"), SABADO("S�bado"), DOMINGO("Domingo");

		private String descricao;
		private String longDesc;
		private String description;

		DOMINIO_DIA_SEMANA(String desc) {
			this.descricao = desc;
			this.description = desc;
			this.longDesc = desc;
		}

		DOMINIO_DIA_SEMANA(String desc, String longDesc) {
			this.descricao = desc;
			this.description = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_DIA_SEMANA valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getDescription() {
			return this.description;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_ESTADO_CIVIL implements DominioInterface<DOMINIO_ESTADO_CIVIL> {

		SOLTEIRO("SOLTEIRO(A)"), CASADO("CASADO(A)"), DESQUITADO("DESQUITADO(A)"), DIVORCIADO("DIVORCIADO(A)"), SEPARADO(
				"SEPARADO(A)"), VIUVO("VIUVO(A)"), AMIGADO("AMIGADO(A)"), MARITAL("MARITAL"), NI("N/I");

		private String descricao;
		private String longDesc;

		DOMINIO_ESTADO_CIVIL(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_ESTADO_CIVIL(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_ESTADO_CIVIL valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_SEXO implements DominioInterface<DOMINIO_SEXO> {

		MASCULINO("MASCULINO"), FEMININO("FEMININO");

		private String descricao;
		private String longDesc;

		DOMINIO_SEXO(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_SEXO(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_SEXO valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {

			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_SIM_NAO implements DominioInterface<DOMINIO_SIM_NAO> {

		NAO("n", "N�O"), SIM("s", "SIM");

		private String descricao;
		private String longDesc;

		DOMINIO_SIM_NAO(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_SIM_NAO(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_SIM_NAO valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_STATUS_USUARIO implements DominioInterface<DOMINIO_STATUS_USUARIO> {

		ACESSO_LIBERADO("ACESSO_LIBERADO"), BLOQUEADO_POR_ERRO_SENHA("BLOQUEADO_POR_ERRO_SENHA"), BLOQUEADO_PELO_MASTER(
				""), BLOQUEADO_PELO_CONVENIO(""), USUARIO_CANCELADO(""), USUARIO_SUSPENSO(""), USUARIO_SUSPENSO_POR_INATIVIDADE(
				"");

		private String descricao;
		private String longDesc;

		DOMINIO_STATUS_USUARIO(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_STATUS_USUARIO(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_STATUS_USUARIO valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_TIPO_ENDERECO implements DominioInterface<DOMINIO_TIPO_ENDERECO> {

		COMERCIAL("COMERCIAL"), RESIDENCIAL("RESIDENCIAL");

		private String descricao;
		private String longDesc;

		DOMINIO_TIPO_ENDERECO(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_TIPO_ENDERECO(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_TIPO_ENDERECO valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_TIPO_FERIADO implements DominioInterface<DOMINIO_TIPO_FERIADO> {

		ESTADUAL("ESTADUAL"), MUNICIPAL("MUNICIPAL"), NACIONAL("NACIONAL");

		private String descricao;
		private String longDesc;

		DOMINIO_TIPO_FERIADO(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_TIPO_FERIADO(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_TIPO_FERIADO valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_TIPO_PESSOA implements DominioInterface<DOMINIO_TIPO_PESSOA> {

		PF("PESSOA F�SICA", "CPF"), PJ("PESSOA JUR�DICA", "CNPJ");

		private String descricao;
		private String longDesc;
		private String documentoFederalLabel;

		DOMINIO_TIPO_PESSOA(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_TIPO_PESSOA(String desc, String documentoFederalLabel) {
			this.descricao = desc;
			this.longDesc = desc;
			this.documentoFederalLabel = documentoFederalLabel;
		}

		public DOMINIO_TIPO_PESSOA valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getDocumentoFederalLabel() {
			return this.documentoFederalLabel;
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_TIPO_TELEFONE implements DominioInterface<DOMINIO_TIPO_TELEFONE> {

		CELULAR("CELULAR"), RESIDENCIAL("RESIDENCIAL"), COMERCIAL("COMERCIAL"), FAX("FAX");

		private String descricao;
		private String longDesc;

		DOMINIO_TIPO_TELEFONE(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_TIPO_TELEFONE(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_TIPO_TELEFONE valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_TIPO_PERFIL implements DominioInterface<DOMINIO_TIPO_PERFIL> {

		ADMINISTRADORA("ADMINISTRADORA"), CONVENIO("CONVENIO"), CONSIGNATARIA("CONSIGNATARIA"), SERVIDOR("SERVIDOR");

		private String descricao;
		private String longDesc;

		DOMINIO_TIPO_PERFIL(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_TIPO_PERFIL(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_TIPO_PERFIL valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_TIPO_IMAGEM_SISTEMA implements DominioInterface<DOMINIO_TIPO_IMAGEM_SISTEMA> {

		LOGO_SISTEMA("Logo do Sistema", "Imagem utilizada nas telas do sistema"), LOGO_RELATORIO("Logo do Relat�rio",
				"Imagem utilizada nos relat�rios emitidos pelo sistema"), IMAGEM_PESSOA("Imagem Pessoa",
				"Imagem utilizada no cadastro de Pessoa"), ;

		private String descricao;
		private String longDesc;

		DOMINIO_TIPO_IMAGEM_SISTEMA(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_TIPO_IMAGEM_SISTEMA(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_TIPO_IMAGEM_SISTEMA valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_PRIMEIRO_ACESSO implements DominioInterface<DOMINIO_PRIMEIRO_ACESSO> {

		SIM("Sim"), NAO("N�o");

		private String descricao;
		private String longDesc;

		DOMINIO_PRIMEIRO_ACESSO(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_PRIMEIRO_ACESSO(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_PRIMEIRO_ACESSO valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

	public enum DOMINIO_MES implements DominioInterface<DOMINIO_MES> {

		JANEIRO("Janeiro", "1", 1), FEVEREIRO("Fevereiro", "2", 2), MARCO("Mar�o", "3", 3), ABRIL("Abril", "4", 4), MAIO(
				"Maio", "5", 5), JUNHO("Junho", "6", 6), JULHO("Julho", "7", 7), AGOSTO("Agosto", "8", 8), SETEMBRO(
				"Setembro", "9", 9), OUTUBRO("Outubro", "10", 10), NOVEMBRO("Novembro", "11", 11), DEZEMBRO("Dezembro",
				"12", 12);

		private String descricao;
		private String longDesc;
		private Integer numero;

		DOMINIO_MES(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
			this.numero = 0;
		}

		DOMINIO_MES(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
			this.numero = 0;
		}

		DOMINIO_MES(String desc, String longDesc, Integer numero) {
			this.descricao = desc;
			this.longDesc = longDesc;
			this.numero = numero;
		}

		public DOMINIO_MES valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return ("".equals(this.longDesc)) ? null : this.longDesc;
		}

		public Integer getNumero() {
			return (this.numero == null) ? 0 : this.numero;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}

	}

	public enum DOMINIO_UF {

		AC("AC", "Acre"), AL("AL", "Alagoas"), AP("AP", "Amap�"), AM("AM", "Amazonas"), BA("BA", "Bahia"), CE("CE",
				"Cear�"), DF("DF", "Distrito Federal"), ES("ES", "Esp�rito Santo"), GO("GO", "Goi�s"), MA("MA",
				"Maranh�o"), MT("MT", "Mato Grosso"), MS("MS", "Mato Grosso do Sul"), MG("MG", "Minas Gerais"), PA(
				"PA", "Par�"), PB("PB", "Para�ba"), PR("PR", "Paran�"), PE("PE", "Pernambuco"), PI("PI", "Piau�"), RJ(
				"RJ", "Rio de Janeiro"), RN("RN", "Rio Grande do Norte"), RS("RS", "Rio Grande do Sul"), RO("RO",
				"Rond�nia"), RR("RR", "Roraima"), SC("SC", "Santa Catarina"), SP("SP", "S�o Paulo"), SE("SE", "Sergipe"), TO(
				"TO", "Tocantins");

		private String uf;
		private String descricao;

		DOMINIO_UF(String uf, String descricao) {
			this.uf = uf;
			this.descricao = descricao;
		}

		public String value() {
			return name();
		}

		public String getUf() {
			return uf;
		}

		public String getDescricao() {
			return descricao;
		}
	}

}
