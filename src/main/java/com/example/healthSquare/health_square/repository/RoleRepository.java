package com.example.healthSquare.health_square.repository;

import com.example.healthSquare.health_square.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*created by Hector Developers
06-08-2019
*/

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
