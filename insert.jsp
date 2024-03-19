<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
    <%@ page import="com.model.displaymodel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 500px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .form-group {
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 5px;
    }
    input[type="text"],
    input[type="email"],
    input[type="tel"],
    select {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
 <s:if test="${list==null}">
    <h2>Registration Form</h2>
    </s:if>
    <s:if test="${list!=null}">
    <h2>Update Form</h2>
    </s:if>
    <s:if test="${list==null}">
    <form action="add" method="post">
    </s:if>
    <s:if test="${list!=null}">
    <form action="update"method="post">
    </s:if>
    <div class="form-group">
            <input type="hidden" id="sid" value="${list.id}" name="id" required >
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" value="${list.name}" name="name" required >
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" value="${list.email}"  name="email"required >
        </div>
        <div class="form-group">
            <label for="mobile">Mobile:</label>
            <input type="tel" id="mobile" value="${list.mobile}" name="mobile" pattern="[0-9]{10}" required>
        </div>
        <div class="form-group">
            <label for="course">Course:</label>
            <input type="text" id="course" value="${list.course}" name="course" required>
        </div>
        <div class="form-group">
            <label for="state">State:</label>
            <input type="text" id="state" value="${list.state}" name="state" required>
        </div>
        <s:if test="${list==null}">
        <input type="submit" value="Register">
        </s:if>
        <s:if test="${list!=null}">
        <input type="submit" value="update">
        </s:if>
    </form>
</div>
</body>
</html>