package com.gestionlabo.gestionlabo.controller;

import com.gestionlabo.gestionlabo.model.Responsable;
import com.gestionlabo.gestionlabo.model.User;
import com.gestionlabo.gestionlabo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/authentificate")
    public User findByLoginAndPassword(@RequestParam String login, @RequestParam String password )
    {
        return  userService.findByLoginAndPassword(login,password);
    }

}
