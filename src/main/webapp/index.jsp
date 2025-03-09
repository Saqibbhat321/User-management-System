<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Database Management</title>
<style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(to right, #ff7e5f, #feb47b);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.container {
    text-align: center;
    background: rgba(255, 255, 255, 0.8);
    padding: 50px;
    border-radius: 15px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h1 {
    margin-bottom: 30px;
    color: #333;
}

.button-container {
    display: flex;
    justify-content: center;
    gap: 20px;
}

.btn {
    display: inline-block;
    padding: 15px 30px;
    font-size: 18px;
    font-weight: bold;
    color: #fff;
    background-color: #007bff;
    border: none;
    border-radius: 5px;
    text-decoration: none;
    transition: background-color 0.3s ease;
}

.btn:hover {
    background-color: #0056b3;
}

</style>
</head>
<body>
    <div class="container">
        <h1>Welcome to User Database Management</h1>
        <div class="button-container">
            <a href="login.jsp" class="btn">Login</a>
            <a href="register.jsp" class="btn">Register</a>
           </div>
    </div>
</body>
</html>
