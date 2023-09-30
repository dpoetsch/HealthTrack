package br.health.ctrl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.health.dao.AguaDao;


/**
 * Servlet implementation class RestControllerDelete
 */
@WebServlet("/DeleteAgua")
public class DeleteAgua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAgua() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("id");
		String CodId = request.getParameter("CodId");
	    new AguaDao().Delete(codigo);
	    request.setAttribute("CodId", CodId);
	    request.setAttribute("cod", CodId);
		RequestDispatcher rd = request.getRequestDispatcher(String.format("deleteAgua.jsp?CodId=%s&cod=%s", CodId, CodId));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

