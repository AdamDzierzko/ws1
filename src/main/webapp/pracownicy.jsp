<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 25.07.18
  Time: 08:33
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

<c:out value="<b> PRACOWNICY </b>" escapeXml="false"/>

<p>
<table>
    <c:forEach items="${employees}" var="a">
        <tr>
            <td>${a.employee_id} ${a.imie} ${a.nazwisko} ${a.adres} ${a.telefon} ${a.notatka} ${a.koszt_roboczogodziny} </td>
        </tr>
    </c:forEach>
</table>
</p>


<form action="pracownicy" method="post">
    <input placeHolder="employee_id" type="number" name="employee_id"></br>
    <input placeHolder="imie" type="text" name="imie"></br>
    <input placeHolder="nazwisko" type="text" name="nazwisko"></br>
    <input placeHolder="adres" type="text" name="adres"></br>
    <input placeHolder="telefon" type="text" name="telefon"></br>
    <input placeHolder="notatka" type="text" name="notatka"></br>
    <input placeHolder="koszt_roboczogodziny" type="text" name="koszt_roboczogodziny"></br>
    Dodaj: <input type="radio" name="op" value="dodaj">
    Modyfikuj: <input type="radio" name="op" value="modyfikuj">
    Usuń: <input type="radio" name="op" value="usun"></br>
    <input type="submit" value="Wyślij">
    <br>
</form>



<jsp:include page="footer.jsp"/>
</body>
</html>
