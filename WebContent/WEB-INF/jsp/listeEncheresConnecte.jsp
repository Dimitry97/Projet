<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des enchères connecté</title>
</head>

<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>

<body>

	<div class="container-fluid">

		<div class="text-center">
			<h3>Liste des enchères</h3>
		</div>
		<br>

		<div class="row">
			<div class="col-md-1"></div>


			<div class="col-md-5">

				<div class="form-group">
					<label for="article"> Filtres </label> <input type="text"
						class="form-control" id="article"
						placeholder="Le nom de l'article contient ..." />
				</div>

				<div class="form-group">
					<label for="categorie"> Catégorie </label> <select
						class="form-control" id="categorie">
						<option>Informatique</option>
						<option>Ameublement</option>
						<option>Vêtement</option>
						<option>Sport / Loisirs</option>
					</select>
				</div>
			</div>

			<div class="col-md-5">
				<br> <br> <br>
				<!-- A modifier -->
				
				
				<div class="row col-md-12">
					<button type="submit" name="rechercher" id="rechercher"
						role="button" class="btn btn-primary btn-lg btn-block active">
						Rechercher</button>
				</div>
				
			</div>
		</div>


	</div>

	<form name="choix">
		<div class="row container-fluid row col-md-12">
			<script type="text/javascript">
					window.onload = function(){
						  var radios = document.getElementsByName("choix");                 // récupération des radio
						  for(i=0;i<radios.length;i++){                                     // boucle sur tous
						    if(radios[i].checked)                                           // si le radio est coché,
						    	document.getElementById("venteEnCours" + radios[i].id).disabled = true; // griser le select correspondant
						    	document.getElementById("ventesNonDebutees" + radios[i].id).disabled = true;	
						    	document.getElementById("ventesTerminees" + radios[i].id).disabled = true;
						  } else {
							    	document.getElementById("encheresOuvertes" + radios[i].id).disabled = true; // griser le select correspondant
							    	document.getElementById("mesEncheres" + radios[i].id).disabled = true;	
							    	document.getElementById("mesEncheresRemportees" + radios[i].id).disabled = true;
						  }
						
					
// 					function grise(){
// 							if(document.getElementById ('btnRadioAchats').checked){
// 						        document.getElementById("encheresOuvertes").disabled = false;
// 						        document.getElementById("mesEncheres").disabled = false;
// 						        document.getElementById("mesEncheresRemportees").disabled = false;
// 						        document.getElementById("venteEnCours").disabled = true;
// 						        document.getElementById("ventesNonDebutees").disabled = true;
// 						        document.getElementById("ventesTerminees").disabled = true;

// 						    }else if(document.getElementById('btnRadioVentes').checked){
// 						    	document.getElementById("encheresOuvertes").disabled = true;
// 						        document.getElementById("mesEncheres").disabled = true;
// 						        document.getElementById("mesEncheresRemportees").disabled = true;
// 						        document.getElementById("venteEnCours").disabled = false;
// 						        document.getElementById("ventesNonDebutees").disabled = false;
// 						        document.getElementById("ventesTerminees").disabled = false;
// 						    }
// 						}
						</script>
			<div class="col-md-1"></div>
			<div class="col-md-3">

				<div class="choix">
					<input type="radio" name="choix" id="btnRadioAchats" value="Achats" checked onclick="grise(this)">
						<label>Achats</label><br>
						
					<input type="checkbox" id="encheresOuvertes" name="encheresOuvertes"> 
						<label for="encheresOuvertes"> enchères ouvertes </label><br> 
					<input type="checkbox" id="mesEncheres" name="mesEncheres">
						<label for="mesEncheres"> mes enchères </label><br> 
					<input type="checkbox" id="mesEncheresRemportees" name="mesEncheresRemportees">
						<label for="mesEncheresRemportees"> mes enchères remportées </label><br>	
				</div>
				
			</div>


				<div class="choix">
					<input type="radio" name="choix" id="btnRadioVentes" value="Mes ventes" checked onclick="grise(this)">
					<Label>Mes ventes</Label><br>
					
					<input type="checkbox" id="venteEnCours" name="venteEnCours">
						<label for="venteEnCours"> mes ventes encours </label><br>
					<input type="checkbox" id="ventesNonDebutees" name="ventesNonDebutees">
						<label for="ventesNonDebutees"> ventes non débutées </label><br>
					<input type="checkbox" id="ventesTerminees" name="ventesTerminees">
						<label for="ventesTerminées"> ventes terminées </label><br>

			</div>

			<div class="col-md-1"></div>
		</div>
	</form>






	<div class="row justify-content-center col-md-12">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			
			<c:if test="${empty listeArticlesEnVente}">
				<div class="card-body">
					<article>Aucun article ne correspond à votre
						recherche</article>
				</div>
			</c:if>

			<c:if test="${!empty listeArticlesEnVente}">
				
				<c:forEach var="ArticleVendu" items="${listeArticlesEnVente }">
					<div class="card-body">
						<article>
							<p>No article : ${ArticleVendu.noArticle }</p>
							<p>Article : ${ArticleVendu.nomArticle }</p>
							<p>Description : ${ArticleVendu.description }</p>
							<p>Prix de vente : ${ArticleVendu.prixVente }</p>
							<p>Fin de l'enchere : ${ArticleVendu.dateFinEncheres }</p>
						</article>
						
					</div>
				</c:forEach>
				
			</c:if>
		</div>
		<div class="col-md-1"></div>
	</div>




	<div class="col-md-1"></div>




</body>
</html>