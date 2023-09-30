package br.health.objet;

/**
 * Classe para input de atividades fisicas
 * @author Echodevs
 * @version 1.0
 */
public class AtvFisica {
	/**
	 * Propriedades relacionadas as atividades fisicas
	 */
	private int cdAtv;
	private String dataAtiv;
	private String tempoAtv;
	private String obsAtv;
	private int cdUser;
	
	public AtvFisica(int cdAtv, String dataAtiv, String tempoAtv, String obsAtv, int cdUser) {
		this.cdAtv = cdAtv;
		this.dataAtiv = dataAtiv;
		this.tempoAtv = tempoAtv;
		this.obsAtv = obsAtv;
		this.cdUser = cdUser;
	}
	
	public AtvFisica(int cdUser, String dataAtiv, String tempoAtv, String obsAtv) {
		this.dataAtiv = dataAtiv;
		this.tempoAtv = tempoAtv;
		this.obsAtv = obsAtv;
		this.cdUser = cdUser;
	}

	public int getCdAtv() {
		return cdAtv;
	}

	public void setCdAtv(int cdAtv) {
		this.cdAtv = cdAtv;
	}

	public String getDataAtiv() {
		return dataAtiv;
	}

	public void setDataAtiv(String dataAtiv) {
		this.dataAtiv = dataAtiv;
	}

	public String getTempoAtv() {
		return tempoAtv;
	}

	public void setTempoAtv(String tempoAtv) {
		this.tempoAtv = tempoAtv;
	}

	public String getObsAtv() {
		return obsAtv;
	}

	public void setObsAtv(String obsAtv) {
		this.obsAtv = obsAtv;
	}

	public int getCdUser() {
		return cdUser;
	}

	public void setCdUser(int cdUser) {
		this.cdUser = cdUser;
	}

	@Override
	public String toString() {
		return "AtvFisica [cdAtv=" + cdAtv + ", dataAtiv=" + dataAtiv + ", tempoAtv=" + tempoAtv + ", obsAtv=" + obsAtv
				+ ", cdUser=" + cdUser + "]";
	}
	
	
	
	/**
	 * Metodo Contrutor para dados de atividades fisicas
	 * @param aAtividade input de informações de atividades fisicas
	 * @param atempoAtv tempo de atividade sicas realizado
	 * @param aModalidade modalide da atividade fisica realizada
	 */

}