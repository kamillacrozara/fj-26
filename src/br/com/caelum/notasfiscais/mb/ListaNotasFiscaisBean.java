package br.com.caelum.notasfiscais.mb;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.tx.Transactional;


@Named
@ViewScoped
@Transactional
public class ListaNotasFiscaisBean {

	@Inject
	private LazyDataModel<NotaFiscal> dataModel;

	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}
	
	
}
