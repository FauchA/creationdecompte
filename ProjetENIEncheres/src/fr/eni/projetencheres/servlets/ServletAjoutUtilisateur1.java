package fr.eni.projetencheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.eni.projetencheres.BusinessException;
import fr.eni.projetencheres.bll.UtilisateurManager2;
import fr.eni.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletAjoutUtilisateur1
 */
@WebServlet("/ServletAjoutUtilisateur1")
public class ServletAjoutUtilisateur1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/CreationDeCompte.jsp"); 
		rd.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");

		String pseudo;
		String nom;
		String prenom;
		String email;
		String telephone;
		String rue;
		String codePostal;
		String ville;
		String motDePasse;
		String confirmation;

		try
		{
			 pseudo = request.getParameter("pseudo");
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			email = request.getParameter("email");
			telephone = request.getParameter("telephone");
			rue = request.getParameter("rue");
			codePostal = request.getParameter("codePostal");
			ville = request.getParameter("ville");
			motDePasse = request.getParameter("motDePasse");
			confirmation = request.getParameter("confirmation");
			
			UtilisateurManager2 utilisateurManager = new UtilisateurManager2();
			Utilisateur utilisateur = utilisateurManager.creerUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, confirmation);

			request.setAttribute("utilisateur", utilisateur);

			
			
			request.setAttribute("pseudo", pseudo);
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("email", email);
			request.setAttribute("telephone", telephone);
			request.setAttribute("rue", rue);
			request.setAttribute("codepostal", codePostal);
			request.setAttribute("ville", ville);
			request.setAttribute("motdepasse", motDePasse);
			request.setAttribute("confirmation", confirmation);


		
		
		}
		catch(NumberFormatException e)
		{
			List<Integer> listeCodesErreur=new ArrayList<>();
			listeCodesErreur.add(CodesResultatServlets.ERREUR_SAISIE_FORMULAIRE);
			request.setAttribute("listeCodesErreur",listeCodesErreur);
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListCodesErreur());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/CreationDeCompte.jsp");
		rd.forward(request, response);
		

		//String pseudo = request.getParameter("pseudo");
		//String nom = request.getParameter("nom");
		//String prenom = request.getParameter("prenom");
		//String email = request.getParameter("email");
		//String telephone = request.getParameter("telephone");
		//String rue = request.getParameter("rue");
		//String codePostal = request.getParameter("codePostal");
		//String ville = request.getParameter("ville");
		//String motDePasse = request.getParameter("motDePasse");
		//String confirmation = request.getParameter("confirmation");
		

		//request.setAttribute("pseudo", pseudo);
		//request.setAttribute("nom", nom);
		//request.setAttribute("prenom", prenom);
		//request.setAttribute("email", email);
		//request.setAttribute("telephone", telephone);
		//request.setAttribute("rue", rue);
		//request.setAttribute("codepostal", codePostal);
		//request.setAttribute("ville", ville);
		//request.setAttribute("motdepasse", motDePasse);
		//request.setAttribute("confirmation", confirmation);


		
		//UtilisateurManager2 utilisateurManager2 = new UtilisateurManager2();
		//Utilisateur utilisateur = null;
		//try {
		//	utilisateur = utilisateurManager2.creerUtilisateur(pseudo,nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
		//} catch (BusinessException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//request.setAttribute("utilisateur", utilisateur);
	//}
       
		
	}


}
