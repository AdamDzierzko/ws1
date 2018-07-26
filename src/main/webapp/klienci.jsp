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
    <link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.jsp"/></br>
<p class="b">
<c:out value="<b> KLIENCI </b>" escapeXml="false"/>
</p>
<p class="b">

<table >
    <tr>
        <th class="table2">customer_id</th>
        <th class="table2">imie</th>
        <th class="table2">nazwisko</th>
        <th class="table2">data_urodzenia</th>
    </tr>
    <c:forEach items="${customer}" var="a">
        <tr>
            <td class="table">${a.customer_id}</td> <td class="table">${a.imie} </td> <td class="table">${a.nazwisko} </td> <td class="table">${a.data_urodzenia}</td>
        </tr>
    </c:forEach>
</table>
</p>
<pre>
<form action="klienci" method="post" class="form">
    customer_id:    <input placeHolder="customer_id" type="number" name="customer_id" class="form2"></br>
    imie:           <input placeHolder="imie" type="text" name="imie" class="form2"></br>
    nazwisko:       <input placeHolder="nazwisko" type="text" name="nazwisko" class="form2"></br>
    data_urodzenia: <input placeHolder="data_urodzenia" type="date" name="data_urodzenia" class="form2"></br>
    Dodaj:  <input type="radio" name="op" value="dodaj">    Modyfikuj:  <input type="radio" name="op" value="modyfikuj"> Usuń:   <input type="radio" name="op" value="usun"></br>
    <input type="submit" value="Wyślij" class="sub">
    <br>
</form>
</pre>

<jsp:include page="footer.jsp"/>

</body>
</html>
