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
            <li class="breadcrumb-item active">Groupes</li>
    </jsp:attribute>

    <jsp:attribute name="body">
        <c:choose>
            <c:when test="${user != null}">
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
                    <c:forEach items="${teams}" var="team">
                        <tr>
                            <td>${team.id}</td>
                            <td>${team.name}</td>
                            <td>${team.members.size()}</td>
                            <td>
                                <button class="btn btn-danger" disabled>Supprimer</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <a role="button" class="btn btn-primary" href="/creategroupe">Ajouter un groupe</a>
            </c:when>
            <c:otherwise>
                <h3 class="text-center">Vous devez vous connecter pour accèder à la liste des groupes</h3>
            </c:otherwise>
        </c:choose>
  </jsp:attribute>
</t:GenericLayout>
