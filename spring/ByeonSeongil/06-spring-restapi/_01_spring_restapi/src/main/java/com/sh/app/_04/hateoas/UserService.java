package com.sh.app._04.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
            return ResponseEntity.notFound().build();
        }
        // HATEOAS의 EntityModel객체(요청자원, 링크....)
        EntityModel entityModel = EntityModel.of(
            found,
            // 링크.관계()
            // linkTo(컨트롤러프락시.메소드())
            linkTo(methodOn(UsersController.class).getUser(id)).withSelfRel(),
            linkTo(methodOn(UsersController.class).getUsers()).withRel("users")
        );
        return ResponseEntity.ok(entityModel);
    }

    public ResponseEntity<?> findAll() {
        // List<User> -> List<EntityModel<User>>
        List<EntityModel<User>> entityModels =
                db.stream()
                        .map((user) -> EntityModel.of(
                                user,
                                linkTo(methodOn(UsersController.class).getUser(user.getId())).withSelfRel(),
                                linkTo(methodOn(UsersController.class).getUsers()).withRel("users")
                        ))
                        .toList();

        return ResponseEntity.ok(Map.of(
            "result", "success",
            "size", db.size(),
            "data", entityModels
        ));
    }
}
