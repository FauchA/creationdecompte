
package fr.eni.projetencheres.dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;


public class Connection1 {
	
	
	public static void main(String[] args) {
		Connection con = null; 
		Statement stmt = null; 
		
		//charger le driver jdbc en mémoire 
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String url = "jdbc:sqlserver://localhost:1433;databaseName=PROJET_ENCHERE";
			
			//obtenir une connexion
			con = DriverManager.getConnection(url, "my_sql_user_enchere", "Pa$$w0rd"); 
			
			
			//créer un statement 
			stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select no_utilisateur, prenom, nom, email from utilisateurs"); 
			while (rs.next()) {
				System.out.println(rs.getString("prenom") + " " + rs.getString("nom") + " " + rs.getString("email"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (stmt !=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		
		
	}
	

}
}
