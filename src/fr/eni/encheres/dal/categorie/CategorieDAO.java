package fr.eni.encheres.dal.categorie;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DALException;

public interface CategorieDAO {

	public void ajouterNewCat(Categorie categorie) throws DALException, SQLException;

	public void modifCat(Categorie categorie) throws DALException, SQLException;

	public int suppCat(Categorie categorie) throws DALException, SQLException;

	public ArrayList<Categorie> listerCat() throws DALException;

	public Categorie rechCatByNo(int id) throws DALException;

}
