<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@page session="true"%>

<!DOCTYPE html>
<% Date start = new Date(); %>
<html lang="ru">
<head>
    <title>Игра</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="../resources/css/index.css">

    <div style="text-align: center;">Страница для авторизации</div>
</head>
<body>
<div id="body_block">
    <div align="center">
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
        <form name="loginForm" action="@{/login}" method="post">
            <table align="center">
                <tr>
                    <td>
                        Введите имя пользователя:
                    </td>
                    <td>
                        <input type="text" placeholder="Имя пользователя" maxlength="50" name="login" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        Введите пароль:
                    </td>
                    <td>
                        <input type="password" placeholder="Пароль" maxlength="50" name="password" required />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Войти" maxlength="50">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <label name="label">${labelValue}</label>
                    </td>
                </tr>
            </table>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>

        <sec:authorize access="hasRole('USER')">
            <a href="hello.jsp">
                Go to Hello!
            </a>
        </sec:authorize>
    </div>
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

