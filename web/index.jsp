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

      <h2>Simple Webapp</h2>

      <ul>
        <li><a href="search">Search</a></li>
      </ul>

      <%--<h3 class="message"><%=YelpAPI.getMessage()%></h3>--%>

      <%--<p>Click the button to get your coordinates.</p>--%>

      <%--<button onclick="getLocation()">Try It</button>--%>

      <%--<p id="demo"></p>--%>

      <script>
        var x = document.getElementById("demo");

        function getLocation() {
          if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);
          } else {
            x.innerHTML = "Geolocation is not supported by this browser.";
          }
        }

        function showPosition(position) {
          x.innerHTML = "Latitude: " + position.coords.latitude +
                  "<br>Longitude: " + position.coords.longitude;
        }
      </script>
    </body>
</html>
