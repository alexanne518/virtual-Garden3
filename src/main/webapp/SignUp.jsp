<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 2025-04-26
  Time: 2:20 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nature's Path - Sign Up</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f5f9f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-size: cover;
            background-position: center;
        }

        .signup-container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
            border: 1px solid #d1e0d7;
        }

        h1 {
            color: #3a5a40;
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
            color: #588157;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 2px solid #d1e0d7;
            border-radius: 8px;
            font-size: 16px;
            box-sizing: border-box;
            transition: border 0.3s;
            background-color: #f8fbf8;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #3a5a40;
            outline: none;
        }

        .signup-btn {
            background-color: #3a5a40;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
            transition: background-color 0.3s;
            font-weight: bold;
            margin-top: 10px;
        }

        .signup-btn:hover {
            background-color: #588157;
        }

        .login-link {
            display: block;
            margin-top: 15px;
            color: #588157;
            text-decoration: none;
            font-size: 14px;
        }

        .login-link:hover {
            text-decoration: underline;
        }

        .error-message {
            color: #d32f2f;
            margin-bottom: 15px;
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="signup-container">
    <h1>Create Your Virtual Garden Account</h1>

    <%-- Display error message if present --%>
    <% if (request.getAttribute("error") != null) { %>
    <div class="error-message">
        <%= request.getAttribute("error") %>
    </div>
    <% } %>

    <form action="signup" method="post">
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
