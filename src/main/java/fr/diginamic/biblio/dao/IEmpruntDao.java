package fr.diginamic.biblio.dao;

import java.util.List;

import fr.diginamic.biblio.entities.Emprunt;
import fr.diginamic.biblio.entities.Livre;

public interface IEmpruntDao {
	public List<Livre> getLivresByIdEmprunt(int id);

	public List<Emprunt> getEmpruntByClient(int id);

	;
}
