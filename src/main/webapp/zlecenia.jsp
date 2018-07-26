<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 26.07.18
  Time: 08:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>ZLECENIA</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.jsp"/></br>
<p class="b">
<c:out value="<b> ZLECENIA </b>" escapeXml="false"/>
</p>
<p>
<table>
    <th class="table2">orders_id</th>
    <th class="table2">vehicle_id</th>
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
    <c:forEach items="${orders}" var="a">
        <tr>
            <td class="table">${a.orders_id}</td> <td class="table">${a.vehicle_id}</td> <td class="table"> ${a.employee_id}</td> <td class="table"> ${a.planowana_data_rozpoczecia_naprawy}</td> <td class="table"> ${a.data_rozpoczecia_naprawy}</td> <td class="table"> ${a.opis_problemu}</td> <td class="table"> ${a.opis_naprawy}</td> <td class="table"> ${a.status}</td> <td class="table"> ${a.koszt_naprawy_dla_klienta}</td> <td class="table"> ${a.koszt_wykorzystanych_czesci}</td> <td class="table"> ${a.koszt_roboczogodziny}</td> <td class="table"> ${a.ilosc_roboczogodzin} </td>
        </tr>
    </c:forEach>
</table>
</p>

<pre>
<form action="zlecenia" method="post" class="form">
    orders_id:                          <input placeHolder="orders_id" type="number" name="orders_id" class="form2"></br>
    vehicle_id:                         <input placeHolder="vehicle_id" type="number" name="vehicle_id" class="form2"></br>
    employee_id:                        <input placeHolder="employee_id" type="number" name="employee_id" class="form2"></br>
    planowana_data_rozpoczecia_naprawy: <input placeHolder="planowana_data_rozpoczecia_naprawy" type="date" name="planowana_data_rozpoczecia_naprawy" class="form2"></br>
    data_rozpoczecia_naprawy:           <input placeHolder="data_rozpoczecia_naprawy" type="date" name="data_rozpoczecia_naprawy" class="form2"></br>
    opis_problemu:                      <input placeHolder="opis_problemu" type="text" name="opis_problemu" class="form2"></br>
    opis_naprawy:                       <input placeHolder="opis_naprawy" type="text" name="opis_naprawy" class="form2"></br>
    status:                             <select name="status" class="form2">
                                        <option value="przyjety">przyjety</option>
                                        <option value="zatwierdzone_koszty_naprawy">zatwierdzone_koszty_naprawy</option>
                                        <option value="w_naprawie">w_naprawie</option>
                                        <option value="gotowy_do_odbioru">gotowy_do_odbioru</option>
                                        <option value="rezygnacja">rezygnacja</option>
                                        </select></br>
    koszt_naprawy_dla_klienta:          <input placeHolder="koszt_naprawy_dla_klienta" type="number" name="koszt_naprawy_dla_klienta" class="form2"></br>
    koszt_wykorzystanych_części:        <input placeHolder="koszt_wykorzystanych_czesci" type="number" name="koszt_wykorzystanych_czesci" class="form2"></br>
    koszt_roboczogodziny:               <input placeHolder="koszt_roboczogodziny" type="number" name="koszt_roboczogodziny" class="form2"></br>
    ilość_roboczogodzin:                <input placeHolder="ilosc_roboczogodzin" type="number" name="ilosc_roboczogodzin" class="form2"></br>
    Dodaj:  <input type="radio" name="op" value="dodaj">    Modyfikuj:  <input type="radio" name="op" value="modyfikuj">    Usuń: <input type="radio" name="op" value="usun"></br>
    <input type="submit" value="Wyślij" class="sub">
    <br>
</form>
</pre>
<jsp:include page="footer.jsp"/>
</body>
</html>
