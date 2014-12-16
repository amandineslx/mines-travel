<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>My profile</h1>

<div>${pageContext.request.userPrincipal.formattedProfil}</div>

<div><a href="<c:url value="../layouts/standard" />">Return</a></div>
