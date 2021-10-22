/**
 * Confirmação de exlusão
 * @author Brunojgrc
 */

function confirmar(idcontatos){
	let resposta = confirm("Confirma a exlusão deste contato?")
	if(resposta === true) {
		//alert(idcontatos)
		window.location.href="delete?idcontatos=" + idcontatos
	}
}