package member.model.vo;

public class Member {

    /**
     * protected로 지정하면 자식 클래스에서 직접 접근 가능하다
     * Member의 자식클래스 Gold Silver Vip VVip에서는 직접 접근할 수 있다.
     *
     * 단, 커스텀클래스를 상속하는 경우에는 protected 지정가능하지만,
     * jdk가 제공하는 어떤 캡슐화된 클래스를 상속한다면, protected로 변경할 수 있다.
     * -> super생성자를 통해 값세팅 & getter, setter 이용
     */


    private String name;
    private String grade;
    private int point;

    public Member() {
    }

    public Member(String name, String grade, int point) {
        this.name = name;
        this.grade = grade;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    // 부모타입에서는 등급별 이자율을 구체화할 수 없기 때문에 기본이자율(Silver)로 계산해 두고, 자식객체쪽에서 구현하게 한다.

    public double getEjapoint(){ return point * 0.02; }
}
