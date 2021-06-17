package fr.eni.projetencheres.bo;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {

	private String resultat;
	
	
	//méthode permettant de vérifier la connexion utilisateur 
	public void verifierIdentifiant (HttpServletRequest request) {
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		
		if (mdp.equals(pseudo + "123")) {
			
			resultat = "vous êtes bien connecté ! ";
		}
		else {
			
			resultat = "Identifiants incorrects";
		}	
	}
	

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	} 
	
	
	
	
	
}
