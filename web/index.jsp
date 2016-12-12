<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 10/8/16
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="service.YelpAPI" %>
<html>
<head>
    <title>Geolocation Experiment</title>
</head>
<body>

<h2>Lazy Yelper</h2>

<button type="button" onclick="getLocation()"><a href="search">Lazy Search</a></button>

<p id="message"></p>
<input type="hidden" id="latitude" name="latitude" />
<input type="hidden" id="longitude" name="longitude" />

<script>
    var msg = document.getElementById("message");
    var latitude = document.getElementById("latitude");
    var longitude = document.getElementById("longitude");

    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(insertPosition);
        } else {
            msg.innerHTML = "Geolocation is not supported by this browser.";
        }
    }

    function insertPosition(position) {
        latitude.value = position.coords.latitude;
        longitude.value = position.coords.longitude;
    }
</script>
</body>
</html>
