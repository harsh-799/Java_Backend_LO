package registrationform;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/logindata")
public class Auth extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");


        Model dbConnect = new Model();

            boolean isValid = dbConnect.getData(dbConnect, name, pass);

            if (isValid){

                req.setAttribute("name",dbConnect.getName());
                req.setAttribute("age",dbConnect.getAge());
                req.setAttribute("city",dbConnect.getCity());
                req.setAttribute("skills",dbConnect.getSkills());

                RequestDispatcher dispatcher = req.getRequestDispatcher("details.jsp");
                dispatcher.forward(req, resp);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("invalidcred.html");
                dispatcher.forward(req, resp);

            }
    }
}
