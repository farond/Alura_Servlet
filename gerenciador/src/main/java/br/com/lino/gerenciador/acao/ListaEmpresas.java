package br.com.lino.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lino.gerenciador.model.Banco;
import br.com.lino.gerenciador.model.Empresa;

public class ListaEmpresas {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("listando empresas");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("empresas", lista);
		
		return "forward:/listaEmpresas.jsp";
		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
//		rd.forward(request, response);
		
	}
	

}
