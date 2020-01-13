package com.example.healthSquare.health_square.dto;

import javax.validation.constraints.NotBlank;

/*created by Hector Developers
06-08-2019
*/

public class UserLoginDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

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

}
