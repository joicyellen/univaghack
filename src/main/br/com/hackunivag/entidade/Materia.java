package br.com.hackunivag.entidade;

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
@Table(name = "MATERIA")
@Name("materia")
@Scope(ScopeType.CONVERSATION)
public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MATERIA")
	private Long idMateria;
	
	@Column(name = "DESCRICAO")
	private String descricao;

}
