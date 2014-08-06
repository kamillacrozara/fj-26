package br.com.caelum.notasfiscais.mb;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.tx.Transactional;


@Named
@RequestScoped
@Transactional
public class ListaNotasFiscaisBean {
	
	@Inject
	private NotaFiscalDao notaFiscalDao;

	private List<NotaFiscal> notas;
	
	public List<NotaFiscal> getNotas(){
		if(notas == null){
			System.out.println("Carregando notas...");
			notas = notaFiscalDao.listaTodos();
		}
		
		return notas;
	}
}
