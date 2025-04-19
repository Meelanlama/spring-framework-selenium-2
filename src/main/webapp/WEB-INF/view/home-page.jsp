<%--
  Created by IntelliJ IDEA.
  User: Meelan
  Date: 2/4/2025
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

    <style type="text/css">
        .error {
            color: red;
            position: fixed;
            text-align: left;
            margin-left: 30px;
        }
    </style>

<%--    <script type="text/javascript" >--%>

<%--        function validateUserName(){--%>
<%--            // Fetching the data and storing in variable--%>
<%--            var userName = document.getElementById('yourName').value;--%>
<%--            var crushName = document.getElementById('crushName').value;--%>

<%--            if(userName.length < 3 || crushName.length < 3){--%>
<%--                alert('Invalid username or crush name');--%>
<%--                return false;--%>
<%--            }else {--%>
<%--                return true;--%>
<%--            }--%>
<%--        }--%>
<%--    </script>--%>

</head>

<h1 align="center">Love Calculator</h1>
<hr/>

<form:form action="process-homepage" method="GET" modelAttribute="userInfo" onsubmit="return validateUserName()" >
<div align="center">
<p>
<label for="yourName">Your name:</label>
<form:input id="yourName" path="userName"/>
    <form:errors path="userName" cssClass="error"/> <%-- Display errors --%>
</p>
<p>
 <label for="crushName">Crush Name:</label>
 <form:input id="crushName" path="crushName"/>
    <form:errors path="crushName" cssClass="error"/>
</p>
    <p>
        <form:checkbox id="tnc" path="termsAndConditions"/>
        <label for="tnc">I am agreeing this is only for fun</label>
        <form:errors path = "termsAndConditions" cssClass="error"/>
    </p>
<input type="submit" value="Calculate">
</div>

</form:form>
</body>
</html>
