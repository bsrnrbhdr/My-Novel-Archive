package com.tr.MNA.Model;

import javax.persistence.*;

@Entity
@Table(schema ="public",name ="user_tbl" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="first_name")
    private String firstName;
    @Column(name ="surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public User(){
        super();
    }

    public User(String firstName, String surname, String email, String password) {
        super();
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
