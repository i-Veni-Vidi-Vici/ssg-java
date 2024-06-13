package com.sh.logback;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.w3c.dom.ls.LSOutput;

/**
 * Logging Framework
 * - System.out.println(); 자바 기본 출력문을 사용할 때 문제를 해결하고 더 나은 사용성 제공하는 기록용 프레임워크
 * - Log4j, LogBack, java.util.logging, commons-logging등
 * - sysout으로 작성한 코드는 선택권이 무조건 출력되면서 성능 저하.
 * - Logging Framework 들은 기본적으로 Logging Level을 지정해서 개발/운여모드를 세밀하게 제어할 수 있다.
 * - 출력타겟을 콘솔, 파일등을 다양하게 선택가능
 *
 */


@Slf4j // private static org.slf4j.Logger log=LoggerFactory.getLogger(App.class)
public class App {
    // Logback 타입으로 제어 가능
//    private static Logger log= (Logger) LoggerFactory.getLogger(App.class);
//    private static ch.qos.logback.classic.Logger log= (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(App.class);

    // 추상화 레이어인 Slf4j를 통해서 제어하고 있다
    // 추상화 레이어를 쓰는 이유
    // Logging 직접객체를 직접써버리면,그 객체의 직접적인 코드가 출력되고,  다른 레벨에 있는 객체를 바꿔서 쓰면 실행이 안될 수 있다
    // 추상화를 쓰면, 직접적인 코드는 안나오고, 다른 레벨의 있는 객체를 써도 실행이 가능하다 = 추상화된 객체이기 때문이다
    // 이러한 방식을 Portable Service Abstraction 라고 한다
//    private static org.slf4j.Logger log=LoggerFactory.getLogger(App.class); // 이걸 클래스마다 해야 했지만, lombok이 있다


    public static void main(String[] args) {

        // 출력 레벨은 error > wran > info > debug > trace
        // 출력 레벨 조절은 xml에서 한다
        // 작성할 로그의 경중을 따져서 적절한 메소드를 호출
        log.error("error"); // 오류/예외 발생시 출력
        log.warn("warn"); // 현제 문제는 없지만, 향후 문제가 될 부분에 작성 (deprecated, 이번에는 돌아가는데 다음번에는 삭제될 예정이야)
        log.info("info"); // 단순 정보성 메세지 (운영모드에서 많이들 사용)
        log.debug("debug"); // 개발시 필요한 로그 작성
        log.trace("trace"); // 개발시에 흐름 추적용 작성 (debug보다 좀 더 세밀한 내용)
        System.out.println("---------------------------------------");
        App app=new App();
        app.foo(100);

    }

    public void foo(int n) {
        log.trace("foo started...");
        log.info("어떤 사용자가 어떤 서비스를 요청했습니다");
        log.warn("foo는 곧 삭제예정입니다, foo2를 사용해주세요");

        try {
            log.debug("n = {}",n); // 11:36:50.984 [main] DEBUG com.sh.logback.App -- n = 100
        }catch (Exception e){
            log.error(e.getMessage());
        }

        log.trace("foo ended");
    }
}
