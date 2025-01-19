package com.example.PoliHack.repository;

import com.example.PoliHack.model.Habit;
import com.example.PoliHack.model.Quiz;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HabitRepository extends MongoRepository<Habit, ObjectId> {
}
