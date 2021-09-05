package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 *  Creates students, puts them in a list and forward to a jsp for display
 *
 *@author    eknapp
 */
@WebServlet(
        name = "studentServlet",
        urlPatterns = { "/createStudents" }
)
public class CreateStudent extends HttpServlet {

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

        Student student1 = new Student("Paula", "Waite", 1);
        Student student2 = new Student("Caeli", "Rice", 2);
        Student student3 = new Student("Ken", "Marks", 3);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        request.setAttribute("listOfStudents", studentList);

        String url = "/displayStudents.jsp";
        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);



    }

}

