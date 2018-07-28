<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 28.07.18
  Time: 16:01
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
<p class="b">
    <c:out value="<b> RAPORT </b>" escapeXml="false"/><br>
</p>

<c:if test="${a==1}">
    <p class="b">
        <c:out value="<b> PRACOWNICZY </b>" escapeXml="false"/>
    </p>

    <table >
        <th class="table2">imie</th>
        <th class="table2">nazwisko</th>
        <th class="table2">ilość roboczogodzin</th>
        <c:forEach items="${o}" var="c">
            <tr>
                <td class="table">${c.imie} </td> <td class="table">${c.nazwisko} </td> <td class="table">${c.sum} </td>

            </tr>
        </c:forEach>

    </table>
</c:if>



<pre>
<form action="raporty" method="post" class="form">
    data początkowa:    <input placeHolder="data początkowa" type="date" name="startdate" class="form2"></br>
    data końcowa:       <input placeHolder="data końcowa" type="date" name="enddate" class="form2"></br>
    <input type="submit" value="Wyślij" class="sub">
    <br>
</form>
</pre>


<jsp:include page="footer.jsp"/>
</body>
</html>
