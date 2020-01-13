package com.example.healthSquare.health_square.service;

import com.example.healthSquare.health_square.model.Users;
import com.example.healthSquare.health_square.dto.UserDto;
import com.example.healthSquare.health_square.dto.UserLoginDto;
import com.example.healthSquare.health_square.dto.UserUpdateDto;
import com.example.healthSquare.health_square.response.ApiResponse;
import org.springframework.stereotype.Service;

/*created by Hector Developers
06-08-2019
*/

@Service
public interface UsersService {

    ApiResponse login(UserLoginDto loginDto);

    boolean isUserAlreadyPresent(Users users);

    void save(Users users);


    Users updateUser(Users users);

    Users deleteUser(String username);
}
