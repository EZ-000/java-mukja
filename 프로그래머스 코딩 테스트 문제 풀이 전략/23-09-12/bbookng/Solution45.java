import java.util.*;

class Solution45 {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<Integer>();

        int day = 1;
        int cnt = 0;
        int index = 0;

        while (index < progresses.length) {
            if (progresses[index] + (speeds[index] * day) >= 100) {
                index ++;
                cnt ++;
            } else {
                day += 1;
                if (cnt > 0) {
                    answer.add(cnt);
                    cnt = 0;
                }
            }
        }

        answer.add(cnt);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}