<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form role="form" method="post" action="./inscriptionServlet">
		<div class="row">
			<div class="col-md-4">


				<div class="form-group">
					<label for="pseudo"> Pseudo <span class="requis">*</span> <!-- Vérifier si pseudo déjà existant, sinon message alerte -->
					</label> <input type="text" class="form-control" id="pseudo" name="pseudo"
						value="" />
				</div>

				<div class="form-group">
					<label for="prenom"> Prenom <span class="requis">*</span>
					</label> <input type="text" class="form-control" id="prenom" name="prenom"
						value="" />
				</div>

				<div class="form-group">
					<label for="telephone"> Telephone </label> <input type="text"
						class="form-control" id="telephone" name="telephone" value="" />
				</div>

				<div class="form-group">
					<label for="codePostal"> Code Postal <span class="requis">*</span>
					</label> <input type="text" class="form-control" id="codePostal"
						name="codePostal" value="" />
				</div>

				<div class="form-group">
					<label for="password"> Mot de passe <span class="requis">*</span>
					</label> <input type="password" class="form-control" id="password"
						name="password" value="" />
				</div>


			</div>


			<div class="col-md-4">


				<div class="form-group">
					<label for="nom"> Nom <span class="requis">*</span>
					</label> <input type="text" class="form-control" id="nom" name="nom"
						value="" />
				</div>

				<div class="form-group">
					<label for="email"> Email <span class="requis">*</span> <!-- Vérifier si email déjà existant, sinon message alerte -->
					</label> <input type="email" class="form-control" id="email" name="email"
						value="" />
				</div>

				<div class="form-group">
					<label for="rue"> Rue <span class="requis">*</span>
					</label> <input type="text" class="form-control" id="rue" name="rue"
						value="" />
				</div>

				<div class="form-group">
					<label for="ville"> Ville <span class="requis">*</span>
					</label> <input type="text" class="form-control" id="ville" name="ville"
						value="" />
				</div>

				<div class="form-group">
					<label for="passwordVerif"> Confirmation mot de passe <span
						class="requis">*</span> <!-- Saisie doit être identique à password -->
					</label> <input type="password" class="form-control" id="passwordVerif"
						name="passwordVerif" value="" />
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