package com.sh.app.users.service;

import com.sh.app.users.dto.UserAddDto;
import com.sh.app.users.dto.UserUpdateDto;
import com.sh.app.users.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private List<User> db = new ArrayList<User>();

    public UserService() {
        this.db.add(new User(1L, "홍길동", LocalDate.of(1999, 9, 9)));
        this.db.add(new User(2L, "신사임당", LocalDate.of(2003, 3, 3)));
        this.db.add(new User(3L, "이순신", LocalDate.of(1988, 8, 8)));
    }

    public ResponseEntity<?> findById(Long id) {
        User found = db.stream()
                        .filter((user) -> user.getId() == id)
                        .findFirst()
                        .orElse(null);
        if (found == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                                 .body(id);
            return ResponseEntity.notFound().build();
        }
//        return ResponseEntity.status(HttpStatus.OK)
//                             .body(found);
        return ResponseEntity.ok(found);
    }

    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(Map.of(
            "result", "success",
            "size", db.size(),
            "data", db
        ));
    }

    public ResponseEntity<?> add(UserAddDto dto) {
        // User객체의 id를 부여
        // 기존 id 최대값에 +1 처리
        Long newId = db.stream()
                    .mapToLong(user -> user.getId())
                    .max()
                    .orElse(0) + 1;
        User newUser = dto.toUser();
        newUser.setId(newId);
        db.add(newUser);
        // POST 생성 요청의 성공은 200보다 더 구체적인 201 Created를 사용한다.
        // Location속성으로 생성된 자원에 대한 링크를 제공해야 한다.
        return ResponseEntity.created(URI.create("/users/" + newId)).build();
    }

    public ResponseEntity<?> update(Long id, UserUpdateDto dto) {
        User found = db.stream()
                        .filter((_user) -> _user.getId() == id)
                        .findFirst().orElse(null);
        if(found == null)
            return ResponseEntity.notFound().build(); // 404
        
        // 수정
        if(dto.getName() != null)
            found.setName(dto.getName());
        if(dto.getBirthday() != null)
            found.setBirthday(dto.getBirthday());
        return ResponseEntity.ok(found); // 200 변경된 데이터를 반환할 수도 있다.
    }

    public ResponseEntity<?> delete(Long id) {
        User found = db.stream()
                .filter((_user) -> _user.getId() == id)
                .findFirst().orElse(null);
        if(found == null)
            return ResponseEntity.notFound().build();
        // 삭제
        db.remove(found);
        // 삭제성공에 대한 상태코드는 204 No Content이다.
        return ResponseEntity.noContent().build(); // 204
    }
}
