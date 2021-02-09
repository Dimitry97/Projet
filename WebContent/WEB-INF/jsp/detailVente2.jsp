<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail vente</title>
</head>
<body>

	<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>


	<div class="container-fluid">

		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center">Détail vente</h3>
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
					<display type="text" class="form-control" id="article">Récupérer
					nom article</display>
				</div>

				<div class="form-group">
					<label for="description"> Description </label>
					<display class="form-control container-fluid" id="description">
					Récupérer la description de l'article 
					(s'adapte à la taille de la description) </display>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-md-6">
							<label for="categorieArticle"> Categorie </label>
						</div>
						<div class="col-md-6">
							<display type="text" class="form-control" id="categorieArticle">Récupérer
							categorie article</display>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-md-6">
							<label for="meilleureOffre"> Meilleure offre </label>
						</div>
						<div class="col-md-6">
							<display type="text" class="form-control" id="meilleureOffre">Récupérer
							meilleure offre</display>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-md-6">
							<label for="miseAPrix"> Mise à prix </label>
						</div>
						<div class="col-md-6">
							<display type="text" class="form-control" id="miseAPrix">Récupérer
							mise à prix</display>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-md-6">
							<label for="dateFinEnchere"> Fin de l'enchère </label>
						</div>
						<div class="col-md-6">
							<display type="text" class="form-control" id="dateFinEnchere">Récupérer
							date fin enchère</display>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-md-6">
							<label for="adresseRetrait"> Retrait </label>
						</div>
						<div class="col-md-6">
							<display type="text" class="form-control container-fluid" id="adresseRetrait">
							Récupérer rue<br>
							Récupérer codepostal et ville </display>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-md-6">
							<label for="pseudoVendeur"> Vendeur </label>
						</div>
						<div class="col-md-6">
							<display type="text" class="form-control" id="pseudoVendeur">Récupérer
							pseudo vendeur</display>
						</div>
					</div>
				</div>
				<br>
				<br>

				<div class="form-group">
					<div class="row">
						<div class="col-md-6">

							<label for="pseudoVendeur"> Ma proposition </label> <input
								type="number" class="form-control" id="miseAPrixArticle" />
						</div>


						<div class="col-md-6 form-row text-center">
							<button type="submit"
								class="btn btn-primary btn-lg btn-block active">
								Encherir</button>
						</div>
					</div>
				</div>




				<div class="col-md-3"></div>
			</div>
		</div>
	</div>


</body>
</html>