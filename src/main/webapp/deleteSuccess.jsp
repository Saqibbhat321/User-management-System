<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Deletion Success</title>
    <style>
        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            text-align: center;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border: none;
            cursor: pointer;
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
