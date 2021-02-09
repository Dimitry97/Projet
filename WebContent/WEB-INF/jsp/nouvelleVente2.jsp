<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle vente</title>
</head>
<body>

	<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>


	<div class="container-fluid">

		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center">Nouvelle vente</h3>
			</div>
		</div>
		<br>

		<div class="row">
			<div class="col-md-3">
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src="..." alt="imageVente">
					<!-- Ajouter photo de uploader -->
				</div>
			</div>

			<div class="col-md-6">

				<div class="form-group">
					<label for="article"> Article </label> <input type="text"
						class="form-control" id="article" placeholder="Nom de l'article"
						required="required" />
				</div>

				<div class="form-group">
					<label for="description"> Description </label>
					<textarea class="form-control" id="description"
						placeholder="Description du produit" required="required"></textarea>
				</div>

				<div class="form-group">
					<label for="categorie"> Catégorie </label> <select
						class="form-control" id="categorie" required="required">
						<option>Informatique</option>
						<option>Ameublement</option>
						<option>Vêtement</option>
						<option>Sport / Loisirs</option>
					</select>
				</div>

				<!-- A travailler -->
				<div class="form-group">
					<label for="photo"> Photo de l'article&nbsp;&nbsp;&nbsp;&nbsp; </label>
					<button type="submit" class="btn btn-default btn-sm" id="photo">
						Charger la photo</button>
				</div>
				<!-- A travailler -->

				<div class="form-group">
					<label for="miseAPrixArticle"> Mise à prix </label> <input
						type="number" class="form-control" id="miseAPrixArticle" />
				</div>

				<div class="form-group">
					<label for="debutEnchere"> Début de l'enchère <!-- Attention conversion date -->
					</label> <input type="date" class="form-control" id="debutEnchere" />
				</div>

				<div class="form-group">
					<label for="finEnchere"> Fin de l'enchère <!-- Attention conversion date -->
					</label> <input type="date" class="form-control" id="finEnchere" />
				</div>


				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Retrait</h5>
						<label for="article">Rue</label>
						<div class="card">
							<h7 class="card-title text-align">Inserer rue vendeur</h7>
						</div>
						<label for="article">Code Postal</label>
						<div class="card">
							<h7 class="card-title text-align">Inserer code postal
							vendeur</h7>
						</div>
						<label for="article">Ville</label>
						<div class="card">
							<h7 class="card-title text-align">Inserer ville vendeur</h7>
						</div>
					</div>


					</div>

					<div class="col-md-3"></div>


					<div class="col-md-12 form-row">
						<div class="col-md-3"></div>

						<div class="col-md-3">
							<button type="submit" class="btn btn-primary btn-lg pull-right">
								Enregistrer
								<!-- Ajout utilisateur dans la base de données -->
							</button>
						</div>

						<!-- Pas de sens doublon avec annuler -->
						<div class="col-md-3">
							<button type="submit" class="btn btn-primary btn-lg pull-left">
								Annuler la vente</button>
						</div>

						<div class="col-md-3"></div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>