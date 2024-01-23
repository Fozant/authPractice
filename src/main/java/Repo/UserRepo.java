package Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fauzan.authPractice.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    
}
