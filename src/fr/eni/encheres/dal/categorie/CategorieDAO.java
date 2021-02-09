package fr.eni.encheres.dal.categorie;

import java.util.ArrayList;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DALException;

public interface CategorieDAO {
	
	public  void ajouter (Categorie categorie) throws DALException;
	
	public void modifier (Categorie categorie) throws DALException;
	
	public   int supprimer (Categorie categorie)throws DALException;
	
	public  ArrayList<Categorie> lister() throws DALException;
	
	public  Categorie recherche(int id) throws DALException;

}
