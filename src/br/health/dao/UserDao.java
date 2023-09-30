package br.health.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.health.conx.ConnectionManager;
import br.health.objet.Usuario;

public class UserDao {
	
	@SuppressWarnings("finally")
	public int AddUser(Usuario usrCad) {
		ConnectionManager dao = new ConnectionManager();
		int j = 0;
		try {
			
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_HTK_USR(CD_USR, NM_USR, DT_NASCIMENTO, NM_APELIDO) VALUES (sq_cd_usr.nextval , ?, TO_DATE(?,'YYYY/MM/DD'), ?)");
			stmt.setString(1, usrCad.getNmUser());
			stmt.setString(2, usrCad.getDtNasc());
			stmt.setString(3, usrCad.getNmApelido());
			
			j = dao.ExecuteComand(stmt);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			return j;
		}
		
		
	}
	
	public List<Usuario> GetTotal(){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		java.util.List<Usuario> lstC = new ArrayList<Usuario>();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_HTK_USR ORDER BY CD_USR DESC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		try {
			while (result.next()) {
				Usuario a = new Usuario(0, null, null, null);
				a.setCdUser(result.getInt("CD_USR"));
				a.setNmUser(result.getString("NM_USR"));
				a.setDtNasc(result.getString("DT_NASCIMENTO"));
				a.setNmApelido(result.getString("NM_APELIDO"));
				a.setCdUser(result.getInt("T_HTK_USR_CD_USR"));
			
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
	
	public String GetOne(){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		String lstC = new String ();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT CD_USR FROM T_HTK_USR ORDER BY CD_USR DESC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		
		try {
			while (result.next()) {
				int tot = result.getInt("CD_USR");
				return String.valueOf(tot);
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
	
	public String GetVerify(String email, String senha){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		String lstC = new String ();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT T_HTK_USR_CD_USR FROM T_HTK_EMAIL WHERE END_EMAIL =? AND SENHA = ?");
			stmt.setString(1, email);
			stmt.setString(2, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		
		try {
			while (result.next()) {
				int tot = result.getInt("T_HTK_USR_CD_USR");
				return String.valueOf(tot);
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
			stmt = dao.GetConnection().prepareStatement("DELETE FROM T_HTK_USR WHERE CD_USR = ?");
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
    public String GetEmail(int idUser){
		ConnectionManager dao = new ConnectionManager();
		PreparedStatement stmt = null;
		String lstC = new String ();
	    try {
			stmt = dao.GetConnection().prepareStatement("SELECT F.CD_EMAIL FROM T_HTK_USR C INNER JOIN T_HTK_EMAIL  F ON(F.t_htk_usr_cd_usr = C.cd_usr) WHERE CD_USR=?");
			stmt.setInt(1, idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = dao.GetData(stmt);
		
		try {
			while (result.next()) {
				int tot = result.getInt("CD_EMAIL");
				return String.valueOf(tot);
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
  
}
