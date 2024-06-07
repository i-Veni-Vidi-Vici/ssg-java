package com.sh._04_http_request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * Http Request Message Header
 * - 실제 요청의 설정정보가 담겨있따.
 * - 4가지 헤더 카테고리
 *  1. General Header : 요청 / 응답에 모두 적용되는 내용
 *  2. Request Header : 응답할 리소스나 요청 클라이언트에 대한 상세정보
 *  3. Response Header : 응답 위치 / 서버 자체와 같은 응답관련 정보
 *  4. Entity Header : 본문의 응답리소스에 대한 상세정보 입력 (리소스 크기, 타입
 *  * accept : 요청을 보낼 때 서버에게 요청할 응답 타입 명시
 * accept-encoding : 응답 시 원하는 인코딩 방식
 * accept-language : 웅답 시 원하는 언어
 * connection : HTTP 통신이 완료된 후에 네트워크 접속을 유지할지 결정 (기본값: keep-alive = 연결을 열린 상태로 유지)
 * host : 서버의 도메인 네임과 서버가 현재 Listening 중인 TCP포트 지정 (반드시 하나가 존재. 없거나 둘 이상이면 404)
 * referer : 이 페이지 이전에 대한 주소
 * sec-fetch-dest : 요청 대상
 * sec-fetch-mode : 요청 모드
 * sec-fetch-site : 출처(origin)와 요청된 resource 사이의 관계
 * sec-fetch-user : 사용자가 시작한 요청일 때만 보내짐 (항상 ?1 값 가짐)
 * cache-control : 캐시 설정
 * user-agent : 현재 사용자가 어떤 클라이언트(OS, browser 포함)을 이용해 보낸 요청인지 명시
 */

@WebServlet("/request")
public class HttpRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName + " = " + headerValue);
        }

    }
}
