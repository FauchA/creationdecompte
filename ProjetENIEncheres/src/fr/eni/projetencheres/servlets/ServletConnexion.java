/*package fr.eni.projetencheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetencheres.BusinessException;
import fr.eni.projetencheres.bll.UtilisateurManager2;
import fr.eni.projetencheres.bo.Utilisateur;


/**
 * Servlet implementation class ServletConnexion
 */
/*@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/connexion.jsp"); 
		rd.forward(request, response);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("/connexion.jsp"); 
		rd.forward(request, response);
		
		PrintWriter out= response.getWriter();

		
		HttpSession session = request.getSession(); 
		
		String erreur = null;

		/*String connected = " "; 
		if (session.getAttribute("connecté")!=null) {
			
			connected = (String)session.getAttribute("connecté"); 
			session.setAttribute("connecté", connected);
			
			RequestDispatcher rd1 = request.getRequestDispatcher("/accueilConnectee.jsp");
			rd1.forward(request, response);*/
			
			
			
			/*String p = request.getParameter("pseudo");
			String mdp = request.getParameter ("motDePasse"); 
			request.setAttribute("pseudo", p);
			request.setAttribute("motDePasse", mdp);
			
			
			try {
				
				//Valider pseudo utilisateur, verification si il est bien dans la bdd
				Utilisateur utilisateur = UtilisateurManager2.selectUtilisateurParPseudo(p);
				//Si la connexion est reussie
				if(utilisateur!= null && mdp.equals(utilisateur.getMotDePasse())) {
					request.getSession().setAttribute("connecté", utilisateur);
					
					this.getServletContext().getRequestDispatcher("/ServletAccueilConnecté").forward(request, response);
					
				} else {
					request.setAttribute("erreur", "pseudo et/ou mot de passe incorrect(s)! Veuillez ressaisir vos identifiants...");
					erreur = (String) session.getAttribute("erreur");
					out.println(erreur);
					this.getServletContext().getRequestDispatcher("/ServletConnexion").forward(request, response);
				}
			} catch (BusinessException e) {
				request.setAttribute("erreur", e);
				this.getServletContext().getRequestDispatcher("/ServletErreurPage").forward(request, response);
			}
		
		
		}
		
	
	

			//Utilisateur utilisateur = null;
			//Valider pseudo utilisateur, verification si il est bien dans la bdd
		//	Utilisateur utilisateur = UtilisateurManager2.selectUtilisateurParPseudo(p);
			//Si la connexion est reussie
			//if(utilisateur!= null && mdp.equals(utilisateur.getMotDePasse())) {
			//	request.getSession().setAttribute("connecté", connected);
				
			//	this.getServletContext().getRequestDispatcher("/ServletAccueilConnecté").forward(request, response);
				
		
		
		
	}*/









package fr.eni.projetencheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetencheres.BusinessException;
import fr.eni.projetencheres.bll.UtilisateurManager2;
import fr.eni.projetencheres.bo.Utilisateur;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.naming.Context;




/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletConnexion")

public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/connexion.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/connexion.jsp");
		rd.forward(request, response);
       	
		PrintWriter out= response.getWriter();
		
		String erreur = null;
		
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("mdp");
		
		HttpSession session = request.getSession();
		//je mets en mémoire le pseudo et le mot de passe
		//pour ne pas que l'utilisateur l ecrive à
		session.setAttribute("pseudo", pseudo);
		
		
		if(pseudo.length()==0 || pseudo.isEmpty()){
				
			//cr�ation de l'erreur
			request.setAttribute("erreur", "pseudo non renseigné. Veuillez le saisir...");
			erreur = (String) session.getAttribute("erreur");
			out.println(erreur);
			
			//redirection vers la page de connexion pour saisir le login
			this.getServletContext().getRequestDispatcher("/ServletConnexion").forward(request, response);
			
			
		}else if(motDePasse.length()==0 || motDePasse.isEmpty()) {
				
			//cr�ation de l'erreur
			request.setAttribute("erreur", "mot de passe non renseign�. Veuillez le saisir...");
			erreur = (String) session.getAttribute("erreur");
			out.println(erreur);
			//redirection vers la page de connexion pour saisir le login
			this.getServletContext().getRequestDispatcher("/ServletConnexion").forward(request, response);
			
		}else {
			
			try {
		
				//Valider pseudo utilisateur, verification si il est bien dans la bdd
				Utilisateur user = UtilisateurManager2.selectUtilisateurParPseudo(pseudo);
				//Si la connexion est reussie
				if(user!= null && motDePasse.equals(user.getMotDePasse())) {
					request.getSession().setAttribute("ConnectedUser", user);
					
					this.getServletContext().getRequestDispatcher("/ServletAccueilConnecté").forward(request, response);
					
				} else {
					request.setAttribute("erreur", "pseudo et/ou mot de passe incorrect(s)! Veuillez ressaisir vos identifiants...");
					erreur = (String) session.getAttribute("erreur");
					out.println(erreur);
					this.getServletContext().getRequestDispatcher("/ServletConnexion").forward(request, response);
				}
			} catch (BusinessException e) {
				request.setAttribute("erreur", e);
				this.getServletContext().getRequestDispatcher("/ServletErreurPage").forward(request, response);
			}
		
		}

	}
}

