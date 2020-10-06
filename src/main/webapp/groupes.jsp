<%--
  Created by IntelliJ IDEA.
  User: arthu
  Date: 06/10/2020
  Time: 09:02
  To change this template use File | Settings | File Templates.
--%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/index.css">

<t:GenericLayout>
  <jsp:attribute name="title">
    fr.lesesperluettes.servlets.Groupes
  </jsp:attribute>

    <jsp:attribute name="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Accueil</a></li>
            <li class="breadcrumb-item active">fr.lesesperluettes.servlets.Groupes</li>
    </jsp:attribute>

    <jsp:attribute name="body">

        <table class="table table-hover">
            <thead class="thead-light">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nom du groupe</th>
                <th scope="col">Nombre de personnes dans le groupe</th>
                <th scope="col">Supprimer</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Les footballers</td>
                <td>12</td>
                <td>
                    <button class="btn btn-danger">Supprimer</button>
                </td>
            </tr>
            </tbody>
        </table>


    <a role="button" class="btn btn-primary" href="/creategroupe">Ajouter un groupe</a>

  </jsp:attribute>
</t:GenericLayout>
