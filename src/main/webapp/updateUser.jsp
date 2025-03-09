<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User</title>
    <style>
        /* Your CSS Styles */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f8ff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: linear-gradient(to bottom right, #00aaff, #00ffaf);
        }
        .container {
            text-align: center;
            padding: 30px;
            background-color: #ffffff;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            border-radius: 15px;
            max-width: 500px;
            width: 100%;
        }
        h1 {
            color: #0056b3;
            margin-bottom: 20px;
        }
        .message {
            color: #28a745;
            font-weight: bold;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .form-group {
            width: 100%;
            margin-top: 15px;
            position: relative;
        }
        .form-group label {
            font-size: 18px;
            color: #333;
        }
        .form-group i {
            position: absolute;
            left: 10px;
            top: 40px;
            font-size: 20px;
            color: #007bff;
        }
        .form-group input[type="text"],
        .form-group input[type="email"],
        .form-group input[type="tel"] {
            width: calc(100% - 40px);
            padding: 12px 20px 12px 35px;
            margin-top: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .buttons {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
            width: 100%;
        }
        input[type="submit"], .main-page-btn {
            padding: 12px 25px;
            font-size: 18px;
            color: #ffffff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            text-decoration: none;
        }
        input[type="submit"]:hover, .main-page-btn:hover {
            background-color: #0056b3;
        }
    </style>
    <!-- FontAwesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div class="container">
        <h1>Update User Details</h1>

        <!-- Display success messages if any -->
        <c:if test="${not empty message}">
            <div class="message">${message}</div>
        </c:if>

        <form action="updateUser" method="post">
            <!-- Hidden input to store the user ID -->
            <input type="hidden" name="id" value="${user.id}" />

            <div class="form-group">
                <label for="name"><i class="fas fa-user"></i> Name:</label>
                <input type="text" name="name" value="${user.name}" required />
            </div>

            <div class="form-group">
                <label for="email"><i class="fas fa-envelope"></i> Email:</label>
                <input type="email" name="email" value="${user.email}" required />
            </div>

            <div class="form-group">
                <label for="country"><i class="fas fa-globe"></i> Country:</label>
                <input type="text" name="country" value="${user.country}" required />
            </div>

            <div class="form-group">
                <label for="phNo"><i class="fas fa-phone"></i> Phone Number:</label>
                <input type="tel" name="phNo" value="${user.phNo}" required />
            </div>

            <div class="buttons">
                <input type="submit" value="Update" />
                <a href="http://localhost:8080/UserManagementSystem/onLogin?email=saqib70241%40gmail.com&password=saqib" class="main-page-btn">Main Page</a>
            </div>
        </form>
    </div>
</body>
</html>
