package Programmers;

import java.util.*;

public class Solution52 {
    public static int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemMap = new HashMap<>();
        int left = 0;
        int minLength = gems.length;

        for (int right = 0; right < gems.length; right++) {
            gemMap.put(gems[right], gemMap.getOrDefault(gems[right], 0) + 1);

            while (gemMap.size() == gemSet.size()) {
                if (right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }

                gemMap.put(gems[left], gemMap.get(gems[left]) - 1);
                if (gemMap.get(gems[left]) == 0) {
                    gemMap.remove(gems[left]);
                }

                left++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer = solution(gems);
    }
}
