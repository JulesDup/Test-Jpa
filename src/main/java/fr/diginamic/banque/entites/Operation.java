package fr.diginamic.banque.entites;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("NA")
@Table(name = "OPERATION")
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

	public Operation() {

	}

	/**
	 * Constructeur
	 * 
	 * @param date
	 * @param montant
	 * @param motif
	 * @param compte
	 */
	public Operation(LocalDateTime date, Double montant, String motif, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Getter
	 * 
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * Getter
	 * 
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * Getter
	 * 
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * Getter
	 * 
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * Setter
	 * 
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * Setter
	 * 
	 * @param montant the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * Setter
	 * 
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * Setter
	 * 
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + ", compte="
				+ compte + "]";
	}

}
