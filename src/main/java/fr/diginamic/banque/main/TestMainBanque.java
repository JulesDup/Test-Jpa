package fr.diginamic.banque.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import antlr.CppCodeGenerator;
import fr.diginamic.banque.entites.Adresse;
import fr.diginamic.banque.entites.AssuranceVie;
import fr.diginamic.banque.entites.Banque;
import fr.diginamic.banque.entites.ClientBanque;
import fr.diginamic.banque.entites.Compte;
import fr.diginamic.banque.entites.LivretA;
import fr.diginamic.banque.entites.Operation;

public class TestMainBanque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		ChargementDonnées(entityManager);
		entityManager.close();
		entityManagerFactory.close();

	}

	public static void ChargementDonnées(EntityManager entityManager) {

//		
//		o Banque
//		o Compte
//		o Operation
//		o Client

//		
//		o insérer un compte associé à 2 clients
//		o insérer un client avec plusieurs comptes :
//			▪ 1 compte de type assurance vie
//			▪ 1 compte de type livret A
//		o insérer des opérations de type virements sur un compte
//		o insérer des opérations de type opérations sur un compte

		Banque bq = new Banque("truc");
		ClientBanque cl1 = new ClientBanque("Astier", "Alexandre", LocalDate.of(1974, 6, 14), bq);
		ClientBanque cl2 = new ClientBanque("Rollin", "Francois", LocalDate.of(1953, 5, 31), bq);
		ClientBanque cl3 = new ClientBanque("Astier", "Lionnel", LocalDate.of(1964, 10, 31), bq);
		ClientBanque cl4 = new ClientBanque("Pitiot", "Franck", LocalDate.of(1964, 6, 27), bq);
		cl1.setAdresse(new Adresse(2, "impasse de la chamoiserie", 79000, "niort"));
		cl2.setAdresse(new Adresse(2, "impasse de la chamoiserie", 79000, "niort"));
		cl3.setAdresse(new Adresse(2, "impasse de la chamoiserie", 79000, "niort"));
		cl4.setAdresse(new Adresse(2, "impasse de la chamoiserie", 79000, "niort"));

		Compte cpt1 = new Compte("6654", 400d);
		Operation ope1 = new Operation(LocalDateTime.now(), 300d, "parceque", cpt1);
		LivretA livretA = new LivretA(cpt1.getNumero(), 300d);
		AssuranceVie assVie = new AssuranceVie(cpt1.getNumero(), LocalDate.of(2025, 3, 12), 0.2);

		ClientBanque cl5 = new ClientBanque("Balkany", "Patrick", LocalDate.of(1964, 6, 27), bq);
		List<ClientBanque> Balkas = Arrays.asList(cl5);
		Compte cpt2 = new Compte("666", 100000000000000000d, Balkas);

//Entrée des données dans la base	
		EntityTransaction tr1 = entityManager.getTransaction();
		tr1.begin();
		entityManager.persist(bq);
		entityManager.persist(cl1);
		entityManager.persist(cl2);
		entityManager.persist(cl3);
		entityManager.persist(cl4);
		entityManager.persist(cpt2);
		entityManager.persist(cpt1);
		entityManager.persist(ope1);
		entityManager.persist(livretA);
		entityManager.persist(assVie);
		tr1.commit();

	}

}
