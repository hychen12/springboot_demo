package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Demo2Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Demo2Application.class);
    }
}

/*
Now, what we want is that these fields should automatically get populated whenever we create or update an entity.

To achieve this, we need to do two things -

1. Add Spring Data JPA’s AuditingEntityListener to the domain model.

We have already done this in our Note model with the annotation @EntityListeners(AuditingEntityListener.class).

2. Enable JPA Auditing in the main application.

Open EasyNotesApplication.java and add @EnableJpaAuditing annotation.
 */

/*
The first step in producing a deployable war file is to provide a SpringBootServletInitializer subclass and override its configure method.
Doing so makes use of Spring Framework’s Servlet 3.0 support and lets you configure your application when it is launched by the servlet container.
Typically, you should update your application’s main class to extend SpringBootServletInitializer, as shown in the following example:


 */