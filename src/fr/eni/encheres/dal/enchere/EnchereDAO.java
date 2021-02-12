package fr.eni.encheres.dal.enchere;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DALException;

public interface EnchereDAO {

	void inserer(Enchere enchere) throws DALException, SQLException;

	public List<Enchere> getAll() throws DALException;

	public void update(Enchere enchere) throws DALException;

	public void delete(int id) throws DALException;

	public List<Enchere> getByEncherisseur(int id) throws DALException;

	public List<Enchere> getRemportesParEncherisseur(int id) throws DALException;

}
