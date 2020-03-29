package fr.diginamic.banque.entites;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "COMPTE")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "NUMERO")
	private String numero;
	@Column(name = "SOLDE")
	private Double solde;
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;
	@ManyToMany(mappedBy = "comptes")
	private List<ClientBanque> clients;

	/**
	 * Constructeur
	 * 
	 */
	public Compte() {
	}

	/**Constructeur
	 * @param numero
	 */
	public Compte(String numero) {
		super();
		this.numero = numero;
	}

	/**
	 * Constructeur
	 * 
	 * @param numero
	 * @param solde
	 * @param clients
	 */
	public Compte(String numero, Double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
	}

	/**Constructeur
	 * @param numero
	 * @param solde
	 * @param clients
	 */
	public Compte(String numero, Double solde, List<ClientBanque> clients) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.clients = clients;
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param numero
	 * @param solde
	 * @param operations
	 * @param clients
	 */
	public Compte(String numero, Double solde, List<Operation> operations, List<ClientBanque> clients) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.operations = operations;
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Getter
	 * 
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/**
	 * Getter
	 * 
	 * @return the operations
	 */
	public List<Operation> getOperations() {
		return operations;
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
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Setter
	 * 
	 * @param solde the solde to set
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	/**
	 * Setter
	 * 
	 * @param operations the operations to set
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
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
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", operations=" + operations
				+ ", clients=" + clients + "]";
	}

}
