<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/principal" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Cadastro de Empresa</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"></c:import>

	<form action="${ linkEntradaServlet }" method="post">
	
	        Nome: <input type="text" name="nome" value="${empresa.nome}" />
	        Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>" />
			<input type="hidden" name="id" value="${empresa.id}" readonly>
			<input type="hidden" name="acao" value="AlteraEmpresa" readonly>
	        <input type="submit" />
	    </form>

</body>
</html>