package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Livre;

public class LivreDao implements ILivreDao {

	@Override
	public Livre getLivreById(int id) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Livre livre = entityManager.find(Livre.class, id);
		entityManager.close();
		entityManagerFactory.close();
		return livre;
	}

	@Override
	public List<Livre> getLivreByAuteur(String auteur) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Livre> query = entityManager.createQuery("select l from Livre l where l.auteur=:auteur", Livre.class)
				.setParameter("auteur", auteur);
		List<Livre> listLiv = query.getResultList();
		entityManager.close();
		entityManagerFactory.close();

		return listLiv;
	}

	@Override
	public Livre getLivreByTitre(String titre) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Livre> query = entityManager.createQuery("select l from Livre l where l.titre=:titre", Livre.class)
				.setParameter("titre", titre);
		Livre livre = query.getSingleResult();

		entityManager.close();
		entityManagerFactory.close();
		return livre;
	}

}
