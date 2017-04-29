<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29.04.2017
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assests/css/bootstrap.css">
</head>
<body>
<div class="table">
    <table class="table">
        <thead>
        <th>Group</th>
        <th>Genre</th>
        </thead>
        <tbody>
        <spring:forEach items="group" var="groups">
            <tr>
                <td><spring:out value="${groups.name}"/></td>
                <td><spring:out value="${groups.genre}"/></td>
            </tr>

        </spring:forEach>
        </tbody>
    </table>
</div>


<script src="/assests/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>
