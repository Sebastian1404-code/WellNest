package com.example.PoliHack.service;

import com.example.PoliHack.model.Habit;
import com.example.PoliHack.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {


    @Autowired
    private HabitRepository habitRepository;

    public void saveHabit(Habit habit)
    {
        habitRepository.save(habit);
    }
    public List<Habit> fetchAll()
    {
        return habitRepository.findAll();
    }

    public void deleteHabit(Habit habit) {
        habitRepository.delete(habit);
    }
}
