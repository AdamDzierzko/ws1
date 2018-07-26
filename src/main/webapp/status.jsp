<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 26.07.18
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>STATUS</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.jsp"/></br>
<p class="b">
<c:out value="<b> STATUS </b>" escapeXml="false"/>
</p>
<p>

<table >
    <th class="table2">orders_id</th>
    <th class="table2">status</th>
    <c:forEach items="${status}" var="a">
        <tr>
            <td>${a.orders_id} </td> <td class="table">${a.status} </td>
        </tr>
    </c:forEach>
</table>
</p>

<pre>
<form action="status" method="post" class="form">
    orders_id:  <input placeHolder="orders_id" type="number" name="orders_id" class="form2"></br>
    status:     <select name="status" class="form2">
                <option value="przyjety">przyjety</option>
                <option value="zatwierdzone_koszty_naprawy">zatwierdzone_koszty_naprawy</option>
                <option value="w_naprawie">w_naprawie</option>
                <option value="gotowy_do_odbioru">gotowy_do_odbioru</option>
                <option value="rezygnacja">rezygnacja</option>
                </select></br>
    Dodaj: <input type="radio" name="op" value="dodaj"> Modyfikuj: <input type="radio" name="op" value="modyfikuj"> Usuń: <input type="radio" name="op" value="usun"></br>
    <input type="submit" value="Wyślij" class="sub">
    <br>
</form>
</pre>

<jsp:include page="footer.jsp"/>
</body>
</html>
