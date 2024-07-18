package com.sh.app.users.dto;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdateDto {
    @Pattern(regexp = "[가-힣]{1,}", message = "이름은 한글 2글자이상 작성해주세요.")
    @Pattern(regexp = "\\S{1,}", message = "이름은 공백을 포함할 수 없습니다.")
    private String name;
    @Past(message = "유효한 날짜를 입력해주세요.")
    private LocalDate birthday;
}
