package com.sh._08_file_upload_to_ftp_server;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileDto {
    private long id;
    private String contentType;
    private String originalFilename;    // 실제 업로드한 파일 이름
    private String renamedFilename;     // unique 한 파일 이름을 만들기 위한 속성
}