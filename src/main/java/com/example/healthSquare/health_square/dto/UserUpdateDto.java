package com.example.healthSquare.health_square.dto;

import javax.validation.constraints.Size;

/*created by Hector Developers
06-08-2019
*/
public class UserUpdateDto {

    @Size(min = 2)
    private String lastname;

    @Size(min = 2)
    private String fullname;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}