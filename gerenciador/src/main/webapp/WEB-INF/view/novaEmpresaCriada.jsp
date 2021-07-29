
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"></c:import>

	<c:if test="${not empty nomeEmpresa }">
		<h3>Empresa: ${ nomeEmpresa } cadastrada com sucesso!</h3>
	</c:if>
	
	<c:if test="${empty nomeEmpresa }">
		<h3>Nenhuma Empresa cadastrada com sucesso!</h3>
	</c:if>
	
</body>
</html>