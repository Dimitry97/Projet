<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>

<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>

<div class="text-center"><h3>Mon profil</h3></div><br>

	<c:if test="${ !empty sessionScope.pseudo }">		
		<h3>Profil de ${ sessionScope.pseudo }</h3>		
	</c:if>
	<span class="erreurs text-danger">${erreurs['supprimer']}</span>
	

<div class="container-fluid">

<form role="form" method="post" action="SupprimerOuModifierProfilServlet">
	<div class="col-md-2"></div>

	<div class="row">
		<div class="col-md-4">
			
			
				<div class="form-group">
					<label for="pseudo">
						Pseudo
					</label>
					<input type="text" class="form-control" id="pseudo" name="pseudo" 
					value="<c:if test="${ !empty champsProfil['pseudo'] }"><c:out value="${champsProfil['pseudo']}"/></c:if><c:if test="${ empty champsProfil['pseudo'] }"><c:out value="${param.pseudo}"/></c:if>">
					<span class="erreurs text-danger">${erreurs['pseudo']}</span>
				</div>
				
				<div class="form-group"> 
					<label for="prenom"> Prenom
					<span class="requis"></span>
					</label>
					<input type="text" class="form-control" id="prenom" name="prenom" 
					value="<c:if test="${ !empty champsProfil['prenom'] }"><c:out value="${champsProfil['prenom']}"/></c:if><c:if test="${ empty champsProfil['prenom'] }"><c:out value="${param.prenom}"/></c:if>">
					<span class="erreur text-danger">${erreurs['prenom']}</span>
				</div>
					 
				<div class="form-group"> 
					<label for="telephone"> Telephone
					</label>
					<input type="text" class="form-control" id="telephone" name="telephone"
					 value="<c:if test="${ !empty champsProfil['telephone'] }"><c:out value="${champsProfil['telephone']}"/></c:if><c:if test="${ empty champsProfil['telephone'] }"><c:out value="${param.telephone}"/></c:if>">
					<span class="erreur text-danger">${erreurs['telephone']}</span>
				</div>
					 
				<div class="form-group"> 
					<label for="codePostal"> Code Postal
					<span class="requis">*</span>
					</label>
					<input type="text" class="form-control" id="codePostal" name="codePostal"
					value="<c:if test="${ !empty champsProfil['codePostal'] }"><c:out value="${champsProfil['codePostal']}"/></c:if><c:if test="${ empty champsProfil['codePostal'] }"><c:out value="${param.codePostal}"/></c:if>">
					<span class="erreur text-danger">${erreurs['codePostal']}</span>
				</div>
				
				<div class="form-group"> 
					<label for="passwordActuel"> Mot de passe actuel</label>
					<!--  recuperer le mot de passe en bdd -->
					<input type="password" class="form-control" id="passwordActuel" name="password" value="">
					<span class="erreur text-danger">${erreurs['password']}</span>
				</div>
					 
				<div class="form-group"> 
					<label for="password"> Nouveau mot de passe
					<span class="requis">*</span>
					</label>
					<input type="password" class="form-control" id="password" name="password" value=""/>
				</div>
				
				<div class="form-group">
					<label for="credit">
						Crédit : 
						<c:if test="${ !empty champsProfil['credit'] }"><c:out value="${champsProfil['credit']}"/></c:if>
						<c:out value="${credit }"/>
					</label>
				</div>	 
				
		</div>
		
		
		<div class="col-md-4">
			
			
				<div class="form-group">
					<label for="nom"> Nom
					<span class="requis">*</span>
					</label>
					<input type="text" class="form-control" id="nom" name="nom"
					value="<c:if test="${ !empty champsProfil['nom'] }"><c:out value="${champsProfil['nom']}"/></c:if><c:if test="${ empty champsProfil['nom'] }"><c:out value="${param.nom}"/></c:if>">
					<span class="erreur text-danger">${erreurs['nom']}</span>
				</div>
				
				<div class="form-group">
					<label for="email"> Email
					<span class="requis">*</span>
						<!-- Vérifier si email déjà existant, sinon message alerte -->
					</label>
					<input type="email" class="form-control" id="email" name="email"
					value="<c:if test="${ !empty champsProfil['email'] }"><c:out value="${champsProfil['email']}"/></c:if><c:if test="${ empty champsProfil['email'] }"><c:out value="${param.email}"/></c:if>">
					<span class="erreur text-danger">${erreurs['email']}</span>
				</div>
				
				<div class="form-group">
					<label for="rue"> Rue
					<span class="requis">*</span>
					</label>
					<input type="text" class="form-control" id="rue" name="rue"
					value="<c:if test="${ !empty champsProfil['rue'] }"><c:out value="${champsProfil['rue']}"/></c:if><c:if test="${ empty champsProfil['rue'] }"><c:out value="${param.rue}"/></c:if>">
					<span class="erreur text-danger">${erreurs['rue']}</span>
				</div>	 
					
				<div class="form-group">
					<label for="ville"> Ville
					<span class="requis">*</span>
					</label>
					<input type="text" class="form-control" id="ville" name="ville"
					value="<c:if test="${ !empty champsProfil['ville'] }"><c:out value="${champsProfil['ville']}"/></c:if><c:if test="${ empty champsProfil['ville'] }"><c:out value="${param.ville}"/></c:if>">
					<span class="erreur text-danger">${erreurs['ville']}</span>
				</div>	 
				
				<!--  creer un champs vide pour saut de ligne -->
				<div><br><br><br><br></div>
				
				<div class="form-group">
					<label for="passwordVerif"> Confirmation de votre nouveau mot de passe
					<span class="requis">*</span>
						<!-- Saisie doit être identique à password -->
					</label>
					<input type="password" class="form-control" id="passwordVerif" name="passwordVerif" value=""/>
					<span class="erreur text-danger">${erreurs['passwordVerif']}</span>
				</div>	 
			
			
		</div>
		
		<div class="col-md-2"></div>
		
		
		<div class="col-md-12 form-row text-center">
			<div class="col-md-3"></div>
			 
			<div class="col-md-3">
				<button type="submit" class="btn btn-primary btn-lg" name="action" value="Update">
					Mettre à jour
					<!-- Mettre à jour la base de données -->
				</button>
			</div>	

			<div class="col-md-3">	
				<button type="submit" class="btn btn-danger btn-lg" name="action" value="Delete">
					Supprimer mon compte
					<!-- Supprime le compte de la base de données -->
				</button>	
			</div>
			
			<div class="col-md-3"></div>
			
		</div>
		</form>
	</div>
</div>


<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>
