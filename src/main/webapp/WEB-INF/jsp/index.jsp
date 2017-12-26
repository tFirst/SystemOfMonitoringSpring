<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@page session="false"%>

<!DOCTYPE html>
<% Date start = new Date(); %>
<html lang="ru">
<head>
    <title>Игра</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="../resources/css/index.css">
</head>
<body>
<div id="body_block">
    <c:url value="/logout" var="logoutUrl" />
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome : ${pageContext.request.userPrincipal.name} | <a
                href="javascript:formSubmit()"> Logout</a>
        </h2>
    </c:if>

    <a href="hello.jsp">Go test</a>
</div>
</body>
<div id="footer">
    <div>
        <label>Время генерации страницы:
            <% Date end = new Date(); %>
            <%= end.getTime() - start.getTime() %>ms
        </label>
    </div>
</div>
</html>