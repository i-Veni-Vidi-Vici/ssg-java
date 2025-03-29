package member.model.vo;

public class Ruby extends Member{
    final double POINT = 0.30;

    public Ruby(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return 0;
    }
    public double getPOINT() {
        return POINT;
    }
    @Override
    public int buy(int price) {
        return (int)((1-POINT)*price);
    }
}
