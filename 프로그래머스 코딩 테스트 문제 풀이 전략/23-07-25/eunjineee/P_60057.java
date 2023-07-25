// 예외처리가 복잡해서 머리굴리다가 파이썬으로 먼저 풀고, 코드를 옮겼음
// 코드를 옮기는 과정에서 좀 더 나은 코드를 작성할 수 있었고
// 책 코드와 비교해보며 역할에 따라 나누어 설계하는 연습이 더 필요하다고 느낌
package PGS_BOOK.CH04;

import java.util.ArrayList;
import java.util.List;

public class P_60057 {
    public static int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length(); i++) {
            int num = i * 2;                       // 다음 범위 마지막 숫자
            int total = s.length();              // 원래 s 문자열 길이
            String word = s.substring(0, i);      // 첫번째 비교할 문자열
            int repeat = 0;                      // 반목한 숫자

            while (num <= s.length()) {
                if (word.equals(s.substring(num - i, num))) {
                    repeat += 1;
                } else {
                    word = s.substring(num - i, num);
                    if (repeat != 0) {
                        total -= (repeat * i - Integer.toString(repeat + 1).length());   // 반복한 숫자를 자신까지 합쳐서 10을 넘는 경우 때문에 +1
                        repeat = 0;
                    }
                }
                num += i;
            }
            if (repeat != 0) {
                total -= (repeat * i - Integer.toString(repeat + 1).length());
                repeat = 0;
            }
            if (answer > total) {
                answer = total;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcdede"));
    }


    // 잘라서, arraylist에 넣어서 반환하는 역할
    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex > source.length()) endIndex = source.length();
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }

    // 토큰이라는 표현이 신박했음
    private int compress(String source, int length) {
        StringBuilder builder = new StringBuilder();

        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) builder.append(count);
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) builder.append(count);
        builder.append(last);

        return builder.length();
    }

    public int book_solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length(); length++) {
            int compressed = compress(s, length);
            if (compressed < min) {
                min = compressed;
            }
        }
        return min;
    }
}
