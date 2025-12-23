package com.example.demo.service;

import com.example.demo.dto.MemberRequest;
import com.example.demo.dto.MemberResponse;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public MemberResponse create(MemberRequest memberRequest){
        var member = Member.builder()
                .name(memberRequest.getName())
                .email(memberRequest.getEmail())
                .age(memberRequest.getAge())
                .enabled(true).build();
        memberRepository.save(member);
        return mapToMemberResponse(member);


    }

    //오류 생기면 이전으로 롤백
    @Transactional
    public List<MemberResponse> createBatch(List<MemberRequest> memberRequests){
        return memberRequests.stream().map(this::create).toList();
    }

    public List<MemberResponse> findAll(){
        return memberRepository.findAll().stream().map(this::mapToMemberResponse).toList();
    }

    private MemberResponse mapToMemberResponse(Member member){
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .age(member.getAge())
                .build();
    }

}
