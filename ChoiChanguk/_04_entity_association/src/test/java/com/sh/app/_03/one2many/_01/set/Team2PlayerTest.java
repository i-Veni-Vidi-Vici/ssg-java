package com.sh.app._03.one2many._01.set;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

// vote에서 person을 참조한다
public class Team2PlayerTest {
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
    @DisplayName("Team - Set<Player> 등록")
    void tes2() {
        Set<Player> players = Set.of(
                new Player(null,"박지성"),
                new Player(null,"손흥민")
        );

        Team team=new Team(null,"조기축구하러 왔음",players);

        players.forEach(this.entityManager::persist);
        this.entityManager.persist(team);
        this.entityManager.flush();

        // 지금 flush 안써도 됨 일단 넣어서 long id 값을 가져와야 하기 때문에

        this.entityManager.clear();
        Team team2=this.entityManager.find(Team.class,team.getId());
        assertThat(team2).isNotNull();


    }

    @Test
    @DisplayName("Team내 Player 수정")
    void test3() {
        Team team=Team.builder()
                .name("으라차차 씨름단").build();
        Set<Player> players = Set.of(
                new Player(null,"강호동"),
                new Player(null,"이만기")
        );


        this.entityManager.flush();
        players.forEach(this.entityManager::persist);
        this.entityManager.persist(team);

    }

}

















