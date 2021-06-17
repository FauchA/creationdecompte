<%@page import="fr.eni.projetencheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.projetencheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="css/creationCompte.css">
  <link rel="stylesheet" href="css/projet.css">
 
<title>Page de création de compte</title>

</head>

<body>
<!-- si l'utilisateur clique sur "confirmer" et que la création du compte est validée, 
l'utilisateur passe en mode connecté et on le dirige vers la page d'accueil -->


<!--  Au contraire, s'il clique sur "annuler", la création de compte est annulée et l'utilisateur 
revient sur la page d'accueil  -->


<!--  formulaire de création de compte -->

<h2>Mon profil</h2>

<%
		Utilisateur utilisateur = (Utilisateur)request.getAttribute("utilisateur");
		if(utilisateur!=null)
		{
	%>
			<p style="color:red;">Le compte a été créé avec succès :</p>
			<p><%=utilisateur%></p>
	<%	
		} 
	%>
	
	<%
		List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur");
		if(listeCodesErreur!=null)
		{
	%>
			<p style="color:red;">Erreur. Le compte n'a pas été créé :</p>
	<%
			for(int codeErreur:listeCodesErreur)
			{
	%>
				<p><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
	<%	
			}
		}
	%>

 
<section>
	<div class="">
	
	<form name = "monformulaire" action ="<%=request.getContextPath()%>/ServletAjoutUtilisateur1" method="post">

<div class="un">
<label for = "pseudo">Pseudo</label>
<input type="text" type="number" name="pseudo" id="pseudo" placeholder="Entrez votre pseudo" size="30" value="<%=listeCodesErreur!=null?request.getParameter("pseudo"):""%>" autofocus required />
</div>

<div class=deux">
<label for = "nom">Nom</label>
<input type="text" name="nom" id="nom" placeholder="Entrez votre nom" size="30" value="<%=listeCodesErreur!=null?request.getParameter("nom"):""%>" autofocus required/>
</div>

<div class="trois">
<label for = "prenom">Prénom</label>
<input type="text" name="prenom" id="prenom" placeholder="Entrez votre prénom" size="30" value="<%=listeCodesErreur!=null?request.getParameter("prenom"):""%>" autofocus required/>
</div>

<div class="quatre">
<label for = "email">Email</label>
<input type="text" name="email" id="email" placeholder="Entrez votre email" size="30" maxlength="100" value="<%=listeCodesErreur!=null?request.getParameter("email"):""%>" autofocus required/>
</div>

<div class="cinq">
<label for = "telephone">Téléphone</label>
<input type="number" name="telephone" id="telephone" placeholder="Entrez votre n° de téléphone" 
size="30" maxlength="10" value="<%=listeCodesErreur!=null?request.getParameter("telephone"):""%>" autofocus required/>
</div>

<div class="six">
<label for = "rue">Rue</label>
<input type="text" type="number" name="rue" id="rue" placeholder="Entrez le n° et le nom de votre rue" size="30" value="<%=listeCodesErreur!=null?request.getParameter("rue"):""%>" autofocus required/>
</div>

<div class="sept">
<label for = "codepostal">Code postal</label>
<input type="number" name="codepostal" id="codepostal" placeholder="Entrez votre code postal" size="10" maxlength="5" value="<%=listeCodesErreur!=null?request.getParameter("codePostal"):""%>"autofocus required/>
</div>

<div class="huit">
<label for = "ville">Ville</label>
<input type="text" name="ville" id="ville" placeholder="Entrez le nom de votre ville" size="30" value="<%=listeCodesErreur!=null?request.getParameter("ville"):""%>"autofocus required/>
</div>

<div class="neuf">
<label for = "motdepasse">Mot de passe</label>
<input type="password" type ="number" name="motdepasse" id="motdepasse" placeholder="Entrez votre mot de passe (entre 8 et 15 caractères)" 
 maxlength="15" size="40" value="<%=listeCodesErreur!=null?request.getParameter("motDePasse"):""%>" autofocus required/> <!-- je n'arrive pas à mettre un minlength="8" -->
</div>

<div class="dix">
<label for = "motdepassebis">Confirmation</label>
<input type="password" type="number" name="motdepassebis" id="motdepassebis" placeholder="Confirmer votre mot de passe" size="30" value="<%=listeCodesErreur!=null?request.getParameter("motdepassebis"):""%>" autofocus required/>
</div>

</div>

</form>


</section>





<form name="creerCompte" action ="ServletConnexion">
          		<button type="submit">Créer</button>
				<button type="submit">Annuler</button>
          		
        
				</form>
		
<br>
<a href="<%=request.getContextPath()%>/ServletAccueilNonConnectee">Retour à la page d'accueil</a>
<!--  revoir ce lien -->

</body>
</html>