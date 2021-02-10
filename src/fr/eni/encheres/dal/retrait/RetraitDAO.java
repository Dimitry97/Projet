package fr.eni.encheres.dal.retrait;

import java.util.ArrayList;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DALException;

public interface RetraitDAO {
	public void ajoutRetrait (Retrait retrait) throws DALException;
	public void modifRetrait (Retrait retrait) throws DALException;
	public ArrayList<Retrait> listerRetrait() throws DALException;
	public int suppRetrait (int id) throws DALException;

}
