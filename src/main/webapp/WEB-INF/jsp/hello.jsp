<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<head>
    <title>Hello World!</title>
</head>
<body>
<h1>${test}</h1>
<form action="goBack" method="POST">
    <input type="text" name="message">
    <input type="submit">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<a href="index">Go home</a>
</body>
</html>