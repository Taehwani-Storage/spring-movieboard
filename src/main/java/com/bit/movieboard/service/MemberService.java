package com.bit.movieboard.service;

import com.bit.movieboard.model.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
public class MemberService {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "mappers.MemberMapper";

    public MemberDTO auth(MemberDTO memberDTO) {
        return sqlSession.selectOne(NAMESPACE + ".auth", memberDTO);
    }

    public boolean validateUsername(String username) {
        return sqlSession.selectOne(NAMESPACE + ".validateUsername", username) == null;
    }

    public boolean validateNickname(String nickname) {
        return sqlSession.selectOne(NAMESPACE + ".validateNickname", nickname) == null;
    }

    public void register (MemberDTO memberDTO) {
        sqlSession.insert(NAMESPACE + ".register", memberDTO);
    }

    public MemberDTO selectByEmail(String email) {
        return sqlSession.selectOne(NAMESPACE + ".selectByEmail", email);
    }
}
