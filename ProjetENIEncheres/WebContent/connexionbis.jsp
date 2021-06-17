<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page de connexion</title>
</head>

<body>




<form name="maconnexion" action="">
            
            <fieldset>
                <!-- Le fieldset permet de faire un encadré et de mettre une légende sur les bordures de l'encadré-->
                <legend> SE CONNECTER </legend>
     			<label for = "identifiant">Identifiant : </label>
				<input name="identifiant" id="identifiant" placeholder="Pseudo ou adresse e-mail" size="100" autofocus required/> <br>
				
	
				
				<label for = "mdp">Mot de passe : </label>
				<input type="password" name="mdp" id="mdp" placeholder="Mot de passe" size="100" autofocus required/><br>
				
				<label for = "souvenir">Se souvenir de moi</label>
				<input type="checkbox" name="souvenir" id="souvenir"/><br>
				
				<p> <a href="#">Mot de passe oublié?</a></p> <br>
				
				<button type="submit">Connexion</button><br>
				
            </fieldset>

</form>

<form name="creerCompte" action ="<%=request.getContextPath() %>/ServletAjoutUtilisateur1" method="post">
<a href ="<%=request.getContextPath() %>/ServletAjoutUtilisateur1">
          		<button type="submit">Créer un compte</button>
        
				</form>
		
		
		

		






</body>
</html>
		
		