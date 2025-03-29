package com.sh._01.java.config;
/**
 * <pre>
 * Data Transfer Object
 * - db로 혹은 db로 부터 전달받은 데이터를 담아줄 객체
 * - 테이블의 각 컬럼과 대응하는 필드를 가지고 있다
 * </pre>
 */
public class MenuDto {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String oderableStatus; // jdbc api에는 char전용 메소드가 없다

    public MenuDto() {
    }

    public MenuDto(int menuCode, String menuName, int menuPrice,
                   int categoryCode, String oderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.oderableStatus = oderableStatus;
    }

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

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOderableStatus() {
        return oderableStatus;
    }

    public void setOderableStatus(String oderableStatus) {
        this.oderableStatus = oderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDto{" +
                "menuCode=" + menuCode +
                ", MenuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", oderableStatus='" + oderableStatus + '\'' +
                '}';
    }
}
