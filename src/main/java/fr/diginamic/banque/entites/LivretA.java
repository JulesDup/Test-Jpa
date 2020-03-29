package fr.diginamic.banque.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte {
	
	@Column(name = "TAUX")
	private Double taux;

	public LivretA() {

	}

	/**
	 * Constructeur
	 * 
	 * @param numero
	 * @param solde
	 * @param taux
	 */
	public LivretA(String numero, Double taux) {
		super(numero);
		this.taux = taux;
	}

	/**
	 * Getter
	 * 
	 * @return the taux
	 */
	public Double getTaux() {
		return taux;
	}

	/**
	 * Setter
	 * 
	 * @param taux the taux to set
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "LivretA [taux=" + taux + "]";
	}

}
