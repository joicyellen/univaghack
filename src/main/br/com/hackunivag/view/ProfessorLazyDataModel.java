package br.com.hackunivag.view;

import java.util.List;
import java.util.Map;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.hackunivag.entidade.Professor;
import br.com.hackunivag.negocio.ProfessorNegocio;

@Name("professorLazyDataModel")
public class ProfessorLazyDataModel extends LazyDataModel<Professor> {
	
	private static final long serialVersionUID = 1L;


	@In(create=true)
	private Professor professor;
	
	@In(create=true)
	private ProfessorNegocio professorNegocio;
	
	
	public ProfessorLazyDataModel(Professor professor, ProfessorNegocio professorNegocio) {
		
		System.out.println("ProfessorLazyDataModel");
		
		this.professor = professor;
		this.professorNegocio = professorNegocio;
	}
	
	
	@Override
	public Professor getRowData(String rowKey) {
		
		Professor Professor = null;
		
		try {
			professor = professorNegocio.buscar(Long.parseLong(rowKey));

		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}

		return Professor;
	}
	
	@Override
	public Object getRowKey(Professor professor) {
		
		return professor.getIdProfessor();	
	}
	
	@Override
	public List<Professor> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {

		setRowCount(professorNegocio.contador(professor).intValue());

		return professorNegocio.listarPorPagina(first, pageSize, sortField,
				sortOrder, professor);
	}

}
