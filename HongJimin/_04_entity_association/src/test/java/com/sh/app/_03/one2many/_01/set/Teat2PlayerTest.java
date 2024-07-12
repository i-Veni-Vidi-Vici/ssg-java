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


public class Teat2PlayerTest {
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
        /**
         * Hibernate:
         *     create table tbl_team (
         *         🙉id bigint not null auto_increment,
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         *
         * Hibernate:
         *     create table tbl_player (
         *         id bigint not null auto_increment,
         *         🙉team_id bigint, 얘가 team을 참조하는 것!
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         *
         *
         * Hibernate:
         *     alter table tbl_player
         *        add constraint FKmge3u7lo7kb3tnb3762ch1b9o
         *        foreign key (team_id)
         *        🙉 references tbl_team (id)
         */
    }

    @Test
    @DisplayName("Team - Set<Player> 등록")
    void test2() {
        // given
        Set<Player> players = Set.of(
                new Player(null, "홍길동"),
                new Player(null, "신삼당")
        );
        Team team = new Team(null, "⚾최강 두산⚾", players);
        // when
        players.forEach(this.entityManager::persist);
        this.entityManager.persist(team); // flush 안해도 됨, id를 가져와야하기 때문에 바로 db에 질의를 해벌윔
        this.entityManager.flush(); // 영속성 컨텍스트에 포함시키기 위함
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
         * Hibernate:
         *     insert
         *     into
         *         tbl_team 🙉team 안에 player Set이 있다는 것
         *         (name)
         *     values
         *         (?)
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
         *         team_id=? 🙉1번 팀으로 업뎃 해줘~
         *     where
         *         id=? 🙉신사임당을 찾아서
         */
        // then
        this.entityManager.clear();
        Team team2 = this.entityManager.find(Team.class, team.getId());
        /**
         * ⚾FetchType.LAZY 일때, 따로따로 select문 날림⚾
         * 🙉 Team 먼저 조회
         * Hibernate:
         *     select
         *         t1_0.id,
         *         t1_0.name
         *     from
         *         tbl_team t1_0
         *     where
         *         t1_0.id=?
         * 🙉 Player 에서 해당 팀의 palyer 조회
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
         * ⚾FetchType.EAGER 일때, 한방에 join쿼리로 select문 날림⚾
         *  Hibernate:
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
         *         t1_0.id=?
         */
        System.out.println(team2);
        assertThat(team2).isNotNull();
        assertThat(team2.getPlayers()).isEqualTo(players);
    }

    @Test
    @DisplayName("Team내 Player 수정")
    void test3() {
        // given
        Team team = Team.builder().name("⚾최강최강 최최강~! 두산⚾").build(); // builder로 build할 때는 모든 필드값이 들어가는데, null값이 있으면 안됨
        Player player1 = new Player(null, "이수신");
        Player player2 = new Player(null, "이만기");
        this.entityManager.persist(team);
        this.entityManager.persist(player1);
        this.entityManager.persist(player2);
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
         * 🙉 Player를 삭제하는게 아니라 fk만 날리면 됨
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
                new Player(null, "신삼당")
        );
        Team team = new Team(null, "⚾최강 두산⚾", players);

        // when
        // then
        assertThatNoException().isThrownBy(() -> {
            // Team 생성자 안에서 변경가능한 Set으로 교체해서 더이상 UnsupportedOperationException 예외가 발생하지 않음
            team.addPlayer(new Player(null, "논개")); // 논개 선수를 추가, 이 문장만 쓰면 UnsupportedOperationException오류가 남! -> Set.of로 만들어진 set을 team의 생성자에 들어가게 되면서 set을 바꿀 수 없어서 오류가 남
        });

    }
}
