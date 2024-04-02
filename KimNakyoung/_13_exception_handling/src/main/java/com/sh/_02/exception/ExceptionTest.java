package com.sh._02.exception;

import java.util.InputMismatchException;

public class ExceptionTest {
    // 예외 안던짐
    public boolean checkEnoughMoney(int price, int money){
        if(price > money)
            return false;

        return true;
    }

    /**
     * 정상흐름 : 구매가능한 경우, 예외 던지지 않음
     * 예외흐름 : 구매불가한 경우, 예외 던짐
     *
     * @param price
     * @param money
     */

    public void checkEnoughMoney2(int price, int money) throws Exception {
        if(money < price){
            throw new Exception();
        }

    }

    public void unchecked() {
//        throw new RuntimeException("헤헤");
//        throw new NullPointerException("그렇네요");
        throw new InputMismatchException("타입변환 불가");
    }

//    public void checked() {
////        throw new Exception("체킷아웃!"); // 이럼 오류남? 왜? Unhandled exception: java.lang.Exception 예외 처리해주세요!!!
//
//        // 1. try catch로 감싸기 ctrl + alt + v (보통 이렇게 안함)
//
//        try {
//            throw new Exception("체킷아웃!"); // 예외처리 안하면 오류
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

    /**
     * 호출부로 예외처리 위임
     *
     */

    // 이 메소드는 예외를 던집니다~ 조심하세요!!
    public void checked() throws Exception {
        throw new Exception("체킷아웃!!");
    }




}
