package com.sh._06_file_upload;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <pre>
 * Resource란??
 * - 스프링에서 다양한 경로의 파일(리소스)에 접근하기 위한 추상인터페이스이다
 * - UrlResource 웹상의 리소스
 * - ClassPathResource 클래스패스상의 리소스
 * - FileSystemResource 서버컴퓨터상의 리소스
 * - Server웹루트디렉토리에서 접근 가능한 리소스...등등이 있다
 * -
 *
 * </pre>
 */
@Controller
@Slf4j
public class FileUploadController {

    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("/singleFile")
    public String singleFile(
            @RequestParam MultipartFile singleFile,
            @RequestParam String singleFileDescription,
            Model model) throws IOException {
        log.debug("{} {} {}",
                singleFile.getName(),
                singleFile.getOriginalFilename(),
                singleFile.getSize());
        log.debug("{}", singleFileDescription);

        // 서버컴퓨터 특정 경로에 이미지를 쓰기 작업 MultipartFile#transferTo(dest)
        // 1. 저장할 경로 가져오기 Resource
        Resource resource = resourceLoader.getResource("classpath:static/upload/single");
        log.debug("resource = {}", resource);
        String dir = resource.getFile().getAbsolutePath();
        log.debug("dir = {}", dir);
        // 2. 저장할 이름 새로 부여 (인코딩이슈, 보안이슈를 대비한 것)
        String originalFilename = singleFile.getOriginalFilename(); // abc.png
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".")); // .png
        String savedName = UUID.randomUUID() + ext; // abds-1234-2352-63er.png
        // 3. 저장
        singleFile.transferTo(new File(dir, savedName)); // 실제 서버컴퓨터에 저장

        // 결과 피드백
        model.addAttribute("message", "파일 업로드 성공👍");
        model.addAttribute("img", "upload/single/" + savedName); // 클라이언트 호출할 경로

        return "result";
    }

    @PostMapping("/multiFile")
    public String multiFile(
            @RequestParam("multiFile") List<MultipartFile> multiFiles
            , @RequestParam String multiFileDescription
            ,   Model model) throws IOException {
        log.debug("{} {}",
                multiFiles.size(),
                multiFiles);
        log.debug("{}", multiFileDescription);

        // 서버컴퓨터 특정 경로에 이미지를 쓰기 작업 MultipartFile#transferTo(dest)
        // 1. 저장할 경로 가져오기 Resource
        Resource resource = resourceLoader.getResource("classpath:static/upload/multi");
        log.debug("resource = {}", resource);

        String dir = resource.getFile().getAbsolutePath();
        log.debug("dir = {}", dir);

        List<FileDto> fileDtos = new ArrayList<>();

        for(MultipartFile multipartFile : multiFiles) {

            // 2. 저장할 이름 새로 부여 (인코딩이슈, 보안이슈를 대비한 것)
            String originalFilename = multipartFile.getOriginalFilename(); // abc.png
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".")); // .png
            String savedName = UUID.randomUUID() + ext; // abds-1234-2352-63er.png

            // 3. 저장
            multipartFile.transferTo(new File(dir, savedName)); // 실제 서버컴퓨터에 저장

            // 4. 뷰단에 전달할 데이터 작성
            fileDtos.add(new FileDto(null, originalFilename, savedName, multiFileDescription));
        }

        // 결과 피드백
        model.addAttribute("message", "파일 업로드 성공👍");
        model.addAttribute("imgs", fileDtos);

        return "result";
    }
}