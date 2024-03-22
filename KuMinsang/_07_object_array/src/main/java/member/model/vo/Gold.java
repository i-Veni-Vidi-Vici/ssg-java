package member.model.vo;

public class Gold extends Member {
    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjaPoint() {
        return getPoint()*0.05;
    }

}
