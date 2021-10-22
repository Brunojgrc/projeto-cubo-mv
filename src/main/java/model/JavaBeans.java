/* Classs JavaBeans para segurança dos dados... encapsulamentos e contém os construtores*/

package model;

public class JavaBeans {
	
	private String idcontatos;
	private String nome;
	private String cpf;
	private String fone;
	private String email;
	private String checkList;
	
	/* Métodos construtores */
	
	public JavaBeans() {
		super();
	}
	
		
	public JavaBeans(String idcontatos, String nome, String cpf, String fone, String email, String checkList) {
		super();
		this.idcontatos = idcontatos;
		this.nome = nome;
		this.cpf = cpf;
		this.fone = fone;
		this.email = email;
		this.checkList = checkList;
	}



	/* Métodos getters and setters */
	
	public String getIdcontatos() {
		return idcontatos;
	}

	public void setIdcontatos(String idcontatos) {
		this.idcontatos = idcontatos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCheckList() {
		return checkList;
	}
	public void setCheckList(String checkList) {
		this.checkList = checkList;
	}
	
}




