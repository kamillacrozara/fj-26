package br.com.caelum.notasfiscais.mb;

import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	public Produto getProduto(){
		return this.produto;
	}
	

	public void setProduto(Produto produto) {
		System.out.println("set produto "+produto + " @@ "+this);
		this.produto = produto;
	}
	
	public String grava(){
		System.out.println("Passou por aqui");
		ProdutoDao dao = new ProdutoDao();
		
		System.out.println("produto "+produto + " @@ "+this);
		if(produto.getId() == null){
			dao.adiciona(produto);
		}else{
			dao.atualiza(produto);
		}
		
		this.produtos = dao.listaTodos();
		this.produto = new Produto();
		return "produto?faces-redirect=true";
	}
	
	public void cancelar(){
		this.produto = new Produto();
	}
	
	public List<Produto> getProdutos(){
		if(produtos == null){
			System.out.println("Carregando produtos...");
			produtos = new ProdutoDao().listaTodos();
		}
		return produtos;
	}
	
	public Double getTotal(){
		Double total = 0.0;
		List<Produto> produtos = getProdutos();
		Iterator<Produto> itr = produtos.iterator();
		
		while(itr.hasNext()) {
	         Produto prod = itr.next();
	         total += prod.getPreco();
	     }
		return total;
	}
	
	public void remove(Produto produto){
		ProdutoDao dao = new ProdutoDao();
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}
	
	
}
