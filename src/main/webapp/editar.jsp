<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda e Lista Café da Manhã</title>
<link rel="icon" href="img/chip_icon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Colaborador</h1>
	<form name="formContato" action="update">
		<table>
			<tr>
				<td><input type="text" class="box-idcontato" name="idcontato"
					readonly value="<%out.print(request.getAttribute("idcontatos"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="box-input-maior" name="nome"
					required value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="box-input-menor" name="cpf" required value="<%out.print(request.getAttribute("cpf"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="box-input-menor" name="fone" required value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td><input type="email" class="box-input-maior" name="email" value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="box-input-maior" name="checkList" required value="<%out.print(request.getAttribute("checkList"));%>"></td>
			</tr>
		</table>
		<input type="button" class="botao-acesso" value="Salvar" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>