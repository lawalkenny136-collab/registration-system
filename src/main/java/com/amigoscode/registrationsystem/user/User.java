package com.amigoscode.registrationsystem.user;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "users")
public class User {

    @Id
    @SequenceGenerator(
            name = "users_id_sequence",
            sequenceName = "users_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_id_sequence"
    )
    private Integer userId;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private Integer age;

    @Column (nullable = false)
   // private String role;

   // @Column (nullable = false)
    private String emailAddress;

    public User(String name, Integer age, String emailAddress) {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public User(Integer userId, String name, Integer age, String emailAddress) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    /*public User(String name, Integer age, String role, String emailAddress) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.emailAddress = emailAddress;
    }*/

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && emailAddress == user.emailAddress && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, emailAddress);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
