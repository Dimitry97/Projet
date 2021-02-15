<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des enchères connecté</title>
</head>
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


				<div class="row">
					<div class="col-md-6">
						<div class="form-group row">
							<input class="form-check-input" type="radio" class="col-sm-2" name="btnRadioAchats" id="btnRadioAchats" >&nbsp; Achats
						</div>
						<br>
						<div class="col-sm-12">
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									id="encheresOuvertes" name="encheresOuvertes" onClick="btnRadioVentes.disabled"> 
									<label class="form-check-label"
									for="encheresOuvertes"> enchères ouvertes </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="mesEncheres" name="mesEncheres" onClick="btnRadioVentes.disabled">
								<label class="form-check-label" for="mesEncheres"> mes
									enchères </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									id="mesEncheresRemportees" name="mesEncheresRemportees" onClick="btnRadioVentes.disabled"> 
									<label
									class="form-check-label" for="mesEncheresRemportees">
									mes enchères remportées </label>
							</div>
						</div>
					</div>


					<div class="col-md-6">
						<div class="form-group row">
							<input class="form-check-input" type="radio" class="col-sm-2" name="btnRadioVentes" id="btnRadioVentes">&nbsp; Mes
							ventes
						</div>
						<br>
						<div class="col-sm-12">
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									id="venteEnCours" name="venteEnCours"  onClick="btnRadioVentes.disabled"> <label class="form-check-label"
									for="venteEnCours"> mes ventes encours </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									id="ventesNonDebutees" name="ventesNonDebutees" onClick="btnRadioVentes.disabled"> <label class="form-check-label"
									for="ventesNonDebutees"> ventes non débutées </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									id="ventesTerminées" name="ventesTerminées" onClick="btnRadioVentes.disabled"> <label class="form-check-label"
									for="ventesTerminées"> ventes terminées </label>
							</div>
						</div>

					</div>
				</div>
			</div>


			<div class="col-md-5">
				<br> <br> <br>
				<!-- A modifier -->
				<div class="row">
					<button type="submit" name="rechercher" id="rechercher" role="button"
						class="btn btn-primary btn-lg btn-block active"> Rechercher </button>

				</div>
			</div>


			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10"><br>
					<div class="carousel slide" id="carousel-709174">
						<ol class="carousel-indicators">
							<li data-slide-to="0" data-target="#carousel-709174"
								class="active"></li>
							<li data-slide-to="1" data-target="#carousel-709174"></li>
							<li data-slide-to="2" data-target="#carousel-709174"></li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img class="d-block w-100" alt="Carousel Bootstrap First"
									src="https://www.layoutit.com/img/sports-q-c-1600-500-1.jpg" />
								<div class="carousel-caption">
									<h4>Récuperer nom article 1</h4>

								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" alt="Carousel Bootstrap Second"
									src="https://www.layoutit.com/img/sports-q-c-1600-500-2.jpg" />
								<div class="carousel-caption">
									<h4>Récuperer nom article 2</h4>

								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" alt="Carousel Bootstrap Third"
									src="https://www.layoutit.com/img/sports-q-c-1600-500-3.jpg" />
								<div class="carousel-caption">
									<h4>Récuperer nom article 3</h4>

								</div>
							</div>
						</div>
						<a class="carousel-control-prev" href="#carousel-709174"
							data-slide="prev"><span class="carousel-control-prev-icon"></span>
							<span class="sr-only">Previous</span></a> <a
							class="carousel-control-next" href="#carousel-709174"
							data-slide="next"><span class="carousel-control-next-icon"></span>
							<span class="sr-only">Next</span></a>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>




			<div class="col-md-1"></div>

		</div>

	</div>


</body>
</html>