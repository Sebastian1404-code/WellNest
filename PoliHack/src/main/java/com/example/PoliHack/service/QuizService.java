package com.example.PoliHack.service;


import com.example.PoliHack.model.Quiz;
import com.example.PoliHack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    public String fetchResponses(List<String> options, List<Quiz> quizzes)
    {
        StringBuilder prompt= new StringBuilder();
        int i=0;
        for(Quiz quiz : quizzes)
        {
            prompt.append(quiz.getQuestion());
            prompt.append("\n");
            prompt.append(quiz.getOptions().get(convert(options.get(i))));
            prompt.append("\n");
            i++;
        }


        return prompt.toString();

    }
    public Integer convert(String value)
    {
        return switch (value) {
            case "a" -> 0;
            case "b" -> 1;
            case "c" -> 2;
            case "d" -> 3;
            default -> null;
        };

    }
}
