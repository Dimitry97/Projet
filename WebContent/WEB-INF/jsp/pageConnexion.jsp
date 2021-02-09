<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page connexion</title>
</head>
<body>

<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>



<div class="container-fluid">

	

	<div class="row">
		<div class="col-md-4"></div>
	
		<div class="col-md-4">
		
			<div class="text-center"><h3>Connexion</h3></div>
		
			<form role="form" method="post" action="modifProfil">
			
				<div class="form-group">
					<label for="identifiant">Identifiant
					<span class="requis">*</span>
					</label>
					<input type="text" class="form-control" id="identifiant" />
				</div>
				
				<div class="form-group"> 
					<label for="password"> Mot de passe
					<span class="requis">*</span>
					</label>
					<input type="password" class="form-control" id="password" name="password" value=""/>
				</div>
			</form>	
			
				<div class="row">
					<div class="col-md-6">
						<a href="./jsp/xxx" role="button" class="btn btn-primary btn-lg">
							Connexion
						</a>
					</div>
					
					<div class="col-md-6">
						
						<input type="checkbox" aria-label="seSouvenirDeMoi"><label>Se souvenir de moi</label><br>
						<a href="/WEB-INF/motDePasseOublie.jsp">Mot de passe oublié</a>
					</div>
				</div>	
			
				<br>	
				<div class="row">
					<a href="./jsp/xxx" role="button" class="btn btn-primary btn-lg btn-block active">
					Créer un compte
					</a>

				</div>
					
			<div class="col-md-4"></div>
		
		</div>
	</div>
</div>		
					

</body>
</html>