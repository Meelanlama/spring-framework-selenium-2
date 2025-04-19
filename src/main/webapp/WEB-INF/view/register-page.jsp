<%--
  Created by IntelliJ IDEA.
  User: Meelan
  Date: 2/5/2025
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>

    <style type="text/css">
        .error {
            color: red;
            position: fixed;
            text-align: left;
            margin-left: 30px;
        }
    </style>
</head>
<body>

<h1 align="center">Love Calculator-Registration Page</h1>
<hr/>

<form:form action="register-success" method="get" modelAttribute="registerInfo">

 <div align="center">
      <label for="name">Name:</label>
      <form:input id="name" path="name"/>
     <form:errors path="name" cssClass="error"/>
            <br/>

         <label for="uName">User Name:</label>
         <form:input id="uName" path="userName"/>
        <form:errors path="userName" cssClass="error"/>
            <br/>

         <label for="pass">Password:</label>
         <form:password id="pass" path="password"/>
            <br/>

         <label for="cName">Country:</label>
         <form:select id="cName" path="country">
         <form:option value="Nep" label="Nepal"> </form:option>
         <form:option value="UK" label="United Kingdom"> </form:option>
         <form:option value="USA" label="United States"> </form:option>
         </form:select>
            <br/>

         <label for="hobby">Hobby:</label>
         Football: <form:checkbox id="hobby" path="hobbies" value="Football"/>
         Programming: <form:checkbox id="hobby" path="hobbies" value="Programming"/>
         Hiking: <form:checkbox id="hobby" path="hobbies" value="Hiking"/>
         Gaming: <form:checkbox id="hobby" path="hobbies" value="Gaming"/>
            <br/>

         <label for="gender">Gender:</label>
         Male: <form:radiobutton id="gender" path="gender" value="Male"/>
         Female: <form:radiobutton id="gender" path="gender" value="Female"/>
         Others: <form:radiobutton id="gender" path="gender" value="others"/>
            <br/>

     <label for="age">Age:</label>
     <form:input id="age" path="age"/>
     <form:errors path="age" cssClass="error"/>
     <br/>

     <h3>Communication</h3>

     <label for="email">Email:</label>
     <form:input  id="email" path="communicationDTO.email"/>
     <form:errors path="communicationDTO.email" cssClass="error"/>
     <br/>

     <label for="phone">Phone:</label>
     <form:input id="phone" path="communicationDTO.phone"/>
     <form:errors path="communicationDTO.phone.userNumber" cssClass="error"/>
     <br/>

     <input type="submit" value="Register">

 </div>
</form:form>
</body>
</html>
