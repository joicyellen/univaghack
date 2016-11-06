package br.com.hackunivag.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Data
@Entity
@Table(name = "ESCOLA")
@Name("escola")
@Scope(ScopeType.CONVERSATION)
public class Escola implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESCOLA")
	private Long idEscola;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "LATITUDE")
	private String latitude;

	@Column(name = "LONGITUDE")
	private String longitude;

	@ManyToOne
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Escola other = (Escola) obj;
		if (descricao == null) {
			if (other.getDescricao() != null)
				return false;
		} else if (!descricao.equals(other.getDescricao()))
			return false;
		if (endereco == null) {
			if (other.getEndereco() != null)
				return false;
		} else if (!endereco.equals(other.getEndereco()))
			return false;
		if (idEscola == null) {
			if (other.getIdEscola() != null)
				return false;
		} else if (!idEscola.equals(other.getIdEscola()))
			return false;
		if (latitude == null) {
			if (other.getLatitude() != null)
				return false;
		} else if (!latitude.equals(other.getLatitude()))
			return false;
		if (longitude == null) {
			if (other.getLongitude() != null)
				return false;
		} else if (!longitude.equals(other.getLongitude()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((idEscola == null) ? 0 : idEscola.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		return result;
	}

}
