package com.sh._05_handler_interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

/**
 * LogInterceptor	/app/images/spring-mvc-flow.png GET로 요청이 시작되었습니다...
 * LogInterceptor	핸들러 요청을 완료했습니다...ModelAndView = null
 * LogInterceptor	응답메세지를 발송합니다...
 *
 * LogInterceptor	/app/test GET로 요청이 시작되었습니다...
 * LogInterceptor	GET /test 핸들러 호출되었다!
 * LogInterceptor	핸들러 요청을 완료했습니다...ModelAndView = ModelAndView [view="test"; model={message=🥞🥞🥞}]
 * LogInterceptor	응답메세지를 발송합니다...
 *
 * LogInterceptor	/app/test/interval GET로 요청이 시작되었습니다...
 * StopwatchInterceptor	시작시간을 체크합니다..
 * TestController	GET /test/interval 핸들러 호출되었다!
 * StopwatchInterceptor	종료시각을 체크합니다...
 * StopwatchInterceptor	소요시간은 : 2013 ms:
 * LogInterceptor	핸들러 요청을 완료했습니다...ModelAndView = ModelAndView [view="test"; model={message=🍟🍟🍟, interval=2013}]
 * LogInterceptor	응답메세지를 발송합니다...
 */