package br.health.objet;

public class Usuario {
	
	private int cdUser;
	private String nmUser;
	private String dtNasc;
	private String nmApelido;
	
	public Usuario(int cdUser, String nmUser, String dtNasc, String nmApelido) {
		this.cdUser = cdUser;
		this.nmUser = nmUser;
		this.dtNasc = dtNasc;
		this.nmApelido = nmApelido;
	}
	
	public Usuario(String nmUser, String dtNasc, String nmApelido) {
		this.nmUser = nmUser;
		this.dtNasc = dtNasc;
		this.nmApelido = nmApelido;
	}

	public int getCdUser() {
		return cdUser;
	}

	public void setCdUser(int cdUser) {
		this.cdUser = cdUser;
	}

	public String getNmUser() {
		return nmUser;
	}

	public void setNmUser(String nmUser) {
		this.nmUser = nmUser;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}


	public String getNmApelido() {
		return nmApelido;
	}

	public void setNmApelido(String nmApelido) {
		this.nmApelido = nmApelido;
	}

	@Override
	public String toString() {
		return "Usuario [cdUser=" + cdUser + ", nmUser=" + nmUser + ", dtNasc=" + dtNasc + ", nmApelido=" + nmApelido
				+ "]";
	}
	
}
