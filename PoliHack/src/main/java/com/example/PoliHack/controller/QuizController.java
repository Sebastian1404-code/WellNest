package com.example.PoliHack.controller;


import com.example.PoliHack.model.Habit;
import com.example.PoliHack.model.Quiz;
import com.example.PoliHack.model.Response;
import com.example.PoliHack.model.user.User;
import com.example.PoliHack.model.user.utils.UserSession;
import com.example.PoliHack.repository.QuizRepository;
import com.example.PoliHack.service.HabitService;
import com.example.PoliHack.service.QuizService;
import com.example.PoliHack.service.UserService;
import com.example.PoliHack.web.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:3000")  // Use the appropriate URL for your frontend
@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizRepository quizRepository;
    private final QuizService quizService;
    private HabitService habitService;


    public QuizController(QuizService quizService,HabitService habitService) {
        this.quizService = quizService;
        this.habitService=habitService;
    }

    // Fetch all quizzes
    @GetMapping()
    public List<Object> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();  // Fetch all quizzes from the database

        return quizzes.stream()
                .map(quiz -> new Object() {
                    public final String question = quiz.getQuestion();  // Map the question
                    public final List<String> options = quiz.getOptions();  // Map the options
                })
                .collect(Collectors.toList());
    }

    @PostMapping("/ai")
    public Mono<ResponseEntity<String>> addSubmit(@RequestBody List<String> options)
    {
        List<Quiz> quizzes = quizRepository.findAll();
        String aiInput=quizService.fetchResponses(options,quizzes);

        ApiClient apiClient=new ApiClient();
        UserSession user= UserSession.getInstance();
        String currentUserId = user.getUserId();


        Mono<String> aiResponse=apiClient.sendQuestion(aiInput)
                .map(response -> response.substring(1, response.length() - 1));
        return aiResponse.flatMap(response -> {
            // Split the response string (which contains comma-separated goals)
            String[] parts = response.split("\\,");

            // Iterate over each part of the response and save habits
            for (String part : parts) {
                Habit habit = new Habit();
                habit.setTitle(part.trim());
                habit.setChosen(false);
                habit.setUser(currentUserId);

                // Save each habit
                habitService.saveHabit(habit);  // Assuming you have a service to save habits
            }

            // Return a success message wrapped in Mono
            return Mono.just(ResponseEntity.ok("Successfully processed habits from AI response."));
        });

    }

}
