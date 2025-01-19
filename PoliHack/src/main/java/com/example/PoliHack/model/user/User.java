package com.example.PoliHack.model.user;

import com.example.PoliHack.model.Group;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String nickname;

    private String firstName;
    private String lastName;
    private String country;
    private String email;
    private String password;
    private List<Group> groups = new ArrayList<Group>();
}

