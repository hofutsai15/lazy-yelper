<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 10/20/16
  Time: 12:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h2>Hello Search!</h2>

    <c:forEach items="${restaurantList}" var="restaurant" >
        ${restaurant.id}
        <br />
        ${restaurant.name}
        <br />
    </c:forEach>
</body>
</html>
