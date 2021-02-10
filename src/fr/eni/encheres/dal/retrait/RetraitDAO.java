package fr.eni.encheres.dal.retrait;

import java.util.ArrayList;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DALException;

public interface RetraitDAO {
	public void ajouter (Retrait retrait) throws DALException;
	public void modifier (Retrait retrait) throws DALException;
	public ArrayList<Retrait> lister() throws DALException;
	public int supprimer (int id) throws DALException;

}
