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
    <link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.jsp"/></br>
<p class="b">
<c:out value="<b> PRACOWNICY </b>" escapeXml="false"/>
</p>
<p>
<table >
    <th class="table2">employee_id</th>
    <th class="table2">imie</th>
    <th class="table2">nazwisko</th>
    <th class="table2">adres</th>
    <th class="table2">telefon</th>
    <th class="table2">notatka</th>
    <th class="table2">koszt_roboczogodziny</th>
    <c:forEach items="${employees}" var="a">
        <tr>
            <td class="table">${a.employee_id} </td> <td class="table">${a.imie} </td> <td class="table">${a.nazwisko} </td> <td class="table">${a.adres} </td> <td class="table">${a.telefon} </td> <td class="table">${a.notatka} </td> <td class="table">${a.koszt_roboczogodziny} </td>
        </tr>
    </c:forEach>
</table>
</p>

<pre>
<form action="pracownicy" method="post" class="form">
    employee_id:            <input placeHolder="employee_id" type="number" name="employee_id" class="form2"></br>
    imie:                   <input placeHolder="imie" type="text" name="imie" class="form2"></br>
    nazwisko:               <input placeHolder="nazwisko" type="text" name="nazwisko" class="form2"></br>
    adres:                  <input placeHolder="adres" type="text" name="adres" class="form2"></br>
    telefon:                <input placeHolder="telefon" type="text" name="telefon" class="form2"></br>
    notatka:                <input placeHolder="notatka" type="text" name="notatka" class="form2"></br>
    koszt_roboczogodziny:   <input placeHolder="koszt_roboczogodziny" type="text" name="koszt_roboczogodziny" class="form2"></br>
    Dodaj: <input type="radio" name="op" value="dodaj"> Modyfikuj: <input type="radio" name="op" value="modyfikuj"> Usuń: <input type="radio" name="op" value="usun"></br>
    <input type="submit" value="Wyślij" class="sub">
    <br>
</form>
</pre>


<jsp:include page="footer.jsp"/>
</body>
</html>
