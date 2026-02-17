<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Visitor Result</title>
</head>
<body>

<h2>Visitor Record Status</h2>

<%
    String message = (String) request.getAttribute("message");

    if (message != null) {
%>

        <h3>
            <%= message %>
        </h3>

<%
    } else {
%>

        <h3>No response received from server.</h3>

<%
    }
%>

<br><br>

<a href="addVisitor.html">Add Another Visitor</a>
<br><br>
<a href="menu.html">Back to Menu</a>

</body>
</html>