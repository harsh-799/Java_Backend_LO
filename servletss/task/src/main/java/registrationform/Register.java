package registrationform;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String city = req.getParameter("city");
        String skills = req.getParameter("skills");
        String password = req.getParameter("password");

        Model dbModel = new Model();
        dbModel.setName(name);
        dbModel.setAge(age);
        dbModel.setCity(city);
        dbModel.setSkills(skills);
        dbModel.setPassword(password);

        boolean status = dbModel.insertData();

        if (!status) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("failed.html");
            dispatcher.forward(req, resp);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
        dispatcher.forward(req, resp);
    }
}
