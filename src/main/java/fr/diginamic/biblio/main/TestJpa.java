package fr.diginamic.biblio.main;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.omg.CORBA.PRIVATE_MEMBER;

import fr.diginamic.biblio.dao.ILivreDao;
import fr.diginamic.biblio.dao.LivreDao;
import fr.diginamic.biblio.entites.Livre;

public class TestJpa {
	private static final Logger LOGGER = Logger.getLogger(TestJpa.class.getName());

	public static void main(String[] args) {

///TP1		
		// creation factory et manager

///TP2
		// Find utilisant l'ID
		ILivreDao livreDao = new LivreDao();
		Livre livre = livreDao.getLivreById(2);
		Livre livre2 = livreDao.getLivreById(1);

		LOGGER.log(Level.INFO, "instance de livre " + livre.toString());
		LOGGER.log(Level.INFO, "instance de livre2 " + livre2.toString());

		// recherche avec requete JPQL

		// voir en console
		List<Livre> listLiv = livreDao.getLivreByAuteur("Jules Verne");
		for (Livre courante : listLiv) {
			System.out.println(courante.getTitre());
		}
		// voir avec logger
		LOGGER.log(Level.INFO, "Titre livre de Jules Verne : " + listLiv.get(0).getTitre());

		// recherche partitre de livre

		Livre livre3 = livreDao.getLivreByTitre("Vingt mille lieues sous les mers");

		LOGGER.log(Level.INFO, "Titre livre de Jules Verne : " + livre3);

	}

}
