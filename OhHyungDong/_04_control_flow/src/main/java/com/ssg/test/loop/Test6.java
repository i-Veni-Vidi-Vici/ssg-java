package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu[] menu = new Menu[11];
        char answer ;
        int count = 0; //수량
        int menuNumber = 0;
        int total = 0; // 총합
        String[] str = new String[11];

        menu[1] = new Menu("원조김밥", 1500);
        menu[2] = new Menu("치즈김밥", 2000);
        menu[3] = new Menu("참치김밥", 2300);
        menu[4] = new Menu("그냥라면", 3000);
        menu[5] = new Menu("치즈라면", 3500);
        menu[6] = new Menu("짬뽕라면", 4000);
        menu[7] = new Menu("떡볶이", 2500);
        menu[8] = new Menu("순대", 2500);
        menu[9] = new Menu("오뎅", 1000);
        menu[10] = new Menu("음료수", 1000);
        do {
            System.out.println("김밥류");
            System.out.println(
                    "김밥류============== \n " +
                            "1. 원조김밥 == 1500원 \n " +
                            "2. 치즈김밥 == 2000원 \n " +
                            "3. 참치김밥 == 2300원 \n " +
                            "라면류============= \n " +
                            "4. 그냥라면 == 3000원 \n " +
                            "5. 치즈라면 == 3500원 \n " +
                            "6. 짬뽕라면 == 4000원 \n " +
                            "7. 떡볶이 == 2500원 \n " +
                            "8. 순대 == 2500원 \n " +
                            "9. 오뎅 == 1000원 \n " +
                            "기타 ============= \n " +
                            "10. 음료수 == 1000원 \n ");
            System.out.println("메뉴를 선택해주세요");
            menuNumber = scanner.nextInt();

            switch(menuNumber) {
                case 1:
                    System.out.println("수량을 입력해주세요 : ");
                    count = scanner.nextInt();
                    total += menu[menuNumber].getPrice() * count; // 선택한 메뉴의 가격을 더해줍니다.
                    str[1] = "원조김밥: " + count + "개" + (count * menu[1].getPrice()) + "원";
                    break;
                case 2:
                    System.out.println("수량을 입력해주세요 : ");
                    count = scanner.nextInt();
                    total += menu[menuNumber].getPrice() * count;
                    str[2] = "치즈김밥: " + count + "개" + (count * menu[2].getPrice()) + "원";


                    break;
                case 3:
                    System.out.println("수량을 입력해주세요 : ");
                    count = scanner.nextInt();
                    total += menu[menuNumber].getPrice() * count;
                    str[3] = "참치김밥: " + count + "개" + (count * menu[3].getPrice()) + "원";

                    break;
                case 4:
                    System.out.println("수량을 입력해주세요 : ");
                    count = scanner.nextInt();
                    total += menu[menuNumber].getPrice() * count;
                    str[4] = "그냥라면: " + count + "개" + (count * menu[4].getPrice()) + "원";
                    break;
                case 5:
                    System.out.println("수량을 입력해주세요 : ");
                    count = scanner.nextInt();
                    total += menu[menuNumber].getPrice() * count;
                    str[5] = "치즈라면: " + count + "개" + (count * menu[5].getPrice()) + "원";
                    break;
                case 6:
                    System.out.println("수량을 입력해주세요 : ");
                    count = scanner.nextInt();
                    total += menu[menuNumber].getPrice() * count;
                    str[6] = "짬뽕라면: " + count + "개" + (count * menu[6].getPrice()) + "원";
                    break;
                case 7:
                    System.out.println("수량을 입력해주세요 : ");
                    count = scanner.nextInt();
                    total += menu[menuNumber].getPrice() * count;
                    str[7] = "떡볶이: " + count + "개" + (count * menu[7].getPrice()) + "원";
                    break;
                case 8:
                    System.out.println("수량을 입력해주세요 : ");
                    count = scanner.nextInt();
                    total += menu[menuNumber].getPrice() * count;
                    str[8] = "순대: " + count + "개 - " + (count * menu[8].getPrice()) + "원";
                    break;
                case 9:
                    System.out.println("수량을 입력해주세요 : ");
                    count = scanner.nextInt();
                    total += menu[menuNumber].getPrice() * count;
                    str[9] = "오뎅: " + count + "개" + (count * menu[9].getPrice()) + "원";
                    break;
                case 10:
                    System.out.println("수량을 입력해주세요 : ");
                    count = scanner.nextInt();
                    total += menu[menuNumber].getPrice() * count;
                    str[10] = "음료수: " + count + "개" + (count * menu[10].getPrice()) + "원";
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }

            System.out.println("추가 주문하시겠어요 ?");
            answer = scanner.next().charAt(0); // 줄 바꿈문자('\n')를 버리고 사용자의 입력을 받습니다.
        } while(answer == 'y' || answer == 'Y'); // 대소문자 구분 없이 'y'를 입력했을 때 반복을 유지합니다.

        // 주문한 정보 출력
        System.out.println("주문하신 정보는 다음과 같습니다.");
        System.out.println("=========================");
        for(int i = 1; i<=10; i++){
            if(str[i] != null){
                System.out.println(str[i]);
            }
        }
        System.out.println("--------------------------");
        System.out.println("합계 : " + total + "원");
        System.out.println("=========================");
        System.out.println("감사합니다 !");
    }

    static class Menu
    {
        String name;
        int price;

        public Menu(String name, int price) {
            this.name = name;
            this.price = price;
        }
        public String getName()
        {
            return name;
        }
        public int getPrice()
        {
            return price;
        }
    }
}
