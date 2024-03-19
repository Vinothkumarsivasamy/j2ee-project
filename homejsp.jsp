<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="com.model.displaymodel" %>
    <%@ page import="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    .container {
        max-width: 800px;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #007bff;
        color: #fff;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }
</style>
<title>Insert title here</title>

</head>
<body>
<div class="container">
    <h1>Student Information</h1><br>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>email</th>
                <th>mobile</th>
                <th>course</th>
                <th>state</th>
                <th>action</th>
            </tr>
        </thead>
        <tbody>
        <a:forEach items="${display1}" var="u"><tr>
        <td><a:out value="${u.id}"></a:out></td>
        <td><a:out value="${u.name}"></a:out></td>
        <td><a:out value="${u.email}"></a:out></td>
       <td><a:out value="${u.mobile}"></a:out></td>
        <td><a:out value="${u.course}"></a:out></td>
        <td><a:out value ="${u.state}"></a:out></td>
        <td><a class="btn btn-primary" href="delete?id=<a:out value="${u.id }"></a:out>">delete</a>
        <a class="btn btn-primary" href="edit?id=<a:out value="${u.id }"></a:out>">edit</a>
        </td></tr>
       </a:forEach> </tbody>
        
    </table><br><br>
   <center><a class="btn btn-primary btn-lg" href="<%=request.getContextPath()%>/insert" role="button">Add student system</a></center>
</div>

</body>
</html>