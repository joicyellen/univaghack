package br.com.hackunivag.entidade;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
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

import br.com.hackunivag.util.Enumerados.SimNao;

@Data
@Entity
@Table(name = "BATIDAREGISTRO")
@Name("batidaRegistro")
@Scope(ScopeType.CONVERSATION)
public class BatidaRegistro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BATIDA_REGISTRO")
	private Long idBatidaRegistro;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@Column(name = "PONTO")
	private Date ponto;

	@Column(name = "MOTIVO")
	private String motivo;

	@ManyToOne
	@JoinColumn(name = "ID_ESCOLA")
	private Escola escola;
	
	@Basic
	private SimNao aprovado;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatidaRegistro other = (BatidaRegistro) obj;
		if (aprovado != other.getAprovado())
			return false;
		if (escola == null) {
			if (other.getEscola() != null)
				return false;
		} else if (!escola.equals(other.getEscola()))
			return false;
		if (idBatidaRegistro == null) {
			if (other.getIdBatidaRegistro() != null)
				return false;
		} else if (!idBatidaRegistro.equals(other.getIdBatidaRegistro()))
			return false;
		if (motivo == null) {
			if (other.getMotivo() != null)
				return false;
		} else if (!motivo.equals(other.getMotivo()))
			return false;
		if (ponto == null) {
			if (other.getPonto() != null)
				return false;
		} else if (!ponto.equals(other.getPonto()))
			return false;
		if (usuario == null) {
			if (other.getUsuario() != null)
				return false;
		} else if (!usuario.equals(other.getUsuario()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aprovado == null) ? 0 : aprovado.hashCode());
		result = prime * result + ((escola == null) ? 0 : escola.hashCode());
		result = prime * result + ((idBatidaRegistro == null) ? 0 : idBatidaRegistro.hashCode());
		result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
		result = prime * result + ((ponto == null) ? 0 : ponto.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	} 

}
