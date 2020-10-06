<%--
  Created by IntelliJ IDEA.
  User: arthu
  Date: 05/10/2020
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/index.css">


<t:GenericLayout>
  <jsp:attribute name="title">
    Inscription
  </jsp:attribute>

    <jsp:attribute name="breadcrumb">
            <li class="breadcrumb-item active"><a href="/">Accueil</a></li>
            <li class="breadcrumb-item">Inscription</li>
    </jsp:attribute>

    <jsp:attribute name="body">

        <form>
            <div class="form-group">
                <label for="email">Adresse mail</label>
                <input type="email" class="form-control" id="email">
            </div>

            <div class="form-group">
                <label for="nom">Nom</label>
                <input type="text" class="form-control" id="nom">
            </div>

            <div class="form-group">
                <label for="prenom">Prenom</label>
                <input type="text" class="form-control" id="prenom">
            </div>

            <div class="form-group">
                <label for="datenaissance">Date de naissance</label>
                <input type="date" class="form-control" id="datenaissance">
            </div>

            <div class="form-group">
                <label for="motDePasse">Mot de passe</label>
                <input type="password" class="form-control" id="motDePasse">
            </div>

            <div class="form-group">
                <label for="motDePasse2">Confirmation du mot de passe</label>
                <input type="password" class="form-control" id="motDePasse2">
            </div>

            <button type="submit" class="btn btn-primary">Créer le compte</button>
        </form>

  </jsp:attribute>
</t:GenericLayout>