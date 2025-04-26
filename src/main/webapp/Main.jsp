<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 2025-04-14
  Time: 2:31 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Virtual Garden</title>
    <script>
        function selectPlant(plantType) {
            if (plantType === 'african-violet') {
                // Hide the popup
                document.getElementById("plant-selection-popup").style.display = "none";
                // Show the homepage buttons
                //document.getElementById("homepage-buttons").style.display = "block";
            } else {
                alert("This plant is not available yet!");
            }
        }
    </script>
</head>

<body>
    <!-- Plant Selection Popup (shown first) -->
    <div id="plant-selection-popup">
        <form action="${pageContext.request.contextPath}/home" method="post">
            <h2>Select Your Plant</h2>
            <input type="hidden" name="action" value="plantSelection">

            <!-- Radio buttons for plant selection
            <input type="radio" name="selectedPlant" value="african-violet" checked> African Violet<br>
            <input type="radio" name="selectedPlant" value="cactus" disabled> Cactus (Coming Soon)<br>
            <input type="radio" name="selectedPlant" value="orchid" disabled> Orchid (Coming Soon)<br>
            -->

            <button type="submit">Submit</button>
        </form>
    </div>

    <!-- Homepage should be hidden until plant is selected but idk how to do that
    <div id="homepage-buttons">
        <h1>Plant Care</h1>

        <form action="${pageContext.request.contextPath}/home" method="post">
            <input type="hidden" name="action" value="waterPlant">
        <button type="submit">Water Plant</button>
        </form>

        <form action="${pageContext.request.contextPath}/home" method="post">
            <input type="hidden" name="action" value="showStats">
            <button type="submit">Show Plant Stats</button>
        </form>
    </div>
    -->
</body>
</html>
