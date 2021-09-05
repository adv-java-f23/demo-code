package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 *  Demonstrating use of JSTL
 *
 *@author    pwaite
 */
@WebServlet(
        name = "jstlFlowerDemo",
        urlPatterns = { "/createFlowers" }
)
public class CreateFlowers extends HttpServlet {

    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<String> flowers = new ArrayList<String>();
        flowers.add("Tulip");
        flowers.add("Rose");
        flowers.add("Daffodil");
        flowers.add("Petunia");
        flowers.add("Lily");

        session.setAttribute("flowersList", flowers);
    }
}
