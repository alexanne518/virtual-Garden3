<%@ page import="com.example.virtualgarden3.model.Plant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/general.css">
    <title>Virtual Garden</title>
    <link rel="stylesheet" type="text/css" href="css/general.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        *, *::before, *::after {
            box-sizing: inherit;
        }

        #backgroundimage {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-image: url("./img/gamebg.jpeg");
            background-size: cover;
            background-repeat: no-repeat;
            background-position: bottom;
            z-index: -1;
            filter: blur(5px) brightness(95%);
        }

        #plandiv {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-end;
        }

        #table {
            width: 400px;
            transform: translateY(20%);
            z-index: -1;
            position: fixed;
        }

        #plant {
            width: 100px;
            transform: translateY(-100%);
            position: fixed;
        }

        #container{
            display: flex;
            justify-content: space-between;
            padding: 10px;
            box-sizing: border-box;
            height: 100%;
        }

        #menu {
            align-self: flex-start; /* ADD THIS */

            box-sizing: border-box;
            font-family: 'DePixelHalbfett', sans-serif;
            background-color: rgba(0, 122, 179, 0.5);
            border-radius: 10px;
            padding: 10px;
            display: flex;
            flex-direction: column;
            justify-content: left;
            border: 1px solid white;
            font-size: 1em;
            color: white;

        }
        #menu1 {
            align-self: flex-start; /* ADD THIS */

            box-sizing: border-box;
            font-family: 'DePixelHalbfett', sans-serif;
            background-color: rgba(232, 199, 236, 0.5);
            border-radius: 10px;
            padding: 10px;
            display: flex;
            flex-direction: column;
            align-items: center;
            border: 1px solid white;
            font-size: 1em;
            color: white;
            gap: 3px;
        }
        #menu1 button {
            background-color: transparent;
            border: none;
            display: flex;
            flex-direction: column;
            align-items: center;
            cursor: pointer;
        }

        #menu1 button:hover {
            opacity: 0.8; /* Efecto de hover */
        }
    </style>




</head>
<body>
<div id="backgroundimage"></div>

<div id="container">

    <div id="menu">
        <p>Stats:</p>
        <p>Water level: ${plant.waterLevel}%</p>
        <p>Vitamins: ${plant.vitaminsLevel} / 5</p>
        <p>Growing speed: ${plant.fertilizerLevel * 3 + 10}%</p>
        <p>General health: ${plant.health}%</p>

    </div>


    <div id="plandiv">
        <img id="plant" src="./img/babyviolet.png" alt="planta">
        <img id="table" src="./img/table.png" alt="mesa">
    </div>


    <div id="menu1">
        <form id="toolsForm" action="virtualgarden" method="post">

            <p>Stats:</p>
            <button id="watercanBtn" type="submit" name="action" value="waterCan">
                <img src="./img/watercan.png" alt="watercan" width="150px">
            </button>
            <h5>Water Can</h5>

            <button id="fertilizerBtn" type="submit" name="action" value="fertilizer">
                <img src="./img/fertilizer.png" alt="fertilizer" width="100px">
            </button>
            <h5>Fertilizer</h5>

            <button id="plantFoodBtn" type="submit" name="action" value="plantFood" >
                <img src="./img/plantFood.png" alt="plantfood" width="100px">
            </button>
            <h5>Plant Food</h5>

        </form>
    </div>

</div>
</body>
</html>
