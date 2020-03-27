package fr.diginamic.banque.entites;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "emprunt")
public class LivreA extends Compte {
	private Compte compte;
	private Double taux;

}
