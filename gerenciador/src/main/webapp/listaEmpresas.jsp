<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.lino.gerenciador.model.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

		<c:if test="${not empty nomeEmpresa }">
			Empresa:  ${ nomeEmpresa } cadastrada com sucesso!
		</c:if>

		<h5>Lista de Empresas:</h5>
		
		<ul>		
			<c:forEach items="${empresas}" var="empresa">
				<li>
					${empresa.nome } <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				</li>
				<a href="/gerenciador/principal?acao=MostraEmpresa&id=${empresa.id}">editar</a>
				<a href="/gerenciador/principal?acao=RemoveEmpresa&id=${empresa.id}">deleta</a>
			</c:forEach>			
		</ul>

</body>
</html>