package lion.homepage.service;

import lion.homepage.domain.Member;
import lion.homepage.dto.*;
import lion.homepage.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAll() { return memberRepository.findAll(); }


    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
//    public List<Member> getMembersByGeneration(Integer generation) {
//        return memberRepository.findByGenerationsId(generation);
//    }

    public List<Member> getLeaderMembersOrderByRole() {
        return memberRepository.findLeaderMembersOrderedByRole();
    }

    public RandomTeamMakerResultDto makeTeam(RandomTeamRequestDto randomTeamRequestDto) {
        List<MemberRoleDto> memberRoleDtoList = memberRepository.findNormalMembers();
        List<String> backendMembers = getBackendMemberNames(memberRoleDtoList);
        List<String> frontendMembers = getFrontendMemberNames(memberRoleDtoList);
        List<String> planningMembers = getPlanningMemberNames(memberRoleDtoList);

        RandomTeamMakerResultDto randomTeamMakerResultDto = new RandomTeamMakerResultDto();
        for(int i = 0; randomTeamRequestDto.getTeamList().size() > i; i++) {
            randomTeamMakerResultDto.getTeamDtoList().add(getRadomTeamDto(randomTeamRequestDto.getTeamList().get(i), backendMembers, frontendMembers, planningMembers));

        }

        return randomTeamMakerResultDto;
    }

    private TeamDto getRadomTeamDto(TeamInfoDto teamInfoDto, List<String> backendMembers, List<String> frontendMembers, List<String> planningMembers) {
        TeamDto teamDto = new TeamDto();
        teamDto.setDesign(makeTeamMemberByPart(teamInfoDto.getDesign(),planningMembers));
        teamDto.setBackend(makeTeamMemberByPart(teamInfoDto.getBackend(),backendMembers));
        teamDto.setFrontend(makeTeamMemberByPart(teamInfoDto.getFrontend(),frontendMembers));
        return teamDto;
    }

    private String makeTeamMemberByPart(Integer memberNum, List<String> memberNameList) {
        List<String> nameList = new ArrayList<>();
        for (int i = 0; i < memberNum; i++) {
            int randomIndex = getRandomIndex(memberNameList);
            nameList.add(memberNameList.get(randomIndex));
            memberNameList.remove(randomIndex);
        }
        return String.join(", ", nameList);
    }

    private int getRandomIndex(List<?> memberList) {
        Random random = new Random();
        return random.nextInt(memberList.size());
    }

    private List<String> getBackendMemberNames(List<MemberRoleDto> memberRoleDtoList) {
        return memberRoleDtoList.stream()
                .filter(m -> m.getRole().ordinal() == 10)
                .map(MemberRoleDto::getName)
                .collect(Collectors.toList());
    }

    private List<String> getFrontendMemberNames(List<MemberRoleDto> memberRoleDtoList) {
        return memberRoleDtoList.stream()
                .filter(m -> m.getRole().ordinal() == 9)
                .map(MemberRoleDto::getName)
                .collect(Collectors.toList());
    }

    private List<String> getPlanningMemberNames(List<MemberRoleDto> memberRoleDtoList) {
        return memberRoleDtoList.stream()
                .filter(m -> m.getRole().ordinal() == 8)
                .map(MemberRoleDto::getName)
                .collect(Collectors.toList());
    }
}
