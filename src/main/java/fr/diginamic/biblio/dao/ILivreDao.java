package fr.diginamic.biblio.dao;

import java.util.List;

import fr.diginamic.biblio.entities.Livre;

public interface ILivreDao {
	public Livre getLivreById(int id);

	public List<Livre> getLivreByAuteur(String auteur);

	public Livre getLivreByTitre(String titre);
}
