package org.example.controller;



import org.example.auth.JwtToken;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    JwtToken jwttoken;

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

    @RequestMapping(value="login")
    public String loginUser(HttpSession session) {
        User user = userService.getUserInfo(1);
        session.setAttribute("token",jwttoken.create(user));//토큰생성
        return "Logged in (token created)";

    }
    @RequestMapping(value="info")
    public User userInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();//세션 요구
        String token = (String)session.getAttribute("token");
        return jwttoken.verify(token);
    }
}
