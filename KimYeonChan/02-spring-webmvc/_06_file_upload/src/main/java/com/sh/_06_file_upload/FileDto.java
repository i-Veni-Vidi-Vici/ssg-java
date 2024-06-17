package com.sh._06_file_upload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    private Long id;
    private String originalFileName;
    private String savedFileName;
    private String fileDescription;
}
