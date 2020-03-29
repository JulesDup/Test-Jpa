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

}
