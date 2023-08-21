import java.util.Arrays;

public class Solution23 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tmp); // 배열 오름차순 정렬
            answer[i] = tmp[commands[i][2] - 1];
        }
        return answer;
    }

    // 책 풀이
    public int[] sol(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            int[] command = commands[i];
            int from = command[0] -1;
            int to = command[1];
            int k = command[2] -1;

            int[] sub = Arrays.copyOfRange(array, from, to);
            Arrays.sort(sub);
            answer[i] = sub[k];
        }
        return answer;
    }
}
