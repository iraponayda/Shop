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
					<li><a href="/admin/toy">Toy</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li class="active"><a href="/admin/subcategory">Subcategory</a></li>
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
	<form:form class="form-horizontal filter" action="/admin/subcategory" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="_categoryIds, categoryIds"/>
			<div class="form-group">
				<label class="control-label col-sm-12">Category</label>
				<div class="col-sm-12">
					<form:checkboxes items="${categories}" path="categoryIds" itemLabel="name" itemValue="id"/>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/subcategory" method="POST" modelAttribute="subcategory">
					<custom:hiddenInputs excludeParams="category, subcategory"/>
					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2 control-label" for="name" style="color:red;text-align:left;"><form:errors path="name"/></label>
						<label class="col-sm-10 col-sm-offset-2 control-label" for="name" style="color:red;text-align:left;"><form:errors path="category"/></label>
					</div>
					<div class="form-group">
    					<label for="category" class="col-sm-2 control-label">Category</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="category" id="category" items="${categories}" itemValue="id" itemLabel="name"/>
    					</div>
  					</div>
					<div class="form-group">
    					<label for="subcategory" class="col-sm-2 control-label">Subcategory</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="name" id="subcategory"/>
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
			<div class="col-md-3 col-xs-3"><h3>Subcategory</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Category</h3></div>			
			<div class="col-md-3 col-xs-3"><h3>Update</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Delete</h3></div>
	</div>
	<c:forEach items="${page.content}" var="subcategory">
		<div class="row">
			<div class="col-md-3 col-xs-3">${subcategory.name}</div>
			<div class="col-md-3 col-xs-3">${subcategory.category.name}</div>
			<div class="col-md-3 col-xs-3"><a class="btn btn-warning" href="/admin/subcategory/update/${subcategory.id}">update</a></div>
			<div class="col-md-3 col-xs-3"><a class="btn btn-danger" href="/admin/subcategory/delete/${subcategory.id}">delete</a></div>
		</div>
	</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"><div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Subcategory asc" paramValue="name" />
								<custom:sort innerHtml="Subcategory desc" paramValue="name,desc" />
								<custom:sort innerHtml="Category name asc" paramValue="category.name" />
								<custom:sort innerHtml="Category name desc" paramValue="category.name,desc" />
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