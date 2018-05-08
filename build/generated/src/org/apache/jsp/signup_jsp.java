package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.Date;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
 Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Style.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Sign Up</title>\n");
      out.write("    </head>\n");
      out.write("    <body><!onLoad=\"displayResults()\">\n");
      out.write("        <h1>Sign Up</h1>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        <form onsubmit = \"openWindow()\" name =\"myForm\" action=\"signup.jsp\" method=\"POST\">\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Email address: </td>\n");
      out.write("                        <td><input type =\"text\" name =\"email\" value=\"\" size =\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>First Name: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"first\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Last Name: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"last\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Street address: </td>\n");
      out.write("                        <td><input type =\"text\" name =\"address\" value=\"\" size =\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Phone number: </td>\n");
      out.write("                        <td><input type =\"text\" name =\"phone\" value=\"\" size =\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Password: </td>\n");
      out.write("                        <td><input type=\"password\" name=\"psswd\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Social Security Number: </td>\n");
      out.write("                        <td><input type =\"text\" name =\"SSN\" value=\"\" size =\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Gender: </td>\n");
      out.write("                        <td><select name=\"gender\">\n");
      out.write("                                <option> Male </option>\n");
      out.write("                                <option> Female </option>\n");
      out.write("                            </select></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"hidden\" name=\"hidden\" value=\"");
      out.print( result);
      out.write("\"/>\n");
      out.write("            <input type=\"reset\" value=\"Clear\" name=\"Clear\" />\n");
      out.write("            <input type=\"submit\" value=\"Submit\" name=\"submit\" />\n");
      out.write("        </form>\n");
      out.write("        <a href=\"index.jsp\">Go Home</a>\n");
      out.write("        <SCRIPT>\n");
      out.write("            function displayResults()\n");
      out.write("            {\n");
      out.write("                if (document.myForm.hidden.value == 1)\n");
      out.write("                {\n");
      out.write("                    alert(\"Data inserted\");\n");
      out.write("                }\n");
      out.write("                else if (document.myForm.hidden.value == 0){\n");
      out.write("                    alert(\"Data not inserted\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function openWindow(){\n");
      out.write("                //if (document.myForm.hidden.value == 1){\n");
      out.write("                         window.open(\"signedup.jsp\");\n");
      out.write("               // }\n");
      out.write("               // else //if (document.myForm.hidden.value == 0){\n");
      out.write("              //      alert(\"Please check your input\")\n");
      out.write("             //   }\n");
      out.write("            }\n");
      out.write("        </SCRIPT>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
