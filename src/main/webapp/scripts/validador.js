/**
 * Validação de formulário
	@author: brunojgrc
 */

function validar() {
	let nome = formContato.nome.value;
	let cpf = formContato.cpf.value;
	let fone = formContato.fone.value;
	let checkList = formContato.checkList.value;
	
	if(nome === "") {
		alert("Preencha o campo Nome")
		formContato.nome.focus()
		return false		
	} else if(cpf === "") {
		alert("Preencha o campo CPF")
		formContato.cpf.focus()
		return false		
	} else if(fone === "") {
		alert("Preencha o campo Fone")
		formContato.fone.focus()
		return false		
	} else if(checkList === "") {
		alert("Preencha o campo Checklist")
		formContato.checkList.focus()
		return false		
	} else {
		document.forms["formContato"].submit()
	}
}