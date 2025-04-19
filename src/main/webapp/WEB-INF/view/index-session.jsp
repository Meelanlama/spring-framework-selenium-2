<%--
  Created by IntelliJ IDEA.
  User: Meelan
  Date: 2/15/2025
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index Session</title>
</head>
<body>
<h1 align="center">Session Attributes examples</h1>

<p>FirstName: ${firstName}</p>
<p>LastName: ${lastName}</p>
<p>Address: ${address}</p>

<a href="/spring_love_calculator/${next}">Next Page(${next})</a>
</body>
</html>
