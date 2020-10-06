<%@ page import="org.ocpsoft.prettytime.PrettyTime" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: codev
  Date: 18/09/2020
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/index.css">

<t:GenericLayout>
  <jsp:attribute name="title">
    Accueil
  </jsp:attribute>

    <jsp:attribute name="breadcrumb">
            <li class="breadcrumb-item">Accueil</li>
    </jsp:attribute>

  <jsp:attribute name="body">
      <form class="form-inline" action="index" method="get">
          <label class="sr-only" for="lieu">Name</label>
          <input type="text" class="form-control mb-2 mr-sm-2" id="lieu" placeholder="Le Mans, France" name="search">
          <button type="submit" class="btn btn-outline-primary mb-2">Chercher</button>
      </form>

      <a type="button" class="btn btn-outline-success" href="/createevent">Ajouter un évènement</a>

      <div class="card-deck mt-3">
          <c:forEach items="${events}" var="event">
              <div class="card">
                  <img src="/src/default.png" class="card-img-top" alt="event image">
                  <div class="card-body d-flex flex-column">
                      <h5 class="card-title">${event.name}</h5>
                      <p class="card-text"></p>
                      <p class="card-text">${event.place.name} <small>(${event.place.address})</small></p>
                      <p class="card-text">
                          <small class="text-muted">Ajouté ${event.getTimeText()}</small></p>
                      <a href="/evenement?id=${event.id}" class="align-self-end btn btn-lg btn-block btn-outline-primary" role="button" aria-pressed="true">Voir</a>
                  </div>
              </div>
          </c:forEach>
      </div>

  </jsp:attribute>
</t:GenericLayout>
