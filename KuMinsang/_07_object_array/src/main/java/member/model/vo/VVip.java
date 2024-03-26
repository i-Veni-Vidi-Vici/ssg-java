package member.model.vo;

public class VVip extends Member{
    final double POINT = 0.15;

    public VVip(String name, String grade, int point) {
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
