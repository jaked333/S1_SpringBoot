<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find a Dog Home</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/maindog.css">

</head>
<body>

 	

<h2>Welcome to "Find a dog home"</h2>
<a href="showAllDogs" class="show-all-link">Show all dogs</a>

<div class="breeds-container">
    <c:forEach var="breed" items="${breeds}">
        <div class="breed-card">
            <img src="${pageContext.request.contextPath}/images/${breed.breedId}.png" 
                 class="breed-image" width="100" height="100" />
            <a href="dogsByBreed/${breed.breedId}" class="breed-link">${breed.breedName}</a>
        </div>
    </c:forEach>
</div>

</body>
</html>