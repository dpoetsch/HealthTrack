package br.health.ctrl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.health.dao.PesoDao;
import br.health.objet.Peso;



/**
 * Servlet implementation class Peso
 */
@WebServlet("/Peso")
public class PesoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesoCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PesoDao totalPeso = new PesoDao();
		List<Peso> listaCo = totalPeso.GetListPeso(Integer.parseInt(request.getParameter("CodId")));
		System.out.println(listaCo);
		request.setAttribute("CodId", request.getParameter("CodId"));
		request.setAttribute("listaCo", listaCo);
		RequestDispatcher rd = request.getRequestDispatcher("peso.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Peso pesoCad = new Peso(0, null, null, 0);
		
		try { 
			
			pesoCad.setCdUser(Integer.parseInt(request.getParameter("CodId")));
			pesoCad.setDtVlpeso(request.getParameter("datePeso"));
			pesoCad.setObsPeso(String.valueOf(request.getParameter("peso")));
			
			PesoDao aDao = new PesoDao();{
			aDao.AddPeso(pesoCad);
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
