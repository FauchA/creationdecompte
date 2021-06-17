package fr.eni.projetencheres.dal;

import java.util.List;

import fr.eni.projetencheres.BusinessException;
import fr.eni.projetencheres.bo.ArticleVendu;
import fr.eni.projetencheres.bo.Utilisateur;

public interface UtilisateurDAO {

	
	public Utilisateur inserer(Utilisateur utilisateur) throws BusinessException;

	public void modifier(Utilisateur utilisateur);

	public Utilisateur getParId(int id);

	public List<Utilisateur> getTousLesUtilisateurs() throws BusinessException;

	public Utilisateur getParPseudo(String pseudo);

	public List<ArticleVendu> getTousLesArticlesVendus(Utilisateur utilisateur);

	public List<String> getTousLesPseudos();

	public void supprimer(int id);
	
	
	

	
	
	

	
	
}
