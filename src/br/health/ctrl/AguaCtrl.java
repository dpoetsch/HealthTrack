package br.health.ctrl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.health.dao.AguaDao;
import br.health.objet.Agua;


/**
 * Servlet implementation class Peso
 */
@WebServlet("/AguaCtrl")
public class AguaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AguaCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AguaDao totalAtv = new AguaDao();
		List<Agua> listaAgua = totalAtv.GetListAgua(Integer.parseInt(request.getParameter("CodId")));
		System.out.println(listaAgua);
		request.setAttribute("CodId", request.getParameter("CodId"));
		request.setAttribute("listaAgua", listaAgua);
		RequestDispatcher rd = request.getRequestDispatcher("agua.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Agua aguaCad = new Agua(null, null, null, 0, null);
		
		try { 
			
			aguaCad.setCdUser(Integer.parseInt(request.getParameter("CodId")));
			aguaCad.setDtAgua(request.getParameter("dateAgua"));
			aguaCad.setVlmAgua(String.valueOf(request.getParameter("vlAgua")));
			aguaCad.setObsAgua(String.valueOf(request.getParameter("agua")));
			aguaCad.setQtaCopos(String.valueOf(request.getParameter("qtdAgua")));
			
			AguaDao aDao = new AguaDao();{
			aDao.AddAgua(aguaCad);
			}
			String CodId = request.getParameter("CodId");
			request.setAttribute("CodId", CodId);
			RequestDispatcher rd = request.getRequestDispatcher(String.format("Index?cod=%s", CodId));
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("erroAll.jsp");
			rd.forward(request, response);
		}
		
		
	}	

}