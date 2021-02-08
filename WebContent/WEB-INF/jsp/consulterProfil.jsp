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
			<form role="form">
					 
				<div class="form-group">
					<label for="pseudo">
						Pseudo :
					</label>
					<input type="text" class="form-control" id="pseudo" />
				</div>
				
				<div class="form-group">
					<label for="nom">
						Nom :
					</label>
					<input type="text" class="form-control" id="nom" />
				</div>
				
				<div class="form-group"> 
					<label for="prenom">
						Prenom :
					</label>
					<input type="text" class="form-control" id="prenom" />
				</div>
				
				<div class="form-group">
					<label for="email">
						Email :
					</label>
					<input type="email" class="form-control" id="email" />
				</div>
					 
				<div class="form-group"> 
					<label for="telephone">
						Telephone :
					</label>
					<input type="text" class="form-control" id="telephone" />
				</div>
				
				<div class="form-group">
					<label for="rue">
						Rue :
					</label>
					<input type="text" class="form-control" id="rue" />
				</div>	 
					 
				<div class="form-group"> 
					<label for="codePostal">
						Code Postal :
					</label>
					<input type="text" class="form-control" id="codePostal" />
				</div>
						
				<div class="form-group">
					<label for="ville">
						Ville :
					</label>
					<input type="text" class="form-control" id="ville" />
				</div>	 
		
			</form>
		</div>
	</div>
</div>

<!-- ajouter bouton modifier profil si consultation Profil par utilisateur concerné -->

		<div class="row">
			<div class="col-md-12">
			 
				<button type="submit" class="btn btn-primary btn-lg">
					Modifier
					<!-- Renvoi sur la page monProfil.jsp -->
				</button>
				
			</div>
		</div>


<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>