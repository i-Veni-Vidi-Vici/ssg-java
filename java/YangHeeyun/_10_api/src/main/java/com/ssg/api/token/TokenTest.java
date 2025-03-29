package com.ssg.api.token;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - 요구사항
 *     1. `"J a v a P r o g r a m "` 문자열 값을 공백 단위로 Token 처리하여 `char[]` 에 저장하여 출력하시오.
 *     2. 토큰 처리전 글자 및 개수 출력
 *     3. 토큰 처리 후 문자배열 갯수 출력 확인
 *     4. `char[]` 값 출력
 *     5. `char[]` 을 다시 `String` 으로 변환, 모두 대문자로 변환하여 출력
 */
public class TokenTest {
    public static void main(String[] args) {
        String str = "J a v a P r o g r a m ";
        System.out.println(str + " 의 토큰 개수 : " + str.length());

        StringTokenizer tokenizer = new StringTokenizer(str, " "); // 공백으로 스플릿
        System.out.println("토큰 처리 후 문자배열 개수 : " + tokenizer.countTokens());

        char[] tokenCh = new char[tokenizer.countTokens()];
        int i = 0;

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            for (char ch : token.toCharArray())
                tokenCh[i++] = ch;
        }

        System.out.print("char[] : ");
        for (char ch : tokenCh)
            System.out.print(ch + " ");

        System.out.println("\nchar[] String, 대문자로 변환");
        System.out.println(Arrays.toString(tokenCh).toUpperCase());

    }
}





