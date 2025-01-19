package com.example.PoliHack.repository;

import com.example.PoliHack.model.Quiz;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz, ObjectId> {
}
