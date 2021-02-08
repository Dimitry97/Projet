<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>

<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>

<div class="container-fluid">

	<div class="col-md-2">
	</div>

	<div class="row">
		<div class="col-md-4">
			<form role="form">
			
				<div class="form-group">
					<label for="pseudo">
						Pseudo :
					</label>
					<input type="text" class="form-control" id="pseudo" />
				</div>
				
				<div class="form-group"> 
					<label for="prenom">
						Prenom :
					</label>
					<input type="text" class="form-control" id="prenom" />
				</div>
					 
				<div class="form-group"> 
					<label for="telephone">
						Telephone :
					</label>
					<input type="text" class="form-control" id="telephone" />
				</div>
					 
				<div class="form-group"> 
					<label for="codePostal">
						Code Postal :
					</label>
					<input type="text" class="form-control" id="codePostal" />
				</div>
					 
				<div class="form-group"> 
					<label for="password">
						Mot de passe :
					</label>
					<input type="password" class="form-control" id="password" />
				</div>
				
				<div class="form-group">
					<label for="credit">
						Crédit : 
						<!-- Afficher les crédit de l'utilisateur en fonction du numéro ID -->
					</label>
					<input type="number" class="form-control" id="credit" />
				</div>	 
					
			</form>
		</div>
		
		
		<div class="col-md-4">
			<form role="form">
			
				<div class="form-group">
					<label for="nom">
						Nom :
					</label>
					<input type="text" class="form-control" id="nom" />
				</div>
				
				<div class="form-group">
					<label for="email">
						Email :
					</label>
					<input type="email" class="form-control" id="email" />
				</div>
				
				<div class="form-group">
					<label for="rue">
						Rue :
					</label>
					<input type="text" class="form-control" id="rue" />
				</div>	 
					
				<div class="form-group">
					<label for="ville">
						Ville :
					</label>
					<input type="text" class="form-control" id="ville" />
				</div>	 
				
				<div class="form-group">
					<label for="passwordVerif">
						Confirmation mot de passe :
						<!-- Saisie doit être identique à password -->
					</label>
					<input type="password" class="form-control" id="passwordVerif" />
				</div>	 
		
			</form>
		</div>
		
		<div class="col-md-3">
		</div>
		
		
		<div class="row">
			<div class="col-md-12">
			 
				<button type="submit" class="btn btn-primary btn-lg">
					Enregistrer
					<!-- Mettre à jour la base de données -->
				</button>
				
				<button type="submit" class="btn btn-primary btn-lg">
					Supprimer mon compte
					<!-- Supprime le compte de la base de données -->
				</button>
				
			</div>
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>
