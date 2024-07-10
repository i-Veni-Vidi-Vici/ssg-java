package com.sh.app._03.one2many._01.set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.junit.jupiter.api.*;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class Team2PlayerTest {
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
        /**
         * Hibernate:
         *     create table tbl_player (
         *         id bigint not null auto_increment,
         *         team_id bigint,
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_team (
         *         id bigint not null auto_increment,
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     alter table tbl_player
         *        add constraint FKmge3u7lo7kb3tnb3762ch1b9o
         *        foreign key (team_id)
         *        references tbl_team (id)
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
//        this.entityManager.getTransaction().commit();
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_player
         *         (name)
         *     values
         *         (?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_player
         *         (name)
         *     values
         *         (?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_team
         *         (name)
         *     values
         *         (?)
         * Hibernate:
         *     update
         *         tbl_player
         *     set
         *         team_id=?
         *     where
         *         id=?
         * Hibernate:
         *     update
         *         tbl_player
         *     set
         *         team_id=?
         *     where
         *         id=?
         */
        // then
        this.entityManager.clear();
        Team team2 = this.entityManager.find(Team.class, team.getId());
        /**
         * fetchType.LAZY인 경우
         * Hibernate:
         *     select
         *         t1_0.id,
         *         t1_0.name
         *     from
         *         tbl_team t1_0
         *     where
         *         t1_0.id=?
         * Hibernate:
         *     select
         *         p1_0.team_id,
         *         p1_0.id,
         *         p1_0.name
         *     from
         *         tbl_player p1_0
         *     where
         *         p1_0.team_id=?
         *
         * =======================================================
         *
         * fetchType.EAGER인 경우
         * Hibernate:
         *     select
         *         t1_0.id,
         *         t1_0.name,
         *         p1_0.team_id,
         *         p1_0.id,
         *         p1_0.name
         *     from
         *         tbl_team t1_0
         *     left join
         *         tbl_player p1_0
         *             on t1_0.id=p1_0.team_id
         *     where
         *         t1_0.id=
         */
        System.out.println(team2);
        assertThat(team2).isNotNull();
        assertThat(team2.getPlayers()).isEqualTo(players);
    }

    @Test
    @DisplayName("Team내 Player 수정")
    void test3() {
        // given
        Team team = Team.builder()
                .name("으라차차 씨름단")
                .build();
        Player player1 = new Player(null, "이순신");
        Player player2 = new Player(null, "이만기");

        this.entityManager.persist(team);
        this.entityManager.persist(player1);
        this.entityManager.persist(player2); // 하지만 team이 지정되진 않는다.
        this.entityManager.flush();
        // when
        team.addPlayer(player1);
        team.addPlayer(player2);
        this.entityManager.flush();
        /**
         * Hibernate:
         *     update
         *         tbl_player
         *     set
         *         team_id=?
         *     where
         *         id=?
         * Hibernate:
         *     update
         *         tbl_player
         *     set
         *         team_id=?
         *     where
         *         id=?
         */
        team.removePlayer(player2);
        this.entityManager.flush();
        /**
         * Hibernate:
         *     update
         *         tbl_player
         *     set
         *         team_id=null
         *     where
         *         team_id=?
         *         and id=?
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
            // Team생성자 안에서 변경 가능한 Set으로 교체해서 더이상 UnsupportedOperationException 예외가 발생하지 않는다.
            team.addPlayer(new Player(null, "논개"));
        });
        team.addPlayer(new Player(null, "논개"));
        this.entityManager.persist(team);
        this.entityManager.flush();
    }
}