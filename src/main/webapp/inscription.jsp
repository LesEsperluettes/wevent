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
        <c:if test="${feedback.exception != null}">
            <div class="alert alert-danger" role="alert">
                ${feedback.exception}
            </div>
        </c:if>

        <form action="inscription" method="POST">
            <div class="form-group">
                <label for="email">Adresse mail</label>
                <input type="email" class="form-control ${feedback.email == null ? '' : 'is-invalid' }" id="email" name="email">
                <c:if test="${feedback.email != null}">
                    <div class="invalid-feedback">
                            ${feedback.email}
                    </div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="nom">Nom</label>
                <input type="text" class="form-control ${feedback.name == null ? '' : 'is-invalid' }" id="nom" name="name">
                <c:if test="${feedback.name != null}">
                    <div class="invalid-feedback">
                            ${feedback.name}
                    </div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="prenom">Prenom</label>
                <input type="text" class="form-control ${feedback.surname == null ? '' : 'is-invalid' }" id="prenom" name="surname">
                <c:if test="${feedback.surname != null}">
                    <div class="invalid-feedback">
                            ${feedback.surname}
                    </div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="datenaissance">Date de naissance</label>
                <input type="date" class="form-control ${feedback.birthdate == null ? '' : 'is-invalid' }" id="datenaissance" name="birthdate">
                <c:if test="${feedback.birthdate != null}">
                    <div class="invalid-feedback">
                            ${feedback.birthdate}
                    </div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="motDePasse">Mot de passe</label>
                <input type="password" class="form-control ${feedback.password == null ? '' : 'is-invalid' }" id="motDePasse" name="password">
                <c:if test="${feedback.password != null}">
                    <div class="invalid-feedback">
                            ${feedback.password}
                    </div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="motDePasse2">Confirmation du mot de passe</label>
                <input type="password" class="form-control ${feedback.password_confirm == null ? '' : 'is-invalid' }" id="motDePasse2" name="password_confirm">
                <c:if test="${feedback.password_confirm != null}">
                    <div class="invalid-feedback">
                            ${feedback.password_confirm}
                    </div>
                </c:if>
            </div>

            <button type="submit" class="btn btn-primary">Créer le compte</button>
        </form>

  </jsp:attribute>
</t:GenericLayout>