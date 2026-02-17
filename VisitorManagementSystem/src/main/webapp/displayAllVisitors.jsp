<%@ page import="java.util.List" %>
<%@ page import="com.wipro.visitor.bean.VisitorBean" %>

<html>
<head>
<title>All Visitors</title>
</head>

<body>

<h2>All Visitor Records</h2>

<%
List<VisitorBean> list =
    (List<VisitorBean>) request.getAttribute("visitorList");

if (list != null && !list.isEmpty()) {

    for (VisitorBean bean : list) {
%>

<hr>
Visitor ID: <%= bean.getVisitorId() %><br>
Visitor Name: <%= bean.getVisitorName() %><br>
Purpose: <%= bean.getPurpose() %><br>
Visit Date: <%= bean.getVisitDate() %><br>
Contact No: <%= bean.getContactNo() %><br>
Remarks: <%= bean.getRemarks() %><br>

<%
    }
} else {
%>

No records available!

<%
}
%>

</body>
</html>

