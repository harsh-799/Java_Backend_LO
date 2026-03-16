package multipleservlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstSv")
public class FirstServlets extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 📝 In this we'll be sharing Connection b/w two servlets
        PrintWriter writer = resp.getWriter();

        System.out.println("We're in First Servlet RN");
        writer.println("<h1> Response coming from First Servlets");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/SecondSv");

        // Having two ways to dispatch b/w two Servlets:

        // Way01: forward()
        // dispatcher.forward(req, resp);

        /* ✅ OUTPUT:
        ON SCREEN: Response coming from Servlet 2
        ON CONSOLE:
        We're in First Servlet RN
        We're in Second Servlet RN..

        IN this the flow is like when
        So the sequence is:
        Write response from Servlet 1
        Forward request to Servlet 2
        But the output from Servlet 1 disappears.
        Because forward() clears the response buffer before sending it to the next servlet.

         */

        // Way02: include()
        dispatcher.include(req, resp);

        System.out.println("Came back to First Servlets");
        writer.println("<h1>Came back to First Servlets</h1>");

        /*
        ✅ OUTPUT:
        Response coming from First Servlets
        Response coming from Servlet 2
        Came back to First Servlets

        In this flow is as we defined and when it goes to the another servlets it's sure that it'll comee back to the called servlet.
         */
    }
}
