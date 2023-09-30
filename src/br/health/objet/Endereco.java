package br.health.objet;

public class Endereco {
	private int cdEnd;
	private int nrImovel;
	private int cep;
	private String logradouro;
	private String cidade;
	private String pais;
	private String estado;
	private int cdUser;
	
	
	public Endereco(int cdEnd, int nrImovel, int cep, String logradouro, String cidade, String pais, String estado, int cdUser) {
		this.cdEnd = cdEnd;
		this.nrImovel = nrImovel;
		this.cep = cep;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.cdUser = cdUser;
	}

	public int getCdEnd() {
		return cdEnd;
	}

	public void setCdEnd(int cdEnd) {
		this.cdEnd = cdEnd;
	}

	public int getNrImovel() {
		return nrImovel;
	}

	public void setNrImovel(int nrImovel) {
		this.nrImovel = nrImovel;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCdUser() {
		return cdUser;
	}

	public void setCdUser(int cdUser) {
		this.cdUser = cdUser;
	}

	@Override
	public String toString() {
		return "Endereco [cdEnd=" + cdEnd + ", nrImovel=" + nrImovel + ", cep=" + cep + ", logradouro=" + logradouro
				+ ", cidade=" + cidade + ", pais=" + pais + ", estado=" + estado + ", cdUser=" + cdUser + "]";
	}

}
