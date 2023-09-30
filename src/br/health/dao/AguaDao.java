package br.health.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.health.conx.ConnectionManager;
import br.health.objet.Agua;

public class AguaDao {
	/**
	 * Classe de criação de objeto do tipo alimento.
	 * @return uma lista com todos os alimentos
	 */
	
	ConnectionManager dao = new ConnectionManager();
	
	public int AddAgua(Agua agua) {
		
		int j = 0;
		try {
				PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_HTK_AGUA(CD_AGUA, VLM_AGUA, QTD_COPOS, OBS_AGUA, T_HTK_USR_CD_USR, DT_CAD_AGUA) VALUES (sq_cd_agua.nextval,?,?,?,?,TO_DATE(?,'YYYY/MM/DD'))");
				stmt.setString(1, agua.getVlmAgua());
				stmt.setString(2, agua.getQtaCopos());
				stmt.setString(3, agua.getObsAgua());
				stmt.setInt(4, agua.getCdUser());
				stmt.setString(5, agua.getDtAgua());
				//stmt.setString(1, dados);
				j = dao.ExecuteComand(stmt);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return j;
		
	}
	
	public List<Agua> Getrank(Integer idUser){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		java.util.List<Agua> lstC = new ArrayList<Agua>();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT ROWNUM AS RANK, OBS_AGUA FROM (SELECT OBS_AGUA FROM T_HTK_AGUA WHERE T_HTK_USR_CD_USR = ? ORDER BY DT_CAD_AGUA DESC) WHERE ROWNUM <=1");
			stmt.setInt(1, idUser);
			System.out.println(idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		try {
			while (result.next()) {
				Agua a = new Agua(null, null, null, idUser, null);
				a.setObsAgua(result.getString("OBS_AGUA"));
				lstC.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		finally{
			dao.CloseConnection();
		}
		return lstC;
	}
	
	public List<Agua> GetListAgua(Integer idUser){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		java.util.List<Agua> lstC = new ArrayList<Agua>();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT CD_AGUA, OBS_AGUA, VLM_AGUA, QTD_COPOS,DT_CAD_AGUA  FROM T_HTK_AGUA WHERE T_HTK_USR_CD_USR = ? ORDER BY DT_CAD_AGUA DESC");
			stmt.setInt(1, idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		try {
			while (result.next()) {
				Agua a = new Agua(null, null, null, idUser, null);
				a.setCdAgua(result.getInt("CD_AGUA"));
				a.setVlmAgua(result.getString("VLM_AGUA"));
				a.setObsAgua(result.getString("OBS_AGUA"));
				a.setDtAgua(result.getString("DT_CAD_AGUA"));
				a.setQtaCopos(result.getString("QTD_COPOS"));
				lstC.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			dao.CloseConnection();
		}
		
		return lstC;
	}
	
	public void Delete(String id){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		
	    try {
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_HTK_AGUA WHERE CD_AGUA = ?");
			stmt.setString(1, id);
			dao.ExecuteComand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			dao.CloseConnection();
		}

}
		
}
