package com.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FragmentController {
    @GetMapping("/fragment/common")
    public String getFragment(){
        return "fragment/fragment-common";
    }
}
