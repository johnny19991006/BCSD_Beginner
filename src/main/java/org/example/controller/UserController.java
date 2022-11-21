package org.example.controller;


import org.example.domain.Reply;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "create User";
    }

    @RequestMapping(value = "/{UserId}", method = RequestMethod.GET)
    public User userInfo(@PathVariable("UserId") Long UserId) {
        return userService.getUserInfo(UserId);
    }

    @PutMapping("/{UserId}")
    public String updateUser(@PathVariable Long UserId, @RequestBody User user){
        userService.updateUser(UserId,user);
        return "update User";
    }

    @DeleteMapping("/{UserId}")
    public String deleteUser(@PathVariable Long UserId){
        userService.deleteUser(UserId);
        return "delete User";
    }
}