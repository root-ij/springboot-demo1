package com.study.web.domain.member.entity;

import javax.persistence.Table;

@Table // DB Table 생성해주는 어노테이션
public enum MemberRole { // enum = 상수
    User, ADMIN, DORMANT, OPT_OUT
}
