package com.sh.app.ocr.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Service
public class OcrService {
    @Value("${naver.clova-ocr.general.url}")
    private String GENERAL_OCR_URL;
    @Value("${naver.clova-ocr.general.secretKey}")
    private String GENERAL_OCR_SECRET_KEY;

    @Value("${naver.clova-ocr.template.url}")
    private String TEMPLATE_OCR_URL;
    @Value("${naver.clova-ocr.template.secretKey}")
    private String TEMPLATE_OCR_SECRET_KEY;

    public String processOcr(String type, String imageFile) {
        boolean isTypeGeneral = type.equals("general");
        final String OCR_URL = isTypeGeneral ? GENERAL_OCR_URL : TEMPLATE_OCR_URL;
        final String SECRET_KEY = isTypeGeneral ? GENERAL_OCR_SECRET_KEY : TEMPLATE_OCR_SECRET_KEY;

        try {
            // java.net.URL : 문자열 경로 정보를 parsing해서 관리하는 객체
            URL url = new URL(OCR_URL);
            // HttpURLConnection 해당 URL에 통신 가능한 Connection 객체
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // 요청 헤더 설정
            con.setUseCaches(false); // 캐싱 방지
            con.setDoInput(true); // 입력스트림 허용
            con.setDoOutput(true); // 출력스트림 허용
            con.setReadTimeout(30000); // 제한시간 30초
            con.setRequestMethod("POST"); // 전송방식
            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
            // NCP 요청 필수 설정
            // X-OCR-SECRET : NCP가 정한 시크릿키 헤더
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-OCR-SECRET", SECRET_KEY);

            // NCP 요청 본문 작성
            /*
                {
                    "version": "string",
                    "requestId": "string",
                    "timestamp": 0,
                    "lang": "string",
                    "images": [{ "format": "string", "url": "string", "data": "string", "name": "string", "templateIds": [ 0 ] }],
                    "enableTableDetection": true
                }
             */
            Map<String, Object> map = new HashMap<>();
            map.put("version", "V2");
            map.put("requestId", UUID.randomUUID().toString());
            map.put("timestamp", System.currentTimeMillis());
            map.put("enableTableDetection", true);

            Map<String, Object> imageMap = new HashMap<>();
            imageMap.put("format", "jpg");
            imageMap.put("name", "demo");
            List<Map<String, Object>> imagesList = new ArrayList<>();
            imagesList.add(imageMap);
            map.put("images", imagesList);

            // Java객체 -> json변환
            // ObjectMapper#writeValueAsString(자바객체):String(json문자열)
            ObjectMapper objectMapper = new ObjectMapper();
            String postParams = objectMapper.writeValueAsString(map);

            // 통신 시작
            con.connect();
            // A.요청
            // 자바자료형 단위로 출력가능한 스트림
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            long start = System.currentTimeMillis();
            File file = null;
            try {
                file = new File(imageFile);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // multipart/form-data 요청 메세지 작성
            writeMultiPart(wr, postParams, file, boundary);
            wr.close();

            // B.응답
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                // con 입력스트림으로부터 응답데이터 읽기
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            // StringBuffer 문자열 이어쓰기 최적화된 객체
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            // 통신 종료
            con.disconnect();
            return response.toString();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }


    }

    private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
            IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append("\r\n");
        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
        sb.append(jsonMessage);
        sb.append("\r\n");

        out.write(sb.toString().getBytes("UTF-8"));
        out.flush();

        if (file != null && file.isFile()) {
            out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
            StringBuilder fileString = new StringBuilder();
            fileString
                    .append("Content-Disposition:form-data; name=\"file\"; filename=");
            fileString.append("\"" + file.getName() + "\"\r\n");
            fileString.append("Content-Type: application/octet-stream\r\n\r\n");
            out.write(fileString.toString().getBytes("UTF-8"));
            out.flush();

            // 파일 이진데이터 쓰기
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, count);
                }
                out.write("\r\n".getBytes());
            }

            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
        }
        out.flush();
    }
}
