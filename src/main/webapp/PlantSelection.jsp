
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
     /*background-color: rgba(232, 199, 236, 0.5);*/
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
     background-color: rgba(232, 199, 236, 0.5);
     border-radius: 10px;
     border: 1px solid white;
     gap: 20px;
     flex-direction: row;
     display: flex;
     justify-content: center;
     align-items: center;
     padding: 10px;
   }
   button{
     color: white;
     font-size: large;
     font-family: 'DePixelHalbfett', sans-serif;
     background: none;
     border: none;
     cursor:pointer;
     transition: all 0.3s ease;
     padding: 2px;
   }
   button:hover {
     background: linear-gradient(
             90deg,
             #f6d8ae,
             #f7c1c0,
             #c9c4e3,
             #a7c6e3,
             #b5e3cb
     );
     background-clip: text;
     -webkit-background-clip: text;
     color: transparent;
     -webkit-text-fill-color: transparent;
     filter: drop-shadow(1px 1px 0 #f1f1f1)
     drop-shadow(-0.3px 0.3px 0 #f1f1f1)
     drop-shadow(0.3px -0.3px 0 #f1f1f1)
     drop-shadow(-0.3px -0.3px 0 #f1f1f1);
   }
   h5{
     font-family: 'DePixelHalbfett', sans-serif;
   }


 </style>
</head>
<body>
  <div id="backgroundImage"></div>
  <div id="menu">
      <form action="PlantSelection" method="post">
        <div id="plantsContainer">
          <div style="display: flex; flex-direction: column;">
            <img src="img/AfricanVioletPrevw.png" alt="AfricanVioletPw" class="plantpw">
            <h5>African Violet</h5>
            <button type="submit" name="plantId" value="0">SELECT</button>
          </div>
          <div style="display: flex; flex-direction: column;">
            <img src="img/CactusPreview.png" alt="Cactuspw" class="plantpw">
            <h5>(Not Available)</h5>
            <button>SELECT</button>
          </div>
          <div style="display: flex; flex-direction: column;">
            <img src="img/orquideaprevw.png" alt="Orquideapw" class="plantpw">
            <h5>(Not Available)</h5>
            <button>SELECT</button>
          </div>
        </div>
      </form>
  </div>



</body>
</html>
