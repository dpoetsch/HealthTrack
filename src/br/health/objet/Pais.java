package br.health.objet;

public class Pais {
	private int nrPais;
	private int cdPais;
	
	public Pais(int nrPais, int cdPais) {
		this.nrPais = nrPais;
		this.cdPais = cdPais;
	}
	
	public int getNrPais() {
		return nrPais;
	}
	public void setNrPais(int nrPais) {
		this.nrPais = nrPais;
	}
	public int getCdPais() {
		return cdPais;
	}
	public void setCdPais(int cdPais) {
		this.cdPais = cdPais;
	}
	
	@Override
	public String toString() {
		return "Pais [nrPais=" + nrPais + ", cdPais=" + cdPais + "]";
	}

}
