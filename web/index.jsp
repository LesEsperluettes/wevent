<%--
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
      <form class="form-inline">
          <label class="sr-only" for="lieu">Name</label>
          <input type="text" class="form-control mb-2 mr-sm-2" id="lieu" placeholder="Le Mans, France">
          <button type="submit" class="btn btn-outline-primary mb-2">Chercher</button>
      </form>

      <a type="button" class="btn btn-outline-success" href="/createevent">Ajouter un évènement</a>

      <div class="card-deck mt-3">
          <div class="card">
              <img src="src/football.jpg" class="card-img-top" alt="...">
              <div class="card-body d-flex flex-column">
                  <h5 class="card-title">Match de football</h5>
                  <p class="card-text">Venez vous entrainer avec une équipe de passionnés !</p>
                  <p class="card-text"><small class="text-muted">Ajouté il y a 5 heures</small></p>
                  <a href="/evenement" class="align-self-end btn btn-lg btn-block btn-outline-primary" role="button" aria-pressed="true">Voir</a>
              </div>
          </div>

          <div class="card">
              <img src="src/poker.jpg" class="card-img-top" alt="...">
              <div class="card-body d-flex flex-column">
                  <h5 class="card-title">Tounois de poker</h5>
                  <p class="card-text">Devenez riche ou devenez pauvre, on ne sait jamais à quoi s'attendre...</p>
                  <p class="card-text"><small class="text-muted">Ajouté il y a un jour</small></p>
                  <a href="/evenement" class="align-self-end btn btn-lg btn-block btn-outline-primary" role="button" aria-pressed="true">Voir</a>
              </div>
          </div>

          <div class="card">
              <img src="src/programmers.jpg" class="card-img-top" alt="...">
              <div class="card-body d-flex flex-column">
                  <h5 class="card-title">24H du code</h5>
                  <p class="card-text">Ca va sentir le mâle</p>
                  <p class="card-text"><small class="text-muted">Ajouté il y a 2 jours</small></p>
                  <a href="/evenement" class="align-self-end btn btn-lg btn-block btn-outline-primary" role="button" aria-pressed="true">Voir</a>
              </div>
          </div>
      </div>

  </jsp:attribute>
</t:GenericLayout>
