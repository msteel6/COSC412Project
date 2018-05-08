<%--
Just a test file. Not part of application
--%>

<%-- 
    Document   : response
    Created on : Apr 10, 2018, 10:42:10 PM
    Author     : Mark
--%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert into DB</title>
    </head>
    <body>
        <h1>Insert into DB</h1>
        <%!
            public class User {

                String URL = "jdbc:mysql://cosc412db.chpcmnsw3q27.us-east-2.rds.amazonaws.com:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String USERNAME = "admin";
                String PASSWORD = "Database3";

                Connection connection = null;
                PreparedStatement insertUsers = null;
                ResultSet resultSet = null;

                public User() {

                    try {
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                        insertUsers = connection.prepareStatement(
                                "INSERT INTO usersdb.Test (fname, lname, last_update) "
                                + "VALUES (?, ?, ?)");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                public int setUsers(String first, String last, Timestamp timeStamp) {
                    int result = 0;
                    try {
                        insertUsers.setString(1, first);
                        insertUsers.setString(2, last);
                        insertUsers.setTimestamp(3, timeStamp);
                        result = insertUsers.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return result;
                }
            }
        %>
        <%
            int result = 0;
            if (request.getParameter("submit") != null) {
                String firstName = new String();
                String lastName = new String();

                if (request.getParameter("first") != null) {
                    firstName = request.getParameter("first");
                }
                if (request.getParameter("last") != null) {
                    lastName = request.getParameter("last");
                }

                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());

                User user = new User();
                result = user.setUsers(firstName, lastName, timeStamp);

                System.out.println("result" + result);
            }
        %>
        <form name="myForm" action="response.jsp" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>First Name: </td>
                        <td><input type="text" name="first" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Last Name: </td>
                        <td><input type="text" name="last" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="reset" value="Clear" name="Clear" />
            <input type="submit" value="Submit" name="submit" />
        </form>
        <br>
        <a href="index.jsp" class="button">Go Home</a>
    </body>
</html>
