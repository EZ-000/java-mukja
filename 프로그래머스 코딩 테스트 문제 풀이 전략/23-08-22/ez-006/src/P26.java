import java.util.Arrays;
import java.util.Comparator;

public class P26 {
    // 내 풀이
    public String solution1(String s) {
        String[] letters = s.split("");
        Arrays.sort(letters, Comparator.reverseOrder());
        return String.join("", letters);
    }
    /*
    테스트 1 〉	통과 (0.95ms, 74.5MB)
    테스트 2 〉	통과 (0.56ms, 66MB)
    테스트 3 〉	통과 (0.59ms, 74.4MB)
    테스트 4 〉	통과 (0.81ms, 81.1MB)
    테스트 5 〉	통과 (2.72ms, 76.7MB)
    테스트 6 〉	통과 (1.76ms, 77.4MB)
    테스트 7 〉	통과 (0.65ms, 71.8MB)
    테스트 8 〉	통과 (1.10ms, 72.8MB)
    테스트 9 〉	통과 (0.99ms, 78MB)
    테스트 10 〉	통과 (1.09ms, 76.4MB)
    테스트 11 〉	통과 (0.68ms, 71.8MB)
    테스트 12 〉	통과 (0.72ms, 72.9MB)
    테스트 13 〉	통과 (1.15ms, 77.9MB)
    테스트 14 〉	통과 (0.41ms, 73.9MB)
    테스트 15 〉	통과 (0.44ms, 71.7MB)
    테스트 16 〉	통과 (0.35ms, 73MB)
    */

    // 책 답안
    public String solution2(String s) {
        return s.chars()
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
    /*
    테스트 1 〉	통과 (3.94ms, 72.4MB)
    테스트 2 〉	통과 (4.89ms, 71.4MB)
    테스트 3 〉	통과 (4.60ms, 76.7MB)
    테스트 4 〉	통과 (3.70ms, 73.6MB)
    테스트 5 〉	통과 (6.93ms, 73.7MB)
    테스트 6 〉	통과 (6.52ms, 79.6MB)
    테스트 7 〉	통과 (3.05ms, 76.4MB)
    테스트 8 〉	통과 (3.95ms, 78.5MB)
    테스트 9 〉	통과 (2.62ms, 77.8MB)
    테스트 10 〉	통과 (3.45ms, 78.9MB)
    테스트 11 〉	통과 (3.49ms, 85MB)
    테스트 12 〉	통과 (3.57ms, 78.7MB)
    테스트 13 〉	통과 (6.00ms, 86.9MB)
    테스트 14 〉	통과 (2.42ms, 77.2MB)
    테스트 15 〉	통과 (3.69ms, 77.8MB)
    테스트 16 〉	통과 (2.84ms, 76.5MB)
     */

}
