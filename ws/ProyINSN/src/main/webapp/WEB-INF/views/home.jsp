<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="include_head.jsp" />
</head>
<body
	class="sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
	<div class="wrapper">
		<jsp:include page="include_navbar.jsp" />
		<jsp:include page="include_aside.jsp" />

		<div class="content-wrapper">
			<!-- Main content -->
			<section class="content">
				<div class="container-fluid mt-3">


					<div id="carouselExampleCaptions" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleCaptions" data-slide-to="0"
								class="active"></li>
							<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
							<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="../resources/img/Carousel/Carousel01.jpg" class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block text-info">
									<h5>Seguimiento de tus ventas</h5>
									<p>Al alcance de tu mano.</p>
								</div>
							</div>
							<div class="carousel-item">
								<img src="../resources/img/Carousel/Carousel02.jpg" class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block text-info">
									<h5>Transformación digital</h5>
									<p>Nos encargamos de digitalizar y autmatizar tus procesos de negocio.</p>
								</div>
							</div>
							<div class="carousel-item">
								<img src="../resources/img/Carousel/Carousel03.jpg" class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block">
									<h5>Siempre contigo</h5>
									<p>Puedes contactarnos todos los días del año.</p>
								</div>
							</div>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleCaptions"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>

				</div>
			</section>
		</div>
	</div>
</body>
<jsp:include page="include_scripts.jsp" />
<script type="text/javascript" src="../resources/js/home.js"></script>
</html>