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

<form role="form" method="post" action="./NouvelleVenteServlet">
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
					<img class="card-img-top" src="..." alt="imageVente" name="imageVente">
					<!-- Ajouter photo de uploader -->
				</div>
			</div>

			<div class="col-md-6">

				<div class="form-group">
					<label for="article"> Article </label> <input type="text"
						class="form-control" id="article" placeholder="Nom de l'article" name="article"
						required="required" />
				</div>

				<div class="form-group">
					<label for="description"> Description </label>
					<textarea class="form-control" id="description" name="description"
						placeholder="Description du produit" required="required"></textarea>
				</div>

				<div class="form-group">
					<label for="categorie"> Catégorie </label> <select
						class="form-control" id="categorie" name="categorie" required="required">
						<option>Informatique</option>
						<option>Ameublement</option>
						<option>Vêtement</option>
						<option>Sport / Loisirs</option>
					</select>
				</div>

				<!-- A travailler -->
				<div class="form-group">
					<label for="photo"> Photo de l'article&nbsp;&nbsp;&nbsp;&nbsp; </label>
					<button type="submit" class="btn btn-default btn-sm" id="photo" name="photo">
						Charger la photo</button>
				</div>
				<!-- A travailler -->

				<div class="form-group">
					<label for="miseAPrixArticle"> Mise à prix </label> <input
						type="number" class="form-control" id="miseAPrixArticle" name="miseAPrixArticle"/>
				</div>

				<div class="form-group">
					<label for="debutEnchere"> Début de l'enchère <!-- Attention conversion date -->
					</label> <input type="date" class="form-control" id="debutEnchere" name="debutEnchere"/>
				</div>

				<div class="form-group">
					<label for="finEnchere"> Fin de l'enchère <!-- Attention conversion date -->
					</label> <input type="date" class="form-control" id="finEnchere" name="finEnchere"/>
				</div>


				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Retrait</h5>
						<label for="rue">Rue</label>
						<div class="card">
							<input type="text"
						class="form-control" id="rue" placeholder="Numero et nom de la rue" name="rue"/>
						</div>
						<label for="codePostal">Code Postal</label>
						<div class="card">
							<input type="text"
						class="form-control" id="codePostal" placeholder="Saisir le code postal" name="codePostal"/>
						</div>
						<label for="ville">Ville</label>
						<div class="card">
							<input type="text"
						class="form-control" id="ville" placeholder="Nom de la ville" name="ville"/>
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
	</form>
</body>
</html>