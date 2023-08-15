import java.util.*;

public class Solution22 {

    // 방문 처리
    static boolean[] visited;

    // 정답 담을 Set
    static HashSet<String> set;

    // 조합 생성
    public static void backtracking(int depth, String res, String[] ban_id, String[] user_id) {

        if (depth == ban_id.length) {
            String[] arr = res.split(" ");
            Arrays.sort(arr);

            String str = "";
            for (String s:arr) str += s;
            set.add(str);

            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (visited[i] ||!user_id[i].matches(ban_id[depth])) continue;
            visited[i] = true;
            backtracking(depth+1, user_id[i] + " " + res, ban_id, user_id);
            visited[i] = false;
        }
    }
    public int solution1(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        set = new HashSet<>();

        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace('*', '.');
        }

        backtracking(0, "", banned_id, user_id);
        return set.size();

    }

    /**
     * 테스트 1 〉	통과 (8.98ms, 77.3MB)
     * 테스트 2 〉	통과 (10.46ms, 86.2MB)
     * 테스트 3 〉	통과 (14.48ms, 73.1MB)
     * 테스트 4 〉	통과 (13.90ms, 94.4MB)
     * 테스트 5 〉	통과 (250.81ms, 169MB)
     * 테스트 6 〉	통과 (29.85ms, 84.3MB)
     * 테스트 7 〉	통과 (17.15ms, 68MB)
     * 테스트 8 〉	통과 (13.56ms, 83.9MB)
     * 테스트 9 〉	통과 (12.53ms, 80.5MB)
     * 테스트 10 〉	통과 (11.30ms, 78.5MB)
     * 테스트 11 〉	통과 (10.63ms, 77.2MB)
     */

    // 책 풀이
    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if (index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String id : bans[index]) {
            if (banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }

    public int solution2(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }

    /**
     * 테스트 1 〉	통과 (3.26ms, 72.2MB)
     * 테스트 2 〉	통과 (5.33ms, 84.9MB)
     * 테스트 3 〉	통과 (4.62ms, 74.6MB)
     * 테스트 4 〉	통과 (4.14ms, 73.3MB)
     * 테스트 5 〉	통과 (88.82ms, 118MB)
     * 테스트 6 〉	통과 (9.73ms, 79.4MB)
     * 테스트 7 〉	통과 (3.70ms, 72.6MB)
     * 테스트 8 〉	통과 (3.94ms, 72.6MB)
     * 테스트 9 〉	통과 (3.38ms, 78.9MB)
     * 테스트 10 〉	통과 (3.87ms, 74.5MB)
     * 테스트 11 〉	통과 (3.73ms, 74.8MB)
     */
}
