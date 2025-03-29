package com.ssg.api.hair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reservation {
    private int id;
    private String firstName, lastName,email,gender;
    private LocalDate birthday, reservationDate;
    private LocalTime reservationTime;
    private LocalDateTime createdAt;

    public Reservation(String reservInfo) {
       String[] infoStrArr = reservInfo.split(",");
       this.id = Integer.parseInt(infoStrArr[0]);
       this.firstName = infoStrArr[1];
       this.lastName = infoStrArr[2];
       this.email = infoStrArr[3];
       this.gender = infoStrArr[4];
       this.birthday = dateStr_ToLocalDate(infoStrArr[5]);
       this.reservationDate = dateStr_ToLocalDate(infoStrArr[6]);
       this.reservationTime

    }

    private LocalDate dateStr_ToLocalDate(String str){
        String[] dateStrArr = str.split("-");
        int[] dateIntArr = new int[dateStrArr.length];
        for(int i =0; i<dateIntArr.length; i++){
            dateIntArr[i] = Integer.parseInt(dateStrArr[i]);
        }
        return LocalDate.of(dateIntArr[0], dateIntArr[1], dateIntArr[2]);
    }
}
