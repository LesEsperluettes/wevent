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
        <c:if test="${exception != null}">
            <div class="alert alert-danger" role="alert">
                ${exception}
            </div>
        </c:if>

        <c:choose>
            <c:when test="${activity != null}">
                <!-- Modal subscribe -->
                <div class="modal fade" id="validateModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Inscription à l'activité</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Voulez-vous vous inscrire à l'activité "${activity.name}" ?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Non j'ai changé d'avis</button>
                                <form action="evenement" method="POST">
                                    <input type="hidden" value="true" name="subscribe">
                                    <input type="hidden" value="${activity.id}" name="activityId">
                                    <button type="submit" class="btn btn-primary">Oui m'inscrire</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Modal unsubscribe -->
                <div class="modal fade" id="validateUnsubscribeModal" tabindex="-1" role="dialog" aria-labelledby="unsubscribeModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="unsubscribeModalLabel">Désinscription de l'activité</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Voulez-vous vous désinscrire de l'activité "${activity.name}" ?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Non j'ai changé d'avis</button>
                                <form action="evenement" method="POST">
                                    <input type="hidden" value="true" name="unsubscribe">
                                    <input type="hidden" value="${activity.id}" name="activityId">
                                    <button type="submit" class="btn btn-primary">Oui me désinscrire</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="card">
                            <img src="${activity.imagePath}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">${activity.name}</h5>
                                <p class="card-text">${activity.description}</p>
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item"><strong>Début :</strong> ${activity.formatDate(activity.startDate)}</li>
                                <li class="list-group-item"><strong>Fin :</strong> ${activity.formatDate(activity.endDate)}</li>
                                <li class="list-group-item"><strong>Lieu :</strong> ${activity.place.name} <small>(${activity.place.address})</small></li>
                            </ul>
                            <div class="card-body">
                                <c:if test="${user == null}"><span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Vous devez être connecté pour vous inscrire à un événement"></c:if>
                                    <c:choose>
                                        <c:when test="${user != null && subscribed != null}">
                                            <a class="btn btn-danger" data-toggle="modal" data-target="#validateUnsubscribeModal">Se désinscrire</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="btn btn-primary ${user == null ? 'disabled':''}" data-toggle="modal" data-target="#validateModal">S'inscrire</a>
                                        </c:otherwise>
                                    </c:choose>
                                <c:if test="${user == null}"></span></c:if>
                                <span class="ml-2">
                                    <c:choose>
                                        <c:when test="${activity.users.size() == 0}">Soyez le premier à vous inscrire !</c:when>
                                        <c:when test="${activity.users.size() > 0}">Déja ${activity.users.size()} personne(s) y participe(nt) !</c:when>
                                    </c:choose>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <iframe style="width: 100%; height: 100%" id="gmap_canvas" src="https://maps.google.com/maps?q=${activity.getEncodedAddress()}&t=&z=16&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>
                    </div>
            </c:when>
            <c:otherwise>

            </c:otherwise>
        </c:choose>
  </jsp:attribute>
</t:GenericLayout>

<script type="application/javascript">
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip()
    });
</script>
