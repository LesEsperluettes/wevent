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
            <li class="breadcrumb-item"><a href="/groupes">Groupes</a></li>
            <li class="breadcrumb-item active">Création d'un groupe</li>
    </jsp:attribute>

    <jsp:attribute name="body">
        <form method="post" action="creategroupe">
            <div class="form-group">
                <label for="nomGroupe">Nom du groupe</label>
                <input type="text" class="form-control" id="nomGroupe" name="nomGroupe" aria-describedby="nomGroupeHelp">
                <small id="nomGroupeHelp" class="form-text text-muted">Choisissez-bien, ce nom ne pourra pas être modifié</small>
            </div>
            
            <div class="form-group">
                <label for="descriptionGroupe">Description du groupe</label>
                <input type="text" class="form-control" id="descriptionGroupe" name="descriptionGroupe" aria-describedby="descriptionGroupeHelp">
                <small id="descriptionGroupeHelp" class="form-text text-muted">Choisissez-bien, cette description ne pourra pas être modifié</small>
            </div>

            <div class="form-group">
                <label for="ajoutMembreGroupe">L'ajout d'un futur membre</label>
                <input type="text" class="form-control" id="ajoutMembreGroupe" name="ajoutMembreGroupe" aria-describedby="ajoutMembreGroupeHelp">
                <small id="ajoutMembreGroupeHelp" class="form-text text-muted">Renseigner l'adresse mail des membres à ajouter</small>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Ajouter le groupe</button>
        </form>

  </jsp:attribute>
</t:GenericLayout>
