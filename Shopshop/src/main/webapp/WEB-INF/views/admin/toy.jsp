<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
	.filter .control-label{
		text-align: left;
	}
	.filter span{
		display: block;
	}
</style>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li  class="active"><a href="/admin/toy">Toy</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li><a href="/admin/subcategory">Subcategory</a></li>
					<li><a href="/admin/producer">Producer</a></li>
					<li><a href="/admin/country">Country</a></li>
					<li><a href="/admin/age">Age</a></li>
					<li><a href="/admin/gender">Gender</a></li>
					<li><a href="/admin/material">Material</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>

<div class="row">
	<div class="col-md-3 col-xs-12">
	<form:form class="form-horizontal filter" action="/admin/toy" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="_producerIds, _subcategoryIds, _genderIds, _ageIds, _materialIds, producerIds, ingredientIds, subcategoryIds, genderIds, ageIds, materialIds"/>
			
			<div class="form-group">
				<label class="control-label col-sm-12">Producer</label>
				<div class="col-sm-12">
					<form:checkboxes items="${producers}" path="producerIds" itemLabel="name" itemValue="id"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Subcategory</label>
				<div class="col-sm-12">
					<form:checkboxes items="${subcategories}" path="subcategoryIds" itemLabel="name" itemValue="id"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Gender</label>
				<div class="col-sm-12">
					<form:checkboxes items="${genders}" path="genderIds" itemLabel="gender" itemValue="id"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Age</label>
				<div class="col-sm-12">
					<form:checkboxes items="${ages}" path="ageIds" itemLabel="age" itemValue="id"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Material</label>
				<div class="col-sm-12">
					<form:checkboxes items="${materials}" path="materialIds" itemLabel="material" itemValue="id"/>
				</div>
			</div>
		
			<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>
	
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
			
				<form:form class="form-horizontal" action="/admin/toy" method="POST" modelAttribute="toy"  enctype="multipart/form-data">
					<custom:hiddenInputs excludeParams="name, file"/>
					<form:hidden path="id"/>
					<form:hidden path="version"/>
					<div class="form-group">
						<label for="toy" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="name"/></label>
						<label for="toy" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="age"/></label>
					</div>
					<div class="form-group">
    					<label for="producer" class="col-sm-2 control-label">Producer</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="producer" id="producer" items="${producers}" itemValue="id" itemLabel="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="toy" class="col-sm-2 control-label">Toy</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="name" id="toy"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="price" class="col-sm-2 control-label">Price</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="price" id="price"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="subcategory" class="col-sm-2 control-label">Subcategory</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="subcategory" id="subcategory" items="${subcategories}" itemLabel="name" itemValue="id"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="gender" class="col-sm-2 control-label">Gender</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="gender" id="gender" items="${genders}" itemLabel="gender" itemValue="id"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="material" class="col-sm-2 control-label">Material</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="material" id="material" items="${materials}" itemLabel="material" itemValue="id"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="age" class="col-sm-2 control-label">Age</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="age" id="age" items="${ages}" itemLabel="age" itemValue="id"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="file" class="col-sm-2 control-label">Image</label>
    						<div class="col-sm-10">
      							<input type="file" name="file" id="file">
    						</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-primary">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-xs-3"><h3>Image</h3></div>
			<div class="col-md-1 col-xs-1"><h4>Toy</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Price</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Subcategory</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Producer</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Gender</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Age</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Material</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Update</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Delete</h4></div>
		</div>
			<c:forEach items="${page.content}" var="toy">
				<div class="row">
					<div class="col-md-3 col-xs-3"><img src="/images/toy/${toy.id}.jpg?version=${toy.version}" width="100%"></div>
					<div class="col-md-1 col-xs-1">${toy.name}</div>
					<div class="col-md-1 col-xs-1">${toy.price}</div>
					<div class="col-md-1 col-xs-1">${toy.subcategory.name}</div>
					<div class="col-md-1 col-xs-1">${toy.producer.name}</div>
					<div class="col-md-1 col-xs-1">${toy.gender.gender}</div>
					<div class="col-md-1 col-xs-1">${toy.age.age}</div>
					<div class="col-md-1 col-xs-1">${toy.material.material}</div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-warning" href="/admin/toy/update/${toy.id}">update</a></div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-danger" href="/admin/toy/delete/${toy.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">
		<div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Toy asc" paramValue="toy" />
								<custom:sort innerHtml="Toy desc" paramValue="toy,desc" />
								<custom:sort innerHtml="Producer name asc" paramValue="producer.name" />
								<custom:sort innerHtml="Producer name desc" paramValue="producer.name,desc" />
								<custom:sort innerHtml="Gender gender asc" paramValue="gender.gender" />
								<custom:sort innerHtml="Gender gender desc" paramValue="gender.gender,desc" />
								<custom:sort innerHtml="Age age asc" paramValue="age.age" />
								<custom:sort innerHtml="Age age desc" paramValue="age.age,desc" />
								<custom:sort innerHtml="Material material asc" paramValue="material.material" />
								<custom:sort innerHtml="Material material desc" paramValue="material.material,desc" />
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-xs-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
				</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>