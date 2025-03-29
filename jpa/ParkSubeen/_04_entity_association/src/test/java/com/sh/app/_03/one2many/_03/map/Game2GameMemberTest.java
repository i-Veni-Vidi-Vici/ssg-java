package com.sh.app._03.one2many._03.map;

import com.sh.app._03.one2many._02.list.Inquiry;
import com.sh.app._03.one2many._02.list.Survey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Game2GameMemberTest {
    // application-scope: 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory;
    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa설정정보를 읽어서 EntityManagerFactory를 생성
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    void setUp() {
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();

    }

    @AfterEach
    void tearDown() {
        this.entityManager.getTransaction().commit();
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
            create table tbl_game (
                gameDate datetime(6),
                id bigint not null auto_increment,
                primary key (id)
            ) engine=InnoDB

            create table tbl_game_member (
                game_id bigint,
                name varchar(255),
                role_name varchar(255),
                username varchar(255) not null,
                primary key (username)
            ) engine=InnoDB

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
                        "TOP", gameMember1,
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
        /* LAZY */
        /*
            select
                g1_0.id,
                g1_0.game_date
            from
                tbl_game g1_0
            where
                g1_0.id=?

            select
                p1_0.game_id,
                p1_0.role_name,
                p1_0.username,
                p1_0.name
            from
                tbl_game_member p1_0
            where
                p1_0.game_id=?
         */
        /* EAGER */
        /*
            select
                g1_0.id,
                g1_0.game_date,
                p1_0.game_id,
                p1_0.role_name,
                p1_0.username,
                p1_0.name
            from
                tbl_game g1_0
            left join
                tbl_game_member p1_0
                    on g1_0.id=p1_0.game_id
            where
                g1_0.id=?
         */
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
                        "TOP", gameMember1,
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
        GameMember gameMember4 = new GameMember("wrestler_park", "박재영");
        this.entityManager.persist(gameMember4);
        game.addParticipant("Bottom", gameMember4); // 추가/수정
        this.entityManager.flush();

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
