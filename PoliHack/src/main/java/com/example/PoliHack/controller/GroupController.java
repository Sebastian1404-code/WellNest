package com.example.PoliHack.controller;


import com.example.PoliHack.model.Group;
import com.example.PoliHack.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;

    @PostMapping
    public void validateRoom(String pass)
    {
        Optional<Group> group=groupRepository.findAll().stream()
                .filter(x-> Objects.equals(pass, x.getPass())).findFirst();
        if(group.isPresent())
        {


        }


    }
}
