package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/inserir", "/select", "/update", "/delete" }) // requisão e acesso
																									// ao Servlet,
																									// inserir...
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();

	}

	/* Conexão Servlet */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// Teste de conexão

		// dao.testeConexao();

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/inserir")) {
			criarContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	/* Criar Contato ServLet */

	protected void criarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Teste Recebimento de parâmetros

		/*
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("cpf"));
		 * System.out.println(request.getParameter("fone"));
		 * System.out.println(request.getParameter("email"));
		 * System.out.println(request.getParameter("checkList"));
		 */

		// Setar as variáveis JavaBeans
		contato.setNome(request.getParameter("nome"));
		contato.setCpf(request.getParameter("cpf"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		contato.setCheckList(request.getParameter("checkList"));

		// Invocar o método inserirContato passando o objeto contato

		dao.inserirContato(contato);

		// Redirecionar para o documento agenda.jsp
		response.sendRedirect("main");

	}

	/* Contatos */

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("agenda.jsp");

		// Criando um ojeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();

		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);

		// Teste de recebimento da lista
		/*
		 * for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getIdcontatos());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getCpf());
		 * System.out.println(lista.get(i).getFone());
		 * System.out.println(lista.get(i).getEmail());
		 * System.out.println(lista.get(i).getCheckList());
		 * 
		 * }
		 */
	}

	/* Editar contato */

	protected void listarContato(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// recebimento do contato a ser recebido (validador.js)
		String idcontatos = request.getParameter("idcontatos");
		// setar a variável idcontatos JavaBeans.
		contato.setIdcontatos(idcontatos);
		//Executar o metodo selecionar contato
		dao.selecionarContato(contato);
		//setar os atributos com o coteundo do JavaBeans
		request.setAttribute("idcontatos", contato.getIdcontatos());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("cpf", contato.getCpf());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("checkList", contato.getCheckList());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		

	}
	
	protected void editarContato(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		contato.setIdcontatos(request.getParameter("idcontato"));
		contato.setNome(request.getParameter("nome"));
		contato.setCpf(request.getParameter("cpf"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		contato.setCheckList(request.getParameter("checkList"));
		
		//exceutar contato
		dao.alterarContato(contato);
		//redirecionar para agenda.jps atualizado
		response.sendRedirect("main");
	
		
	}
	/* Remover contato */

	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do contato a ser recebido (validador.js)
		String idcontatos = request.getParameter("idcontatos");
		// setar a variável idcontatos JavaBeans.
		contato.setIdcontatos(idcontatos);
		// Executar o metodo deletarContato(DAO) passando objeto
		dao.deletarContato(contato);
		// redirecionar para o documento agenda.jsp (deletando alteraçoes)
		response.sendRedirect("main");

	}

}
