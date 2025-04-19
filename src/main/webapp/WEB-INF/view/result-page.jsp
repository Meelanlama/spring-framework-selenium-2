<%--
  Created by IntelliJ IDEA.
  User: Meelan
  Date: 2/4/2025
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Result Page</title>
</head>
<body>

<h1 align="center">Love calculator</h1>
<hr/>

<h3>Love Calculator predicts :</h3>
<br/>
${userInfo.userName} and ${userInfo.crushName} are
<br/>
${userInfo.result}
<br/>

<%--<a href="${pageContext.request.contextPath}/sendEmail">Send this result to Email</a>--%>
<a href="<c:url value="/sendEmail"/>">Send Result to Email</a>
</body>
</html>
