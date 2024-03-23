package com.sh.object.creation;

/**
 * <pre>
 * DTO 클래스
 * - 종합선물세트와 같이 getter/setter, 필드생성자를 모두 준비해둔다.
 * - 기본생성자호출 + setter값대입
 * - 핃드생성자호출 값대입

 * </pre>
 */
public class Item {
    private long id;
    private String name;
    private int price;

    // 기본생성자
    public Item(){}

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    // 필드생성자
    public Item(long id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println(this.id + ", " + this.name + ", " + this.price);
    }
    // getter/setter
}
