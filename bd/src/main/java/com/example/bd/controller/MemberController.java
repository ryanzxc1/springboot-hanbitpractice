package com.example.bd.controller;


import com.example.bd.model.Member;
import com.example.bd.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;


    @GetMapping("/members")
    public List<Member> getMembers(){
        return memberRepository.findAll();
    }
}
