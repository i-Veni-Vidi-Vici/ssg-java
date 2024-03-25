package com.ssg.oop.model;

public class TestProduct {
    public static void main(String[] args) {
        Product[] products=new Product[3];
        products[0]=new Product("ssgnote6","갤럭시노트6","경기도수원", 960000,10.0);
        products[1]=new Product("igxnote5","LG스마트폰5","경기도평택", 780000,0.7);
        products[2]=new Product("ktnorm3","KT일반폰3","서울시강남", 25000,0.3);

        for(Product product:products)
        {
            product.information();
        }

        for(int i=0;i<3;i++)
        {
            products[i].setPrice(1200000);
            products[i].setTex(0.05);
            System.out.printf("삼품명 : %-5s\n부가세 포함 가격 %.0f\n",
                    products[i].getProductName(),products[i].getPrice()+(products[i].getPrice()*products[i].getTex()));
        }



    }
}
