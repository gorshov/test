<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <spring:url value="/assests/css/bootstrap.css" var="bootstrapCss"/>
    <%--<spring:url value="/assests/css/happy.css" var="happyCss"/>--%>
    <link href="${bootstrapCss}" rel="stylesheet"/>
<%--
    <link href="${happyCss}" rel="stylesheet"/>
--%>
</head>
<body>

<div class="table" align="center">
    <table class="table table-striped table-bordered">
        <thead class="table" align="center">
        <th>Group</th>
        <th>Genre</th>
        <th>Album</th>
        </thead>
        <tbody>
        <spring:forEach items="${groupList}" var="group">
            <tr>
                <td><spring:out value="${group.name}"/></td>
                <td><spring:out value="${group.genre}"/></td>
                <td><spring:forEach items="${group.albumSet}" var="album">
                    <spring:out value="${album.nameAlbum}"/>
                </spring:forEach></td>
            </tr>
        </spring:forEach>
        </tbody>
    </table>
</div>


<spring:url value="/assests/js/happy.js" var="happyJs"/>
<spring:url value="/assests/js/bootstrap.js" var="bootstrapJs"/>
<script src="${bootstrapJs}"></script>
<script src="${happyJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->

</body>
</html>
