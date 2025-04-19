<%--
  Created by IntelliJ IDEA.
  User: Meelan
  Date: 2/8/2025
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <%-- Import JSTL core taglib --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%-- Import JSTL fmt taglib --%>

<html>
<head>
  <title>Bill success</title>
</head>
<body>
<h1 align="center">Bill generated:</h1>
<hr/>

<h3>Details are:</h3>
<p>Credit card Number: ${billInfo.creditCard}</p>

<p>Bill amount:
  <c:choose>
    <c:when test="${not empty billInfo.amount}">
      <%-- Format using JSTL fmt:formatNumber (simpler for basic formatting) --%>
      <fmt:formatNumber value="${billInfo.amount.billAmount}" type="currency" currencyCode="${billInfo.amount.localeDefinition}"/>
      <%-- OR, format using your CurrencyFormatter (more control) --%>
      <%-- Make sure you have the locale available in the model (see below) --%>
      <%-- ${currencyFormatter.format(billInfo.amount.billAmount, billInfo.locale)} --%>
    </c:when>
    <c:otherwise>
      No Amount Provided
    </c:otherwise>
  </c:choose>
</p>

<p>Bill Paid Date: ${billInfo.date}</p>
</body>
</html>
