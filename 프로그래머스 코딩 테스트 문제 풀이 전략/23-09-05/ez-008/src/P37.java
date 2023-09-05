import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P37 {
    // 내 풀이
    public String solution1(String[] participant, String[] completion) {
        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (String person : participant) {
            if (counts.containsKey(person)) counts.put(person, counts.get(person) + 1);
            else counts.put(person, 0);
        }

        for (String person : completion) {
            counts.put(person, counts.get(person) - 1);
        }

        String answer = "";
        for (String key : counts.keySet()) {
            if (counts.get(key) == 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
    /*
    정확성  테스트
    테스트 1 〉	통과 (0.07ms, 65.1MB)
    테스트 2 〉	통과 (0.10ms, 73MB)
    테스트 3 〉	통과 (0.57ms, 75.1MB)
    테스트 4 〉	통과 (0.91ms, 74.5MB)
    테스트 5 〉	통과 (0.86ms, 76.2MB)
    테스트 6 〉	통과 (0.03ms, 74.8MB)
    테스트 7 〉	통과 (0.03ms, 74.3MB)

    효율성  테스트
    테스트 1 〉	통과 (35.41ms, 83.4MB)
    테스트 2 〉	통과 (68.55ms, 87.9MB)
    테스트 3 〉	통과 (85.71ms, 94.8MB)
    테스트 4 〉	통과 (90.61ms, 95.8MB)
    테스트 5 〉	통과 (62.60ms, 95.4MB)
    */

    public String solution2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        String answer = "";
        for (int index = 0; index < completion.length; index++) {
            if (!participant[index].equals(completion[index])) {
                answer = participant[index + 1];
                break;
            }
        }
        if (answer.equals("")) answer = participant[participant.length - 1];

        return answer;
    }
    /*
    정확성  테스트
    테스트 1 〉	통과 (0.28ms, 80MB)
    테스트 2 〉	통과 (0.27ms, 73.7MB)
    테스트 3 〉	통과 (1.92ms, 77MB)
    테스트 4 〉	통과 (3.84ms, 84.1MB)
    테스트 5 〉	통과 (4.53ms, 86.8MB)
    테스트 6 〉	통과 (0.26ms, 73.8MB)
    테스트 7 〉	통과 (0.18ms, 67.1MB)

    효율성  테스트
    테스트 1 〉	통과 (106.36ms, 81.5MB)
    테스트 2 〉	통과 (204.26ms, 88.1MB)
    테스트 3 〉	통과 (255.73ms, 93.6MB)
    테스트 4 〉	통과 (305.09ms, 96.7MB)
    테스트 5 〉	통과 (300.41ms, 96.7MB)
    */

    // 책 답안
    public String solution3(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();

        for (String name : participant) {
            count.putIfAbsent(name, 0);
            count.put(name, count.get(name) + 1);
        }

        for (String name : completion) {
            int v = count.get(name) - 1;
            count.put(name, v);
            if (v == 0) count.remove(name);
        }

        return count.keySet().iterator().next();
    }
    /*
    정확성  테스트
    테스트 1 〉	통과 (0.08ms, 70.7MB)
    테스트 2 〉	통과 (0.11ms, 71.9MB)
    테스트 3 〉	통과 (0.62ms, 74.7MB)
    테스트 4 〉	통과 (1.26ms, 74.8MB)
    테스트 5 〉	통과 (0.99ms, 76MB)
    테스트 6 〉	통과 (0.04ms, 73.8MB)
    테스트 7 〉	통과 (0.05ms, 76.9MB)
    효율성  테스트
    테스트 1 〉	통과 (48.32ms, 81.3MB)
    테스트 2 〉	통과 (68.77ms, 88.9MB)
    테스트 3 〉	통과 (70.25ms, 110MB)
    테스트 4 〉	통과 (97.91ms, 96.5MB)
    테스트 5 〉	통과 (82.11ms, 95.4MB)
    */
}
