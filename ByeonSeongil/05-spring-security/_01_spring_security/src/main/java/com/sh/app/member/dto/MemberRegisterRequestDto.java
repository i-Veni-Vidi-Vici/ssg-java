package com.sh.app.member.dto;

import com.sh.app.member.entity.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * @Null  null만 허용합니다.
 * @NotNull  null을 허용하지 않습니다. "", " "는 허용합니다.
 * @NotEmpty  null, ""을 허용하지 않습니다. " "는 허용합니다.
 * @NotBlank  null, "", " " 모두 허용하지 않습니다.
 *
 * @Email  이메일 형식을 검사합니다. 다만 ""의 경우를 통과 시킵니다
 * @Pattern(regexp = )  정규식을 검사할 때 사용됩니다.
 *
 * @Size(min=, max=)  길이를 제한할 때 사용됩니다.
 * @Max(value = )  value 이하의 값을 받을 때 사용됩니다.
 * @Min(value = )  value 이상의 값을 받을 때 사용됩니다.
 *
 * @Positive  값을 양수로 제한합니다.
 * @PositiveOrZero  값을 양수와 0만 가능하도록 제한합니다.
 * @Negative  값을 음수로 제한합니다.
 * @NegativeOrZero  값을 음수와 0만 가능하도록 제한합니다.
 *
 * @Future  현재보다 미래
 * @Past  현재보다 과거
 *
 * @AssertFalse  false 여부, null은 체크하지 않습니다.
 * @AssertTrue  true 여부, null은 체크하지 않습니다.
 * </pre>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegisterRequestDto {
    @NotNull(message = "아이디는 null일 수 없습니다.")
    private String memberId;
    @NotEmpty(message = "비밀번호는 null 또는 공백x")
    private String password;
    @NotBlank(message = "이름은 공백 또는 공백문자열x")
    private String name;

    public Member toMember(){
        return new Member(this.memberId, this.password, this.name, null);
    }
}
