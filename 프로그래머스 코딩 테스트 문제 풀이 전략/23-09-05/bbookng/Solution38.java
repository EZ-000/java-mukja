package Programmers;

public class Solution38 {
    public static int solution(int n) {
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = ((dp[i-1] + dp[i-2]) % 1234567);
        }
        return (int) (dp[n]);
    }

    public static void main(String[] args) {
        System.out.println(Solution38.solution(10));
    }

}
