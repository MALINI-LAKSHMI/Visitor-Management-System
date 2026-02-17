<%@ page import="com.wipro.visitor.bean.VisitorBean" %>
<html>
<head>
<title>Visitor Details</title>
</head>
<body>
<h2>Visitor Record</h2>
<%
VisitorBean visitor =
    (VisitorBean) request.getAttribute("visitor");
if(visitor != null){
%>
<table border="1" cellpadding="10">
<tr>
<th>Visitor ID</th>
<td><%= visitor.getVisitorId() %></td>
</tr>
</table>
<%
}  // close if
%>
</body>
</html>

