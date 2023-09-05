package Programmers;

import java.util.HashSet;
import java.util.Set;

public class Solution36 {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        for (int number : numbers) {
            if (set.contains(number)) {
                set.remove(number);
            }
        }

        int sum = 0;
        for (int number : set) {
            sum += number;
        }

        return sum;
    }
}
