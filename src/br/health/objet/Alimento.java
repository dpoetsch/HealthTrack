package br.health.objet;

/**
 * Classe para adição do consumo de alimentos
 * @author Echodevs
 * @version 1.0
 */
public class Alimento {
	/**
	 * Propriedades relacionada a criação do obejto.
	 */
	private int cdConsumo;
	private String qtdConsu;
	private String datConsum;
	private String obsConsum;
	private int cdUser;
	
	public Alimento(int cdConsumo, String qtdConsu, String datConsum, String obsConsum, int cdUser) {
		this.cdConsumo = cdConsumo;
		this.qtdConsu = qtdConsu;
		this.datConsum = datConsum;
		this.obsConsum = obsConsum;
		this.cdUser = cdUser;
	}
	
	public Alimento(String qtdConsu, String datConsum, String obsConsum, int cdUser) {
		this.qtdConsu = qtdConsu;
		this.datConsum = datConsum;
		this.obsConsum = obsConsum;
		this.cdUser = cdUser;
	}


	public int getCdConsumo() {
		return cdConsumo;
	}

	public void setCdConsumo(int cdConsumo) {
		this.cdConsumo = cdConsumo;
	}

	public String getQtdConsu() {
		return qtdConsu;
	}

	public void setQtdConsu(String qtdConsu) {
		this.qtdConsu = qtdConsu;
	}

	public String getDatConsum() {
		return datConsum;
	}

	public void setDatConsum(String datConsum) {
		this.datConsum = datConsum;
	}

	public String getObsConsum() {
		return obsConsum;
	}

	public void setObsConsum(String obsConsum) {
		this.obsConsum = obsConsum;
	}

	public int getCdUser() {
		return cdUser;
	}

	public void setCdUser(int cdUser) {
		this.cdUser = cdUser;
	}

	@Override
	public String toString() {
		return "[cdConsumo=" + cdConsumo + ", qtdConsu=" + qtdConsu + ", datConsum=" + datConsum
				+ ", obsConsum=" + obsConsum + ", cdUser=" + cdUser + "]";
	}

	
}
