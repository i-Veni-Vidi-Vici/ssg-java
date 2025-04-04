package com.ssg.api.hair.model.dto;

import java.time.LocalDate;

public class User {
    private int id;
    private String firstName;

    private String lastName;

    private String email;
    private String gender;
    private LocalDate birthday;
    private LocalDate reservationDate;
    private LocalDate reservationTime;
    private LocalDate created_at;
    public User(int id, String firstName, String lastName, String email, String gender, LocalDate birthday, LocalDate revationDate, LocalDate reservationTime, LocalDate created_at) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.reservationDate = revationDate;
        this.reservationTime = reservationTime;
        this.created_at = created_at;
    }

    public String information(){
        return "User{id="+id+", firstName="+firstName+", lastName="+lastName+", email="+email
                +", gender="+gender+", birthday="+birthday+", reservationDate="+reservationDate
                +", reservationTime"+reservationTime+", createdAt="+created_at;
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

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDate reservationTime) {
        this.reservationTime = reservationTime;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }
}
