package PGS_BOOK.CH10;

// 오류해결시 도움됐던 댓글
//🚨이런 문제가 있어요
//        n이 매우 큰 경우 n번째 피보나치 수는 언어가 표현할 수 있는 자료형의 범위를 넘어가, 오버플로우가 납니다.
//        예를 들어
//        47번째 피보나치 수는 2,971,215,073이고, 이 수는 32비트 정수(ex. int) 범위를 넘어 오버플로우가 발생합니다.
//        100,000번째 피보나치 수는 자릿수가 20,000을 넘어가며, 이는 64비트 정수(ex. long) 범위를 넘어 오버플로우가 발생합니다.
//        💡그럼 코드를 어떻게 바꾸면 좋나요?
//        모든 단계에서 % 연산을 사용하여, 모든 연산에서 오버플로우가 일어나지 않게 만들어 주세요.


import java.util.Arrays;

public class P_38_12945 {
    public static int solution(int n) {
        long[] num = new long[n+2];
        num[0] = 0;
        num[1] = 1;

        for (int i = 0; i < n; i++){
            //num[i+1] += num[i]; 에서 오버플로우
           num[i+1] = (num[i+1] + num[i]) % 1234567;
           if (i+2 < num.length) num[i+2] += num[i];
        }

        int ans = (int) (num[n] % 1234567);
        return ans;
    }

    private static final int[] mem = new int[100001];
    private static int fibonacci(int n) {
        if (mem[n] != -1) return mem[n];
        if (n == 0 || n == 1) return n;
        return mem[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
    }

    public static int book_solution(int n) {
        Arrays.fill(mem, -1);
        for (int i = 0; i <= n; i++) {
            fibonacci(n);
        }
        return fibonacci(n);
    }

    public static void main(String[] args) {
        System.out.println(book_solution(3));
        System.out.println(book_solution(5));
    }
}
