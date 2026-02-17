<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Visitor</title>
</head>
<body>

<h2>Add Visitor Record</h2>

<form action="MainServlet" method="post">

   <input type="hidden" name="operation" value="newRecord">
   
    Visitor Name:
    <input type="text" name="visitorName" required>
    <br><br>

    Purpose:
    <input type="text" name="purpose" required>
    <br><br>

    Visit Date:
    <input type="date" name="visitDate" required>
    <br><br>

    Contact Number:
    <input type="text" name="contactNo" required>
    <br><br>

    Remarks:
    <input type="text" name="remarks">
    <br><br>

    <input type="submit" value="Add Visitor">

</form>


<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>