package lion.homepage.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lion.homepage.domain.Member;
import lion.homepage.dto.MemberRoleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static lion.homepage.domain.QGenerationRole.generationRole;
import static lion.homepage.domain.QMember.member;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberCustomRepositoryImpl implements MemberCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MemberRoleDto> findNormalMembers() {
        return jpaQueryFactory
                .select(Projections.constructor(MemberRoleDto.class,
                        member.name,
                        generationRole.role))
                .from(member)
                .innerJoin(generationRole)
                .where(generationRole.role.ordinal().goe(8))
                .fetch();
    }
}
