<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:url var="rootURL" value="/"/>

<!DOCTYPE html>
<html>
<head>
<base href="${rootURL}">
<title>Admin</title>
</head>
<body>
<h2>Hello <sec:authentication property="name"/></h2>
<p><a href="j_spring_security_logout">Logout(/j_spring_security_logout)</a> </p>
<p><a href="logout">Logout(/logout)</a> </p>

</body>
</html>