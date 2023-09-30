package br.health.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.health.conx.ConnectionManager;
import br.health.objet.Alimento;

public class AlimentoDao {
	/**
	 * Classe de criação de objeto do tipo alimento.
	 * @return uma lista com todos os alimentos
	 */
	
	ConnectionManager dao = new ConnectionManager();
	
	public int AddAlim(Alimento pressao) {
		
		int j = 0;
		try {
				PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_HTK_ALIM(CD_CONSU, QTD_CONS_ALIM, DT_CONSUMO, OBS_CONSUMO, T_HTK_USR_CD_USR) VALUES (sq_cd_consu.nextval, ?, TO_DATE(?,'YYYY/MM/DD'),?,?)");
				stmt.setString(1, pressao.getQtdConsu());
				stmt.setString(2, pressao.getDatConsum());
				stmt.setString(3, pressao.getObsConsum());
				stmt.setInt(4, pressao.getCdUser());
				//stmt.setString(1, dados);
				j = dao.ExecuteComand(stmt);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return j;
		
	}
	
	public List<Alimento> Getrank(Integer idUser){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		java.util.List<Alimento> lstC = new ArrayList<Alimento>();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT ROWNUM AS RANK, OBS_CONSUMO, DT_CONSUMO, QTD_CONS_ALIM FROM (SELECT OBS_CONSUMO, DT_CONSUMO, QTD_CONS_ALIM FROM T_HTK_ALIM WHERE T_HTK_USR_CD_USR = ? ORDER BY DT_CONSUMO DESC) WHERE ROWNUM <=1");
			stmt.setInt(1, idUser);
			System.out.println(idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		try {
			while (result.next()) {
				Alimento a = new Alimento(null, null, null, idUser);
				a.setDatConsum(result.getString("DT_CONSUMO"));
				a.setObsConsum(result.getString("OBS_CONSUMO"));
				a.setQtdConsu(result.getString("QTD_CONS_ALIM"));
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
	
	public List<Alimento> GetListAlimento(Integer idUser){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		java.util.List<Alimento> lstC = new ArrayList<Alimento>();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT CD_CONSU, OBS_CONSUMO, DT_CONSUMO, QTD_CONS_ALIM  FROM T_HTK_ALIM WHERE T_HTK_USR_CD_USR = ? ORDER BY DT_CONSUMO DESC");
			stmt.setInt(1, idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		try {
			while (result.next()) {
				Alimento a = new Alimento(null, null, null, idUser);
				a.setCdConsumo(result.getInt("CD_CONSU"));
				a.setDatConsum(result.getString("DT_CONSUMO"));
				a.setObsConsum(result.getString("OBS_CONSUMO"));
				a.setQtdConsu(result.getString("QTD_CONS_ALIM"));
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_HTK_ALIM WHERE CD_CONSU = ?");
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
