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
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            max-width: 400px;
            width: 100%;
        }
        h1 {
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        label {
            font-size: 16px;
            margin-top: 10px;
            color: #333;
        }
        input[type="text"], input[type="email"], input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Update User</h1>

        <!-- Display error messages if any -->
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <form action="/updateUser" method="post">
            <!-- Hidden input to store the user ID -->
            <input type="hidden" name="id" value="${user.id}" />

            <div>
                <label for="name">Name:</label>
                <input type="text" name="name" value="${user.name}" required />
            </div>

            <div>
                <label for="email">Email:</label>
                <input type="email" name="email" value="${user.email}" required />
            </div>

            <div>
                <label for="country">Country:</label>
                <input type="text" name="country" value="${user.country}" required />
            </div>

            <div>
                <label for="phNo">Phone Number:</label>
                <input type="text" name="phNo" value="${user.phNo}" required />
            </div>

            <input type="submit" value="Update" />
        </form>
    </div>
</body>
</html>
