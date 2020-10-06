<%--
  Created by IntelliJ IDEA.
  User: arthu
  Date: 05/10/2020
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/index.css">


<t:GenericLayout>
  <jsp:attribute name="title">
    Evenement
  </jsp:attribute>

    <jsp:attribute name="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Accueil</a></li>
            <li class="breadcrumb-item active" aria-current="page">Evenement</li>
    </jsp:attribute>

    <jsp:attribute name="body">
        <c:if test="${exception != null}">
            <div class="alert alert-danger" role="alert">
                ${exception}
            </div>
        </c:if>

        <c:choose>
            <c:when test="${activity != null}">
                <h1>${activity.name}</h1>
                <img src="${activity.imagePath}" class="img-fluid" alt="Image illustration">

                <p>${activity.description}</p>

                <p>Du ${activity.formatDate(activity.startDate)} au ${activity.formatDate(activity.endDate)}</p>

                <p>Posté ${activity.getTimeText()}</p>
            </c:when>
            <c:otherwise>

            </c:otherwise>
        </c:choose>
  </jsp:attribute>
</t:GenericLayout>
