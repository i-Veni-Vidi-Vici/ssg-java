package member.model.vo;

public class Silver extends Member{

    public Silver(){}

    public Silver (String name, String grade, int ponint){super(name, grade, ponint);}

    public double getEjapoint(){return super.getPoint() * 0.02; }
}
