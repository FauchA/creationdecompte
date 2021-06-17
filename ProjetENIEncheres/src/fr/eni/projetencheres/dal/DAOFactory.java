package fr.eni.projetencheres.dal;

import fr.eni.projetencheres.dal.UtilisateurDAO;
import fr.eni.projetencheres.dal.jdbc.UtilisateurDAOJDBCImpl;


public abstract class DAOFactory {
		
		public static UtilisateurDAO getUtilisateurDAO()
		{
			return new UtilisateurDAOJDBCImpl();		
		}
		
		

}

	
	
	
	