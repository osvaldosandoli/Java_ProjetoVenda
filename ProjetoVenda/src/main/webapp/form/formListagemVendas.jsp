
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>
	
<body>
		<jsp:include page="../listaVenda"></jsp:include>
	<div class="container">	
		<h1>Listagem de Vendas</h1>
		<table class="bordered striped centered highlight responsive-table">
			<thead>
				<tr>
					<th>Funcion�rio</th>
					<th>Sal�rio Base (R$)</th>
					<th>Total de Comiss�o (R$)</th>
					<th>Sal�rio Total (R$)</th>									
				</tr>
			</thead>
			<tbody>
			<c:forEach var="venda" items="${lista}">
				<tr> 
					<td><c:out value="${venda.funcionario.nome}"></c:out></td>
					<td><c:out value="${venda.funcionario.salario}"></c:out></td>
					<td><c:out value="${venda.comissao}"></c:out></td>
					<c:set var="total" value="${venda.funcionario.salario + venda.comissao}"></c:set>
					<td><c:out value="${total}"></c:out></td>
				</tr>
			</c:forEach>
					
			</tbody>
		</table>	
		
		<p><p>
		<a class="btn waves-effect waves-teal" href="../index.jsp">
		<i class="material-icons left">cloud</i>Voltar</a>	
	
	</div>
	
</body>
</html>