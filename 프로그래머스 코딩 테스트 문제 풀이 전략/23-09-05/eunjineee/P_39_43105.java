package PGS_BOOK.CH10;

import java.util.Arrays;

public class P_39_43105 {
    // 찾아본 코드
    // dp를 담을 배열을 만들어주고
    // 높이만큼 돌면서 안쪽에서 한번 더 돌기
    // 깔끔깔쌈한 코드
    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            // 맨 왼쪽
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            // 중간
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
            // 맨 오른쪽
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        int answer = 0;

        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }

        return answer;
    }


    private static final int[][] mem = new int[501][501];

    private static int max(int x, int y, int[][] triangle) {
        if (y == triangle.length) return 0;
        if (mem[x][y] != -1) return mem[x][y];

        return mem[x][y] = triangle[y][x] + Math.max(
                max(x, y + 1, triangle),
                max(x + 1, y + 1, triangle));
    }

    public static int book_solution(int[][] triangle) {
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return max(0, 0, triangle);
    }

    public static void main(String[] args) {
        int[][] arr = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(solution(arr));
//        System.out.println(book_solution(arr));
    }
}
