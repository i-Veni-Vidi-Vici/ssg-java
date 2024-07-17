package com.sh.app._04.hateoas;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * HATEOAS (Hypermedia as the Engin of Application State)
 * - Rest API가 지정한 룰 중의 하나로써, 응답 결과에 사용자의 다음액션을 결정할 수 있는 링크를 제공하는 것
 * - 사용자가-시스템간의 인터액션을 더 효율적으로 처리할 수 있다.
 *
 * 구성요소
 * - EntityModel 조회결과와 관련링크를 가지는 컨테이너 객체이다.
 *
 * - linkTo 링크생성 static 메서드
 * - methodOn 컨트롤러 클래스의 프록시생성 static 메서드
 * - withSelfRel 요청 자원 스스로를 가리키는 링크
 * - withRel 요청자원과 어떤관계인지 설정 (목록, 연관된 엔티티 조회)
 *
 * </pre>
 */
@RestController
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
     *
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        log.info("GET /users/{}", id);
        return userService.findById(id);
    }
}