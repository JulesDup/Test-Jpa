package fr.diginamic.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@OneToMany(mappedBy = "client")
	private List<Emprunt> listEmp;

	/**
	 * Constructeur
	 * 
	 */
	public Client() {
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 */
	public Client(Integer id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

//	@Override
//	public String toString() {
//		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
//	}
	/**
	 * Getter
	 * 
	 * @return the listEmp
	 */
	public List<Emprunt> getListEmp() {
		return listEmp;
	}

	/**
	 * Setter
	 * 
	 * @param listEmp the listEmp to set
	 */
	public void setListEmp(List<Emprunt> listEmp) {
		this.listEmp = listEmp;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + " listEmp=" + listEmp + "]";
	}

}
