<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Meelan
  Date: 2/8/2025
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bill</title>
</head>
<body>
<h1 align="center">Bill Page</h1>
<br/>

<form:form action="bill-success" method="post" modelAttribute="billInfo">
<div align="center">
    <label for="credit">Credit Card:</label>
    <form:input id="credit" path="creditCard"/>
    <form:errors path="creditCard" cssStyle="color:red"/>
    <br/>

    <label for="bill">Bill Amount (e.g: "100.50 USD"):</label>
    <form:input id="bill" path="amountString"/>
    <form:errors path="amountString" cssStyle="color:red"/>

    <br/>

    <label for="date">Date:</label>
    <form:input id="date" path="date"/>
    <form:errors path="date" cssStyle="color:red"/>
<br/>

    <input type="submit" value="Generate Bill">
</div>
</form:form>

</body>
</html>
