package member.model.vo;

public class Vip extends  Member{

    public Vip(){}

    public Vip(String name, String grade, int point){super(name,grade,point);}

    @Override
    public double getEjapoint(){return super.getEjapoint() * 0.1;}
}
