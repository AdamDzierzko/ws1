<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<c:out value="<b> KLIENCI </b>" escapeXml="false"/>

<p>
    <c:forEach items="customers" var="a">
        ${a.customer_id}  ${a.imie} <br/>
    </c:forEach>

</p>
${}
<jsp:include page="footer.jsp"/>
</body>
</html>