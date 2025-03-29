package com.sh._08_file_upload_to_ftp_server;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileUploadService {
    @Value("${ftp.server.host}")
    private String server;

    @Value("${ftp.server.port}")
    private int port;

    @Value("${ftp.server.username}")
    private String username;

    @Value("${ftp.server.password}")
    private String password;

    public FileDto upload(MultipartFile multipartFile) throws IOException {
        FTPClient ftpClient = new FTPClient();
        try {
            //이진 데이터 받을거에요
            ftpClient.connect(server, port);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            //실제 데이터가 입출력 stream으로 왓다갓다함
            try (InputStream inputStream = multipartFile.getInputStream()) {
                String contentType = multipartFile.getContentType();
                String originalFilename = multipartFile.getOriginalFilename();
                String dir = "test/";
                String renamedFilename = getRenamedFilename(originalFilename);
                //실제 파일 전송
                boolean done = ftpClient.storeFile(dir + renamedFilename, inputStream);
                if (!done)
                    throw new RuntimeException("[" + multipartFile + "] 파일 업로드에 실패했습니다.");

                //Builder 패턴을 사용한 객체 생성
                // 기본 생성자 만들어서 setter로 하던지, 이런 방법도 있다~ 정도로 생각해보기......나중에 해!!!
                return FileDto.builder()
                        .originalFilename(originalFilename)
                        .renamedFilename(renamedFilename)
                        .contentType(contentType)
                        .build();
            }
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String getRenamedFilename(String originalFilename) {
        return "%s_%s".formatted(UUID.randomUUID().toString(), originalFilename);
    }
}
