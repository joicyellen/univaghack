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

import lombok.Data;

@Data
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

}
