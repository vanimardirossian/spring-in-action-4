<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/webapp/resources/style.css"/>">
</head>
<body>
<h1><s:message code="spittr.welcome"/></h1>
<a href="<s:url value="/spittles"/>">Spittles</a>
<a href="<s:url value="/spitter/register"/>">Register</a>
</body>
</html>