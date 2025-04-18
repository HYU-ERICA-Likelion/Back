package lion.homepage.enums;

public enum RoleType {
    President("대표"), // 대표
    PlanningPartManager("기획/디자인 파트장"), // 기획 파트장
    PlanningPartMember("기획/디자인 파트원"), // 기획 파트원
    FrontendPartManager("프론트엔드 파트장"), // 프론트엔드 파트장
    FrontendPartMember("프론트엔드 파트원"), // 프론트엔드 파트원
    BackendPartManager("백엔드 파트장"), // 백엔드 파트장
    BackendPartMember("백엔드 파트원"), // 백엔드 파트원


    // 프로젝트에 들어갈 Role인경우
    // Member로만 등록됨
    // 멋사 안에서 프론트엔드 파트장이어도 프로젝트에서는 프론트엔드 Member로 됨


    ProjectManager("프로젝트 매니저"), // 프로젝트 매니저

    NormalPlanningMember("기획/디자인 아기사자"),
    NormalFrontendMember("프론트엔드 아기사자"),
    NormalBackendMember("백엔드 아기사자");

    private final String korean;

    RoleType(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}
