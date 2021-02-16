<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des enchères non connecté</title>
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
						class="form-control" id="rechercheArticle" name="rechercheArticle"
						placeholder="Le nom de l'article contient ..." />
				</div>

				<div class="form-group">
					<label for="categorie"> Catégorie </label> <select
						class="form-control" id="categorie" name="categorie">
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