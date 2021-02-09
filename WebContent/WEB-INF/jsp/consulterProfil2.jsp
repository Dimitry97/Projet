<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vente remportée</title>
</head>

<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>


<div class="container-fluid">

	<div class="row">
		<div class="col-md-12">
			<h3 class="text-center">Vous avez remporté la vente</h3>
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
				Récupérer la description de l'article (s'adapte à la taille de la
				description) </display>
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
						<label for="adresseRetrait"> Retrait </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control container-fluid"
							id="adresseRetrait"> Récupérer rue<br>
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

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="telVendeur"> Telephone </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="telVendeur">Récupérer
						tel vendeur</display>
					</div>
				</div>
			</div>

			<br> <br>



			<div class="col-md-6 form-row text-center">
				<button type="submit"
					class="btn btn-primary btn-lg btn-block active">Back</button>
			</div>
		</div>
	</div>




	<div class="col-md-3"></div>
</div>


</body>
</html>


<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>