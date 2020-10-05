<%--
  Created by IntelliJ IDEA.
  User: arthu
  Date: 05/10/2020
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>


<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/index.css">


<t:GenericLayout>
  <jsp:attribute name="title">
    Connexion
  </jsp:attribute>

    <jsp:attribute name="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Accueil</a></li>
            <li class="breadcrumb-item active">Connexion</li>
    </jsp:attribute>

    <jsp:attribute name="body">

        <form>
            <div class="form-group">
                <label for="email">Adresse mail</label>
                <input type="email" class="form-control" id="email">
            </div>
            
            <div class="form-group">
                <label for="motDePasse">Mot de passe</label>
                <input type="password" class="form-control" id="motDePasse">
            </div>

            <button type="submit" class="btn btn-primary">Se connecter</button>
        </form>

        <p>Vous n'avez pas de compte ? <a href="/inscription">Créez-en un !</a></p>
        
  </jsp:attribute>
</t:GenericLayout>