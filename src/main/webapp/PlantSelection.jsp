
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Plant Selection</title>
  <link rel="stylesheet" type="text/css" href="css/general.css">

 <style>
   #backgroundImage{
     position: fixed;
     top: 0;
     left: 0;
     width: 100%;
     height: 100%;
     background-image: url("./img/descarga.jpeg");
     background-size: cover;
     background-repeat: no-repeat;
     background-position: bottom;
     z-index: -1;
     filter: blur(5px) brightness(95%);
   }

   #menu {
     background-color: rgba(232, 199, 236, 0.5);
     left: 0;
     bottom: 0;
     right: 0;
     top: 0;
     padding: 80px;
     display: flex;
     justify-content: center;
     align-items: center;
     position: fixed;
   }
   .plantpw{
     width:150px ;
     height: 150px;
   }
   #plantsContainer{
     border-radius: 10px;
     border: 1px solid white;
     gap: 20px;
     flex-direction: row;
     display: flex;
     justify-content: center;
     align-items: center;
     padding: 10px;

   }

 </style>
</head>
<body>
  <div id="backgroundImage"></div>
  <div id="menu">
    <div id="plantsContainer">
    <div>
      <img src="img/AfricanVioletPrevw.png" alt="AfricanVioletPw" class="plantpw">
    </div>
      <div>
        <img src="img/AfricanVioletPrevw.png" alt="Cactuspw" class="plantpw">
      </div>
      <div>
        <img src="img/AfricanVioletPrevw.png" alt="Orquideapw" class="plantpw">
      </div>
    </div>

  </div>



</body>
</html>
