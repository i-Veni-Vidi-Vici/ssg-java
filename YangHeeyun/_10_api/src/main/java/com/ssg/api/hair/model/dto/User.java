package com.ssg.api.hair.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private LocalDate birthday;
    private LocalDate reservation_date;
    private LocalTime reservation_time;
    private LocalDateTime createdAt;

    public User(int id, String first_name, String last_name, String email, String gender, LocalDate birthday, LocalDate reservation_date, LocalTime reservation_time, LocalDateTime createdAt) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.reservation_date = reservation_date;
        this.reservation_time = reservation_time;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", reservation_date=" + reservation_date +
                ", reservation_time=" + reservation_time +
                ", createdAt=" + createdAt +
                '}';
    }
}
