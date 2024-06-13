package com.sh.logback;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logging Framework
 * - System.out.println() 자바 기본 출력문을 사용할때 문제를 해결하고 더 나은 사용성을 제공하는 기록용 프레임워크
 * - Log4j, Logback, java.util.logging, commons-logging 등
 * - sout 으로 작성한 코드는 선택원이 무조건 출력되면서 서능 저하
 * - Logging Framework 들은 기본적으로 Logging level 을 지정해서 개발/운영모드를 세밀하게 제어할 수 있다.
 */
@Slf4j
public class App {
    // Logback 타입을 제어
//    private static ch.qos.logback.classic.Logger log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(App.class);
    // 추상화 레이어인 slf4j 를 통해서 제어
//    private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        // 작성할 로그의 경중을 따져서 적절한 메소드를 호출
        log.error("error"); // 오류/예외 발생시 출력
        log.warn("warn"); // 현재 문제는 없지만, 향후 문제가 될 부분에 작성 (deprecated)
        log.info("info"); // 단순한 정보성 메세지 (운영)
        log.debug("debug"); // 개발시 필요한 로그 작성
        log.trace("trace"); // 개발시에 흐름 추적용 작성(debug 보다 세밀한 내용)

        new App().foo(100);
    }

    public void foo(int n) {
        log.trace("foo started...");
        log.info("어떤 사용자가 어떤 서비스를 요청했습니다.");
        log.warn("foo 는 곧 삭제예정입니다. foo2를 사용해주세요.");
        try {
            log.debug("n={}", n);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        log.trace("foo ended...");
    }
}
