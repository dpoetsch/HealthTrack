package br.health.objet;

public class Telefone {
	private int cdTel;
	private int telPessoal;
	private double ramal;
	private int nrComercial;
	private int nrPais;
	private int nrEstado;
	private int cdUser;
	
	public Telefone(int cdTel, int telPessoal, double ramal, int nrComercial, int nrPais, int nrEstado, int cdUser) {
		this.cdTel = cdTel;
		this.telPessoal = telPessoal;
		this.ramal = ramal;
		this.nrComercial = nrComercial;
		this.nrPais = nrPais;
		this.nrEstado = nrEstado;
		this.cdUser = cdUser;
	}

	public int getCdTel() {
		return cdTel;
	}

	public void setCdTel(int cdTel) {
		this.cdTel = cdTel;
	}

	public int getTelPessoal() {
		return telPessoal;
	}

	public void setTelPessoal(int telPessoal) {
		this.telPessoal = telPessoal;
	}

	public double getRamal() {
		return ramal;
	}

	public void setRamal(double ramal) {
		this.ramal = ramal;
	}

	public int getNrComercial() {
		return nrComercial;
	}

	public void setNrComercial(int nrComercial) {
		this.nrComercial = nrComercial;
	}

	public int getNrPais() {
		return nrPais;
	}

	public void setNrPais(int nrPais) {
		this.nrPais = nrPais;
	}

	public int getNrEstado() {
		return nrEstado;
	}

	public void setNrEstado(int nrEstado) {
		this.nrEstado = nrEstado;
	}

	public int getCdUser() {
		return cdUser;
	}

	public void setCdUser(int cdUser) {
		this.cdUser = cdUser;
	}

	@Override
	public String toString() {
		return "Telefone [cdTel=" + cdTel + ", telPessoal=" + telPessoal + ", ramal=" + ramal + ", nrComercial="
				+ nrComercial + ", nrPais=" + nrPais + ", nrEstado=" + nrEstado + ", cdUser=" + cdUser + "]";
	}
	
	
}
