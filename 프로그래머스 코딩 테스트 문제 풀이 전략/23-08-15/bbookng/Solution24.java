import java.util.HashSet;
import java.util.Set;

public class Solution24 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int number = numbers[i] + numbers[j];
                set.add(number);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
