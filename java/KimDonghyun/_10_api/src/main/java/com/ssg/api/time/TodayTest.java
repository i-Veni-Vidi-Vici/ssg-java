package com.ssg.api.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TodayTest {

	public static void main(String[] args){
		LocalDateTime today = LocalDateTime.now();
		// E 목 Thu
		System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일 E요일")));
		System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일 E요일", Locale.KOREA)));
	}
}
