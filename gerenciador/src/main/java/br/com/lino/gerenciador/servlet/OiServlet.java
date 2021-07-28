package br.com.lino.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/teste")
public class OiServlet extends HttpServlet {
	
	public OiServlet() {
		System.out.println("Criando Oi Servlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter out =  resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Ola, testando primeiro servlets.");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("rodou?");
		
	}

}
