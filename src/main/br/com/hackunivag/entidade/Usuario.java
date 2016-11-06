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

import lombok.Data;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Data
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (pessoa == null) {
			if (other.getPessoa() != null)
				return false;
		} else if (!pessoa.equals(other.getPessoa()))
			return false;
		if (idUsuario == null) {
			if (other.getIdUsuario() != null)
				return false;
		} else if (!idUsuario.equals(other.getIdUsuario()))
			return false;
		if (login == null) {
			if (other.getLogin() != null)
				return false;
		} else if (!login.equals(other.getLogin()))
			return false;
		if (nome == null) {
			if (other.getNome() != null)
				return false;
		} else if (!nome.equals(other.getNome()))
			return false;
		if (senha == null) {
			if (other.getSenha() != null)
				return false;
		} else if (!senha.equals(other.getSenha()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	
}