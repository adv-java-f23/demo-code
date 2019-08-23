package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
import java112.utilities.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    eknapp
 */
@WebServlet(
    name = "propertiesReaderServlet",
    urlPatterns = { "/propertiesReader" }
)
public class PropertiesReader extends HttpServlet implements PropertiesLoader{

    private Properties properties;
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>TrivialServlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Properties Reader!</h1>");
        // get all the properties
        Set<String> propertyNames = properties.stringPropertyNames();
        out.print("<ol>");
        // display the key-value pairs (property name and its corresponding value)
        for (String key : propertyNames) {
            out.println("<li>The key is: " + key + ". The value is " +
                    properties.getProperty(key) + "</li>");

        }
        out.print("</ol>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

    public void init(ServletConfig config) throws ServletException {
        try {
            properties = loadProperties("/demo.properties");
        } catch (Exception exception) {
            log("Error in PropertiesReader init" + exception);
        }
    }

}
