package com.sh.logback;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logging Framework
 * - System.out.println() 자바 기본 출력문을 사용할 때 문제를 해결하고 더나은 사용성을 제공하는 기록용 프레임워크가 있다.
 * - 대표적으로 Log4j, Logback, java.util.logging, commons-logging 등이 있다.
 * - System.out.println()으로 작성한 코드는 선택권 없이 무조건 출력되면서 성능이 저하된다.
 * - Logging Framework들은 기본적으로 Logging Level를 지정해서 개발/운영모드를 세밀하게 제어할 수 있다.
 * - 출력타겟을 콘솔, 파일 등을 다양하게 선택할 수 있다.
 */

@Slf4j // 이것만 작성하면 바로 출력할 수 있다.
public class App {
    // 출력전에 반드시 작성해야 하는 것_작성하지 않으면 출력되지 않음
    // Logback 타입을 제어할 수 있다.
//    private static ch.qos.logback.classic.Logger log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(App.class); // 선언
    // 추상화 레이어인 Slf4j를 통해서 제어 (PSA)
//    private static org.slf4j.Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        // 작성할 로그의 경중을 따져서 적절한 메소드를 호출
        log.error("error"); // 오류/예외 발생시 출력
        log.warn("warn"); // 현재 문제는 없지만, 향후 문제가 될 부분에 대해서 작성 (deprecated_지금은 돌아가는데 다음에는 삭제될 예정이야)
        log.info("info"); // 단순 정보성 메시지 (보통 운영에서 사용)
        log.debug("debug"); // 개발시에 필요한 로그작성
        log.trace("trace"); // 개발시에 흐름 추적용 작성(debug보다 세밀한 내용)
        /*
            logback.xml을 참고하기. root레벨이 debug로 되어 있어서 debug까지 출력된 것이다.
            만약 root레벨이 trace라면 trace까지 출력된다.
            11:24:28.408 [main] ERROR com.sh.logback.App -- error
            11:24:28.410 [main] WARN  com.sh.logback.App -- warn
            11:24:28.410 [main] INFO  com.sh.logback.App -- info
            11:24:28.410 [main] DEBUG com.sh.logback.App -- debug
         */

        new App().foo(100);
    }

    public void foo(int n) {
        log.trace("foo started");
        log.info("어떤 사용자가 어떤 서비스를 요청했습니다."); // 정보성 메소드
        log.warn("foo는 곧 삭제예정입니다. foo2를 사용해주세요.");

        try {
            log.debug("n = {}", n);

        } catch (Exception e) {
            log.error(e.getMessage());
        }

        log.trace("foo ended");
    }
}
