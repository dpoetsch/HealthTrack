package br.health.objet;

public class EmailCad {
	private int cdEmail;
	private String endEmail;
	private int cdUser;
	private String senha;
	
	public EmailCad( String endEmail, int cdUser, String senha) {
		this.endEmail = endEmail;
		this.cdUser = cdUser;
		this.senha = senha;
	}
	
	public EmailCad( String endEmail, String senha) {
		this.endEmail = endEmail;
		this.senha = senha;
	}

	public int getCdEmail() {
		return cdEmail;
	}

	public void setCdEmail(int cdEmail) {
		this.cdEmail = cdEmail;
	}

	public String getEndEmail() {
		return endEmail;
	}

	public void setEndEmail(String endEmail) {
		this.endEmail = endEmail;
	}

	public int getCdUser() {
		return cdUser;
	}

	public void setCdUser(int cdUser) {
		this.cdUser = cdUser;
	}
	
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "EmailCad [cdEmail=" + cdEmail + ", endEmail=" + endEmail + ", cdUser=" + cdUser + ", senha=" + senha
				+ "]";
	}


}
