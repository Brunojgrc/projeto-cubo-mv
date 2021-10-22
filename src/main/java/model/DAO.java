package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/* M�dulo de conex�o */

	// Par�metros de conex�o

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "mysql123456";

	// M�todos de conex�o

	private Connection conectar() {
		Connection conexao = null;
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} catch (Exception excecao) {
			System.out.println(excecao);
			return null;
		}
	}

	// Teste de conex�o
	/*
	 * public void testeConexao() { try { Connection conexao = conectar();
	 * System.out.println(conexao); } catch (Exception excecao) {
	 * System.out.println(excecao); } }
	 */

	/* CRUD CREATE */
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, cpf, fone, email, checkList) values (?,?,?,?,?)";
		try {
			// abrir conex�o com o banco
			Connection conexao = conectar();
			// Preparar a query para execu��o no banco de dados
			PreparedStatement pst = conexao.prepareStatement(create);
			// Substituir os par�metros (?) pelo conte�do das vari�veis JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getCpf());
			pst.setString(3, contato.getFone());
			pst.setString(4, contato.getEmail());
			pst.setString(5, contato.getCheckList());
			// Executar a query
			pst.executeUpdate();
			// Encerrar conex�o com o banco
			conexao.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/* CRUD READ */
	public ArrayList<JavaBeans> listarContatos() {

		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String read = "select * from contatos order by nome";
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				// vari�veis de apoio que recebem dados do banco
				String idcontatos = rs.getString(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String fone = rs.getString(4);
				String email = rs.getString(5);
				String checkList = rs.getString(6);

				contatos.add(new JavaBeans(idcontatos, nome, cpf, fone, email, checkList));
			}
			conexao.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/* CRUD DELETE */
	
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where idcontatos=?";
				try {
					Connection conexao = conectar();
					PreparedStatement pst = conexao.prepareStatement(delete);
					pst.setString(1,contato.getIdcontatos());
					pst.executeUpdate();
					conexao.close();
				} catch (Exception e) {
					System.out.println(e);
				}
	}

}
