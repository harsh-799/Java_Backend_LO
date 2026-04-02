package com.harsh.webmvc;

import com.harsh.webmvc.controller.HarshServlets;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class LaunchApp {
    public static void main(String[] args) {
        Tomcat tomcatServer = new Tomcat();
        tomcatServer.setPort(8080); // 🚀 Used to set the port number of the server by default 8080.
        tomcatServer.getConnector(); // Start server and listen for requests


        //  public Context addContext(String contextPath, String docBase) {}

        // 📝 contextPath = 👉 contextPath = the base URL under which your entire app is accessible
        // 🌐 Visual understanding
        // Think:
        // http://localhost:8080 + contextPath + endpoint

        // 🔥 Why contextPath exists
        // Run multiple apps on same server
        // Separate apps logically
        // Avoid URL conflicts

        // If it's "" (empty string) it'll consider it from root only.
        // 📝 docBase = physical folder of your web app

        String contextPath = "";
        String projectPath = new File(".").getAbsolutePath(); // ✅ C:\VS Codes\WorkSpace\Java_Backend_LO\SpringWebMVC\mavenembeddedtomcat\.

        Context context = tomcatServer.addContext(contextPath,projectPath);

        /*
        * This will help the tomcat to search for the project context path is basically for the entry point (prefix) of our webapp.
        * And the projectPath will help tomcat to know the getAbsolutePath() to give Tomcat a valid physical directory (docBase) so it knows where our web application files are located.*/

        Tomcat.addServlet(context,"mysv",new HarshServlets());
        context.addServletMappingDecoded("/","mysv");


        try {
            tomcatServer.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        tomcatServer.getServer().await();



    }
}
