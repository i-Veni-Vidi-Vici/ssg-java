package com.sh.app.users.dto;

import com.sh.app.users.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "UserAddDto", description = "회원등록 DTO")
public class UserAddDto {
    @NotBlank(message = "이름은 공백을 허용하지 않습니다.")
    @Pattern(regexp = "[가-힣]{1,}", message = "이름은 한글 2글자이상 작성해주세요.")
    @Schema(description = "사용자 한글 이름", example = "홍길동")
    private String name;
    @Past(message = "유효한 날짜를 입력해주세요.")
    @Schema(description = "사용자 생일", example = "1988-08-08", nullable = true)
    private LocalDate birthday;

    public User toUser() {
        return new User(null, this.name, this.birthday);
    }
}
