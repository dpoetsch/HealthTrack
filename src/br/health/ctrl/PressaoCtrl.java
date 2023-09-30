package br.health.ctrl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.health.dao.PressaoDao;
import br.health.objet.Pressao;



/**
 * Servlet implementation class Peso
 */
@WebServlet("/PressaoCtrl")
public class PressaoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PressaoCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PressaoDao totalPressao = new PressaoDao();
		List<Pressao> listaCo = totalPressao.GetListPressao(Integer.parseInt(request.getParameter("CodId")));
		System.out.println(listaCo);
		request.setAttribute("CodId", request.getParameter("CodId"));
		request.setAttribute("listaPr", listaCo);
		RequestDispatcher rd = request.getRequestDispatcher("pressao.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Pressao pressaoCad = new Pressao(0, null, null);
		
		try { 
			
			pressaoCad.setCdUser(Integer.parseInt(request.getParameter("CodId")));
			pressaoCad.setDtAfericao(request.getParameter("datePressao"));
			pressaoCad.setObsPressao(String.valueOf(request.getParameter("pressao")));
			
			PressaoDao aDao = new PressaoDao();{
			aDao.AddPressao(pressaoCad);
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
