<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <link rel="stylesheet" href="css/connexion.css">
 <link rel="stylesheet" href="css/projet.css"> 


<title>Page de connexion</title>
</head>

<body>

<!--  TODO : SI MON PSEUDO OU MDP EST VIDE, J AFFICHE "IDENTIFIANTS INCORRECTS" -->
<p>${ !empty p ? p : ''} </p>


 <!-- <nav class="navbar"> -->
  <div class="titre">Eni-Enchères</div>



<form name="maconnexion" action="<%=request.getContextPath() %>/ServletConnexion" method="post">
            <div class="formulaire" >
            <fieldset>
                <!-- Le fieldset permet de faire un encadré et de mettre une légende sur les bordures de l'encadré-->
                <legend> SE CONNECTER </legend>
     			<label for = "pseudo">Identifiant : </label>
				<input type="text" name="pseudo" id="pseudo" placeholder="Pseudo ou adresse e-mail" size="30" autofocus required/> <br>
				
	
				
			<label for = "mdp">Mot de passe : </label>
			<input type="password" name="mdp" id="motDePasse" placeholder="Mot de passe" size="30" autofocus required/><br>	
				
				<label for = "souvenir">Se souvenir de moi</label>
				<input type="checkbox" name="souvenir" id="souvenir"/><br>
				
				<p> <a href="#">Mot de passe oublié?</a></p> <br>
				
				
				</div>
</form>

<div class="formulaire">
<form name="connexion" action ="ServletAccueilConnecté" method="post">
<!-- <a href ="<%=request.getContextPath() %>/ServletAjoutUtilisateur"> -->
          		<button type="submit">Connexion</button>
        
				</form>
			
				
            </fieldset>


<form name="creerCompte" action ="ServletAjoutUtilisateur1">
<!-- <a href ="<%=request.getContextPath() %>/ServletAjoutUtilisateur"> -->
          		<button type="submit">Créer un compte</button>
        
				</form>
		</div>
		
		





</body>
</html>

