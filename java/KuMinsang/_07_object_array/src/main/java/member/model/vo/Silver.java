package member.model.vo;

public class Silver extends Member {
    final double POINT = 0.02;
    public Silver(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint(){
        return getPoint() * POINT;
    }

    public double getPOINT() {
        return POINT;
    }
    @Override
    public int buy(int price) {
        return (int)((1-POINT)*price);
    }
}
