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

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.com.hackunivag.util.Enumerados.SimNao;

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

	public Long getIdBatidaRegistro() {
		return idBatidaRegistro;
	}

	public void setIdBatidaRegistro(Long idBatidaRegistro) {
		this.idBatidaRegistro = idBatidaRegistro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getPonto() {
		return ponto;
	}

	public void setPonto(Date ponto) {
		this.ponto = ponto;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public SimNao getAprovado() {
		return aprovado;
	}

	public void setAprovado(SimNao aprovado) {
		this.aprovado = aprovado;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatidaRegistro other = (BatidaRegistro) obj;
		if (aprovado != other.aprovado)
			return false;
		if (escola == null) {
			if (other.escola != null)
				return false;
		} else if (!escola.equals(other.escola))
			return false;
		if (idBatidaRegistro == null) {
			if (other.idBatidaRegistro != null)
				return false;
		} else if (!idBatidaRegistro.equals(other.idBatidaRegistro))
			return false;
		if (motivo == null) {
			if (other.motivo != null)
				return false;
		} else if (!motivo.equals(other.motivo))
			return false;
		if (ponto == null) {
			if (other.ponto != null)
				return false;
		} else if (!ponto.equals(other.ponto))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
