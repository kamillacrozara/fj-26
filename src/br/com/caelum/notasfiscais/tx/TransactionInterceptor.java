package br.com.caelum.notasfiscais.tx;

import java.io.Serializable;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import br.com.caelum.notasfiscais.tx.Transactional;

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception{
		System.out.println("Abrindo transação");
		manager.getTransaction().begin();
		
		Object resultado = ctx.proceed();
		
		manager.getTransaction().commit();
		System.out.println("Comitando transação");
		
		return resultado;
	}
}
