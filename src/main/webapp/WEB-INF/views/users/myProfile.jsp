<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h1>My profile</h1>

<div>${pageContext.request.userPrincipal.name}</div>

<div><a href="<c:url value="/" />">Return</a></div>
