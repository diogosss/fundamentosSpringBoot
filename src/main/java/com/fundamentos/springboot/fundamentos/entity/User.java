package com.fundamentos.springboot.fundamentos.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_user", nullable = false, unique = true)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String email;

    private LocalDate bitrthday;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //
    @JsonManagedReference
    private List<Post> post = new ArrayList<>();

    public User() {
    }

    public User(String name, String email, LocalDate bitrthday) {
        this.name = name;
        this.email = email;
        this.bitrthday = bitrthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBitrthday() {
        return bitrthday;
    }

    public void setBitrthday(LocalDate bitrthday) {
        this.bitrthday = bitrthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bitrthday=" + bitrthday +
                ", post=" + post +
                '}';
    }
}
