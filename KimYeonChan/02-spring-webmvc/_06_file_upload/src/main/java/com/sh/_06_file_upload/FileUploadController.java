package com.sh._06_file_upload;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Resource 란?
 * - 스프링에서 다양한 경로의 파일(리소스)에 접근하기 위한 추상 인터페이스
 * - 웹상의 리소스
 * - 서버 컴퓨터 상의 리소스
 * = Servlet
 */
@Controller
@Slf4j
public class FileUploadController {
    @PostMapping("/singleFile")
    public String singleFile(
            @RequestParam MultipartFile singleFile,
            @RequestParam String singleFileDescription
    ) {
        log.debug("{} {}", singleFile.getOriginalFilename(), singleFile.getSize());
        log.debug("{}", singleFileDescription);

        // 서버 컴퓨터 특정 결오에 이미지를 쓰기 작업(MultipartFile#transferTo(default)

        // 1. 저장할 경로 가져오기

        // 2. 저장할 이름 새로 부여(인코딩 이슈, 보안이슈 대비)
        // 3. 저장
        return "result";
    }
}