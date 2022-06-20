package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.User;
import com.gestionlabo.gestionlabo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByLoginAndPassword (String login,String password)
    {
        return userRepository.getByLoginAndPassword(login,password);
    }

}
