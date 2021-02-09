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
		<div class="col-md-6">
			<form role="form">
			
				<div class="form-group">
					<label for="pseudo">
						Pseudo :
						<!-- Vérifier si pseudo déjà existant, sinon message alerte -->
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
					
			</form>
		</div>
		
		
		<div class="col-md-6">
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
						<!-- Vérifier si email déjà existant, sinon message alerte -->
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
		

		<div class="row">
			<div class="col-md-12">
			 
				<button type="submit" class="btn btn-primary btn-lg">
					Créer
					<!-- Ajout utilisateur dans la base de données -->
				</button>
				
				<button type="submit" class="btn btn-primary btn-lg">
					Annuler
				</button>
				
			</div>
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>