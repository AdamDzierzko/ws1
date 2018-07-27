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
    <link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.jsp"/></br>
<p class="b">
<c:out value="<b> POJAZDY </b>" escapeXml="false"/>
</p>
<p>
<table >
    <th class="table2">vehicle_id</th>
    <th class="table2">customer_id</th>
    <th class="table2">model</th>
    <th class="table2">rok_produkcji</th>
    <th class="table2">nr_rejestracyjny</th>
    <th class="table2">data_kolejnego_przeglądu</th>
    <c:forEach items="${vehicles}" var="a">
        <tr>
            <td class="table">${a.vehicle_id} </td> <td class="table">${a.customer_id} </td> <td class="table">${a.model} </td> <td class="table">${a.rok_produkcji} </td> <td class="table">${a.nr_rejestracyjny} </td> <td class="table">${a.data_kolejnego_przeglądu} </td>
        </tr>
    </c:forEach>
</table>
</p>

<c:if test="${g==1}">
    <p class="b">
        <c:out value="<b> LISTA NAPRAW POJAZDU ${d} </b>" escapeXml="false"/>
    </p>

    <table >
        <th class="table2">orders_id</th>
        <th class="table2">employee_id</th>
        <th class="table2">planowana_data_rozpoczecia_naprawy</th>
        <th class="table2">data_rozpoczecia_naprawy</th>
        <th class="table2">opis_problemu</th>
        <th class="table2">opis_naprawy</th>
        <th class="table2">status</th>
        <th class="table2">koszt_naprawy_dla_klienta</th>
        <th class="table2">koszt_wykorzystanych_czesci</th>
        <th class="table2">koszt_roboczogodziny</th>
        <th class="table2">ilosc_roboczogodzin</th>
        <c:forEach items="${o}" var="c">
            <tr>
                <td class="table">${c.orders_id}</td> <td class="table"> ${c.employee_id}</td> <td class="table"> ${c.planowana_data_rozpoczecia_naprawy}</td> <td class="table"> ${c.data_rozpoczecia_naprawy}</td> <td class="table"> ${c.opis_problemu}</td> <td class="table"> ${c.opis_naprawy}</td> <td class="table"> ${c.status}</td> <td class="table"> ${c.koszt_naprawy_dla_klienta}</td> <td class="table"> ${c.koszt_wykorzystanych_czesci}</td> <td class="table"> ${c.koszt_roboczogodziny}</td> <td class="table"> ${c.ilosc_roboczogodzin} </td>
            </tr>
        </c:forEach>

    </table>
</c:if>

<pre>
<form action="pojazdy" method="post" class="form">
    vehicle_id:                 <input placeHolder="vehicle_id" type="number" name="vehicle_id" class="form2"></br>
    customer_id:                <input placeHolder="customer_id" type="text" name="customer_id" class="form2"></br>
    model:                      <input placeHolder="model" type="text" name="model" class="form2"></br>
    rok_produkcji:              <input placeHolder="rok_produkcji" type="text" name="rok_produkcji" class="form2"></br>
    nr_rejestracyjny:           <input placeHolder="nr_rejestracyjny" type="text" name="nr_rejestracyjny" class="form2"></br>
    data_kolejnego_przegladu:   <input placeHolder="data_kolejnego_przegladu" type="date" name="data_kolejnego_przegladu" class="form2"></br>
    Dodaj:  <input type="radio" name="op" value="dodaj">    Modyfikuj:  <input type="radio" name="op" value="modyfikuj">    Usuń:   <input type="radio" name="op" value="usun"> Lista napraw pojazdu:   <input type="radio" name="op" value="ln"></br>
    <input type="submit" value="Wyślij" class="sub">
    <br>
</form>
</pre>

<jsp:include page="footer.jsp"/>
</body>
</html>
