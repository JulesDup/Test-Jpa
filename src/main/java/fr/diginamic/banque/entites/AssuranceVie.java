package fr.diginamic.banque.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {
	@Column(name = "COMPTE")
	private Compte compte;
	@Column(name = "DATE_FIN")
	private LocalDate datefin;
	@Column(name = "TAUX")
	private Double taux;

}
