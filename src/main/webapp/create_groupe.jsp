<%--
  Created by IntelliJ IDEA.
  User: arthu
  Date: 06/10/2020
  Time: 09:19
  To change this template use File | Settings | File Templates.
--%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/index.css">

<t:GenericLayout>
  <jsp:attribute name="title">
    Création d'un groupe
  </jsp:attribute>

    <jsp:attribute name="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Accueil</a></li>
            <li class="breadcrumb-item"><a href="/groupes">fr.lesesperluettes.servlets.Groupes</a></li>
            <li class="breadcrumb-item active">Création d'un groupe</li>
    </jsp:attribute>

    <jsp:attribute name="body">

        <form>
            <div class="form-group">
                <label for="nomGroupe">Nom du groupe</label>
                <input type="text" class="form-control" id="nomGroupe" aria-describedby="nomGroupeHelp">
                <small id="nomGroupeHelp" class="form-text text-muted">Choisissez-bien, ce nom ne pourra pas être modifié</small>
            </div>
            
            <div class="form-group">
                <label for="descriptionGroupe">Description du groupe</label>
                <input type="text" class="form-control" id="descriptionGroupe" aria-describedby="descriptionGroupeHelp">
                <small id="descriptionGroupeHelp" class="form-text text-muted">Choisissez-bien, cette description ne pourra pas être modifié</small>
            </div>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                <label class="form-check-label" for="defaultCheck1">
                    Alexis POUPELIN
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="defaultCheck2">
                <label class="form-check-label" for="defaultCheck2">
                    Théo DAVID
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="defaultCheck3">
                <label class="form-check-label" for="defaultCheck3">
                    Antoine CORGNIARD
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="defaultCheck4">
                <label class="form-check-label" for="defaultCheck4">
                    Arthr CHERAMY
                </label>
            </div>

            <button type="submit" class="btn btn-primary mt-3">Ajouter le groupe</button>
        </form>

  </jsp:attribute>
</t:GenericLayout>
