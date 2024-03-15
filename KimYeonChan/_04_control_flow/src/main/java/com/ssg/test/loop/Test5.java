package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=================== 회원목록 ====================");
        System.out.print("1 ");
        String member1 = sc.nextLine();
        System.out.print("2 ");
        String member2 = sc.nextLine();
        System.out.print("3 ");
        String member3 = sc.nextLine();

        int sumAge = 0;
        int sumHeight = 0;
        int sumWeight = 0;

        int findCount = 0;
        boolean inputStart = false;
        String strNum = "";

        for (int i = 0; i < member1.length(); i++) {
            // 맴버 1 나이 더하기
            boolean isNum = member1.charAt(i) >= '0' && member1.charAt(i) <= '9';
            if (findCount == 0) {
                if (!inputStart) {
                    if (isNum) {
                        inputStart = true;
                        strNum += member1.charAt(i);
                    }
                }
                else {
                    if (isNum) {
                        strNum += member1.charAt(i);
                    }
                    else {
                        inputStart = false;
                        int num = 0;
                        for (int j = 0; j < strNum.length(); j++) {
                            int tmpNum = strNum.charAt(j) - '0';
                            num = num * 10 + tmpNum;
                        }
                        sumAge += num;
                        strNum = "";
                        findCount++;
                    }
                }
            }
            // 맴버 1 키 더하기
            else if (findCount == 1) {
                if (!inputStart) {
                    if (isNum) {
                        inputStart = true;
                        strNum += member1.charAt(i);
                    }
                }
                else {
                    if (isNum) {
                        strNum += member1.charAt(i);
                    }
                    else {
                        inputStart = false;
                        int num = 0;
                        for (int j = 0; j < strNum.length(); j++) {
                            int tmpNum = strNum.charAt(j) - '0';
                            num = num * 10 + tmpNum;
                        }
                        sumHeight += num;
                        strNum = "";
                        findCount++;
                    }
                }
            }
            // 맴버 1 몸무게 더하기
            else if (findCount == 2) {
                if (!inputStart) {
                    if (isNum) {
                        inputStart = true;
                        strNum += member1.charAt(i);
                    }
                }
                else {
                    if (isNum) {
                        strNum += member1.charAt(i);
                    }
                    else {
                        inputStart = false;
                        int num = 0;
                        for (int j = 0; j < strNum.length(); j++) {
                            int tmpNum = strNum.charAt(j) - '0';
                            num = num * 10 + tmpNum;
                        }
                        sumWeight += num;
                        strNum = "";
                        findCount++;
                    }
                }
            }
            else {
                findCount = 0;
                break;
            }
        }
        for (int i = 0; i < member2.length(); i++) {
            // 맴버 2 나이 더하기
            boolean isNum = member2.charAt(i) >= '0' && member2.charAt(i) <= '9';
            if (findCount == 0) {
                if (!inputStart) {
                    if (isNum) {
                        inputStart = true;
                        strNum += member2.charAt(i);
                    }
                }
                else {
                    if (isNum) {
                        strNum += member2.charAt(i);
                    }
                    else {
                        inputStart = false;
                        int num = 0;
                        for (int j = 0; j < strNum.length(); j++) {
                            int tmpNum = strNum.charAt(j) - '0';
                            num = num * 10 + tmpNum;
                        }
                        sumAge += num;
                        strNum = "";
                        findCount++;
                    }
                }
            }
            // 맴버 2 키 더하기
            else if (findCount == 1) {
                if (!inputStart) {
                    if (isNum) {
                        inputStart = true;
                        strNum += member2.charAt(i);
                    }
                }
                else {
                    if (isNum) {
                        strNum += member2.charAt(i);
                    }
                    else {
                        inputStart = false;
                        int num = 0;
                        for (int j = 0; j < strNum.length(); j++) {
                            int tmpNum = strNum.charAt(j) - '0';
                            num = num * 10 + tmpNum;
                        }
                        sumHeight += num;
                        strNum = "";
                        findCount++;
                    }
                }
            }
            // 맴버 2 몸무게 더하기
            else if (findCount == 2) {
                if (!inputStart) {
                    if (isNum) {
                        inputStart = true;
                        strNum += member2.charAt(i);
                    }
                }
                else {
                    if (isNum) {
                        strNum += member2.charAt(i);
                    }
                    else {
                        inputStart = false;
                        int num = 0;
                        for (int j = 0; j < strNum.length(); j++) {
                            int tmpNum = strNum.charAt(j) - '0';
                            num = num * 10 + tmpNum;
                        }
                        sumWeight += num;
                        strNum = "";
                        findCount++;
                    }
                }
            }
            else {
                findCount = 0;
                break;
            }
        }
        for (int i = 0; i < member3.length(); i++) {
            // 맴버 3 나이 더하기
            boolean isNum = member3.charAt(i) >= '0' && member3.charAt(i) <= '9';
            if (findCount == 0) {
                if (!inputStart) {
                    if (isNum) {
                        inputStart = true;
                        strNum += member3.charAt(i);
                    }
                }
                else {
                    if (isNum) {
                        strNum += member3.charAt(i);
                    }
                    else {
                        inputStart = false;
                        int num = 0;
                        for (int j = 0; j < strNum.length(); j++) {
                            int tmpNum = strNum.charAt(j) - '0';
                            num = num * 10 + tmpNum;
                        }
                        sumAge += num;
                        strNum = "";
                        findCount++;
                    }
                }
            }
            // 맴버 3 키 더하기
            else if (findCount == 1) {
                if (!inputStart) {
                    if (isNum) {
                        inputStart = true;
                        strNum += member3.charAt(i);
                    }
                }
                else {
                    if (isNum) {
                        strNum += member3.charAt(i);
                    }
                    else {
                        inputStart = false;
                        int num = 0;
                        for (int j = 0; j < strNum.length(); j++) {
                            int tmpNum = strNum.charAt(j) - '0';
                            num = num * 10 + tmpNum;
                        }
                        sumHeight += num;
                        strNum = "";
                        findCount++;
                    }
                }
            }
            // 맴버 3 몸무게 더하기
            else if (findCount == 2) {
                if (!inputStart) {
                    if (isNum) {
                        inputStart = true;
                        strNum += member3.charAt(i);
                    }
                }
                else {
                    if (isNum) {
                        strNum += member3.charAt(i);
                    }
                    else {
                        inputStart = false;
                        int num = 0;
                        for (int j = 0; j < strNum.length(); j++) {
                            int tmpNum = strNum.charAt(j) - '0';
                            num = num * 10 + tmpNum;
                        }
                        sumWeight += num;
                        strNum = "";
                        findCount++;
                    }
                }
            }
            else {
                findCount = 0;
                break;
            }
        }

        System.out.printf("평균나이 %d세 / 평균 키 : %dCM / 평균 몸무게 : %dkg", sumAge / 3, sumHeight / 3, sumWeight / 3);
    }
}
