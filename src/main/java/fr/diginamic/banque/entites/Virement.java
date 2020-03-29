package fr.diginamic.banque.entites;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("V")
public class Virement extends Operation {

	@Column(name = "BENEFICIAIRE")
	private String benificiaire;

	/**
	 * Constructeur
	 * 
	 * @param benificiaire
	 */
	public Virement(String benificiaire) {
		super();
		this.benificiaire = benificiaire;
	}

	/**
	 * Getter
	 * 
	 * @return the benificiaire
	 */
	public String getBenificiaire() {
		return benificiaire;
	}

	/**
	 * Setter
	 * 
	 * @param benificiaire the benificiaire to set
	 */
	public void setBenificiaire(String benificiaire) {
		this.benificiaire = benificiaire;
	}

	@Override
	public String toString() {
		return "Virement [benificiaire=" + benificiaire + "]";
	}

}
