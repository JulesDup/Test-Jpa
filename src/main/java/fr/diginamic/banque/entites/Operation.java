package fr.diginamic.banque.entites;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("NA")
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "DATE")
	private LocalDateTime date;
	@Column(name = "MONTANT")
	private Double montant;
	@Column(name = "MOTIF")
	private String motif;
	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private Compte compte;

}
