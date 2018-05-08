<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
    </head>
    <body><!onLoad="displayResults()">
        <h1>Sign Up</h1>
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
                                "INSERT INTO usersdb.User (email, fname, lname, address, telephone, password, SSN, gender) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                public int setUsers(String email, String first, String last, String address, String phone, String psswd, String SSN, String gender) {
                    int result = 0;
                    try {
                        insertUsers.setString(1, email);
                        insertUsers.setString(2, first);
                        insertUsers.setString(3, last);
                        insertUsers.setString(4, address);
                        insertUsers.setString(5, phone);
                        insertUsers.setString(6, psswd);
                        insertUsers.setString(7, SSN);
                        insertUsers.setString(8, gender);
                        result = insertUsers.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return result;
                }
            }
        %>
        <%
            int result = -1;
            if (request.getParameter("submit") != null) {
                String email = new String();
                String firstName = new String();
                String lastName = new String();
                String address = new String();
                String phone = new String();
                String psswd = new String();
                String SSN = new String();
                String gender = new String();

                if (request.getParameter("email") != null) {
                    email = request.getParameter("email");
                }
                if (request.getParameter("first") != null) {
                    firstName = request.getParameter("first");
                }
                if (request.getParameter("last") != null) {
                    lastName = request.getParameter("last");
                }
                if (request.getParameter("address") != null) {
                    address = request.getParameter("address");
                }
                if (request.getParameter("phone") != null) {
                    phone = request.getParameter("phone");
                }
                if (request.getParameter("psswd") != null) {
                    psswd = request.getParameter("psswd");
                }
                if (request.getParameter("SSN") != null) {
                    SSN = request.getParameter("SSN");
                }
                if (request.getParameter("gender") != null) {
                    gender = request.getParameter("gender");
                    gender = gender.substring(0, 1);
                }

                //Date date = new Date();
                //Timestamp timeStamp = new Timestamp(date.getTime());
                User user = new User();
                result = user.setUsers(email, firstName, lastName, address, phone, psswd, SSN, gender);
            }
        %>
        <form onsubmit = "openWindow()" name ="myForm" action="signup.jsp" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td> Email address: </td>
                        <td><input type ="text" name ="email" value="" size ="50" /></td>
                    </tr>
                    <tr>
                        <td>First Name: </td>
                        <td><input type="text" name="first" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Last Name: </td>
                        <td><input type="text" name="last" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td> Street address: </td>
                        <td><input type ="text" name ="address" value="" size ="50" /></td>
                    </tr>
                    <tr>
                        <td> Phone number: </td>
                        <td><input type ="text" name ="phone" value="" size ="50" /></td>
                    </tr>
                    <tr>
                        <td> Password: </td>
                        <td><input type="password" name="psswd" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td> Social Security Number: </td>
                        <td><input type ="text" name ="SSN" value="" size ="50" /></td>
                    </tr>
                    <tr>
                        <td> Gender: </td>
                        <td><select name="gender">
                                <option> Male </option>
                                <option> Female </option>
                            </select></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="hidden" value="<%= result%>"/>
            <input type="reset" value="Clear" name="Clear" />
            <input type="submit" value="Submit" name="submit" />
        </form>
        <a href="index.jsp">Go Home</a>
        <SCRIPT>
            function displayResults()
            {
                if (document.myForm.hidden.value == 1)
                {
                    alert("Data inserted");
                }
                else if (document.myForm.hidden.value == 0){
                    alert("Data not inserted");
                }
            }
            function openWindow(){
                //if (document.myForm.hidden.value == 1){
                         window.open("signedup.jsp");
               // }
               // else //if (document.myForm.hidden.value == 0){
              //      alert("Please check your input")
             //   }
            }
        </SCRIPT>
    </body>
</html>
