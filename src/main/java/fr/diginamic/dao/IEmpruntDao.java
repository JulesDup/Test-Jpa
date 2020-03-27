package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entities.Emprunt;
import fr.diginamic.entities.Livre;

public interface IEmpruntDao {
	public List<Livre> getLivresByIdEmprunt(int id);

	public List<Emprunt> getEmpruntByClient(int id);

	;
}
