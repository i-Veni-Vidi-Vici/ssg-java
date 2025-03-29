package com.sh.app._02.response.entity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
//@RestController
@RequiredArgsConstructor
@Slf4j
public class UsersController {
    private final UserService userService;

    @GetMapping("/users")
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
    public ResponseEntity<?> addUser(@RequestBody User user) {
        log.info("POST /users : user = {}", user);
        return userService.add(user);
    }
    @PatchMapping("/users/{id}")
    public ResponseEntity<?> updateUser(
                            @PathVariable Long id,
                            @RequestBody User user) {
        log.info("PATCH /users/{} : user = {}", id, user);
        return userService.update(id, user);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        log.info("DELETE /users/{}", id);
        return userService.delete(id);
    }

}


