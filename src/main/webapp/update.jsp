
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update user page</title>
</head>
<body>
    <sf:form method="post" action="/saveUpdate" modelAttribute="user">
        <sf:input path="id" type="hidden"/><br>
        <sf:input path="name" /><br>
        <sf:input path="age" /><br>
        <input type="submit" value="Update">
    </sf:form>
</body>
</html>
