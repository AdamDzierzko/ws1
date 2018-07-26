<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 26.07.18
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.jsp"/></br>
<p class="b">
    <c:out value="<b> STRONA GŁÓWNA </b>" escapeXml="false"/><br>
    <c:out value="<b> AKTUALNE ZLECENIA </b>" escapeXml="false"/>
</p>

<table >
    <th class="table2">orders_id</th>
    <th class="table2">employee_id</th>
    <th class="table2">vehicle_id</th>
    <c:forEach items="${sg}" var="a">
        <tr>
            <td class="table">${a.orders_id} </td> <td class="table">${a.employee_id} </td> <td class="table">${a.vehicle_id} </td>
        </tr>
    </c:forEach>
</table>
</p>


<jsp:include page="footer.jsp"/>
</body>
</html>
