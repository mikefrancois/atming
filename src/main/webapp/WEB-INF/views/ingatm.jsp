<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ING ATM Application</title>
    <style>
        .username.ng-valid {
            background-color: lightgreen;
        }

        .username.ng-dirty.ng-invalid-required {
            background-color: red;
        }

        .username.ng-dirty.ng-invalid-minlength {
            background-color: yellow;
        }

        .email.ng-valid {
            background-color: lightgreen;
        }

        .email.ng-dirty.ng-invalid-required {
            background-color: red;
        }

        .email.ng-dirty.ng-invalid-email {
            background-color: yellow;
        }

    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="ControllerService as ctrl">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of ATMs</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Address</th>
                    <th>Distance</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.atms">
                    <td><span ng-bind="u.address.street"></span></td>
                    <td><span ng-bind="u.address.housenumber"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/ingatmui_service.js' />"></script>
<script src="<c:url value='/static/js/controller/ingatmui_controller.js' />"></script>
</body>
</html>
