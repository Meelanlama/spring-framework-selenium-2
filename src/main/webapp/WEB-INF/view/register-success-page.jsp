<%--
  Created by IntelliJ IDEA.
  User: Meelan
  Date: 2/5/2025
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Success</title>
</head>
<body>
<h1 align="center">Register Successful</h1>
<h3>Registration Details are:</h3>
<hr/>

<%--Calls getter method internally--%>
<p>Your Name is: ${registerInfo.name}</p>
<p>Your Username is: ${registerInfo.userName}</p>
<p>Your password is: ${registerInfo.password}</p>
<p>Country Name is: ${registerInfo.country}</p>

<p>Your hobbies are:
<c:forEach var="values" items="${registerInfo.hobbies}">
${values}
</c:forEach>
</p>

<p>Your age is: ${registerInfo.age}</p>

<p>Your Gender is: ${registerInfo.gender}</p>

<p>Your email is : ${registerInfo.communicationDTO.email}</p>

<p>Your phone number is: ${registerInfo.communicationDTO.phone}</p>
</body>
</html>
