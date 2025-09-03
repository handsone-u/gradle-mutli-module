package io.handsone.core.repository

import io.handsone.domain.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
}
