<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Hello</h2>
<sec:authorize access="isAuthenticated()">
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="/admin">admin</a>
	</sec:authorize>
	<form:form action="/logout" method="POST">
		<button type="submit" class="btn btn-danger">Logout</button>
	</form:form>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
<a href="/login">Login</a>
<a href="/registration">Registration</a>
</sec:authorize>
<content>
				<div class="content">
					<!--carousel-->			
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>
	 
						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="/resources/img/Carousel/HW_banner_lp_rihappy_980x220.jpg" alt="...">
								<div class="carousel-caption">
									<h3>Cars</h3>
								</div>
							</div>
							<div class="item">
								<img src="/resources/img/Carousel/teddy-bears-normal-wallpaper.jpg" alt="...">
								<div class="carousel-caption">
									<h3>Soft toys</h3>
								</div>
							</div>
							<div class="item">
								<img src="/resources/img/Carousel/4b13e03b683b4f7a11f88516b81eedf0.jpg" alt="...">
								<div class="carousel-caption">
									<h3>Barbies</h3>
								</div>
							</div>
						</div>
	 
						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left"></span>
						</a>
						<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div> <!-- Carousel -->
					<!--Toy finder-->
					<div class="finder">
						<div>Не знаєте що подарувати?</div>
						<div class="form-group">
							<label for="age" class="control-label col-md-2">Вік:</label>
							<div class="col-md-10">
								<select class="form-control" id="age">
									<option disabled selected>Виберіть вік</option>
									<option>Новонароджені</option>
									<option>1-2 роки</option>
									<option>3-5 років</option>
									<option>6-9 років</option>
									<option>10-14 років</option>
									<option>Дорослі</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="gender" class="control-label col-md-2">Стать:</label>
							<label for="boy" class="control-label">Хлопчик</label><input type="radio" id="boy" value="boy" name="gender" checked>
							<label for="girl" class="control-label">Дівчинка</label><input type="radio" id="girl" value="girl" name="gender">
						</div>
						<!-- <div><b>€ 10</b> <input id="ex2" type="text" class="span2" value="" data-slider-min="10" data-slider-max="1000" data-slider-step="5" data-slider-value="[250,450]"/> <b>€ 1000</b></div> -->
						<div><button class="btn btn-default find" type="submit">Знайти</button></div>
					</div>
					<hr>
					<hr>
					<div class="row">
						<div class="col-md-2"><h3>Бренди</h3></div>
						<div class="col-md-1"><a href=""><img class = "brands" src="/resources/img/Brands/Barbie.png"></img></a></div>
						<div class="col-md-1"><a href=""><img class = "brands" src="/resources/img/Brands/Hot_Wheels_logo.png"></img></a></div>
						<div class="col-md-1"><a href=""><img class = "brands" src="/resources/img/Brands/Mattel-brand.png"></img></a></div>
						<div class="col-md-1"><a href=""><img class = "brands" src="/resources/img/Brands/LEGO.png"></img></a></div>
						<div class="col-md-1"><a href=""><img class = "brands" src="/resources/img/Brands/UGEARS-Malaysia-Logo.png"></img></a></div>
						<div class="col-md-1"><a href=""><img class = "brands" src="/resources/img/Brands/logo_main.png"></img></a></div>
						<div class="col-md-1"><a href=""><img class = "brands" src="/resources/img/Brands/logo_danko.png"></img></a></div>
						<div class="col-md-1"><a href=""><img class = "brands" src="/resources/img/Brands/__5.png"></img></a></div>
						<div class="col-md-1"><a href=""><img class = "brands" src="/resources/img/Brands/castorland.png"></img></a></div>
					</div>
					<hr>
					<hr>
					<div class="row">
						<div class="col-md-2"><h3>Пошук за віком</h3></div>
						<div class="col-md-10">
							<div class="col-md-2"><a href=""><img class = "age" src="/resources/img/Age/newb2.png"><br>Новонароджені</img></a></div>
							<div class="col-md-2 "><a href=""><img class = "age" src="/resources/img/Age/1-2.png"><br>1-2 роки</img></a></div>
							<div class="col-md-2 "><a href=""><img class = "age" src="/resources/img/Age/3-5.png"><br>3-5 років</img></a></div>
							<div class="col-md-2 "><a href=""><img class = "age" src="/resources/img/Age/6-9.png"><br>6-9 років</img></a></div>
							<div class="col-md-2 "><a href=""><img class = "age" src="/resources/img/Age/10-14.png"><br>10-14 років</img></a></div>
							<div class="col-md-2 "><a href=""><img class = "age" src="/resources/img/Age/adult.png"><br>Дорослі</img></a></div>
						</div>
					</div>
					<hr>
					<hr>
					
					<div class="row">
						<div class="col-md-2"><h3>Пошук за категоріями</h3></div>
						<div class="col-md-5"><a href=""><img class = "category" src="/resources/img/Category/doll.png"><br>Ляльки</img></a></div>
						<div class="col-md-5"><a href=""><img class = "category" src="/resources/img/Category/car.png"><br>Машинки</img></a></div>
					</div>
					<div class="row">
						<div class="col-md-4"><a href=""><img class = "category" src="/resources/img/Category/soft.png"><br>М'які іграшки</img></a></div>
						<div class="col-md-4"><a href=""><img class = "category" src="/resources/img/Category/puzzle.png"><br>Головоломки</img></a></div>
						<div class="col-md-4"><a href=""><img class = "category" src="/resources/img/Category/book.png"><br>Книжки</img></a></div>
					
					</div>
					
					<hr>
				    <hr>
				</div>
			</content>