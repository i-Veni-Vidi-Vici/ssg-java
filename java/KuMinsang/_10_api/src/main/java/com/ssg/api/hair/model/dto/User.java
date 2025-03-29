package com.ssg.api.hair.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private LocalDate birthday;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private LocalDate createAt;

    public User() {
    }

    public User(int id, String firstName, String lastName, String email, String gender, LocalDate birthday, LocalDate reservationDate, LocalTime reservationTime, LocalDate createAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        if(!birthday.isEmpty()) {
            this.birthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        if(!reservationDate.isEmpty()) {
            this.reservationDate = LocalDate.parse(reservationDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        if(!reservationTime.isEmpty()) {
            String[] time = reservationTime.split(":");
            if(Integer.parseInt(time[0])<10){
                time[0] = '0'+time[0];
            }
            this.reservationTime = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
            //this.reservationTime = LocalTime.parse(reservationTime, DateTimeFormatter.ofPattern("HH:mm"));
        }
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        if(!createAt.isEmpty()) {
            this.createAt = LocalDate.parse(createAt, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }

    @Override
    public String toString(){
        return String.format("id=%d, firstName='%s', lastName='%s', email='%s', gender='%s', birthday=%s, reservationDate=%s, reservationTime=%s, createAt=%s", id, firstName, lastName, email, gender, birthday, reservationDate, reservationTime, createAt);
    }

}
