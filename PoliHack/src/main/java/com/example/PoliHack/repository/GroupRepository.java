package com.example.PoliHack.repository;

import com.example.PoliHack.model.Group;
import com.example.PoliHack.model.Habit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupRepository extends MongoRepository<Group, ObjectId> {
}
