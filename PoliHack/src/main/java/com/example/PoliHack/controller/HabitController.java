package com.example.PoliHack.controller;


import com.example.PoliHack.model.Habit;
import com.example.PoliHack.model.user.User;
import com.example.PoliHack.model.user.utils.UserSession;
import com.example.PoliHack.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HabitController {

    @Autowired
    private HabitService habitService;

    @GetMapping("/recommendation")
    public List<Habit> choosingHabits()
    {
        UserSession userSession= UserSession.getInstance();
        String current=userSession.getUserId();

        return habitService.fetchAll().stream().filter(habit -> !habit.isChosen()  ).collect(Collectors.toList());
    }

    @PostMapping("/recommandation")
    public void selectHabit(@RequestBody Habit habit) {
        UserSession userSession = UserSession.getInstance();
        String currentUser = userSession.getUserId();

        // Marcăm habit-ul ca selectat
        habit.setChosen(true);
        habitService.fetchAll().stream()
                .filter(h -> !h.isChosen()) // Filter habits where chosen is false
                .forEach(habitService::deleteHabit);


        // Salvăm habit-ul pentru utilizatorul curent
        habit.setUser(currentUser);
        habitService.saveHabit(habit);

    }



}
