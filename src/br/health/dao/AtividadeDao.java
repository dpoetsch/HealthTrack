package br.health.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.health.conx.ConnectionManager;
import br.health.objet.AtvFisica;

public class AtividadeDao {
	/**
	 * Classe de criação de objeto do tipo alimento.
	 * @return uma lista com todos os alimentos
	 */
	
	ConnectionManager dao = new ConnectionManager();
	
	public int AddAtv(AtvFisica pressao) {
		
		int j = 0;
		try {
				PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_HTK_ATV(CD_ATV, DT_ATV, OBS_ATV, TMP_ATV, T_HTK_USR_CD_USR) VALUES (sq_cd_atv.nextval,TO_DATE(?,'YYYY/MM/DD'),?,?,?)");
				stmt.setString(1, pressao.getDataAtiv());
				stmt.setString(2, pressao.getObsAtv());
				stmt.setString(3, pressao.getTempoAtv());
				stmt.setInt(4, pressao.getCdUser());
				//stmt.setString(1, dados);
				j = dao.ExecuteComand(stmt);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return j;
		
	}
	
	public List<AtvFisica> Getrank(Integer idUser){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		java.util.List<AtvFisica> lstC = new ArrayList<AtvFisica>();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT ROWNUM AS RANK, OBS_ATV, DT_ATV, TMP_ATV FROM (SELECT OBS_ATV, DT_ATV,TMP_ATV FROM T_HTK_ATV WHERE T_HTK_USR_CD_USR = ? ORDER BY TMP_ATV DESC) WHERE ROWNUM <=1");
			stmt.setInt(1, idUser);
			System.out.println(idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		try {
			while (result.next()) {
				AtvFisica a = new AtvFisica(idUser, null, null, null);
				a.setDataAtiv(result.getString("DT_ATV"));
				a.setObsAtv(result.getString("OBS_ATV"));
				a.setTempoAtv(result.getString("TMP_ATV"));
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
	
	public List<AtvFisica> GetListAtv(Integer idUser){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		java.util.List<AtvFisica> lstC = new ArrayList<AtvFisica>();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT CD_ATV, OBS_ATV, DT_ATV, TMP_ATV  FROM T_HTK_ATV WHERE T_HTK_USR_CD_USR = ? ORDER BY DT_ATV DESC");
			stmt.setInt(1, idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		try {
			while (result.next()) {
				AtvFisica a = new AtvFisica(idUser, null, null, null);
				a.setCdAtv(result.getInt("CD_ATV"));
				a.setDataAtiv(result.getString("DT_ATV"));
				a.setObsAtv(result.getString("OBS_ATV"));
				a.setTempoAtv(result.getString("TMP_ATV"));
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_HTK_ATV WHERE CD_ATV = ?");
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
