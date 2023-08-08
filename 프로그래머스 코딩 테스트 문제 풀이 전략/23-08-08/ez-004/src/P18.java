import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class P18 {
    // 내 풀이 - 리스트 자료형 쓸 때마다 파이썬이랑 달라서 고민
    public int[] solution1(int[] answers) {
        int[] way1 = {1, 2, 3, 4, 5};
        int[] way2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] way3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];
        for (int index = 0; index < answers.length; index++) {
            if (answers[index] == way1[index % way1.length]) scores[0] += 1;
            if (answers[index] == way2[index % way2.length]) scores[1] += 1;
            if (answers[index] == way3[index % way3.length]) scores[2] += 1;
        }

        int max = -1;
        for (int score : scores) {
            if (max < score) max = score;
        }

        List<Integer> answer = new ArrayList<>();
        for (int index = 0; index < 3; index++) {
            if (scores[index] == max) answer.add(index + 1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // 책 답안
    private static final int[][] RULES = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4 ,4, 5, 5}
    };

    private int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }

    public int[] solution2(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;

        for (int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem];
            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, problem);
                if (answer == picked) {
                    if (max < ++corrects[person]) max = corrects[person];
                }
            }
        }

        final int maxCorrects = max;
        return IntStream.range(0, 3)
                .filter(i -> corrects[i] == maxCorrects)
                .map(i -> i + 1)
                .toArray();
    }
}
