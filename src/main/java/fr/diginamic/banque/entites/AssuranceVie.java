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

}
