package fr.diginamic.banque.entites;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Virement {
	@Column(name = "OPERATION")
	private Operation operation;
	@Column(name = "BENEFICIAIRE")
	private String benificiaire;

}
