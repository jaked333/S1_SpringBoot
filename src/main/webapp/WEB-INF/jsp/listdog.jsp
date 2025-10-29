<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Dogs</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listdog.css">

   

</head>
<body>

<h2>List of Dogs</h2>

<div class="dogs-container">
    <c:forEach var="dog" items="${dogs}">
        <div class="dog-card">
            <c:if test="${dog.owner == null}">
                <a href="${pageContext.request.contextPath}/adopt/${dog.dogId}">
                    <img src="${pageContext.request.contextPath}/images/${dog.dogId}.png"
                         class="dog-image available"
                         width="100" height="100"
                         alt="${dog.dogName}" />
                </a>
            </c:if>

            <c:if test="${dog.owner != null}">
                <img src="${pageContext.request.contextPath}/images/${dog.dogId}.png"
                     class="dog-image taken"
                     width="100" height="100"
                     alt="${dog.dogName}" />
            </c:if>

            <div class="dog-info">
                <strong>${dog.dogName}</strong> 
                (${dog.sex == 1 ? 'Male' : 'Female'}) - ${dog.age} years old <br>
                Breed: ${dog.breed.breedName} <br>
                Details: ${dog.details} <br>
                <span class="owner">Owner: <c:out value="${dog.owner != null ? dog.owner.fullName : 'No owner'}" /></span>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>