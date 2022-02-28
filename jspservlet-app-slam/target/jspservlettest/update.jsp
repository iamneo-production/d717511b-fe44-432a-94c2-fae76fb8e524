<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Slam" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Document</title>
	</head>
	<body>
		<%
            String message = (String)request.getAttribute("message");
            Slam slam = (Slam)request.getAttribute("slam");
        %>
        <form action="/slam/UpdateSlam" method="POST">

            <table align="center">
                <tr><td><%= message %></td> </tr>
                <tr><td><input type="text" name="enterNameToWhom" value="<%= slam.getToWhom()%>"></td> </tr>
                <tr><td><input type="text" name="enterAbout" value="<%= slam.getAboutThem()%>"></td> </tr>
                <tr><td><input type="text" name="enterBestMemories" value="<%= slam.getBestMemories()%>"></td> </tr>
                <tr><td><input type="hidden" name="slamId" value="<%= slam.getSlamId() %>"><input type="submit" name="addButton" value="Update"></td> </tr>
            </table>


        </form>
        
	</body>
</html>