package com.example.demo2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Notes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createAt","updateAt"}, allowGetters = true)
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createAt;

    @LastModifiedDate
    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}

/*
All your domain models must be annotated with @Entity annotation. It is used to mark the class as a persistent Java class.

@Table annotation is used to provide the details of the table that this entity will be mapped to.

@Id annotation is used to define the primary key.

@GeneratedValue annotation is used to define the primary key generation strategy. In the above case, we have declared the primary key to be an Auto Increment field.

@NotBlank annotation is used to validate that the annotated field is not null or empty.

@Column annotation is used to define the properties of the column that will be mapped to the annotated field. You can define several properties like name, length, nullable, updateable etc.

By default, a field named createdAt is mapped to a column named created_at in the database table. i.e. all camel cases are replaced with underscores.

If you want to map the field to a different column, you can specify it using -

@Column(name = "created_on")
private String createdAt;
@Temporal annotation is used with java.util.Date and java.util.Calendar classes. It converts the date and time values from Java Object to compatible database type and vice versa.

@JsonIgnoreProperties annotation is a Jackson annotation. Spring Boot uses Jackson for Serializing and Deserializing Java objects to and from JSON.

This annotation is used because we don’t want the clients of the rest api to supply the createdAt and updatedAt values. If they supply these values then we’ll simply ignore them. However, we’ll include these values in the JSON response.
 */