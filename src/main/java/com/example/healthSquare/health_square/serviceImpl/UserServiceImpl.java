package com.example.healthSquare.health_square.serviceImpl;

import com.example.healthSquare.health_square.repository.RoleRepository;
import com.example.healthSquare.health_square.repository.UsersRepository;
import com.example.healthSquare.health_square.model.Role;
import com.example.healthSquare.health_square.model.Users;
import com.example.healthSquare.health_square.dto.UserDto;
import com.example.healthSquare.health_square.dto.UserLoginDto;
import com.example.healthSquare.health_square.dto.UserUpdateDto;
import com.example.healthSquare.health_square.response.ApiResponse;
import com.example.healthSquare.health_square.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;

/*created by Hector Developers
06-08-2019
*/

@Service
@Transactional
public class UserServiceImpl implements UsersService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UsersRepository usersRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public ApiResponse login(UserLoginDto loginDto) {
        Users user = usersRepository.findByUsername(loginDto.getUsername());
        if (user == null) {
            throw new IllegalArgumentException(String.format("User with username %s does not exist.", loginDto.getUsername()));
        }

        if (!BCrypt.checkpw(loginDto.getPassword(), user.getPassword())) {

            throw new RuntimeException("Password mismatch.");

        }
        return new ApiResponse(200, "Login success", null);

    }

    @Override
    public boolean isUserAlreadyPresent(Users users) {
        boolean isUserAlreadyExists = false;
        Users existingUser = usersRepository.findByEmail(users.getEmail());
        // If user is found in database, then then user already exists.
        if (existingUser != null) {
            isUserAlreadyExists = true;
        }
        return isUserAlreadyExists;
    }


    @Override
    public void save(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        users.setRoles(new HashSet<Role>(roleRepository.findAll()));
        usersRepository.save(users);
    }


    @Override
    public Users updateUser(Users users) {
        return null;
    }

    @Override
    public Users deleteUser(String username) {
        return null;
    }

}
