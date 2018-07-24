<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<p>
    <c:forEach items="employees" var="a">
        ${a.employee_id}  ${a.imie} <br/>
    </c:forEach>

</p>
${}

<jsp:include page="footer.jsp"/>
</body>
</html>