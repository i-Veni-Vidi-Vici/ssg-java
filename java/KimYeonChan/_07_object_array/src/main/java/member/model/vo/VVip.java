package member.model.vo;

public class VVip extends Member {
    public VVip() {}
    public VVip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public int getEjapoint() {
        return (int)(getPoint() * 0.15);
    }
}
