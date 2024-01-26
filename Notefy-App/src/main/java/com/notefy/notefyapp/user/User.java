package com.notefy.notefyapp.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "\"users\"")
public class User{
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private Set<String> role;
    @JsonIgnore
    private String password;

    public User() {

    }

    public User(
            String id,
            String firstName,
            String lastName,
            String username,
            Set<String> role,
            String password
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public User(
            String firstName,
            String lastName,
            String username,
            Set<String> role,
            String password
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
