package com.example.bd.config;


import com.example.bd.model.Member;
import com.example.bd.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class DataInitializer implements ApplicationRunner {
    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        memberRepository.save(Member.builder().name("윤서준").email("SeojunYoon@hanbit.co.kr").age(10).build());
        memberRepository.save(Member.builder().name("윤광철").email("KwangcheolYoon@hanbit.co.kr").age(43).build());
    }
}
