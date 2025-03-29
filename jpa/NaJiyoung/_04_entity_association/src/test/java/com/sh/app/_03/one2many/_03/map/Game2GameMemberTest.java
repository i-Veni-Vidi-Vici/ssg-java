package com.sh.app._03.one2many._03.map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Game2GameMemberTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    void setUp() {
        this.entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close();
    }

    @Test
    @DisplayName("ddl-auto=create 확인")
    void test() {
        /*
            Hibernate:
                create table tbl_game (
                    gameDate datetime(6),
                    id bigint not null auto_increment,
                    primary key (id)
                ) engine=InnoDB
            Hibernate:
                create table tbl_game_member (
                    game_id bigint,
                    id bigint not null,
                    name varchar(255),
                    role_name varchar(255),
                    username varchar(255),
                    primary key (id)
                ) engine=InnoDB
            Hibernate:
                alter table tbl_game_member
                   add constraint FKeph2ggo2yndk0xi5powqv0735
                   foreign key (game_id)
                   references tbl_game (id)
         */
    }

    @Test
    @DisplayName("Game 등록")
    void test2() {
        // given
        GameMember gameMember1 = new GameMember("honggd", "홍길동");
        GameMember gameMember2 = new GameMember("sinsa", "신사임당");
        GameMember gameMember3 = new GameMember("leess", "이순신");
        Game game = Game.builder()
                .participants(Map.of(
                        "Top", gameMember1,
                        "Jungle", gameMember2,
                        "Support", gameMember3
                ))
                .build();
        // when
        this.entityManager.persist(gameMember1);
        this.entityManager.persist(gameMember2);
        this.entityManager.persist(gameMember3);
        this.entityManager.persist(game);
        this.entityManager.flush();
        /*
            Hibernate:
                insert
                into
                    tbl_game_member
                    (name, username)
                values
                    (?, ?)
            Hibernate:
                insert
                into
                    tbl_game_member
                    (name, username)
                values
                    (?, ?)
            Hibernate:
                insert
                into
                    tbl_game_member
                    (name, username)
                values
                    (?, ?)
            Hibernate:
                insert
                into
                    tbl_game
                    (gameDate)
                values
                    (?)
            Hibernate:
                update
                    tbl_game_member
                set
                    game_id=?,
                    role_name=?
                where
                    username=?
            Hibernate:
                update
                    tbl_game_member
                set
                    game_id=?,
                    role_name=?
                where
                    username=?
            Hibernate:
                update
                    tbl_game_member
                set
                    game_id=?,
                    role_name=?
                where
                    username=?
         */
        // then
        this.entityManager.clear();
        Game game2 = this.entityManager.find(Game.class, game.getId());
        System.out.println(game2);
        assertThat(game2).isNotNull();
        assertThat(game2.getParticipants()).hasSize(3);
    }

    @Test
    @DisplayName("GameMember 추가/삭제")
    void test3() {
        // given
        GameMember gameMember1 = new GameMember("honggd", "홍길동");
        GameMember gameMember2 = new GameMember("sinsa", "신사임당");
        GameMember gameMember3 = new GameMember("leess", "이순신");
        Game game = Game.builder()
                .participants(Map.of(
                        "Top", gameMember1,
                        "Jungle", gameMember2,
                        "Support", gameMember3
                ))
                .build();
        this.entityManager.persist(gameMember1);
        this.entityManager.persist(gameMember2);
        this.entityManager.persist(gameMember3);
        this.entityManager.persist(game);
        this.entityManager.flush();
        // when
        System.out.println(game);

        GameMember gameMember4 = new GameMember("wrestler_chan", "김연찬");
        this.entityManager.persist(gameMember4);
        game.addParticipant("Bottom", gameMember4); // 추가/수정
        this.entityManager.flush();
        System.out.println(game);

        game.removeParticipant("Support");
        this.entityManager.flush();
        /*
            update
                tbl_game_member
            set
                game_id=null,
                role_name=null
            where
                game_id=?
                and username=?
         */
        // then
        assertThat(game.getParticipants()).hasSize(3);
    }
}