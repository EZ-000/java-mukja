import java.util.Set;

public class P21 {
    // 재귀는 상태, 종료조건, 점화식으로 구성
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
        if (isPrime(acc)) p
    }

    public int solution(String numbers) {
        int answer = 0;
        return answer;
    }
}
