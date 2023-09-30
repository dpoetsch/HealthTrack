package br.health.ctrl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.health.dao.EmailDao;
import br.health.dao.UserDao;
import br.health.objet.EmailCad;


/**
 * Servlet implementation class Email
 */
@WebServlet("/Email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Email() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("cademail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userGet = new UserDao();
		String cd  = userGet.GetOne();
		EmailCad EmailCad = new EmailCad(null , 0, null);
		EmailCad.setEndEmail(request.getParameter("email"));
		EmailCad.setCdUser(Integer.parseInt(cd));
		EmailCad.setSenha(request.getParameter("senha"));
		EmailDao insert = new EmailDao();
		insert.AddEmail(EmailCad);
		
		RequestDispatcher rd = request.getRequestDispatcher("sucessoMsg.jsp");
		rd.forward(request, response);
	}

}
