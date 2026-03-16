package basicsofservlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletexecution")
public class ServletsExecutions extends HttpServlet {

    static {
        System.out.println("ServletsExecution Class is loaded");
    }

    public ServletsExecutions() {
        System.out.println("ServletsExecution class instance is created.");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Init Block is Running..");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Service block is running");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy block is running");
    }

    /*
    ✅ OUTPUT
    ServletsExecution Class is loaded
    ServletsExecution class instance is created.
    Init Block is Running..
    Service block is running
    Service block is running
    Service block is running
    Destroy block is running

    🚀 NOTE:
    - In the servlets we are not creating obj by ourselves it's the responsibility of servlet container that's tomcat to create an obj of Servlet class and execute the stuffs.
    - When the first request for the servlet comes (or when the server starts if configured), Tomcat loads the servlet class.

     Because servlet loading can happen in two ways:
     1️⃣ Lazy loading (default)
     Class loads when first request arrives

     2️⃣ Load on startup
     @WebServlet(urlPatterns="/servletexecution", loadOnStartup = 1)
     Then it loads when Tomcat starts.

    - And after class is loaded it's object is created
    - And then the Init block gets executed (It gets only 1 time per servlet)
    - service block will get block execute N times based on the req (SO if N req N times it'll get executed)
    - And destory block will only exuected once when the servlets is destroyed

    NOTE:
    - service() is the main method that handles every incoming request. Whenever a request reaches the servlet, Tomcat calls service() first.
    Browser Request
      ↓
    Tomcat
      ↓
    service()

    Inside HttpServlet, the service() method checks the HTTP method and calls the correct function.

    Internally it does something like:
    
    if request is GET  → call doGet()
    if request is POST → call doPost()
    if request is PUT  → call doPut()
    if request is DELETE → call doDelete()

    So the real flow is:

    Browser
       ↓
    Tomcat
       ↓
    service()
       ↓
    doGet() / doPost() / doPut() / doDelete()

     */
}
