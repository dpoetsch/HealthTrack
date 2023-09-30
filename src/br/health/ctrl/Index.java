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
import br.health.dao.AlimentoDao;
import br.health.dao.AtividadeDao;
import br.health.dao.PesoDao;
import br.health.dao.PressaoDao;
import br.health.objet.Agua;
import br.health.objet.Alimento;
import br.health.objet.AtvFisica;
import br.health.objet.Peso;
import br.health.objet.Pressao;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CodId = request.getParameter("cod");
		System.out.println(CodId);
		PesoDao utmPeso = new PesoDao();
		AguaDao utmAgua = new AguaDao();
		AlimentoDao utmAlim = new AlimentoDao();
		PressaoDao utmPressao = new PressaoDao();
		AtividadeDao utmAtv = new AtividadeDao();
		
		int resu = Integer.parseInt(CodId);
		List<Peso> listPeso = utmPeso.Getrank(resu);
		List<Pressao> listPressao = utmPressao.Getrank(resu);
		List<Agua> listAgua = utmAgua.Getrank(resu);
		List<Alimento> listAlimento = utmAlim.Getrank(resu);
		List<AtvFisica> listAtv = utmAtv.Getrank(resu);
		
		
		request.setAttribute("listPeso", listPeso);
		request.setAttribute("CodId", CodId);
		request.setAttribute("listPressao", listPressao);
		request.setAttribute("listAgua", listAgua);
		request.setAttribute("listAlimento", listAlimento);
		request.setAttribute("listAtv", listAtv);
		RequestDispatcher rd = request.getRequestDispatcher(String.format("index.jsp?CodId=%s", CodId));
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
