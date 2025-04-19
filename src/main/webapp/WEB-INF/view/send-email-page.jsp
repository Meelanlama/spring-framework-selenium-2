<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Meelan
  Date: 2/13/2025
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send Email</title>
</head>
<body>

<%--Captured data from url and available in our view--%>
<h2>Hi ${userInfo.userName}</h2>
<h2>Send Result To Your Email </h2>

<form:form action="process-email" method="get" modelAttribute="emailDto">

<label>Enter Your Email: </label>
  <form:input path="userEmail"/>
  <input type="Submit" value="Send">

</form:form>
</body>
</html>
