package fr.diginamic.banque.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.mapping.Array;

import antlr.CppCodeGenerator;
import fr.diginamic.banque.entites.Adresse;
import fr.diginamic.banque.entites.AssuranceVie;
import fr.diginamic.banque.entites.Banque;
import fr.diginamic.banque.entites.ClientBanque;
import fr.diginamic.banque.entites.Compte;
import fr.diginamic.banque.entites.LivretA;
import fr.diginamic.banque.entites.Operation;
import fr.diginamic.banque.entites.Virement;

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
		Banque bq = new Banque("truc");
		
//		o Compte
		Compte cpt1 = new Compte("6654", 400d);
//		o Operation
		Operation ope1 = new Operation(LocalDateTime.now(), 300d, "parceque", cpt1);
//		o Client
		ClientBanque cl1 = new ClientBanque("Astier", "Alexandre", LocalDate.of(1974, 6, 14), bq);
		ClientBanque cl2 = new ClientBanque("Rollin", "Francois", LocalDate.of(1953, 5, 31), bq);
		ClientBanque cl3 = new ClientBanque("Astier", "Lionnel", LocalDate.of(1964, 10, 31), bq);
		ClientBanque cl4 = new ClientBanque("Pitiot", "Franck", LocalDate.of(1964, 6, 27), bq);
		cl1.setAdresse(new Adresse(2, "impasse de la chamoiserie", 79000, "niort"));
		cl2.setAdresse(new Adresse(2, "impasse de la chamoiserie", 79000, "niort"));
		cl3.setAdresse(new Adresse(2, "impasse de la chamoiserie", 79000, "niort"));
		cl4.setAdresse(new Adresse(2, "impasse de la chamoiserie", 79000, "niort"));
//		
//		o insérer un compte associé à 2 clients
		List<ClientBanque> listComptes = new ArrayList<ClientBanque>();
		listComptes.add(cl1);
		listComptes.add(cl2);
		Compte cpt2 = new Compte("123456", 10000d, listComptes);

//		o insérer un client avec plusieurs comptes :
//			▪ 1 compte de type assurance vie
		Compte assuranceVie1 = new AssuranceVie("456879", LocalDate.now(), 4500d);
		List<Compte> compteAssuranceVie = new ArrayList<>();
		compteAssuranceVie.add(assuranceVie1);
		cl3.setComptes(compteAssuranceVie);

//			▪ 1 compte de type livret A
		ClientBanque cl5 = new ClientBanque("luc", "machin", LocalDate.of(1964, 6, 27), bq);
		Compte livretA = new LivretA("147258", 5000d);
		List<Compte> compteLivretA = new ArrayList<>();
		compteLivretA.add(livretA);
		cl5.setComptes(compteLivretA);

//		o insérer des opérations de type virements sur un compte
		Compte cpt3 = new Compte("123456", 10000d);
		Operation vir2 = new Virement(LocalDateTime.now(), 100d, "parceque", livretA, "inconu");
		Operation vir3 = new Virement(LocalDateTime.now(), 100d, "parceque", livretA, "inconu");
		Operation vir4 = new Virement(LocalDateTime.now(), 300d, "parceque", cpt1, "lui");
		List<Operation> listVir = new ArrayList<>();
		listVir.add(vir2);
		listVir.add(vir3);
		listVir.add(vir4);
		cpt3.setOperations(listVir);
//		o insérer des opérations de type opérations sur un compte
		Compte cpt4 = new Compte("123456", 10000d, listComptes);
		Operation ope2 = new Virement(LocalDateTime.now(), 100d, "parceque", assuranceVie1, "inconu");
		Operation ope3 = new Virement(LocalDateTime.now(), 100d, "parceque", livretA, "inconu");
		Operation ope4 = new Virement(LocalDateTime.now(), 300d, "parceque", cpt1, "lui");
		List<Operation> listOp = new ArrayList<>();
		listOp.add(ope2);
		listOp.add(ope3);
		listOp.add(ope4);
		cpt4.setOperations(listOp);

//Entrée des données dans la base	
		EntityTransaction tr1 = entityManager.getTransaction();
		tr1.begin();
		entityManager.persist(bq);
		entityManager.persist(cpt1);
		entityManager.persist(ope1);

		entityManager.persist(cl1);
		entityManager.persist(cl2);
		entityManager.persist(cl3);
		entityManager.persist(cl4);

		entityManager.persist(cpt2);

		tr1.commit();

	}

}
