package com.example.demo.controller;


import com.example.demo.dto.MemberRequest;
import com.example.demo.dto.MemberResponse;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping()
    public List<MemberResponse> post(@RequestBody List<MemberRequest> memberRequests){
        return memberService.createBatch(memberRequests);
    }
    @GetMapping()
    public List<MemberResponse> get(){
        return memberService.findAll();
    }


}
