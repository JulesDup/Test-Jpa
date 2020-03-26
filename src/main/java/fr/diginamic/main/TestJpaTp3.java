package fr.diginamic.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Emprunt;
import fr.diginamic.entities.Livre;

public class TestJpaTp3 {
	private static final Logger LOGGER = Logger.getLogger(TestJpa.class.getName());

	public static void main(String[] args) {

		// creation factory et manager

		EntityManagerFactory entityManagerFactory2 = Persistence.createEntityManagerFactory("biblio-pu");
		EntityManager entityManager2 = entityManagerFactory2.createEntityManager();

//		Réaliser une requête qui permet d’extraire un emprunt et tous ses livres associés.

//		 requete JPQL
		TypedQuery<Emprunt> query = entityManager2.createQuery("select e from Emprunt e where e.id=2", Emprunt.class);
		List<Emprunt> listEmp = query.getResultList();
		Set<Livre> setLivre = new HashSet<>();
		
		for (Emprunt courant : listEmp) {
			
		}

		entityManager2.close();

		entityManagerFactory2.close();

	}

}
