<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Libros</title>
</head>
<body>

<c:set var="lista" scope="request" value="${libros}" />

	<table>
		<tr>
			<td><strong>Codigo</strong></td>
			<td><strong>Nombre</strong></td>
			<td><strong>isbn</strong></td>
			<td><strong>NumPaginas</strong></td>
			<td><strong>Autor</strong></td>
		</tr>
		<c:forEach var="l" items="${lista}">
			<tr>
				<td>${l.codigo}</td>				
				<td>${l.nombre}</td>
				<td>${l.isbn}</td>
				<td>${l.NumPAginas}</td>
				<td>${l.Autor}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>