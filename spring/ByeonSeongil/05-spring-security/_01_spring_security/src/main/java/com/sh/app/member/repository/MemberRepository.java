package com.sh.app.member.repository;

import com.sh.app.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Query("""
       select
            m
       from
            Member m join fetch m.authorities
       where
            m.memberId = :username
       """)
    Optional<Member> findByUsername(String username);
}
