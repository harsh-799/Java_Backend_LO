package com.harsh.webmvc.springbootwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebappApplication.class, args);

        /* This is basically the springboot application embedded with tomcat server we don't need to configure anything in this like Making Tomcat object, Context path nothing.
        * Spring do everything automatically for us.
        * Now you must be wondering that if spring will do on it's own how tf It'll accept request since we'll not even make servlets class into this.
        * Also regarding the mavenwithembeddedtomcat in that we used to define our endPoints in the context.addServletMappingDecoded("/","mysv") now since there'll be no context so how we're supposed to manage it.
        *
        * All this doubts are valid and we'll see in future commits which part replaces what of the Normal Approach.
        */
	}

}
