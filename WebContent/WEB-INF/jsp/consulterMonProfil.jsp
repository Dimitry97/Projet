NouvelleVenteServlet.java<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MonProfil</title>
</head>

<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>

<div class="text-center">
	<h3>Consulter et modifier mon profil</h3>
</div>
<br>


<div class="container-fluid">
	<div class="col-md-3"></div>
	<form role="form" action="./ConsulterMonProfilServlet" method="post">
		<div class="row">
		
			<div class="col-md-12">
			
				
			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<label for="pseudo"> Pseudo </label>
					</div>
					<div class="col-md-6">
						<display class="form-control" id="pseudo">
							<c:out value="${pseudo }" />
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
						<c:out value="${nom }" />
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
						<c:out value="${prenom }" />
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
						<c:out value="${email }" />
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
						<i class="form-control" id="telephone">
						<c:out value="${telephone }" default="Aucun numéro enregistré"/>
						</i>
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
						<c:out value="${rue }" />
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
						<c:out value="${codePostal }" />
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
						<c:out value="${ville }" />
						</display>
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
	</form>
</div>
<!--  </form> -->

<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>

</body>
</html>


