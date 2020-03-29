package fr.diginamic.banque.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BANQUE")
public class Banque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "NOM")
	private String nom;
	@OneToMany(mappedBy = "banque")
	private List<ClientBanque> clients;

	public Banque() {

	}

	/**
	 * Constructeur
	 * 
	 * @param nom
	 */
	public Banque(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 * @param clients
	 */
	public Banque(String nom, List<ClientBanque> clients) {
		super();

		this.nom = nom;
		this.clients = clients;
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
	 * @return the clients
	 */
	public List<ClientBanque> getClients() {
		return clients;
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
	 * @param clients the clients to set
	 */
	public void setClients(List<ClientBanque> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + ", clients=" + clients + "]";
	}

}
