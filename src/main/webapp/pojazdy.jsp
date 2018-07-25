<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 25.07.18
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>POJAZDY</title>
</head>
<body>
<jsp:include page="header.jsp"/></br>

<c:out value="<b> POJAZDY </b>" escapeXml="false"/>

<p>
<table>
    <c:forEach items="${vehicles}" var="a">
        <tr>
            <td>${a.vehicle_id} ${a.customer_id} ${a.model} ${a.rok_produkcji} ${a.nr_rejestracyjny} ${a.data_kolejnego_przeglądu} </td>
        </tr>
    </c:forEach>
</table>
</p>


<form action="pojazdy" method="post">
    <input placeHolder="vehicle_id" type="number" name="vehicle_id"></br>
    <input placeHolder="customer_id" type="text" name="customer_id"></br>
    <input placeHolder="model" type="text" name="model"></br>
    <input placeHolder="rok_produkcji" type="text" name="rok_produkcji"></br>
    <input placeHolder="nr_rejestracyjny" type="text" name="nr_rejestracyjny"></br>
    <input placeHolder="data_kolejnego_przegladu" type="date" name="data_kolejnego_przegladu"></br>
    Dodaj: <input type="radio" name="op" value="dodaj">
    Modyfikuj: <input type="radio" name="op" value="modyfikuj">
    Usuń: <input type="radio" name="op" value="usun"></br>
    <input type="submit" value="Wyślij">
    <br>
</form>



<jsp:include page="footer.jsp"/>
</body>
</html>
