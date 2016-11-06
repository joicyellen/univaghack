package br.com.hackunivag.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import lombok.Data;
import br.com.hackunivag.util.Enumerados.Periodo;

@Data
@Entity
@Table(name = "TURMA")
@Name("turma")
@Scope(ScopeType.CONVERSATION)
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TURMA")
	private Long idTurma;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "PERIODO")
	private Periodo periodo;

}
