package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
 Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Style.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Log in</title>\n");
      out.write("    </head>\n");
      out.write("    <body> \n");
      out.write("        <h1>Log In</h1>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("\n");
      out.write("        <form onsubmit = \"openWindow()\" name=\"myForm\" action=\"login.jsp\">\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Email:</td>\n");
      out.write("                        <td><input type=\"text\" name =\"email\" value =\"\" size =\"50\" /> </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Password:</td>\n");
      out.write("                        <td><input type=\"password\" name=\"password\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"hidden\" name=\"hidden\" value=\"");
      out.print( flag);
      out.write("\"/>\n");
      out.write("            <input type=\"reset\" value=\"Clear\" name=\"Clear\" />\n");
      out.write("            <input type=\"submit\" value=\"Submit\" name=\"submit\" />\n");
      out.write("        </form>\n");
      out.write("        <a href=\"index.jsp\">Go Home</a>\n");
      out.write("        <SCRIPT>\n");
      out.write("            function openWindow() {\n");
      out.write("                if (document.myForm.hidden.value) {\n");
      out.write("                    //window.location = \"loggedin.jsp\";\n");
      out.write("                    window.open('loggedin.jsp');\n");
      out.write("                } else{\n");
      out.write("                    alert(\"Username or password is incorrect\");\n");
      out.write("                }\n");
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
