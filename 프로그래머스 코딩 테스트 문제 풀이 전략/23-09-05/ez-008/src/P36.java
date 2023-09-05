import java.util.HashSet;
import java.util.Set;

public class P36 {
    // 내 풀이
    public int solution1(int[] numbers) {
        boolean[] visited = {false, false, false, false, false, false, false, false, false, false};
        for (int number : numbers) {
            visited[number] = true;
        }

        int answer = 0;
        for (int n = 0; n < 10; n++) {
            if (!visited[n]) answer += n;
        }

        return answer;
    }

    // 책 답안
    public int solution2(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int v : numbers) set.add(v);

        int sum = 0;
        for (int n = 0; n < 10; n++) {
            if (set.contains(n)) continue;
            sum += n;
        }
        return sum;
    }
}
