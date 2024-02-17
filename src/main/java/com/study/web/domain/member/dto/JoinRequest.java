package com.study.web.domain.member.dto;

import com.study.web.domain.member.entity.MemberRole;
import com.study.web.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor // 파라미터 없는 기본 생성자 자동 생성
public class JoinRequest {

        private String loginId;
        private String password;
        private String passwordCheck;
        private String email;
        private String nickname;

        // Password 암호화 X
        public Member toEntity() {
            return Member.builder()
                    .loginId(this.loginId)
                    .password(this.password)
                    .email(this.email)
                    .nickname(this.nickname)
                    .role(MemberRole.USER)
                    .build();
        }

        // Password 암호화
        public Member toEntity(String encodedPassword) {
            return Member.builder()
                    .loginId(this.loginId)
                    .password(encodedPassword)
                    .email(this.email)
                    .nickname(this.nickname)
                    .role(MemberRole.USER)
                    .build();
        }

}