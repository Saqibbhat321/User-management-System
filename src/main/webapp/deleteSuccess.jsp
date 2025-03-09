<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deletion Success</title>
    <style>
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
            max-width: 500px;
            margin: 0 auto;
            padding: 30px;
            text-align: center;
            background-color: #ffffff;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            border-radius: 15px;
        }
        h1 {
            color: #0056b3;
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
            color: #333;
            margin-bottom: 20px;
        }
        .btn {
            display: inline-block;
            padding: 12px 25px;
            font-size: 18px;
            border-radius: 5px;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Deletion Success</h1>
        <p>User <strong>${userName}</strong> has been successfully deleted from the database.</p>
        <a href="http://localhost:8080/UserManagementSystem/onLogin?email=saqib70241%40gmail.com&password=saqib" class="btn">Main Page</a>
    </div>
</body>
</html>
