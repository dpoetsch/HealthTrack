package br.health.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.health.conx.ConnectionManager;
import br.health.objet.Peso;

public class PesoDao {
	/**
	 * Classe de criação de objeto do tipo alimento.
	 * @return uma lista com todos os alimentos
	 */
	
	ConnectionManager dao = new ConnectionManager();
	
	public int AddPeso(Peso peso) {
		
		int j = 0;
		try {
				PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_HTK_PESO(CD_PESO, DT_VALOR_PESO, OBS_PESO, T_HTK_USR_CD_USR) VALUES (sq_cd_peso.nextval ,TO_DATE(?,'YYYY/MM/DD'),?,?)");
				stmt.setString(1, peso.getDtVlpeso());
				stmt.setString(2, peso.getObsPeso());
				stmt.setInt(3, peso.getCdUser());
				//stmt.setString(1, dados);
				j = dao.ExecuteComand(stmt);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return j;
		
	}
	
	public List<Peso> Getrank(Integer idUser){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		java.util.List<Peso> lstC = new ArrayList<Peso>();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT ROWNUM AS RANK, OBS_PESO, DT_VALOR_PESO FROM (SELECT OBS_PESO, DT_VALOR_PESO FROM T_HTK_PESO WHERE T_HTK_USR_CD_USR = ? ORDER BY DT_VALOR_PESO DESC) WHERE ROWNUM <=1");
			stmt.setInt(1, idUser);
			System.out.println(idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		try {
			while (result.next()) {
				Peso a = new Peso(null, null);
				a.setDtVlpeso(result.getString("DT_VALOR_PESO"));
				a.setObsPeso(result.getString("OBS_PESO"));
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
	
	public List<Peso> GetListPeso(Integer idUser){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		java.util.List<Peso> lstC = new ArrayList<Peso>();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT CD_PESO, OBS_PESO, DT_VALOR_PESO  FROM T_HTK_PESO WHERE T_HTK_USR_CD_USR = ? ORDER BY DT_VALOR_PESO DESC");
			stmt.setInt(1, idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		try {
			while (result.next()) {
				Peso a = new Peso(null, null);
				a.setCdPeso(result.getInt("CD_PESO"));
				a.setDtVlpeso(result.getString("DT_VALOR_PESO"));
				a.setObsPeso(result.getString("OBS_PESO"));
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_HTK_PESO WHERE CD_PESO = ?");
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
