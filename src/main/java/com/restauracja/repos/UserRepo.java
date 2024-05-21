//package com.restauracja;
//
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@EnableJpaRepositories
//@Repository
//public interface UserRepo extends JpaRepository<Admin,String>
//{
//    Optional<Admin> findOneByUserIdAndPassword(String userId, String password);
//
//    Admin findByUserId(String userId);
//}
package com.restauracja.repos;

import com.restauracja.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findByUserId(String userId);
}