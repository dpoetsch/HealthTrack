package br.health.ctrl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.health.dao.AtividadeDao;
import br.health.objet.AtvFisica;



/**
 * Servlet implementation class Peso
 */
@WebServlet("/AtvidadeCtrl")
public class AtvidadeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtvidadeCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AtividadeDao totalAtv = new AtividadeDao();
		List<AtvFisica> listaCo = totalAtv.GetListAtv(Integer.parseInt(request.getParameter("CodId")));
		System.out.println(listaCo);
		request.setAttribute("CodId", request.getParameter("CodId"));
		request.setAttribute("listaAtv", listaCo);
		RequestDispatcher rd = request.getRequestDispatcher("atividade_fisica.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AtvFisica atvCad = new AtvFisica(0, null, null, null, 0);
		
		try { 
			
			atvCad.setCdUser(Integer.parseInt(request.getParameter("CodId")));
			atvCad.setDataAtiv(request.getParameter("dateAtividade"));
			atvCad.setObsAtv(String.valueOf(request.getParameter("atividade")));
			atvCad.setTempoAtv(String.valueOf(request.getParameter("tmpAtv")));
			
			AtividadeDao aDao = new AtividadeDao();{
			aDao.AddAtv(atvCad);
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