package br.health.objet;

/**
 * Classe para criação do objeto de consumo de agua
 * @author Echodevs
 * @version 1.0
 */
public class Agua {
	
	private int cdAgua;
	private String vlmAgua;
	private String qtaCopos;
	private String obsAgua;
	private int cdUser;
	private String dtAgua;
	
	public Agua(int cdAgua, String vlmAgua, String qtaCopos, String obsAgua, int cdUser, String dtAgua) {
		this.cdAgua = cdAgua;
		this.vlmAgua = vlmAgua;
		this.qtaCopos = qtaCopos;
		this.obsAgua = obsAgua;
		this.cdUser = cdUser;
		this.dtAgua = dtAgua;
	}
	
	public Agua(String vlmAgua, String qtaCopos, String obsAgua, int cdUser, String dtAgua) {
		this.vlmAgua = vlmAgua;
		this.qtaCopos = qtaCopos;
		this.obsAgua = obsAgua;
		this.cdUser = cdUser;
		this.dtAgua = dtAgua;
	}

	public int getCdAgua() {
		return cdAgua;
	}

	public void setCdAgua(int cdAgua) {
		this.cdAgua = cdAgua;
	}

	public String getVlmAgua() {
		return vlmAgua;
	}

	public void setVlmAgua(String vlmAgua) {
		this.vlmAgua = vlmAgua;
	}

	public String getQtaCopos() {
		return qtaCopos;
	}

	public void setQtaCopos(String qtaCopos) {
		this.qtaCopos = qtaCopos;
	}

	public String getObsAgua() {
		return obsAgua;
	}

	public void setObsAgua(String obsAgua) {
		this.obsAgua = obsAgua;
	}

	public int getCdUser() {
		return cdUser;
	}

	public void setCdUser(int cdUser) {
		this.cdUser = cdUser;
	}

	public String getDtAgua() {
		return dtAgua;
	}

	public void setDtAgua(String dtAgua) {
		this.dtAgua = dtAgua;
	}

	@Override
	public String toString() {
		return "[cdAgua=" + cdAgua + ", vlmAgua=" + vlmAgua + ", qtaCopos=" + qtaCopos + ", obsAgua=" + obsAgua
				+ ", cdUser=" + cdUser + ", dtAgua=" + dtAgua + "]";
	}
	
}
