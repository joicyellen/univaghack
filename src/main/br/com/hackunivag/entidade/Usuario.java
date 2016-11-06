package br.com.hackunivag.entidade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Entity
@Table(name = "USUARIO")
@Name("usuario")
@Scope(ScopeType.CONVERSATION)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;

	@Column(name = "NOME", nullable = false, length = 80)
	private String nome;

	@Column(unique = true, name = "LOGIN", nullable = false, length = 20)
	private String login;

	@Column(name = "SENHA", nullable = false, length = 50)
	private String senha;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;
	
	@Transient
	private String senhaConfirmar;
	
	@Transient
	private String senhaAlterar;
	
	@Transient
	private int tempoSessao;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getSenhaConfirmar() {
		return senhaConfirmar;
	}

	public void setSenhaConfirmar(String senhaConfirmar) {
		this.senhaConfirmar = senhaConfirmar;
	}

	public String getSenhaAlterar() {
		return senhaAlterar;
	}

	public void setSenhaAlterar(String senhaAlterar) {
		this.senhaAlterar = senhaAlterar;
	}

	public int getTempoSessao() {
		return tempoSessao;
	}

	public void setTempoSessao(int tempoSessao) {
		this.tempoSessao = tempoSessao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((senhaAlterar == null) ? 0 : senhaAlterar.hashCode());
		result = prime * result + ((senhaConfirmar == null) ? 0 : senhaConfirmar.hashCode());
		result = prime * result + tempoSessao;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (senhaAlterar == null) {
			if (other.senhaAlterar != null)
				return false;
		} else if (!senhaAlterar.equals(other.senhaAlterar))
			return false;
		if (senhaConfirmar == null) {
			if (other.senhaConfirmar != null)
				return false;
		} else if (!senhaConfirmar.equals(other.senhaConfirmar))
			return false;
		if (tempoSessao != other.tempoSessao)
			return false;
		return true;
	}

}