package com.example.healthSquare.health_square.model;


import com.example.healthSquare.health_square.enums.GenericStatusConstant;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/*created by Hector Developers
06-08-2019
*/

@Entity
@Table(name = "users",
        uniqueConstraints = @UniqueConstraint(columnNames = {"email", "username"}))
public class Users extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "please enter your first name")
    private String firstname;


    @NotNull(message = "please enter your last name")
    private String lastname;

    @NotNull
    private String gender;

    @Column(nullable=false, unique=true)
    @NotNull(message = "please enter your email")
    @Email
    private String email;

    @Column(nullable=false, unique=true)
    @NotNull(message = "please enter your username")
    private String username;

    @NotNull(message = "please enter your password")
    private String password;

    @NotNull
    private GenericStatusConstant status;


    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GenericStatusConstant getStatus() {
        return status;
    }

    public void setStatus(GenericStatusConstant status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}