package fr.eni.projetencheres.bll;

import java.util.List;

import fr.eni.projetencheres.BusinessException;
import fr.eni.projetencheres.bo.ArticleVendu;
import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.dal.DAOFactory;
import fr.eni.projetencheres.dal.UtilisateurDAO;
import fr.eni.projetencheres.dal.jdbc.UtilisateurDAOJDBCImpl;

public class UtilisateurManager2 {

	private static UtilisateurDAO utilisateurDAO = new UtilisateurDAOJDBCImpl();
	private static Utilisateur utilisateur = new Utilisateur();

	private static BusinessException businessException = new BusinessException();

	public UtilisateurManager2() {
		UtilisateurManager2.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	
	public Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, String confirmation) throws BusinessException {

		validerCoordonnees(utilisateur);


		if (!businessException.hasErreurs()) {
			utilisateurDAO.inserer(utilisateur);

		} else {

			throw businessException;
		}
		return utilisateur;
	}
	
	public static void modifierUtilisateur(Utilisateur utilisateur) throws BusinessException {

		modifierCoordonnees(utilisateur, businessException);

		if (!businessException.hasErreurs()) {
			utilisateurDAO.modifier(utilisateur);

		}

	}


	private static void validerCoordonnees(Utilisateur utilisateur) {

		if (utilisateur.getPseudo().trim().equals("") || utilisateur.getNom().trim().equals("")
				|| utilisateur.getPrenom().trim().equals("") || utilisateur.getEmail().trim().equals("")
				|| utilisateur.getRue().trim().equals("") || utilisateur.getCodePostal().trim().equals("")
				|| utilisateur.getVille().trim().equals("") || utilisateur.getMotDePasse().trim().equals("")) {

			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEURS_COORDONNEES_ERREUR);
		}
	}

	
	public static void modifierCoordonnees(Utilisateur utilisateur, BusinessException businessException) {

		if ( utilisateur.getNom().trim().equals("")
				|| utilisateur.getPrenom().trim().equals("") || utilisateur.getEmail().trim().equals("")
				|| utilisateur.getRue().trim().equals("") || utilisateur.getCodePostal().trim().equals("")
				|| utilisateur.getVille().trim().equals("") || utilisateur.getMotDePasse().trim().equals("")) {
			
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEURS_COORDONNEES_ERREUR);
		}

	}

	/*public static void ventesUtilisateur(List<ArticleVendu> articlesVendus) throws BusinessException {
		validerListeArticlesVendus(articlesVendus);
	}
	/*private static void validerListeArticlesVendus(List<ArticleVendu> articlesVendus) {
		if (utilisateur.getArticlesVendus() == null || utilisateur.getArticlesVendus().size() == 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEURS_ARTICLE_VENDU_ERREUR);
		}
	}
	private static void validerListeEncheres(List<Enchere> encheres) {
		if (utilisateur.getEncheres() == null || utilisateur.getEncheres().size() == 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEURS_ENCHERES_ERREUR);
		}
	}*/

	/*public static void encheresUtilisateur(List<Enchere> encheres) throws BusinessException {
		validerListeEncheres(encheres);
	}*/
	/*public static void achatsUtilisateur(List<ArticleVendu> articlesAchetes) throws BusinessException {
		validerListeArticlesAchetes(articlesAchetes);
	}*/

	/*private static void validerListeArticlesAchetes(List<ArticleVendu> articlesAchetes) {
		if (utilisateur.getArticlesAchetes() == null || utilisateur.getArticlesAchetes().size() == 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEURS_ARTICLE_ACHETE_ERREUR);
		}
	}*/

	public static Utilisateur selectUtilisateurParId(int id) throws BusinessException {
		return utilisateurDAO.getParId(id);

	}

	public static List<Utilisateur> selectTousLesUtilisateurs() throws BusinessException {
		return utilisateurDAO.getTousLesUtilisateurs();
	}

	public static Utilisateur selectUtilisateurParPseudo(String pseudo) throws BusinessException{
		return utilisateurDAO.getParPseudo(pseudo);
	}
	
	public static List<ArticleVendu> selectArticlesVendus ()throws BusinessException{
		return utilisateurDAO.getTousLesArticlesVendus(utilisateur);
	}
	
	public static List<String> selectTousLesPseudos() throws BusinessException{
		return utilisateurDAO.getTousLesPseudos();
	}
	
	public static void supprimerUtilisateur(int id) throws BusinessException{
		utilisateurDAO.supprimer(id);
	}


	public Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		// TODO Auto-generated method stub
		return null;
	}
}
	