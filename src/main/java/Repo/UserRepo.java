package Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.fauzan.authPractice.model.User;


public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
 
}
