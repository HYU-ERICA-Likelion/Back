package lion.homepage.enums;

public enum Role {
    President("회장"),
    VICE_PRESIDENT("부회장"),
    Frontend("프론트"),
    Backend("백엔드"),
    NORMAL_MEMBER("아기사자");

    private final String korean;

    Role(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}
