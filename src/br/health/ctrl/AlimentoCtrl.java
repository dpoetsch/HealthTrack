package br.health.ctrl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.health.dao.AlimentoDao;
import br.health.objet.Alimento;



/**
 * Servlet implementation class Peso
 */
@WebServlet("/AlimentoCtrl")
public class AlimentoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlimentoCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AlimentoDao totalAlimento = new AlimentoDao();
		List<Alimento> listaConsu = totalAlimento.GetListAlimento(Integer.parseInt(request.getParameter("CodId")));
		System.out.println(listaConsu);
		request.setAttribute("CodId", request.getParameter("CodId"));
		request.setAttribute("listaConsu", listaConsu);
		RequestDispatcher rd = request.getRequestDispatcher("alimentacao.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Alimento AlimentoCad = new Alimento(null, null, null, 0);
		
		try { 
			
			AlimentoCad.setCdUser(Integer.parseInt(request.getParameter("CodId")));
			AlimentoCad.setDatConsum(request.getParameter("dateAlim"));
			AlimentoCad.setObsConsum(String.valueOf(request.getParameter("alimento")));
			AlimentoCad.setQtdConsu(String.valueOf(request.getParameter("qtdAlim")));
			
			AlimentoDao aDao = new AlimentoDao();{
			aDao.AddAlim(AlimentoCad);
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
