
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="css/general.css">
    <style>

        #backgroundimage{
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
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'DePixelHalbfett', sans-serif;
            position: relative;
            min-height: 100vh;
        }


        #title {
            font-family: 'DePixelHalbfett', sans-serif;
            font-size: 60px;
            text-align: center;
            margin-top: 150px;
            margin-bottom: 110px;
            color: white;
            /*
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


            filter: drop-shadow(2px 2px 0 grey)
            drop-shadow(-0.6px 0.6px 0 grey)
            drop-shadow(0.6px -0.6px 0 grey)
            drop-shadow(-0.6px -0.6px 0 grey);

             */
        }

        #menu {
            text-align: center;
            background-color: rgba(232, 199, 236, 0.5);
            border-radius: 10px;
            padding: 10px;
            width: 200px;
            height: 200px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            position: fixed;
            left: 50%;
            top:50%;
            margin-top:110px ;
            transform: translate(-50%, -50%);
            border: 1px solid white;
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

    </style>
</head>
<body>
    <div id="backgroundimage"></div>
    <div style = "padding: 10px;">

        <div id="title">
            <p>VIRTUAL GARDEN</p>
        </div>

        <form action="menu" method="post" >
            <div id="menu">
                <button type="submit" name="action" value="selectPlant" >SELECT PLANT</button>
                <button type="submit" name="action" value="play" >PLAY</button>
                <button type="submit" name="action" value="login">LOGIN</button> <!--check if the location is right-->
            </div>
        </form>
    </div>

</body>
</html>
