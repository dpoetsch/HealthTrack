package br.health.dao;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import br.health.conx.ConnectionManager;
import br.health.objet.EmailCad;

public class EmailDao {
	
	@SuppressWarnings("finally")
	public int AddEmail(EmailCad emailCad) {
		ConnectionManager dao = new ConnectionManager();
		int j = 0;
		try {
			
			PreparedStatement stmt = dao.GetConnection().prepareStatement("INSERT INTO T_HTK_EMAIL(CD_EMAIL, END_EMAIL, T_HTK_USR_CD_USR, SENHA) VALUES (sq_cd_email.nextval , ?, ?, ?)");
			stmt.setString(1, emailCad.getEndEmail());
			stmt.setInt(2, emailCad.getCdUser());
			stmt.setString(3, emailCad.getSenha());
			j = dao.ExecuteComand(stmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		finally{
			return j;
		}
		
		}
		
		public void Delete(String id){
			ConnectionManager dao = new ConnectionManager();
			PreparedStatement stmt = null;
			
		    try {
				stmt = dao.GetConnection().prepareStatement("DELETE FROM T_HTK_EMAIL WHERE CD_EMAIL = ?");
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
