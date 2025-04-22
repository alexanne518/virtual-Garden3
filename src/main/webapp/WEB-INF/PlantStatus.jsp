<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 2025-04-21
  Time: 5:44 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.virtualgarden3.model.*" %>

<html>
<head>
    <title>Plant Status</title>
</head>
<body>
    <h1>Plant Status</h1>

    <%
        Plant plant = (Plant) session.getAttribute("currentPlant");
        System.out.println("DEBUG - Plant in session: " + plant); // Check server logs
        if (plant != null) {
            System.out.println("DEBUG - Plant name: " + plant.getName());
    %>
    <p><strong>Type:</strong> <%= plant.getName() %></p>
    <p><strong>Water Level:</strong> <%= plant.getWaterLevel() %>%</p>

    <!-- Water Button -->

    <% } else { %>
    <p>No plant selected. <a href="${pageContext.request.contextPath}/home">Go back</a></p>
    <% } %>
</body>
</html>
