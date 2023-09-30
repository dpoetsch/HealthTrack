package br.health.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.health.conx.ConnectionManager;
import br.health.objet.Pressao;

public class PressaoDao {
	/**
	 * Classe de criação de objeto do tipo alimento.
	 * @return uma lista com todos os alimentos
	 */
	
	ConnectionManager dao = new ConnectionManager();
	
	public int AddPressao(Pressao pressao) {
		
		int j = 0;
		try {
				PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_HTK_PRESSAO(CD_PRESSAO, DT_AFERICAO, OBS_PRESSAO, T_HTK_USR_CD_USR) VALUES (sq_cd_pressao.nextval ,TO_DATE(?,'YYYY/MM/DD'),?,?)");
				stmt.setString(1, pressao.getDtAfericao());
				stmt.setString(2, pressao.getObsPressao());
				stmt.setInt(3, pressao.getCdUser());
				//stmt.setString(1, dados);
				j = dao.ExecuteComand(stmt);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return j;
		
	}
	
	public List<Pressao> Getrank(Integer idUser){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		java.util.List<Pressao> lstC = new ArrayList<Pressao>();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT ROWNUM AS RANK, OBS_PRESSAO, DT_AFERICAO FROM (SELECT OBS_PRESSAO, DT_AFERICAO FROM T_HTK_PRESSAO WHERE T_HTK_USR_CD_USR = ? ORDER BY DT_AFERICAO DESC) WHERE ROWNUM <=1");
			stmt.setInt(1, idUser);
			System.out.println(idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		try {
			while (result.next()) {
				Pressao a = new Pressao(idUser, null, null);
				a.setDtAfericao(result.getString("DT_AFERICAO"));
				a.setObsPressao(result.getString("OBS_PRESSAO"));
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
	
	public List<Pressao> GetListPressao(Integer idUser){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		java.util.List<Pressao> lstC = new ArrayList<Pressao>();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT CD_PRESSAO, OBS_PRESSAO, DT_AFERICAO  FROM T_HTK_PRESSAO WHERE T_HTK_USR_CD_USR = ? ORDER BY DT_AFERICAO DESC");
			stmt.setInt(1, idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		try {
			while (result.next()) {
				Pressao a = new Pressao(idUser, null, null);
				a.setCdPressao(result.getInt("CD_PRESSAO"));
				a.setDtAfericao(result.getString("DT_AFERICAO"));
				a.setObsPressao(result.getString("OBS_PRESSAO"));
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_HTK_PRESSAO WHERE CD_PRESSAO = ?");
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
