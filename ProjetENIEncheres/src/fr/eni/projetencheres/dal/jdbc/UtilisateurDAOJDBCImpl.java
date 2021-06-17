package fr.eni.projetencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetencheres.dal.ArticleVenduDAO;
import fr.eni.projetencheres.dal.CategorieDAO;
import fr.eni.projetencheres.dal.EnchereDAO;
import fr.eni.projetencheres.dal.RetraitDAO;
import fr.eni.projetencheres.dal.jdbc.ArticleVenduDAOJDBCImpl;
import fr.eni.projetencheres.dal.jdbc.CategorieDAOJDBCImpl;
import fr.eni.projetencheres.dal.jdbc.EnchereDAOJDBCImpl;
import fr.eni.projetencheres.dal.jdbc.RetraitDAOJDBCImpl;
import fr.eni.projetencheres.dal.CodesResultatDAL;
import fr.eni.projetencheres.dal.ConnectionProvider;
import fr.eni.projetencheres.BusinessException;
import fr.eni.projetencheres.bo.ArticleVendu;
import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.dal.UtilisateurDAO;

public class UtilisateurDAOJDBCImpl implements UtilisateurDAO {

	
	private static final String INSERER = "INSERT INTO UTILISATEURS VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_TOUS_LES_UTILISATEURS = "SELECT * FROM UTILISATEURS";
	private static final String GET_PAR_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String MODIFIER = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?,"
			+ "email=?, telephone=?, rue=?, code_postal=?, ville=?," + " mot_de_passe=?, credit=?, administrateur=? WHERE no_utilisateur=?";
	private static final String SUPPRIMER = "DELETE UTILISATEURS WHERE no_utilisateur=?";
	private static final String GET_TOUS_LES_ARTICLES_VENDUS = "select * from ARTICLES_VENDUS WHERE no_utilisateur=?";
	private static final String GET_PAR_PSEUDO ="select * from UTILISATEURS WHERE pseudo=? ";
	private static final String GET_TOUS_LES_PSEUDOS = "SELECT pseudo FROM UTILISATEURS";

	/*private static EnchereDAO enchereDao = new EnchereDAOJDBCImpl();
	private static ArticleVenduDAO articleDao = new ArticleVenduDAOJDBCImpl();
	private static CategorieDAO categorieDao = new CategorieDAOJDBCImpl();
	private static RetraitDAO retraitDao = new RetraitDAOJDBCImpl();*/


	
	@Override
	public Utilisateur inserer(Utilisateur utilisateur) throws BusinessException {


			if (utilisateur == null) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}

			try (Connection cnx = ConnectionProvider.getConnection()) {

				PreparedStatement statement = cnx.prepareStatement(INSERER, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, utilisateur.getPseudo());
				statement.setString(2, utilisateur.getNom());
				statement.setString(3, utilisateur.getPrenom());
				statement.setString(4, utilisateur.getEmail());
				if (utilisateur.getTelephone() != null) {
					statement.setString(5, utilisateur.getTelephone());
				} else {
					statement.setNull(5, Types.VARCHAR);
				}
				statement.setString(5, utilisateur.getTelephone());
				statement.setString(6, utilisateur.getRue());
				statement.setString(7, utilisateur.getCodePostal());
				statement.setString(8, utilisateur.getVille());
				statement.setString(9, utilisateur.getMotDePasse());
				statement.setInt(10, utilisateur.getCredit());
				statement.setBoolean(11, utilisateur.isAdministrateur());

				statement.executeUpdate();
				ResultSet rs = statement.getGeneratedKeys();

				if (rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt(1));
				}

				statement.close();
				cnx.commit();

			} catch (Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
				throw businessException;
			}
			return utilisateur;
		}

		@Override
		public List<Utilisateur> getTousLesUtilisateurs() throws BusinessException {

			List<Utilisateur> list = new ArrayList<>();
			Utilisateur utilisateur = null;
			
			try (Connection cnx = ConnectionProvider.getConnection()) {
				PreparedStatement statement = cnx.prepareStatement(GET_TOUS_LES_UTILISATEURS);
				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					utilisateur = utilisateurBuilder(rs);
					list.add(utilisateur);
				}

			} catch (Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_UTILISATEURS_ECHEC);
				throw businessException;

			}
			return list;
		}

		
	
	


	@Override
	public void modifier(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur getParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Utilisateur getParPseudo(String pseudo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> getTousLesArticlesVendus(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getTousLesPseudos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public Utilisateur utilisateurBuilder(ResultSet rs) throws SQLException
	{
		/*List<ArticleVendu> articlesVendus = this.getArticlesVendusUtilisateur(rs.getInt("no_utilisateur"));
		List<ArticleVendu> articlesAchetes = this.getArticlesAchetesUtilisateur(rs.getInt("no_utilisateur"));
		List<Enchere> encheres = this.getEncheresUtilisateur(rs.getInt("no_utilisateur"));*/
		
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
		utilisateur.setPseudo(rs.getString("pseudo"));
		utilisateur.setNom(rs.getString("nom"));
		utilisateur.setPrenom(rs.getString("prenom"));
		utilisateur.setEmail(rs.getString("email"));
		utilisateur.setTelephone(rs.getString("telephone"));
		utilisateur.setRue(rs.getString("rue"));
		utilisateur.setCodePostal(rs.getString("code_postal"));
		utilisateur.setVille(rs.getString("ville"));
		utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
		utilisateur.setCredit(rs.getInt("credit"));
		utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
		
		return utilisateur;
	
}
	
}
