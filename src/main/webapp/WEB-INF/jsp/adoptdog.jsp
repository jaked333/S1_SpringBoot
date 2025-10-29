<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adopt Dog</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adoptdog.css">

   

<script>
    function validateForm() {
        let idCard = document.forms["adoptForm"]["idCard"].value;
        let fullName = document.forms["adoptForm"]["fullName"].value;
        let address = document.forms["adoptForm"]["address"].value;
        let mobile = document.forms["adoptForm"]["mobile"].value;
        let email = document.forms["adoptForm"]["email"].value;
        let gender = document.forms["adoptForm"]["gender"].value;

        let idPattern = /^[1-9][0-9]{12}$/;
        if (!idPattern.test(idCard)) {
            alert("ID Card must be exactly 13 digits and cannot start with 0.");
            return false;
        }

        if (fullName.trim() === "") {
            alert("Full Name is required.");
            return false;
        }
        if (address.trim() === "") {
            alert("Address is required.");
            return false;
        }
        if (mobile.trim() === "") {
            alert("Mobile number is required.");
            return false;
        }

   
        if (!gender) {
            alert("Please select gender.");
            return false;
        }

        return true;
    }
</script>
</head>
<body>

<h2>Adopt Dog</h2>

<div class="adopt-container">
    <img src="${pageContext.request.contextPath}/images/${dog.dogId}.png" 
         class="dog-image"
         width="120" height="120" />
    
    <div class="dog-info">
        <p>
            <strong>${dog.dogName}</strong> 
            (${dog.sex == 1 ? 'Male' : 'Female'}) - ${dog.age} years old <br>
            ${dog.details}
        </p>
    </div>
    
    <div class="clear"></div>
    <h3>Adopter Details</h3>

    <form name="adoptForm" action="${pageContext.request.contextPath}/adopt/save" 
          method="post" onsubmit="return validateForm();">
        <input type="hidden" name="dogId" value="${dog.dogId}" />

        <label>ID Card:</label>
        <input type="text" name="idCard" maxlength="13" required />

        <label>Full Name:</label>
        <input type="text" name="fullName" required />

        <label>Address:</label>
        <input type="text" name="address" required />

        <label>Mobile:</label>
        <input type="text" name="mobile" required />

        <label>Email:</label>
        <input type="email" name="email" required />

        <label>Gender:</label>
        <div class="gender-group">
            <input type="radio" name="gender" value="male" required /> Male
            <input type="radio" name="gender" value="female" required /> Female
        </div>

        <button type="submit">Adopt</button>
    </form>
</div>

</body>
</html>