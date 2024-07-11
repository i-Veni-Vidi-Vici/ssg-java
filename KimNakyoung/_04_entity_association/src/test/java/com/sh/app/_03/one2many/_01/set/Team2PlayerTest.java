package com.sh.app._03.one2many._01.set;


import com.sh.app._02.many2one.Grade;
import com.sh.app._02.many2one.Restaurant;
import com.sh.app._02.many2one.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

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
    @DisplayName("Team -Set<Player> 등록")
    void test2() {
        //given
        Set<Player> players = Set.of(
                new Player(null,"홍길동"),
                new Player(null,"신사임당")
        );
        Team team = new Team(null, "우당탕탕 야구단", players);
        //when
        players.forEach(this.entityManager::persist);
        this.entityManager.persist(team);
        //플러쉬 안해도 됨 id를 db에서 바로 가져와야되서

        //then
        this.entityManager.clear();
        Team team2 = this.entityManager.find(Team.class, team.getId());
        System.out.println(team2);
        assertThat(team2).isNotNull();
        assertThat(team2.getPlayers()).isEqualTo(players);

    }

    @Test
    @DisplayName("Team내 Player 수정")
    void test3() {

        //given
        Team team = Team.builder().name("으랏차차 씨름단").build();
        Set<Player> players = Set.of(
                new Player(null, "이순신"),
                new Player(null, "이만기")
        );
        Player player1 = new Player(null,"이순신");
        Player player2 = new Player(null,"이만기");
        this.entityManager.persist(team);
        this.entityManager.persist(player1);
        this.entityManager.persist(player2);
        this.entityManager.flush();

        //when
        team.removePlayer(player2);
        this.entityManager.clear();


        //then
        assertThat(team.getPlayers()).containsExactly(player1);

    }

    @Test
    @DisplayName("변경가능한 Set으로 관리하기")
    void test4() {
        //given
        Set<Player> players = Set.of(
                new Player(null,"홍길동"),
                new Player(null,"신사임당")
        );
        Team team = new Team(null, "우당탕탕 야구단", players);
        //when
        assertThatNoException().isThrownBy(() -> {
            //Team생성자안에서 변경가능한 Set으로 교체해서 더이상 unsupportedOperationException 나오지 않는다.
            team.addPlayer(new Player(null, "논개"));
        });

    }





}
