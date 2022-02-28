<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, model.Slam" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>Weather Forecast</title>
    
        <style>
            table, th, td {
                border: 1px solid #000;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
    <%
        List<Slam> slams = (List<Slam>)request.getAttribute("slams");
        String message = (String)request.getAttribute("message");
    %>
    
    <form action="/slam/AddSlam" method="get"><input type="submit" value="Add"></form>
    
    <table>
        <% for( Slam slam:slams) { %>
            <tr>
                <td>To : <%= slam.getToWhom()%></td>
                <td>About Him/Her : <%= slam.getAboutThem()%></td>
                <td>Best Memories : <%= slam.getBestMemories()%></td>
                <td><form action="/slam/UpdateSlam" method="GET"><input type="hidden" name="slamId" value="<%= slam.getSlamId() %>"><input type="submit" value="Edit"></form></td>
                <td><form action="/slam/DeleteSlam" method="GET"><input type="hidden" name="slamId" value="<%= slam.getSlamId() %>"><input type="submit" value="Delete"></form></td>
                
            </tr>
        <% } %>
    </table> 
    <% if(message!= null) { %>
            <%= message %>
    <% } %> 
    </body>
    </html>