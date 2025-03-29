package com.sh.app._03.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddDto {
    @NotBlank(message = "이름은 공백을 허용하지 않습니다.")
    @Pattern(regexp = "[가-힣]{1,}", message = "이름은 한글 2글자이상 작성해주세요.")
    private String name;
    @Past(message = "유효한 날짜를 입력해주세요.")
    private LocalDate birthday;

    public User toUser() {
        return new User(null, this.name, this.birthday);
    }
}
