<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultation autre profil</title>
</head>

<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>

<div class="text-center">
	<h3>Consulter un profil d'un autre utilisateur </h3>
</div>
<br>


<div class="container-fluid">
	<div class="col-md-3"></div>
	<form role="form" action="./ConsulterAutreProfilServlet" method="post">
		<div class="row">
		
			<div class="col-md-12">
			
				
			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="pseudo"> Pseudo </label>
					</div>
					<div class="col-md-6">
						<display class="form-control" id="pseudo" />
						<p>${champsProfil['pseudo']}</p>
						</display>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="nom"> Nom </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="nom">
						<p>${champsProfil['nom']}</p>
						</display>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="prenom"> Prenom </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="prenom">
						<p>${champsProfil['prenom']}</p>
						</display>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="email"> Email </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="email">
						<p>${champsProfil['email']}</p>
						</display>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="telephone"> Telephone </label>
					</div>
					<div class="col-md-6">
						<display class="form-control" id="telephone">
						<c:out value="${champsProfil['telephone']}"/>
						</display>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="rue"> Rue </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="rue">
						<p>${champsProfil['rue']}</p>
						</display>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="codePostal"> Code Postal </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="codePostal">
						<p>${champsProfil['codePostal']}</p>
						</display>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="ville"> Ville </label>
					</div>
					<div class="col-md-6">
						<display type="text" class="form-control" id="ville">
						<p>${champsProfil['ville']}</p>
						</display>
					</div>
				</div>
			</div>
			<br>
			
			<input type="submit" value="test">
			
			<div class="col-md-3"></div>
		</div>
	</div>
	</form>
</div>
<!--  </form> -->

<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>

</body>
</html>


