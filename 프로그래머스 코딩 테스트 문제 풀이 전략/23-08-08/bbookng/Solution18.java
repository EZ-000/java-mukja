import java.util.*;
import java.util.stream.IntStream;

public class Solution18 {

    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] arr = {0, 0, 0};
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i%5]) arr[0] ++;
            if (answers[i] == second[i%8]) arr[1] ++;
            if (answers[i] == third[i%10]) arr[2] ++;

        }

        int maxValue = Arrays.stream(arr).max().getAsInt();

        // for 문
        for (int i = 0; i < 3; i++) {
            if (maxValue == arr[i]) {
                answer.add(i+1);
            }
        }

        // stream 문
//        IntStream.range(0, 3)
//                .filter(i -> maxValue == arr[i])
//                .forEach(i -> answer.add(i + 1));


        return answer.stream().mapToInt(i->i).toArray();


    }
}
