package introtoJSP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jsp1")
public class NeedOfJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");

        // Now suppose we wanna to send the redirect this to another page stating Registration is successful but it's not possible Since how in html we'll use this name and gender value. We need JSP for that

        PrintWriter writer = resp.getWriter();

        // Another work around (Writing everything in same servlet makes the code looks bad and confusing)
        writer.println("<h1>Congrats! Your Registration is successfull..</h1>");
        writer.println("<h1>Here are your details: </h1>");
        writer.println("<h3>Name: "+name + ", Gender: "+gender+"/<h1>");

        /*
        🚀 1️⃣ Why JSP Exists (VERY IMPORTANT)
        Right now with servlets you do this:
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello</h1>");
        out.println("</body>");
        out.println("</html>");

        💀 Problem:

        Too much HTML inside Java

        Ugly + hard to maintain

        Not scalable
         */
    }
}
