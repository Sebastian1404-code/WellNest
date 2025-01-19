package com.example.PoliHack.repository;

import com.example.PoliHack.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByNickname(String nickname);
}