//package com.sh._03.element.collection._01.set._02.embeddable;
//
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import org.junit.jupiter.api.*;
//
//import java.util.Set;
//
//public class RoleEntityTest {
//    private static EntityManagerFactory entityManagerFactory;
//    private EntityManager entityManager;
//
//    @BeforeAll
//    static void beforeAll() {
//        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
//    }
//
//    @BeforeEach
//    void setUp() {
//        this.entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @AfterEach
//    void tearDown() {
//        this.entityManager.close();
//    }
//
//    @AfterAll
//    static void afterAll() {
//        entityManagerFactory.close();
//    }
//
//    @Test
//    @DisplayName("ddl-auto=create 확인")
//    void test() {
//        /*
//
//         */
//    }
//
//    @Test
//    @DisplayName("Role Entity 등록")
//    void test2() {
//        //given
//        Role role = Role.builder()
//                .id("ROLE_MANAGER")
//                .permessions(Set.of("/manager/members", "/manager/stat/*"))
//                .name("매니져")
//                .build();
//
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        try{
//            entityManager.persist(role);
//            transaction.commit();
//        }catch (Exception e)
//        {
//            transaction.rollback();
//            e.printStackTrace();
//        }
//        entityManager.detach(role);
//
//        Role role2=entityManager.find(Role.class, role.getId());
//        System.out.println("role2 = " + role2);
//    }
//    @Test
//    @DisplayName("Role Entity 수정")
//    void test4() {
////        permission은 일부 수정이 아닌 Set객체 전체를 교체한다
//    }
//
//
//
//
//
//}
