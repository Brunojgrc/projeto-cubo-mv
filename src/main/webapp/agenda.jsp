<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda e Lista Café da Manhã</title>
<link rel="icon" href="img/chip_icon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Lista Café da Manhã</h1>
	<a href="novoContato.html" class="botao-acesso">Novo Contato</a>
	<table id="tabela">
		<thead>
			<th>Id</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>Fone</th>
			<th>E-mail</th>
			<th>Checklist</th>
			<th>Opções</th>
		</thead>
		<tbody>
			<%for (int i=0; i < lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getIdcontatos()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getCpf()%></td>
					<td><%=lista.get(i).getFone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><%=lista.get(i).getCheckList()%></td>
					<td><a href="select?idcontatos=<%=lista.get(i).getIdcontatos()%>" class="botao-acesso">Editar</a></td>
					<td><a href="javascript: confirmar(<%=lista.get(i).getIdcontatos() %>)" class=botao-delete>Excluir</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"><</script>
</body>
</html>