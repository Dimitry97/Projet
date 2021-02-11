<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer profil</title>
</head>

<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>

<div class="text-center">
	<h3>Mon profil</h3>
</div>
<br>

<div class="container-fluid">
	<div class="col-md-2"></div>
	<form role="form" method="post" action="./servlets/inscriptionServlet">
		<div class="row">
			<div class="col-md-4">
				
				<div class="form-group">
					<label for="pseudo"> Pseudo <span class="requis">*</span> <!-- Vérifier si pseudo déjà existant, sinon message alerte -->
					</label> <input type="text" class="form-control" id="pseudo" name="pseudo"
						 value="<c:out value="${param.pseudo}"/>">
					<span class="erreurs text-danger">${erreurs['pseudo']}</span>
				</div>

				<div class="form-group">
					<label for="prenom"> Prenom <span class="requis">*</span>
					</label> <input type="text" class="form-control" id="prenom" name="prenom"
						value="<c:out value="${param.prenom}"/>" />
						<span class="erreur text-danger">${erreurs['prenom']}</span>
				</div>

				<div class="form-group">
					<label for="telephone"> Telephone </label> <input type="text"
						class="form-control" id="telephone" name="telephone" value="<c:out value="${param.telephone}"/>" />
						<span class="erreur text-danger">${erreurs['telephone']}</span>
				</div>

				<div class="form-group">
					<label for="codePostal"> Code Postal <span class="requis">*</span>
					</label> <input type="text" class="form-control" id="codePostal"
						name="codePostal" value="<c:out value="${param.codePostal}"/>" />
						<span class="erreur text-danger">${erreurs['codePostal']}</span>
				</div>

				<div class="form-group">
					<label for="password"> Mot de passe <span class="requis">*</span>
					</label> <input type="password" class="form-control" id="password"
						name="password" value="" />
						<span class="erreur text-danger">${erreurs['password']}</span>
				</div>


			</div>


			<div class="col-md-4">


				<div class="form-group">
					<label for="nom"> Nom <span class="requis">*</span>
					</label> <input type="text" class="form-control" id="nom" name="nom"
						value="<c:out value="${param.nom}"/>" />
						<span class="erreur text-danger">${erreurs['nom']}</span>
				</div>

				<div class="form-group">
					<label for="email"> Email <span class="requis">*</span> <!-- Vérifier si email déjà existant, sinon message alerte -->
					</label> <input type="email" class="form-control" id="email" name="email"
						value="<c:out value="${param.email}"/>" />
						<span class="erreur text-danger">${erreurs['email']}</span>
				</div>

				<div class="form-group">
					<label for="rue"> Rue <span class="requis">*</span>
					</label> <input type="text" class="form-control" id="rue" name="rue"
						value="<c:out value="${param.rue}"/>" />
						<span class="erreur text-danger">${erreurs['rue']}</span>
				</div>

				<div class="form-group">
					<label for="ville"> Ville <span class="requis">*</span>
					</label> <input type="text" class="form-control" id="ville" name="ville"
						value="<c:out value="${param.ville}"/>" />
						<span class="erreur text-danger">${erreurs['ville']}</span>
				</div>

				<div class="form-group">
					<label for="passwordVerif"> Confirmation mot de passe <span
						class="requis">*</span> <!-- Saisie doit être identique à password -->
					</label> <input type="password" class="form-control" id="passwordVerif"
						name="passwordVerif" value="<c:out value="${param.password}"/>" />
						<span class="erreur text-danger">${erreurs['password']}</span>
				</div>


			</div>

			<div class="col-md-2"></div>


			<div class="col-md-12 form-row text-center">
				<div class="col-md-3"></div>

				<div class="col-md-3">
					<button type="submit" class="btn btn-primary btn-lg">
						Créer
						<!-- Ajout utilisateur dans la base de données -->
					</button>
				</div>

				<div class="col-md-3">
					<!-- lien à modifier pour retour à la page d'accueil -->
					<a href="./jsp/accueil" role="button"
						class="btn btn-primary btn-lg"> Annuler </a>
					<!-- retour à la page d'accueil -->
				</div>

				<div class="col-md-3"></div>
			</div>
		</div>
	</form>
</div>


<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>