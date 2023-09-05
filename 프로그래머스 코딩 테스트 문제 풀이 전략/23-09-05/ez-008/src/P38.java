import java.math.BigInteger;
import java.util.Arrays;

public class P38 {
    // 12945. 피보나치 수
    // 내 답안
    public int solution1(int n) {
        BigInteger[] fibonacci = new BigInteger[n + 1];
        fibonacci[0] = BigInteger.ZERO;
        fibonacci[1] = BigInteger.ONE;

        for (int index = 2; index <= n; index++) {
            fibonacci[index] = fibonacci[index - 2].add(fibonacci[index - 1]);
        }

        return fibonacci[n].mod(BigInteger.valueOf(1234567)).intValue();
    }
    /*
    정확성  테스트
    테스트 1 〉	통과 (0.64ms, 71.9MB)
    테스트 2 〉	통과 (0.69ms, 75MB)
    테스트 3 〉	통과 (0.69ms, 74.3MB)
    테스트 4 〉	통과 (0.67ms, 72.6MB)
    테스트 5 〉	통과 (0.85ms, 70.5MB)
    테스트 6 〉	통과 (0.76ms, 73.7MB)
    테스트 7 〉	통과 (1.75ms, 67.4MB)
    테스트 8 〉	통과 (2.02ms, 82.2MB)
    테스트 9 〉	통과 (1.00ms, 77.4MB)
    테스트 10 〉	통과 (1.82ms, 75.8MB)
    테스트 11 〉	통과 (1.21ms, 72.6MB)
    테스트 12 〉	통과 (1.21ms, 72.7MB)
    테스트 13 〉	통과 (305.48ms, 688MB)
    테스트 14 〉	통과 (285.86ms, 642MB)
    */

    // 다른 사람의 풀이
    public int solution2(int n) {
        int[] fibonacci = new int[n + 1];
        fibonacci[1] = 1;

        for (int index = 2; index <= n; index++) {
            fibonacci[index] = (fibonacci[index - 2] + fibonacci[index - 1]) % 1234567;
        }

        return (int) fibonacci[n];
    }
    /*
    정확성  테스트
    테스트 1 〉	통과 (0.03ms, 72.2MB)
    테스트 2 〉	통과 (0.02ms, 79.7MB)
    테스트 3 〉	통과 (0.02ms, 73.6MB)
    테스트 4 〉	통과 (0.02ms, 77.4MB)
    테스트 5 〉	통과 (0.02ms, 71.2MB)
    테스트 6 〉	통과 (0.03ms, 73.2MB)
    테스트 7 〉	통과 (0.06ms, 76.5MB)
    테스트 8 〉	통과 (0.07ms, 79.2MB)
    테스트 9 〉	통과 (0.04ms, 75.7MB)
    테스트 10 〉	통과 (0.11ms, 87.5MB)
    테스트 11 〉	통과 (0.02ms, 76.9MB)
    테스트 12 〉	통과 (0.06ms, 81MB)
    테스트 13 〉	통과 (2.43ms, 76.3MB)
    테스트 14 〉	통과 (2.49ms, 72.2MB)
    */

    // 책 답안
    private final int[] mem = new int[100001];
    private int fibonacci(int n) {
        if (mem[n] != -1) return mem[n];
        if (n == 0 || n == 1) return n;
        return mem[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
    }

    public int solution3(int n) {
        Arrays.fill(mem, -1);
        for (int i = 0; i <= n; i++) fibonacci(n);
        return fibonacci(n);
    }
    /*
    테스트 1 〉	통과 (1.04ms, 73.1MB)
    테스트 2 〉	통과 (1.07ms, 71MB)
    테스트 3 〉	통과 (1.03ms, 68.4MB)
    테스트 4 〉	통과 (1.67ms, 77.4MB)
    테스트 5 〉	통과 (1.62ms, 77.6MB)
    테스트 6 〉	통과 (0.95ms, 73.9MB)
    테스트 7 〉	통과 (1.39ms, 74.8MB)
    테스트 8 〉	통과 (1.24ms, 69.6MB)
    테스트 9 〉	통과 (1.12ms, 77.2MB)
    테스트 10 〉	통과 (1.34ms, 80.6MB)
    테스트 11 〉	통과 (1.37ms, 75.9MB)
    테스트 12 〉	통과 (1.15ms, 76.7MB)
    테스트 13 〉	통과 (16.55ms, 83.3MB)
    테스트 14 〉	통과 (16.62ms, 89.6MB)
    */
}
