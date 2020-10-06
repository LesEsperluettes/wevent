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


    <button type="button" class="btn btn-primary" id="ajouterClasse">Ajouter un groupe</button>

  </jsp:attribute>
</t:GenericLayout>
