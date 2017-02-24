<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${ages}" var ="age">
<div>${age.age }</div>
</c:forEach>
<h1>${age.age}</h1>