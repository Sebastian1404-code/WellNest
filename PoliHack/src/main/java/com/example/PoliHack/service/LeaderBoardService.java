package com.example.PoliHack.service;

import com.example.PoliHack.model.LeaderBoard;
import com.example.PoliHack.model.user.User;
import com.example.PoliHack.model.user.UserStatus;
import com.example.PoliHack.model.user.utils.UserSession;
import com.example.PoliHack.repository.LeaderBoardRepository;
import com.example.PoliHack.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class LeaderBoardService {

    private final UserRepository userRepository;
    private final LeaderBoardRepository leaderBoardRepository;

    public List<LeaderBoard> generateAndSaveLeaderBoard() {
        List<User> users = userRepository.findAll();
        UserSession currentUserSession = UserSession.getInstance();
        List<LeaderBoard> leaderBoardList = new ArrayList<>();

        for (User user : users) {
            int score = calculateScoreForUser(user);
            int statusValue = determineStatusValueForUser(user);
            boolean voted =  true;

            LeaderBoard leaderBoard = new LeaderBoard();
            leaderBoard.setUser(user);
            leaderBoard.setScore(score);
            leaderBoard.setStatus(UserStatus.fromValue(statusValue));
            leaderBoard.setIscurentuser(user.getId().equals(currentUserSession.getUserId()));
            leaderBoard.setVoted(voted);

            leaderBoardList.add(leaderBoard);
        }

        leaderBoardList.sort(Comparator.comparingInt(LeaderBoard::getScore).reversed());
        leaderBoardRepository.deleteAll();
        leaderBoardRepository.saveAll(leaderBoardList);

        return leaderBoardList;
    }

    public List<LeaderBoard> getLeaderBoard() {
        return leaderBoardRepository.findAll();
    }

    public LeaderBoard processAndUpdateCurrentUserScore(List<Integer> scores) {
        UserSession currentUserSession = UserSession.getInstance();
        String currentUserId = currentUserSession.getUserId();

        LeaderBoard leaderBoard = leaderBoardRepository.findByUserId(currentUserId)
                .orElseThrow(() -> new IllegalArgumentException("Utilizatorul curent nu există în LeaderBoard."));

        int doneCount = (int) scores.stream().filter(score -> score == 2).count();
        int predefinedValue = 10;
        int additionalScore = doneCount * predefinedValue;

        int newScore = leaderBoard.getScore() + additionalScore;
        leaderBoard.setScore(newScore);

        return leaderBoardRepository.save(leaderBoard);
    }

    private int calculateScoreForUser(User user) {
        return (int) (Math.random() * 100);
    }

    private int determineStatusValueForUser(User user) {
        return (int) (Math.random() * 4);
    }

    public boolean hasVoted(String userId) {
        LeaderBoard leaderBoard = leaderBoardRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utilizatorul nu există în LeaderBoard."));
        return leaderBoard.isVoted();
    }


}