package br.com.lino.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lino.gerenciador.acao.Acao;
import br.com.lino.gerenciador.acao.AlteraEmpresa;
import br.com.lino.gerenciador.acao.ListaEmpresas;
import br.com.lino.gerenciador.acao.MostraEmpresa;
import br.com.lino.gerenciador.acao.NovaEmpresa;
import br.com.lino.gerenciador.acao.NovaEmpresaForm;
import br.com.lino.gerenciador.acao.RemoveEmpresa;


@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.lino.gerenciador.acao." + paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome 
			Acao acao = (Acao) classe.newInstance();		
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEndereco = nome.split(":"); //Usado para saparar Ex: foward:listaEmpresa
	    if(tipoEndereco[0].equals("forward")) { // verifica se na posi��o 0 do array tipoEEndereco tem "foward", se sim entra no if
	        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]); // chama o m�todo getRequestDispatcher passando como par�metro a posi��o 1 do array que cont�m o valor "listaEmpresa"
	        rd.forward(request, response); //Por fim � enviado o forward para o JSP
	    } else {
	        response.sendRedirect(tipoEndereco[1]); /* Caso a string retornada em n0 seja diferente de "forward" ent�o  � executado o redirect para o endere�o n1*/

	    }
		
//		String nome = null;
//		if(paramAcao.equals("ListaEmpresas")) {						
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);			
//		}
//		else if(paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acaoRemove = new RemoveEmpresa();
//			nome = acaoRemove.executa(request, response);
//		}		
//		else if(paramAcao.equals("MostraEmpresa")) {			
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//		}
//		else if(paramAcao.equals("AlteraEmpresa")) {			
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		}
//		else if(paramAcao.equals("NovaEmpresa")) {			
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		}
//		else if(paramAcao.equals("NovaEmpresaForm")) {			
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}

	}

}
