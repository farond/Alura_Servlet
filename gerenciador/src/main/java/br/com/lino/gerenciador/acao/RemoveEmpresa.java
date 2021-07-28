package br.com.lino.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lino.gerenciador.model.Banco;

public class RemoveEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("removendo empresas");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		
		return "redirect:principal?acao=ListaEmpresas";
		//response.sendRedirect("principal?acao=ListaEmpresas");
		
	}

}
