package com.example.healthSquare.health_square.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

/*created by Hector Developers
06-08-2019
*/
public class UserDto {

    @NotBlank
    @Size(min = 2)
    private String firstname;

    @NotBlank
    @Size(min = 2)
    private String lastname;

    @NotBlank
    @Size(min = 1)
    private String gender;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 4)
    private String username;

    @NotBlank
    @Size(min = 6)
    private String password;

    private String status;

    public Set Roles;


    public UserDto() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set getRoles() {
        return Roles;
    }

    public void setRoles(Set roles) {
        Roles = roles;
    }
}
