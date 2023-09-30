package br.health.objet;

public class Estado {
	private int nrEstado;
	private int cdEstado;
	
	public Estado(int nrEstado, int cdEstado) {
		this.nrEstado = nrEstado;
		this.cdEstado = cdEstado;
	}

	public int getNrEstado() {
		return nrEstado;
	}

	public void setNrEstado(int nrEstado) {
		this.nrEstado = nrEstado;
	}

	public int getCdEstado() {
		return cdEstado;
	}

	public void setCdEstado(int cdEstado) {
		this.cdEstado = cdEstado;
	}

	@Override
	public String toString() {
		return "Estado [nrEstado=" + nrEstado + ", cdEstado=" + cdEstado + "]";
	}
	
	
}
