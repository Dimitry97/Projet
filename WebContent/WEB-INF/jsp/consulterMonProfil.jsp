<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>


<div class="container-fluid">

	<div class="row">
		<div class="col-md-12">
			<h3 class="text-center">Profil</h3>
		</div>
	</div>
	<br>

	<div class="row">
		<div class="col-md-3"></div>

		<div class="col-md-6">

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="pseudo"> Pseudo </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="pseudo">Récupérer
						Pseudo</display>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="nom"> Nom </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="nom">Récupérer
						nom</display>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="email"> Email </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="email">Récupérer
						email</display>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="telephone"> Telephone </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="telephone">Récupérer
						telephone</display>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="rue"> Rue </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="rue">Récupérer
						rue</display>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="codePostal"> Code Postal </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="codePostal">Récupérer
						Code Postal</display>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="ville"> Ville </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="ville">Récupérer
						ville</display>
					</div>
				</div>
			</div>
			<br>


			<div class="row">
				<div class="col-md-12 text-center">

					<button type="submit" class="btn btn-primary btn-lg">
						Modifier
						<!-- Renvoi sur la page monProfil.jsp -->
					</button>

				</div>
			</div>



			<div class="col-md-3"></div>
		</div>
	</div>
</div>


</body>
</html>


<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>