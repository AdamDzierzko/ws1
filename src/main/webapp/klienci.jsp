<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 25.07.18
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/></br>

<c:out value="<b> KLIENCI </b>" escapeXml="false"/>

<p>

<table>
    <c:forEach items="${customer}" var="a">
        <tr>
            <td>${a.customer_id} ${a.imie} ${a.nazwisko} ${a.data_urodzenia}</td>
        </tr>
    </c:forEach>
</table>
</p>

<form action="klienci" method="post">
    <input placeHolder="customer_id" type="number" name="customer_id"></br>
    <input placeHolder="imie" type="text" name="imie"></br>
    <input placeHolder="nazwisko" type="text" name="nazwisko"></br>
    <input placeHolder="data_urodzenia" type="date" name="data_urodzenia"></br>
    Dodaj: <input type="radio" name="op" value="dodaj">
    Modyfikuj: <input type="radio" name="op" value="modyfikuj">
    Usuń: <input type="radio" name="op" value="usun"></br>
    <input type="submit" value="Wyślij">
    <br>
</form>


<jsp:include page="footer.jsp"/>

</body>
</html>
