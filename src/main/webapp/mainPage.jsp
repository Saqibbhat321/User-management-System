<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management System</title>
    <style>
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
            width: 80%;
            text-align: center;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        h1 {
            color: #333;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .action-btn {
            padding: 5px 10px;
            font-size: 14px;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
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
    </style>
</head>
<body>
    <div class="container">
        <h1>User Management System</h1>
         <c:if test="${not empty success}">
                      <p style="color: green;">${success}</p>
                  </c:if>
                  <c:if test="${not empty error}">
                      <p style="color: red;">${error}</p>
         </c:if>
        <div class="button-container">
                    <a href="addUser.jsp" class="primary btn">Add New User</a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Location</th>
                    <th>Phone Number</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="list" items="${list}">
                    <tr>
                        <td>${list.name}</td>
                        <td>${list.email}</td>
                        <td>${list.country}</td>
                        <td>${list.phNo}</td>
                        <td>
                        <div class="button-container">

                                        <form action="/updateUser?id=${list.id}" method="post" style="display:inline;">

                                                                            <button type="submit" class="action-btn delete-btn">update</button>
                                                                      </form>
                            <form action="deleteUser" method="post" style="display:inline;">
                                    <input type="hidden" name="id" value="${list.id}" />
                                    <button type="submit" class="action-btn delete-btn">Delete</button>
                              </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
