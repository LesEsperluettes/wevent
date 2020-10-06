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

        <h1>Nom de l'évènement</h1>
        <img src="src/programmers.jpg" class="img-fluid" alt="Image illustration">

        <p>Description de l'évènement</p>

        <p>Date</p>

        <p>Posté il y a 3 heures</p>


  </jsp:attribute>
</t:GenericLayout>
