package fr.diginamic.biblio.entities;

import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.diginamic.biblio.main.TestJpa;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {

	/** id : id du fournisseur */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	/** nom : nom fournisseur */
	@Column(name = "nom")
	String nom;

	/**
	 * Constructeur
	 * 
	 * @param nom
	 * @param id
	 */
	public Fournisseur(String nom, int id) {
		super();
		this.nom = nom;
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Fournisseur [nom=" + nom + ", id=" + id + "]";
	}

}
