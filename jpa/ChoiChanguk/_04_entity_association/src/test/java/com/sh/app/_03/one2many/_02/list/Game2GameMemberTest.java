package com.sh.app._03.one2many._02.list;


import com.sh.app._03.one2many._01.set.Player;
import com.sh.app._03.one2many._01.set.Team;
import com.sh.app._03.one2many._03.map.Game;
import com.sh.app._03.one2many._03.map.GameMember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

// vote에서 person을 참조한다
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

    }

    @Test
    @DisplayName("ddl-auto=create 확인")
    void test2() {
        GameMember gameMember1=new GameMember("cstangga","최창욱");
        GameMember gameMember2=new GameMember("sinsa","신사임당");
        GameMember gameMember3=new GameMember("lees","이순신");

        Game game= Game.builder()
                .participants(Map.of(
                        "top",gameMember1,
                        "jungle",gameMember2,
                        "support",gameMember3
                )).build();

        this.entityManager.persist(gameMember1);
        this.entityManager.persist(gameMember2);
        this.entityManager.persist(gameMember3);
        this.entityManager.persist(game);
        this.entityManager.flush();
    }


    @Test
    @DisplayName("멤버 삭제해보기")
    void test3() {


        GameMember gameMember1=new GameMember("cstangga","최창욱");
        GameMember gameMember2=new GameMember("sinsa","신사임당");
        GameMember gameMember3=new GameMember("lees","이순신");

        Game game= Game.builder()
                .participants(Map.of(
                        "top",gameMember1,
                        "jungle",gameMember2,
                        "support",gameMember3
                )).build();

        this.entityManager.persist(gameMember1);
        this.entityManager.persist(gameMember2);
        this.entityManager.persist(gameMember3);
        this.entityManager.persist(game);
        this.entityManager.flush();

        System.out.println("game = " + game);

        GameMember gameMember4=new GameMember("wrestling_chan","연찬님");
        this.entityManager.persist(gameMember4);
        game.addParticipant("bottom",gameMember4);

        game.removeParticipant("top");
        this.entityManager.flush();


    }


}

















