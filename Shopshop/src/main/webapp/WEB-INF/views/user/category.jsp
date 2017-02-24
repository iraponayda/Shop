<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>${category.name}</h2>
<c:forEach items="${toys}" var ="toy">
<div>${toy.name } $(toy.price)</div>
</c:forEach>
<ul>
<li><a href="/dolls">Dolls</a></li>
<li><a href="/cars">Cars</a></li>
<li><a href="/softToys">Soft toys</a></li>
<li><a href="/puzzles">Puzzles</a></li>
<li><a href="/books">Books</a></li>
</ul>