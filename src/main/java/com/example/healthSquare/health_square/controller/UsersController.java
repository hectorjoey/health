package com.example.healthSquare.health_square.controller;

import com.example.healthSquare.health_square.exception.ResourceNotFoundException;
import com.example.healthSquare.health_square.repository.UsersRepository;
import com.example.healthSquare.health_square.model.Users;
import com.example.healthSquare.health_square.dto.UserDto;
import com.example.healthSquare.health_square.dto.UserLoginDto;
import com.example.healthSquare.health_square.enums.GenericStatusConstant;
import com.example.healthSquare.health_square.service.UsersService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

/*created by Hector Developers
06-08-2019
*/

@RestController
@RequestMapping(value = "/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UsersRepository usersRepository;
    private final UsersService usersService;

    public UsersController(BCryptPasswordEncoder bCryptPasswordEncoder,
                           UsersRepository usersRepository,
                           UsersService usersService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.usersRepository = usersRepository;
        this.usersService = usersService;
    }

    //get lists of all users
    @GetMapping(value = "/list")
    public ResponseEntity<Object> getUsers() {
        return new ResponseEntity<>(usersRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{username}")
    public ResponseEntity<Users> getUser(@PathVariable("username") String username)
            throws ResourceNotFoundException {
        Users users = usersRepository.findByUsername(username);
        return new ResponseEntity<Users>(usersRepository.findByUsername(username), new HttpHeaders(), HttpStatus.OK);
    }

    //user login api
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDto userLoginDto) {
        return new ResponseEntity<>(usersService.login(userLoginDto), HttpStatus.valueOf(200));
    }

    //    User sign up api
    @PostMapping(path = "/signup")
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        Users users = usersRepository.findByUsername(userDto.getUsername());
        if (users != null) {
            throw new IllegalArgumentException(String.format("User with username %s already exist", userDto.getUsername()));
        }
        Users usersEmail = usersRepository.findByEmail(userDto.getEmail());
        if (usersEmail != null) {
            throw new IllegalArgumentException(String.format("User with email %s already exist", userDto.getEmail()));
        }
        Users users3 = new Users();
        logger.info("======> About to create user");
        users3.setFirstname(userDto.getFirstname());
        users3.setLastname(userDto.getLastname());
        users3.setGender(userDto.getGender());
        users3.setEmail(userDto.getEmail());
        users3.setUsername(userDto.getUsername());
        users3.setPassword(userDto.getPassword());
        users3.setStatus(GenericStatusConstant.DEACTIVATED);
        users3.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        logger.info(users3.getFirstname() + " " + users3.getLastname() + " created");
        return new ResponseEntity<>(usersRepository.save(users3), HttpStatus.CREATED);

    }

    //update a user by username
    @PutMapping("/{username}")
    public ResponseEntity<Users> updateUser(@PathVariable String username, @RequestBody Users users) {
        users.setUsername(username);
        return ResponseEntity.ok().body(this.usersService.updateUser(users));
    }

    //Deletes user by username
    @DeleteMapping("/{username}")
    public HttpStatus deleteUser(@PathVariable("username") String username)
            throws ResourceNotFoundException {
        usersService.deleteUser(username);
        return HttpStatus.FORBIDDEN;
    }


    @GetMapping
    public Principal getUser(Principal users) {
        return users;
    }
}
