package com.sh._01.java.config;

/**
 * DTO : Data Transfer Object
 * - db로 혹은 db로부터 잔달 받은 데이터를 담아줄 객체
 * - 테이블의 각 컬럼과 대응하는 필드를 가지고 있다.
 */
public class MenuDto {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categroyCode;
    private String orderableStaus; //jdbc API에는 char전용 메소드가 없다. 한글자여도 String으로

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategroyCode() {
        return categroyCode;
    }

    public void setCategroyCode(int categroyCode) {
        this.categroyCode = categroyCode;
    }

    public String getOrderableStaus() {
        return orderableStaus;
    }

    public void setOrderableStaus(String orderableStaus) {
        this.orderableStaus = orderableStaus;
    }

    @Override
    public String toString() {
        return "MenuDto{" +
                "menuCode='" + menuCode + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categroyCode=" + categroyCode +
                ", orderableStaus='" + orderableStaus + '\'' +
                '}';
    }

    public MenuDto() {
    }

    public MenuDto(int menuCode, String menuName, int menuPrice, int categroyCode, String orderableStaus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categroyCode = categroyCode;
        this.orderableStaus = orderableStaus;
    }
}
