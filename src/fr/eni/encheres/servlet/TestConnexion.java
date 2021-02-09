package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DBConnection;

/**
 * Servlet implementation class TestConnexion
 */
@WebServlet("/TestConnexion")
public class TestConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TestConnexion() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection cnx = null;
		
		try {
			cnx = DBConnection.seConnecter();
			//System.out.println("connexion OK");
			response.getWriter().append("connexion OK");
		} catch (DALException e) {
			//System.out.println("connexion KO");
			//System.out.println(e.getMessage());
			response.getWriter().append("connexion KO").append("\n").append(e.getMessage());
		}finally {
			try {
				DBConnection.seDeconnecter(cnx);
			} catch (DALException e) {
				//System.out.println("PB FERMETURE BASE");
				//System.out.println(e.getMessage());
				response.getWriter().append("PB FERMETURE BASE").append("\n").append(e.getMessage());
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
