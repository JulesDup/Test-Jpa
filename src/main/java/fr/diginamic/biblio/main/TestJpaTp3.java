package fr.diginamic.biblio.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.biblio.dao.EmpruntDao;
import fr.diginamic.biblio.entities.Emprunt;
import fr.diginamic.biblio.entities.Livre;

public class TestJpaTp3 {
	private static final Logger LOGGER = Logger.getLogger(TestJpaTp3.class.getName());

	public static void main(String[] args) {
//
//		// creation factory et manager
//
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio-pu");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
////		Réaliser une requête qui permet d’extraire un emprunt et tous ses livres associés.
//
////		 requete JPQL
//
//		TypedQuery<Emprunt> query = entityManager.createQuery("select e from Emprunt e where e.id=2", Emprunt.class);
//		List<Emprunt> listEmp = query.getResultList();
//		Set<Livre> setLivre = listEmp.get(0).getLivres();

		EmpruntDao empDao = new EmpruntDao();
		List<Livre> listLivre = empDao.getLivresByIdEmprunt(2);
		for (Livre courant : listLivre) {
			System.out.println(courant);
		}
		List<Emprunt> ListEmprunt = empDao.getEmpruntByClient(3);
		for (Emprunt courant : ListEmprunt) {
			System.out.println(courant);
		}

	}

}
