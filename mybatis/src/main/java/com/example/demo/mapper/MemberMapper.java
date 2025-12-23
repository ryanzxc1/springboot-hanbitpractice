package com.example.demo.mapper;

import com.example.demo.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
    //SELECT * FROM MEMBER;
    List<Member> selectAll();

    //SELECT * FROM member WHERE id = #{id}
    Member selectById(@Param("id") Long id);

}
