package Programmers;

import java.util.Arrays;

public class Solution35 {
    public static int solution(String before, String after) {
        char[] beforeCharArray = before.toCharArray();
        char[] afterCharArray = after.toCharArray();
        Arrays.sort(beforeCharArray);
        Arrays.sort(afterCharArray);

        return Arrays.equals(beforeCharArray, afterCharArray) ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution35.solution("olleh", "hello");
    }
}
