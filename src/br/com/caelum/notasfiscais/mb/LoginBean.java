package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Inject
	Event<Usuario> eventoLogin;
	
	Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDao dao;
	
	public String efetuaLogin() {
		
		boolean loginValido = dao.existe(this.usuario);
		if(loginValido){
			eventoLogin.fire(usuario);
			usuarioLogado.logar(usuario);
			return "produto?faces-redirect=true";
		}else{
			usuarioLogado.deslogar();
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public String logout(){
		usuarioLogado.deslogar();
		return "login?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
}
