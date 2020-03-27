package fr.diginamic.banque.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	@Column(name = "NUMERO")
	private Integer numero;
	@Column(name = "RUE")
	private String rue;
	@Column(name = "CODE_POSTAL")
	private Integer codePostal;
	@Column(name = "VILLE")
	private String ville;
}
