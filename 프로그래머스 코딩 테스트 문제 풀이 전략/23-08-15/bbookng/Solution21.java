import java.util.HashSet;
import java.util.Set;

public class Solution21 {
    static boolean[] visited;
    static Set<Integer> map = new HashSet<>();

    public static void dfs(int depth, String numbers, String current) {
        if (depth == numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                String number = current + numbers.charAt(i);

                if (isPrime(Integer.parseInt(number))) {
                    map.add(Integer.parseInt(number));
                }

                dfs(depth + 1, numbers, number);
                visited[i] = false;

            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs(0, numbers, "");
        return map.size();
    }
}