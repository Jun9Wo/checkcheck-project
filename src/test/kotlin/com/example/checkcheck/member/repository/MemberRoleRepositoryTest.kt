package com.example.checkcheck.member.repository

import com.example.checkcheck.common.enums.Role
import com.example.checkcheck.member.entity.Member
import com.example.checkcheck.member.entity.MemberRole
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = ["classpath:application-test.yml"])
class MemberRoleRepositoryTest @Autowired constructor(
    private val memberRoleRepository: MemberRoleRepository,
    private val memberRepository: MemberRepository,
) {
    @Test
    fun `멤버 권한 생성 테스트`() {
        val member = Member(
            id = 1,
            email = "test@test.com",
            password = "testtest1@",
            name = "test"
        )

        memberRepository.save(member)

        val memberRole = MemberRole(
            id = 1,
            role = Role.MEMBER,
            member = member
        )

        memberRoleRepository.save(memberRole)

        assertThat(memberRole.id).isSameAs(1L)
        assertThat(memberRole.role).isSameAs(Role.MEMBER)
        assertThat(memberRole.member.id).isSameAs(1L)
        assertThat(memberRole.member.name).isSameAs("test")
        assertThat(memberRole.member.email).isSameAs("test@test.com")
        assertThat(memberRole.member.password).isSameAs("testtest1@")
    }
}