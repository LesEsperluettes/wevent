<%--
  Created by IntelliJ IDEA.
  User: arthu
  Date: 05/10/2020
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/index.css">


<t:GenericLayout>
  <jsp:attribute name="title">
    Création d'un évènement
  </jsp:attribute>

    <jsp:attribute name="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Accueil</a></li>
            <li class="breadcrumb-item active" aria-current="page">Création d'un évènement</li>
    </jsp:attribute>

    <jsp:attribute name="body">
      <form action="createevent" method="POST">
          <div class="form-group">
              <label for="nomEvenement">Nom de l'évènement</label>
              <input type="text" class="form-control" id="nomEvenement" name="nomEvenement" required aria-describedby="nomEvenementHelp">
              <small id="nomEvenementHelp" class="form-text text-muted">Choisissez un nom concis pour votre
                  évènement.</small>
          </div>

          <div class="form-group">
              <label for="descriptionEvenement" aria-describedby="descriptionEvenementHelp">Description de
                  l'évènement</label>
              <input type="text" class="form-control" id="descriptionEvenement" name="descriptionEvenement">
              <small id="descriptionEvenementHelp" class="form-text text-muted">Décrivez votre évènement aux
                  utilisateurs.</small>
          </div>

          <div class="form-group">
              <label for="imageIllustration" aria-describedby="imageIllustrationHelp">Image d'illustration</label>
              <input type="file" class="form-control-file" id="imageIllustration" name="imageIllustration">
              <small id="imageIllustrationHelp" class="form-text text-muted">Une image d'illustration permet au visiteur
                  d'être engagé avec la proposition d'évènement qu'il a sous les yeux.</small>
          </div>

          <div class="form-group">
              <label class="form-check-label" for="dateEvenementDebut">Date de début l'évènement</label>
              <input type="date" class="form-control" id="dateEvenementDebut" name="dateEvenementDebut" required>
          </div>

          <div class="form-group">
              <label class="form-check-label" for="dateEvenementFin">Date de fin de l'évènement</label>
              <input type="date" class="form-control" id="dateEvenementFin" name="dateEvenementFin" required>
          </div>
          <div class="form-group">
              <label for="lieuEvenement">Lieu de l'évènement</label>
              <input type="text" class="form-control" id="lieuEvenement" name="lieuEvenement" aria-describedby="lieuEvenementHelp" required>
              <small id="lieuEvenementHelp" class="form-text text-muted">Choisissez un lieu pour localiser votre
                  événement</small>
          </div>
          <div class="form-group">
              <label for="adresseEvenement">Adresse de l'évènement</label>
              <input type="text" class="form-control" id="adresseEvenement" name="adresseEvenement" aria-describedby="adresseEvenementHelp" required>
              <small id="adresseEvenementHelp" class="form-text text-muted">Renseigner l'adresse de l'événement</small>
          </div>
          <div class="form-group">
              <label for="typeEvenement">Type de l'évènement</label>
              <select class="form-control" multiple name="activityType" id="typeEvenement" required>
                <c:forEach items="${activitiesTypes}" var="activityType">
                    <option value="${activityType}" >${activityType}</option>
                </c:forEach>
              </select>
          </div>
          <button type="submit" class="btn btn-primary">Créer</button>
      </form>

</jsp:attribute>
</t:GenericLayout>