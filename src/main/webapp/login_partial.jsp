<%--
  Created by IntelliJ IDEA.
  User: arthu
  Date: 05/10/2020
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${user == null}">
        <!-- User not logged -->
        <a class="nav-link" href="/login" tabindex="-1" aria-disabled="true"> Se connecter </a>
    </c:when>
    <c:when test="${user != null}">
        <!-- User logged -->
        <a class="nav-link" href="/login?logout" tabindex="-1" aria-disabled="true"> Se deconnecter (${user.email}) </a>
    </c:when>
</c:choose>
