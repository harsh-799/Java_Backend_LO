package introtoJSP;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/process")
public class TaskGPT extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String strAge = req.getParameter("age");
        Integer age = Integer.parseInt(strAge);

        String gender = req.getParameter("gender");

        RequestDispatcher dispatch = req.getRequestDispatcher("/result.jsp");

        boolean isAdult = false;

        if (age >= 18){
            isAdult = true;
            req.setAttribute("name",name);
            req.setAttribute("age",age);
            req.setAttribute("gender",gender);
            req.setAttribute("status",isAdult);
        }

        dispatch.forward(req, resp);

    }
}
