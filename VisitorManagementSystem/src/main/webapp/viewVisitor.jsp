<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Visitor</title>
</head>
<body>

<h2>View Visitor Record</h2>

<form action="MainServlet" method="post">

    <!-- FIXED HERE -->
    <input type="hidden" name="operation" value="viewRecord">

    Visitor Name:
    <input type="text" name="visitorName" required>
    <br><br>

    Visit Date:
    <input type="date" name="visitDate" required>
    <br><br>

    <input type="submit" value="View Record">

</form>

<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>