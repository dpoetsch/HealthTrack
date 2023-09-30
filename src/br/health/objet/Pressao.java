package br.health.objet;

public class Pressao {
	private int cdPressao;
	private String dtAfericao;
	private String obsPressao;
	private int cdUser;
	
	
	public Pressao(int cdPressao, String dtAfericao, String obsPressao, int cdUser) {
		this.cdPressao = cdPressao;
		this.dtAfericao = dtAfericao;
		this.obsPressao = obsPressao;
		this.cdUser = cdUser;
	}
	
	public Pressao(int cdUser, String dtAfericao, String obsPressao) {
		this.dtAfericao = dtAfericao;
		this.obsPressao = obsPressao;
		this.cdUser = cdUser;
	}


	public int getCdPressao() {
		return cdPressao;
	}


	public void setCdPressao(int cdPressao) {
		this.cdPressao = cdPressao;
	}


	public String getDtAfericao() {
		return dtAfericao;
	}


	public void setDtAfericao(String dtAfericao) {
		this.dtAfericao = dtAfericao;
	}


	public String getObsPressao() {
		return obsPressao;
	}


	public void setObsPressao(String obsPressao) {
		this.obsPressao = obsPressao;
	}


	public int getCdUser() {
		return cdUser;
	}


	public void setCdUser(int cdUser) {
		this.cdUser = cdUser;
	}


	@Override
	public String toString() {
		return "[cdPressao=" + cdPressao + ", dtAfericao=" + dtAfericao + ", obsPressao=" + obsPressao
				+ ", cdUser=" + cdUser + "]";
	}
	
}
