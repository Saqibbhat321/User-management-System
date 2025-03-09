<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management System</title>
    <style>
        /* Beautiful CSS Styles */
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
            width: 90%;
            text-align: center;
            padding: 30px;
            background-color: #ffffff;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            border-radius: 15px;
        }
        h1 {
            background-color: #0056b3;
            color: #ffffff;
            margin-bottom: 20px;
            font-size: 64px;
            padding: 15px;
            border-radius: 10px;
        }
        .message {
            color: #28a745;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .button-container {
            margin-bottom: 20px;
        }
        .primary-btn {
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
        .primary-btn:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            font-size: 18px;
            color: #333;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .action-btn {
            padding: 10px 20px;
            font-size: 16px;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: opacity 0.3s ease;
        }
        .update-btn {
            background-color: #28a745;
        }
        .delete-btn {
            background-color: #dc3545;
        }
        .action-btn:hover {
            opacity: 0.8;
        }
        .form-inline {
            display: inline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>User Management System</h1>
        <c:if test="${not empty success}">
            <p class="message">${success}</p>
        </c:if>
        <c:if test="${not empty error}">
            <p class="message">${error}</p>
        </c:if>
        <div class="button-container">
            <a href="addUser.jsp" class="primary-btn">Add New User</a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Serial No.</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Location</th>
                    <th>Phone Number</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="list" items="${list}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${list.name}</td>
                        <td>${list.email}</td>
                        <td>${list.country}</td>
                        <td>${list.phNo}</td>
                        <td>
                            <div class="button-container form-inline">
                                <form action="deleteUser" method="post" style="display:inline;">
                                    <input type="hidden" name="id" value="${list.id}" />
                                    <button type="submit" class="action-btn delete-btn">Delete</button>
                                </form>
                                <a href="updateUser?id=${list.id}" class="action-btn update-btn">Update</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
