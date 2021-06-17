package fr.eni.projetencheres.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
	
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=PROJET_ENCHERE","my_sql_user_enchere","Pa$$w0rd");
	}

}