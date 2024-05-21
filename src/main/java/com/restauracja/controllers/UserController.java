//package com.restauracja;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping(path = "/login")
//    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
//    {
//        LoginResponse loginResponse = userService.loginEmployee(loginDTO);
//        return ResponseEntity.ok(loginResponse);
//    }
//}
package com.restauracja.controllers;

import com.restauracja.models.User;
import com.restauracja.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepo repo;

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User userData){
        User user=repo.findByUserId(userData.getUserId());
        if(user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);
        return (ResponseEntity<User>) ResponseEntity.internalServerError();
    }
}