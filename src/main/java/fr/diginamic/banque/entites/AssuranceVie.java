package fr.diginamic.banque.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte {

	@Column(name = "DATE_FIN")
	private LocalDate datefin;
	@Column(name = "TAUX")
	private Double taux;

	public AssuranceVie() {

	}

	/**
	 * Constructeur
	 * 
	 * @param datefin
	 * @param taux
	 */
	public AssuranceVie(String numero, LocalDate datefin, Double taux) {
		super(numero);
		this.datefin = datefin;
		this.taux = taux;
	}

	/**
	 * Getter
	 * 
	 * @return the datefin
	 */
	public LocalDate getDatefin() {
		return datefin;
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
	 * @param datefin the datefin to set
	 */
	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}

	/**
	 * Setter
	 * 
	 * @param taux the taux to set
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}

}
