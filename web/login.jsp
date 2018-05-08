<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
    </head>
    <body> 
        <h1>Log In</h1>
        <%!
            public class User {

                String URL = "jdbc:mysql://cosc412db.chpcmnsw3q27.us-east-2.rds.amazonaws.com:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String USERNAME = "admin";
                String PASSWORD = "Database3";

                Connection connection = null;
                PreparedStatement insertUsers = null;
                PreparedStatement selectUsers = null;
                ResultSet resultSet = null;

                public User() {

                    try {
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                        selectUsers = connection.prepareStatement("SELECT email, password" + "FROM usersdb.User" + "WHERE email= ? and WHERE password= ?");// + "WHERE email = ? WHERE password = ?");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                public ResultSet getUser(String email, String password) {
                    try {
                        selectUsers.setString(1, email);
                        selectUsers.setString(2, password);
                        resultSet = selectUsers.executeQuery();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return resultSet;
                }
            }
        %>
        <%
            boolean flag = false;
            User user = null;
            ResultSet rs = null;
            String email = new String();
            String password = new String();
            if (request.getParameter("submit") != null) {
                if (request.getParameter("email") != null) {
                    email = request.getParameter("email");
                }
                if (request.getParameter("password") != null) {
                    password = request.getParameter("password");             
                }
                user = new User();
                rs = user.getUser(email, password);
                if (rs.getString(1).equals(email) && rs.getString(2).equals(password)) {
                    flag = true;
                }
            }
        %>

        <form onsubmit = "openWindow()" name="myForm" action="login.jsp">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name ="email" value ="" size ="50" /> </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="hidden" value="<%= flag%>"/>
            <input type="reset" value="Clear" name="Clear" />
            <input type="submit" value="Submit" name="submit" />
        </form>
        <a href="index.jsp">Go Home</a>
        <SCRIPT>
            function openWindow() {
                if (document.myForm.hidden.value) {
                    //window.location = "loggedin.jsp";
                    window.open('loggedin.jsp');
                } else{
                    alert("Username or password is incorrect");
                }
            }
        </SCRIPT>
    </body>
</html>
