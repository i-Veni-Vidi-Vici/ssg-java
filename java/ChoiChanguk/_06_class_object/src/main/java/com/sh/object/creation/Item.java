package com.sh.object.creation;


/**
 * DTO 클래스
 *  - 종합선물세트와 같이 getter/setter, 필드생성자를 모두 준비해둔다.
 *  - 기본생성자호출 + setter 값대입
 *  - 필드생성자호출 값대입
 */
public class Item {

    private long id;
    private String name;

    //기본생성자

    public Item()
    {

    }
    public Item(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void print()
    {
        System.out.println(this.id+", "+this.name+", "+this.price);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;
}
