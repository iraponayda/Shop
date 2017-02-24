<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>Hello</h2>
<a href="/admin">admin</a>
<ul>
	<c:forEach items="${categories}" var="category">
		<li><a href="/category/${category.id}">${category.name}</a></li>
	</c:forEach>
</ul>

<a href="/admin">admin</a>
<br>
<a href="/category">Category</a>
<br>
<a href="/gender">Gender</a>
<br>
<a href="/age">Age</a>
<br>
<h1>ADD</h1>
<br>
<a href="/admin/producer">Producer</a>
<br>
<a href="/admin/category">Category</a>
<br>
<a href="/admin/subcategory">Subcategory</a>
<br>
<a href="/admin/gender">Gender</a>
<br>
<a href="/admin/toy">Toy</a>