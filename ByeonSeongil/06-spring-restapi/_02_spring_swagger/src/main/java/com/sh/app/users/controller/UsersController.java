package com.sh.app.users.controller;

import com.sh.app.users.dto.UserAddDto;
import com.sh.app.users.dto.UserUpdateDto;
import com.sh.app.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * ResponseEntity
 * - @ResponseBody 기능이 있는 응답객체이다.
 * - 응답 StatusCode, Header, Body를 쉽게 작성할 수 있다.
 * - new 연산자 또는 builder패턴으로 객체를 생성할수 있다.
 * - ResponseEntity<T>와 같이 응답 본문에 출력될 객체를 generic으로 가진다.
 * </pre>
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "UserController", description = "사용자 관리 Rest API")
public class UsersController {
    private final UserService userService;
    
    @GetMapping("/users")
    @Operation(summary = "전체 사용자 조회", description = "모든 사용자를 조회합니다.")
    public ResponseEntity<?> getUsers() {
        return userService.findAll();
    }

    /**
     * 200 - 정상조회시
     * 404 - 해당 id로 회원이 존재하지 않는 경우
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    @Operation(summary = "사용자 ID 조회", description = "ID와 일치하는 사용자를 한명 조회합니다.")
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "해당 사용자가 존재하는 경우 입니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
        @ApiResponse(responseCode = "404", description = "해당 사용자가 존재하지 않는 경우 입니다.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        log.info("GET /users/{}", id);
        return userService.findById(id);
    }

    /**
     * <pre>
     * @RequestBody - 요청메세지 본문의 내용을 읽어와 매개변수 타입으로 전달한다.
     * - json형식의 데이터를 커맨트객체(dto)타입으로 변환도 지원한다.
     * </pre>
     * @param user
     * @return
     */
    @PostMapping("/users")
    @Operation(summary = "사용자 등록", description = "사용자를 등록합니다.")
    @ApiResponse(responseCode = "201", description = "사용자가 정상등록된 경우입니다. Location 응답헤더에서 식별주소를 확인하세요.")
    @Parameters({
        @Parameter(name = "name", description = "(필수) 이름을 작성하세요. 한글만 허용합니다.", example = "홍길동"),
        @Parameter(name = "birthday", description = "생일을 작성하세요.", example = "1999-09-09"),
    })
    public ResponseEntity<?> addUser(@Valid @RequestBody UserAddDto user) {
        log.info("POST /users : user = {}", user);
        return userService.add(user);
    }
    
    @PatchMapping("/users/{id}")
    @Operation(summary = "사용자 정보 수정", description = "일부 사용자 정보를 수정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "정상적으로 수정된 경우 입니다."),
        @ApiResponse(responseCode = "404", description = "해당 사용자가 존재하지 않는 경우 입니다.")
    })
    public ResponseEntity<?> updateUser(
                            @PathVariable Long id,
                            @Valid @RequestBody UserUpdateDto user) {
        log.info("PATCH /users/{} : user = {}", id, user);
        return userService.update(id, user);
    }
    @DeleteMapping("/users/{id}")
    @Operation(summary = "사용자 삭제", description = "ID와 일치하는 사용자를 삭제합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "정상적으로 삭제된 경우 입니다."),
        @ApiResponse(responseCode = "404", description = "해당 사용자가 존재하지 않는 경우 입니다.")
    })
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        log.info("DELETE /users/{}", id);
        return userService.delete(id);
    }

}


