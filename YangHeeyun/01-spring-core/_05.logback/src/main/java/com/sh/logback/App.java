package com.sh.logback;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

/**
 * Logging Franework
 * - System.out.println() 자바 기본 출력문을 사용할때 문제를 해결하고 더나은 사용성 제공하는 기록용 프레임워크
 * - Log4j, java.util.logging, commons-logging등
 * - sysout으로 작성한 코드는 선택권없이 무조건 출력되면서 성능 저하.
 * - Logging Framework들은 기본적으로 Loggint Level을 지정해서 개발/운영모드를 세밀하게 제어할 수 있다.
 * - 출력타겟을 콘솔, 파일등을 다양하게 활용
 */

@Slf4j  // Slf4j레이어를 사용하려면 21,23줄을 반드시 작성해야하는데 @Slf4j lombok을 사용하면 작성하지 않아도 되어 편리하다
public class App {
    // Logback 타입을 제어
    // Logger import까먹을까봐 경로 그대로 작성해둠
//    private static ch.qos.logback.classic.Logger log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(App.class);
//    // 추상화 레이어인 Slf4j를 통해서 제어 (PSA)
//    private static Logger log = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {
        // 작성할 로그의 경중을 따져서 적절한 메소드를 호출
        log.error("error"); // 오류/예외 발생시 출력
        log.warn("warn"); // 현재 문제는 없지만, 향후 문제가 될 부분에 대해 작성(deprecated)
        log.info("info"); // 단순 정보성 메세지(운영)
        log.debug("debug"); // 개발시에 필요한 로그 작성
        log.trace("trace"); // 디버그를 세분화. 개발시에 흐름 추적용 작성(debug보다 세밀한 내용)

        new App().foo(100);
    }

    public void foo(int n){
        log.trace("foo started...");
        log.info("어떤 사용자가 어떤 서비스를 요청했습니다.");
        log.warn("foo는 곧 삭제예정입니다. foo2를 사용해주세요.");

        try{
            // int n이 잘 들어왔는지 확인
            log.debug("n = {}",n);
        }catch(Exception e){
            log.error(e.getMessage());
        }

        log.trace("foo ended...");
    }
}
