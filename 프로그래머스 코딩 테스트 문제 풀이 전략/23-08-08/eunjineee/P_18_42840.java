package PGS_BOOK.CH05;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class P_18_42840 {
    // 10,000문제 -> 3명꺼 다 돌아도 3만번 -> 완전 탐색
    static char[] sol1 = {1,2,3,4,5}; //5
    static char[] sol2 = {2,1,2,3,2,4,2,5}; //8
    static char[] sol3 = {3,3,1,1,2,2,4,4,5,5}; // 10


    public static int[] solution(int[] answer){
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;

        for (int i = 0; i < answer.length; i++){
            int s1 = 0;
            int s2 = 0;
            int s3 = 0;

            if (i != 0) {
                s1 = i % 5;
                s2 = i % 8;
                s3 = i % 10;
            }

            if (answer[i] == sol1[s1]) ans1 += 1;
            if (answer[i] == sol2[s2]) ans2 += 1;
            if (answer[i] == sol3[s3]) ans3 += 1;
        }

        int[] total = {ans1, ans2, ans3};
        List<Integer> answer_li = new ArrayList<>();
        int max_num = 0;
        for (int j: total){
            if (j >= max_num){
                max_num = j;
            }
        }

        for (int j =0; j < 3; j++){
            if (total[j] == max_num){
                answer_li.add(j+1);
            }
        }
        return answer_li.stream().mapToInt(i -> i).toArray();
    }


    public static final int[][] RULES = {
        {1,2,3,4,5},
        {2,1,2,3,2,4,2,5},
        {3,3,1,1,2,2,4,4,5,5},
    };

    // 숫자 뽑아오는 거 자체를 함수로 만들어서 사용
    private static int getPicked(int person, int problem){
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }

    public static int[] book_solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;

        for (int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem];

            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, problem);
                if (answer == picked) {
                    // 더하면서 저장하고
                    // for 문 한번에 corrects배열 저장과 max까지 한번에 계산
                    if (++corrects[person] > max) {
                        max = corrects[person];
                    }
                }
            }
        }

        final int maxCorrects = max;
        return IntStream.range(0, 3)
                .filter(i -> corrects[i] == maxCorrects)
                .map(i -> i + 1)
                .toArray();
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
//        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
//        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1})));
//        System.out.println(Arrays.toString(solution(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5})));
        System.out.println(Arrays.toString(book_solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(book_solution(new int[]{1, 3, 2, 4, 2})));
    }

}
