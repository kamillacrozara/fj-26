package br.com.caelum.notasfiscais.datamodel;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.swing.SortOrder;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

public class DataModelNotasFiscais extends LazyDataModel<NotaFiscal>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private NotaFiscalDao dao;
	
	@PostConstruct
	void inicializaTotal(){
		super.setRowCount(dao.contaTodos());
	}
	
	@Override
	public List<NotaFiscal> load(int inicio, int quantidade, String sortField,
			org.primefaces.model.SortOrder sortOrder,
			Map<String, String> filters) {
		// TODO Auto-generated method stub
		return dao.listaTodosPaginada(inicio, quantidade);
	}
}
