package com.management.Controllers;

import com.management.Model.User;
import com.management.Model.UserModel;
import com.management.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping({"/signup"})
    public ResponseEntity<User> createUser(@RequestBody UserModel user) {
        return new ResponseEntity(this.userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping({"/login"})
    public ResponseEntity<User> checkUser(@RequestBody UserModel user) {
        User tempUser = this.userService.checkUser(user);
        if(tempUser != null) {
            return new ResponseEntity(tempUser, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping({"/details/{userId}"})
    public ResponseEntity<User> getUser(@PathVariable(required = true, name="userId") int userId) {
        User tempUser = this.userService.getUserDetails(userId);
        if(tempUser != null) {
            return new ResponseEntity(tempUser, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
}
