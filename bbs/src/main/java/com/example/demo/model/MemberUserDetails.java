package com.example.demo.model;

import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;



//로그인한 사용자의 정보를 담는 객체
/*
UserDetails는 Spring Security가 사용하는 “사용자 정보 인터페이스”

우리가 만든 Member 엔티티는 일반 JPA 엔티티이기 때문에,
Security가 직접 사용할 수 없습니다.

그래서 이렇게 UserDetails를 구현한 클래스를 만들어
Security가 이해할 수 있는 형태로 변환합니다.
 */
@Data
public class MemberUserDetails implements UserDetails {
    //User Details 디폴트 구현 getUsername(),getPassword(), getAuthorities()

    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authorities;

    //Extra
    private String displayName;
    private Long memberId;

    public MemberUserDetails(Member member, List<Authority> authorities) {
        this.username=member.getEmail();
        this.displayName=member.getName();
        this.password=member.getPassword();
        this.memberId=member.getId();
        this.authorities= authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .toList();
    }

}
