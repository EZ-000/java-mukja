import java.util.Arrays;

public class P27 {
    // 내 풀이
    public String[] solution1(String[] strings, int n) {
        Arrays.sort(strings);
        Arrays.sort(strings, (v1, v2) -> v1.charAt(n) - v2.charAt(n));
        return strings;
    }
    /*
    테스트 1 〉	통과 (1.32ms, 77.5MB)
    테스트 2 〉	통과 (1.17ms, 75.8MB)
    테스트 3 〉	통과 (1.69ms, 90.7MB)
    테스트 4 〉	통과 (1.56ms, 79.1MB)
    테스트 5 〉	통과 (7.80ms, 80.2MB)
    테스트 6 〉	통과 (1.37ms, 70.7MB)
    테스트 7 〉	통과 (1.86ms, 74MB)
    테스트 8 〉	통과 (1.47ms, 73.5MB)
    테스트 9 〉	통과 (1.18ms, 80.4MB)
    테스트 10 〉	통과 (1.39ms, 74.4MB)
    테스트 11 〉	통과 (1.27ms, 78.2MB)
    테스트 12 〉	통과 (1.10ms, 84MB)
    */

    // 책 답안
    public String[] solution2(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) != s2.charAt(n)) return s1.charAt(n) - s2.charAt(n);
            return s1.compareTo(s2);
        });
        return strings;
    }
    /*
    테스트 1 〉	통과 (1.04ms, 77.1MB)
    테스트 2 〉	통과 (1.27ms, 70MB)
    테스트 3 〉	통과 (1.14ms, 84.1MB)
    테스트 4 〉	통과 (1.22ms, 78.1MB)
    테스트 5 〉	통과 (1.14ms, 75.4MB)
    테스트 6 〉	통과 (1.11ms, 77.7MB)
    테스트 7 〉	통과 (1.20ms, 67.7MB)
    테스트 8 〉	통과 (0.88ms, 73.6MB)
    테스트 9 〉	통과 (1.44ms, 75.9MB)
    테스트 10 〉	통과 (1.07ms, 79.6MB)
    테스트 11 〉	통과 (1.04ms, 77.7MB)
    테스트 12 〉	통과 (0.96ms, 75.6MB)
    */
}
