<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Document</title>
	</head>
	<body>
		<%
            String message = (String)request.getAttribute("message");
        %>
        <form action="/slam/AddSlam" method="POST">

            <table align="center">
                <tr><td><%= message %></td> </tr>
                <tr><td><input type="text" name="enterNameToWhom" value="enter the name to whom"></td> </tr>
                <tr><td><input type="text" name="enterAbout" value="enter about him/her"></td> </tr>
                <tr><td><input type="text" name="enterBestMemories" value="write about your best memories with him/her"></td> </tr>
                <tr><td><input type="submit" name="addButton" value="Add"></td> </tr>
            </table>


        </form>
        
	</body>
</html>