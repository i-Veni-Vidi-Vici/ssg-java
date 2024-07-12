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
        /*
            Hibernate:
                create table tbl_team (
                    id bigint not null auto_increment,
                    name varchar(255),
                    primary key (id)
                ) engine=InnoDB
            Hibernate:
                create table tbl_player (
                    id bigint not null auto_increment,
                    team_id bigint,
                    name varchar(255),
                    primary key (id)
                ) engine=InnoDB
            Hibernate:
                alter table tbl_player
                   add constraint FKmge3u7lo7kb3tnb3762ch1b9o
                   foreign key (team_id)
                   references tbl_team (id)
         */
    }

    @Test
    @DisplayName("Team - Set<Player> 등록")
    void test2() {
        // given
        Set<Player> players = Set.of(
                new Player(null, "홍길동"),
                new Player(null, "신사임당")
        );
        Team team = new Team(null, "우당탕탕 야구단", players);
        // when
        players.forEach(this.entityManager::persist);
        this.entityManager.persist(team);
        this.entityManager.flush();
        /*
            Hibernate:
                insert
                into
                    tbl_player
                    (name)
                values
                    (?)
            Hibernate:
                insert
                into
                    tbl_player
                    (name)
                values
                    (?)
            Hibernate:
                insert
                into
                    tbl_team
                    (name)
                values
                    (?)
            Hibernate:
                update
                    tbl_player
                set
                    team_id=?
                where
                    id=?
            Hibernate:
                update
                    tbl_player
                set
                    team_id=?
                where
                    id=?

         */
        // then
        this.entityManager.clear();
        Team team2 = this.entityManager.find(Team.class, team.getId());
        /*
            Hibernate:
                select
                    t1_0.id,
                    t1_0.name
                from
                    tbl_team t1_0
                where
                    t1_0.id=?
            Hibernate:
                select
                    p1_0.team_id,
                    p1_0.id,
                    p1_0.name
                from
                    tbl_player p1_0
                where
                    p1_0.team_id=?
         */
        System.out.println(team2);
        assertThat(team2).isNotNull();
        assertThat(team2.getPlayers()).isEqualTo(players);
    }

    @Test
    @DisplayName("Team내 Player 수정")
    void test3() {
        // given
        Team team = Team.builder().name("으라차차 씨름단").build();
        Player player1 = new Player(null, "이순신");
        Player player2 = new Player(null, "이만기");
        this.entityManager.persist(team);
        this.entityManager.persist(player1);
        this.entityManager.persist(player2);
        this.entityManager.flush();
        // when
        team.addPlayer(player1);
        team.addPlayer(player2);
        this.entityManager.flush();
        /*
            Hibernate:
                update
                    tbl_player
                set
                    team_id=?
                where
                    id=?
            Hibernate:
                update
                    tbl_player
                set
                    team_id=?
                where
                    id=?
         */

        team.removePlayer(player2);
        this.entityManager.flush();
        /*
            Hibernate:
                update
                    tbl_player
                set
                    team_id=null
                where
                    team_id=?
                    and id=?
         */
        // then
        assertThat(team.getPlayers()).containsExactly(player1);
    }

    @Test
    @DisplayName("변경가능한 Set으로 관리하기")
    void test4() {
        // given
        Set<Player> players = Set.of(
                new Player(null, "홍길동"),
                new Player(null, "신사임당")
        );
        Team team = new Team(null, "우당탕탕 야구단", players);
        // when
        // then
        assertThatNoException().isThrownBy(() -> {
            // Team생성자안에서 변경가능한 Set으로 교체해서 더이상 UnsupportedOperationException 예외가 발생하지 않는다.
            team.addPlayer(new Player(null, "논개"));
        });
    }
}