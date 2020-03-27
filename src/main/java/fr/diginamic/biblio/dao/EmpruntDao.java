package fr.diginamic.biblio.dao;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.biblio.entities.Emprunt;
import fr.diginamic.biblio.entities.Livre;

public class EmpruntDao implements IEmpruntDao {
	@Override
	public List<Livre> getLivresByIdEmprunt(int id) {

		// creation factory et manager

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		Réaliser une requête qui permet d’extraire un emprunt et tous ses livres associés.

//		 requete JPQL
		TypedQuery<Livre> query = entityManager
				.createQuery("select l from Livre l join l.emprunts e where e.id=:id", Livre.class)
				.setParameter("id", id);
		List<Livre> listLivre = query.getResultList();

		entityManager.close();

		entityManagerFactory.close();

		return listLivre;

	}

	@Override
	public List<Emprunt> getEmpruntByClient(int id) {
		// creation factory et manager

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.
//		 requete JPQL
		TypedQuery<Emprunt> query = entityManager
				.createQuery("select e from Emprunt e join e.client c where c.id=:id", Emprunt.class)
				.setParameter("id", id);
		List<Emprunt> listEmp = query.getResultList();

		entityManager.close();

		entityManagerFactory.close();
		return listEmp;
	}

}
