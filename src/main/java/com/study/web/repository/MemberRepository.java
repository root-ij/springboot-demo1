package com.study.web.repository;

import com.study.web.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // @Entity class 가 있어야 JAP repository 사용 가능, 메소드 이름만으로 쿼리 생성
public interface MemberRepository extends JpaRepository<Member, Long> { // <T = 사용될 엔티티, ID = ID 값 >

    /*  public {A} findBy{B}And{C}(String B, String C);
     *  SELECT = findBy, 즉 "SELECT * FROM A WHERE B = ? and C = ?" 와 같음 */
    boolean existsByLoginId(String loginId);
    boolean existsByNickname(String nickname);

}
