package com.example.healthSquare.health_square.repository;

import com.example.healthSquare.health_square.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*created by Hector Developers
06-08-2019
*/

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    Users findByEmail(String email);

}
