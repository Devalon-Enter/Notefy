package com.notefy.notefyapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v2/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable String id) {
        User user = userService.getUser(id);
        if(user != null) {
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist with id: " + id);
        }
    }

    @PostMapping
    public User newUser(@RequestBody User user) {
        return userService.newUser(user);
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        User depUser = userService.getUser(id);
        if(depUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist with id: " + id);
        }

        depUser.setFirstName(user.getFirstName());
        depUser.setLastName(user.getLastName());
        depUser.setUsername(user.getUsername());
        depUser.setPassword(user.getPassword());

        return userService.updateUser(depUser);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable String id) {
        User toDeleteUser = userService.getUser(id);
        if(toDeleteUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist with id: " + id);
        }
        userService.deleteUser(id);
    }
}
