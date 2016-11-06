package br.com.hackunivag.entidade;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "AULA")
@Name("aula")
@Scope(ScopeType.CONVERSATION)
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AULA")
	private Long idAula;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TURMA", nullable = false)
	private Turma turma;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_MATERIA")
	private Materia materia;

	public Long getIdAula() {
		return idAula;
	}

	public void setIdAula(Long idAula) {
		this.idAula = idAula;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAula == null) ? 0 : idAula.hashCode());
		result = prime * result + ((materia == null) ? 0 : materia.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
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
		Aula other = (Aula) obj;
		if (idAula == null) {
			if (other.idAula != null)
				return false;
		} else if (!idAula.equals(other.idAula))
			return false;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}

}
