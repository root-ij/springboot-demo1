package com.study.web.service;

import com.study.web.domain.member.dto.JoinRequest;
import com.study.web.domain.member.dto.LoginRequest;
import com.study.web.domain.member.entity.Member;
import com.study.web.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional // 데이터베이스 트랜잭션: 작업 or 연산 단위에 프록시 패턴을 설정해 단독 처리를 가능하게 함 - DB 꼬임 방지
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    // 회원 (Login Id) 중복 체크
    public boolean duplicateCheck(String loginId) {
        return memberRepository.existsByLoginId(loginId);
    }

    // 회원 가입
    public void join(JoinRequest req) {
        memberRepository.save(req.toEntity());
    }

    // 로그인
    public Member login(LoginRequest req) {
        Optional<Member> optionalMember = memberRepository.findByLoginId(req.getLoginId());

        // 회원 Id와 일치하는 회원이 없으면 null 값 return
        if(optionalMember.isEmpty()) {
            return null;
        }

        Member member = optionalMember.get();

        // 회원 Id : PW 가 일치하지 않으면 null 값 return
        if(!member.getPassword().equals(req.getPassword())) {
            return null;
        }

        return member;
    }

}
