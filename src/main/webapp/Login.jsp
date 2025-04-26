<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 2025-04-21
  Time: 7:47 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
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
        body {
            font-family: 'DePixelHalbfett', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-size: cover;
            background-position: center;
        }

        .login-container {
            background-color: rgba(232, 199, 236, 0.5);
            padding: 40px;
            border-radius: 10px;
            width: 350px;
            text-align: center;
            border: 1px solid white;
        }



        h1 {
            color:white;
            margin-bottom: 30px;
            font-size: 24px;
        }

        .input-group {
            margin-bottom: 20px;
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: white;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            font-family: 'DePixelHalbfett', sans-serif;
            width: 100%;
            padding: 12px;
            border: 2px solid white;
            border-radius: 8px;
            font-size: 16px;
            box-sizing: border-box;
            transition: border 0.3s;
            background-color: rgba(232, 199, 236, 0.5);
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            font-family: 'DePixelHalbfett', sans-serif;
            border-color: white;
            outline: none;
        }

        .login-btn {
            background: none;
            color: white;
            border: none;
            padding: 20px 20px;
            cursor: pointer;
            font-size: 18px;
            transition: all 0.3s ease;
            font-weight: bold;
            font-family: 'DePixelHalbfett', sans-serif;
        }

        .login-btn:hover {
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

        .forgot-password {
            display: block;
            margin-top: 15px;
            color: #588157;
            text-decoration: none;
            font-size: 14px;
        }

        .forgot-password:hover {
            text-decoration: underline;
        }

        .leaf-decoration {
            position: absolute;
            width: 100px;
            opacity: 0.6;
        }

        .leaf1 {
            top: 20px;
            left: 20px;
            transform: rotate(45deg);
        }

        .leaf2 {
            bottom: 20px;
            right: 20px;
            transform: rotate(-20deg);
        }
    </style>
</head>
<body>
<div id="backgroundimage"></div>

<div class="login-container">

    <h1>Welcome to Virtual Garden</h1>

    <form action="Login" method="post">
        <div class="input-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" placeholder="Enter your username" required>
        </div>

        <div class="input-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" required>
        </div>

        <button type="submit" class="login-btn">Log In</button>

    </form>
</div>
</body>
</html>
