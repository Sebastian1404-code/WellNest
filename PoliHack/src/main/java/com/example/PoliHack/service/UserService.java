package com.example.PoliHack.service;

import com.example.PoliHack.model.user.User;
import com.example.PoliHack.model.user.utils.UserSession;
import com.example.PoliHack.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticateUser(String nickname, String password) {
        User user = userRepository.findByNickname(nickname);
        if (user != null && user.getPassword().equals(password)) {
            UserSession userSession = UserSession.getInstance();
            userSession.setUserId(user.getId());
            userSession.setUserNickname(user.getNickname());
            return true;
        }
        return false;
    }


    public boolean registerUser(User user) {
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(new ObjectId().toString());
        }

        if (userRepository.findByNickname(user.getNickname()) != null) {
            return false;
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return false;
        }

        userRepository.save(user);
        return true;
    }

}