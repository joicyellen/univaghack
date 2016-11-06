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

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import lombok.Data;

@Data
@Entity
@Table(name = "PROFESSOR")
@Name("professor")
@Scope(ScopeType.CONVERSATION)
public class Professor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROFESSOR")
	private Long idProfessor;
	
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;
	
	@Column(name = "MATRICULA")
	private int matricula;
	
	@Column(name = "CARGA_HORARIA")
	private Float cargaHoraria;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ESCOLA", nullable = false)
	private Escola escola;

}
