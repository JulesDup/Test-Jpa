package fr.diginamic.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprunt")
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "DATE_DEBUT")
	private String date_debut;
	@Column(name = "DATE_FIN")
	private String date_fin;
	@Column(name = "DELAI")
	private Integer delais;
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livres;

	/**
	 * Constructeur
	 * 
	 */
	public Emprunt() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param date_debut
	 * @param date_fin
	 * @param delais
	 * @param client
	 */
	public Emprunt(Integer id, String date_debut, String date_fin, Integer delais, Client client) {
		super();
		this.id = id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.delais = delais;
		this.client = client;
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
	 * @return the date_debut
	 */
	public String getDate_debut() {
		return date_debut;
	}

	/**
	 * Getter
	 * 
	 * @return the date_fin
	 */
	public String getDate_fin() {
		return date_fin;
	}

	/**
	 * Getter
	 * 
	 * @return the delais
	 */
	public Integer getDelais() {
		return delais;
	}

	/**
	 * Getter
	 * 
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Getter
	 * 
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
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
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	/**
	 * Setter
	 * 
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	/**
	 * Setter
	 * 
	 * @param delais the delais to set
	 */
	public void setDelais(Integer delais) {
		this.delais = delais;
	}

	/**
	 * Setter
	 * 
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Setter
	 * 
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", delais=" + delais
				+ ", client=" + client + "]";
	}

}
