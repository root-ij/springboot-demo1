package com.study.web.domain.member.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity // Entity 클래스에 Setter 생성 절대 X 왜? 객체를 언제든지 변경할 수 있어 안정성 보장 X
public class Member {

        @Id // = PK 역할  spring-jap 쓰면 나옴 댕신기
        @GeneratedValue(strategy = IDENTITY) // Gen.Value = PK 자동 생성, IDENTITY = DB에 생성 위임
        private Long id;

        @Column(nullable = false) // DB Table 에 대한 설정을 java class 에서 구현 가능 댕신기 22
        private String loginId;
        private String password;
        private String passwordCheck;
        private String email;
        private String nickname;

        private MemberRole role;

}

