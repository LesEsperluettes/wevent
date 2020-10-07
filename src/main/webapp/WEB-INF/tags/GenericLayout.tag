<%--
  Created by IntelliJ IDEA.
  User: arthu
  Date: 05/10/2020
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>

<%@tag description="LA DESCRIPTION" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="breadcrumb" fragment="true" %>
<%@attribute name="body" fragment="true" %>

<html>

<head>
    <link rel="icon" href="src/classroom.svg" sizes="any" type="image/svg+xml">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>

    <jsp:invoke fragment="header"/>

    <title>
        <jsp:invoke fragment="title"/>
    </title>
    <link rel="icon" type="image/png" href="/src/logo_wevent.png" />
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">
        <img src="/src/logo_wevent.png" width="30" height="30" alt="" loading="lazy">
        Wevent
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${pageContext.request.servletPath == '/index.jsp' ? 'active' : ''}">
                <a class="nav-link" href="/">Accueil</a>
            </li>
            <li class="nav-item ${pageContext.request.servletPath == '/groupes.jsp' ? 'active' : ''}">
                <a class="nav-link" href="/groupes">Groupes</a>
            </li>
        </ul>
        <span class="navbar-item">
            <%@ include file="../../login_partial.jsp" %>
        </span>
    </div>




</nav>

<div class="container mt-5">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <jsp:invoke fragment="breadcrumb"/>
        </ol>
    </nav>

    <jsp:invoke fragment="body"/>
</div>

</body>

<footer class="footer mt-auto py-3">
    <div class="container">
        <span class="text-muted">© Wevent - Les Esperluettes 2020</span>
    </div>
</footer>

</html>