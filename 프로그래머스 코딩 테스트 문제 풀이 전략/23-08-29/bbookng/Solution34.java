package Programmers;

import java.util.HashSet;

public class Solution34 {

    // 새로운 문자열을 생성하고 복사하는 과정이 반복됨.
    public static String solution(String my_string) {
        HashSet<Character> set = new HashSet<>();
        String answer = "";

        for (char c : my_string.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                answer += c;
            };
        }
        System.out.println(answer);

        return answer;
    }

    // String Builder 를 쓰면 훨씬 빠르다.
    // 내부 버퍼에 문자를 누적시킴
    public static String solution2(String my_string) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (char c : my_string.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                builder.append(c);
            };
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution34.solution("people");
    }
}
