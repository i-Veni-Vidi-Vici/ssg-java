package com.ssg.api.hair.run;

import com.ssg.api.hair.model.dto.User;

public class App {
    public static void main(String[] args) {
        String data = """
        id,first_name,last_name,email,gender,birthday,reservation_date,reservation_time,created_at
        1,Devin,Rossey,drossey0@state.tx.us,Male,,2024-09-04,20:22,2012-10-10T07:55:50
        2,Alice,Krause,akrause1@about.com,Female,1983/04/04,2024-06-01,16:16,2011-09-08T17:09:39
        """;

        String[] a = data.split(",");
        User[] users = new User[100];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < 12; j++) {
                users[i].setId(Integer.parseInt(a[0]));
            }
        }
    }
}
