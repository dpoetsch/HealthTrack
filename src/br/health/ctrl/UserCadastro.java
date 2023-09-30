package br.health.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.health.dao.UserDao;
import br.health.objet.Usuario;

/**
 * Servlet implementation class UserCadastro
 */
@WebServlet("/UserCadastro")
public class UserCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario userCad = new Usuario(null, null, null);
		userCad.setNmUser(request.getParameter("nome"));
		userCad.setDtNasc(request.getParameter("dtNascimento"));
		userCad.setNmApelido(request.getParameter("apelido"));
		UserDao add = new UserDao();
		add.AddUser(userCad);
		RequestDispatcher rd = request.getRequestDispatcher("cademail.jsp");
		rd.forward(request, response);
	}
	
	

}
