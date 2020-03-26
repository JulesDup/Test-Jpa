package fr.diginamic.main;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.omg.CORBA.PRIVATE_MEMBER;

import fr.diginamic.entities.Livre;

public class TestJpa {
	private static final Logger LOGGER = Logger.getLogger(TestJpa.class.getName());

	public static void main(String[] args) {

		
///TP1		
		// creation factory et manager

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

///TP2
		// Find utilisant l'ID
		Livre livre = entityManager.find(Livre.class, 1);
		Livre livre2 = entityManager.find(Livre.class, 2);

		LOGGER.log(Level.INFO, "instance de livre " + livre.toString());
		LOGGER.log(Level.INFO, "instance de livre2 " + livre2.toString());

		// recherche avec requete JPQL

		TypedQuery<Livre> query = entityManager.createQuery("select l from Livre l where l.auteur='Jules Verne'",
				Livre.class);
		List<Livre> listLiv = query.getResultList();

		// voir en console
		for (Livre courante : listLiv) {
			System.out.println(courante.getTitre());
		}
		// voir avec logger
		LOGGER.log(Level.INFO, "Titre livre de Jules Verne : " + listLiv.get(0).getTitre());

		// recherche partitre de livre

		TypedQuery<Livre> query2 = entityManager
				.createQuery("select l from Livre l where l.titre='Vingt mille lieues sous les mers'", Livre.class);
		List<Livre> listLiv2 = query2.getResultList();

		LOGGER.log(Level.INFO, "Titre livre de Jules Verne : " + listLiv2.get(0).getTitre());

		entityManager.close();

		entityManagerFactory.close();
	}

}
