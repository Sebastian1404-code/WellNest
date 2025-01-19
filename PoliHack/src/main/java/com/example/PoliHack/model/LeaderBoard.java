package com.example.PoliHack.model;

import com.example.PoliHack.model.user.User;
import com.example.PoliHack.model.user.UserStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "leaderboard")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaderBoard {
    @Id
    private String id;
    private User user;
    private int score;
    private UserStatus status;
    private boolean iscurentuser;
    private boolean voted;
}