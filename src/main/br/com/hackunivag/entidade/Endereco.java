package br.com.hackunivag.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import lombok.Data;

@Data
@Entity
@Name("endereco")
@Table(name = "ENDERECO")
@Scope(ScopeType.CONVERSATION)
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENDERECO")
	private Long idEndereco;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@Column(name = "BAIRRO")
	private String bairro;
	
	@Column(name = "NUMERO")
	private String numero;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.getBairro() != null)
				return false;
		} else if (!bairro.equals(other.getBairro()))
			return false;
		if (complemento == null) {
			if (other.getComplemento() != null)
				return false;
		} else if (!complemento.equals(other.getComplemento()))
			return false;
		if (descricao == null) {
			if (other.getDescricao() != null)
				return false;
		} else if (!descricao.equals(other.getDescricao()))
			return false;
		if (idEndereco == null) {
			if (other.getIdEndereco() != null)
				return false;
		} else if (!idEndereco.equals(other.getIdEndereco()))
			return false;
		if (numero == null) {
			if (other.getNumero() != null)
				return false;
		} else if (!numero.equals(other.getNumero()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	
}
