package com.example.PoliHack.repository;

import com.example.PoliHack.model.LeaderBoard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LeaderBoardRepository extends MongoRepository<LeaderBoard, String> {
    Optional<LeaderBoard> findByUserId(String userId);
}
