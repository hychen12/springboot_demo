package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
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
