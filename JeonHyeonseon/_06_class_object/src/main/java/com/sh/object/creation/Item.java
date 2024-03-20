package com.sh.object.creation;

/**
 * <pre>
 * DTO 클래스
 *  - 종합선물세트와 같이 getter/setter, 필드생성자(파라미터)를 모두 준비해둔다.
 *  - 기본생성자 호출 + setter호출 후 값대입
 *  - 필드생성자 호출 + 값대입
 *  두 가지 다 가능
 * </pre>
 */
public class Item {
    private long id;
    private String name;
    private int price;

    // 기본생성자
    public Item(){}
    // 필드생성자
    public Item(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    // getter/setter

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

    public void print() {
        System.out.println(this.id + ", " + this.name + ", " + this.price);
    }
}
