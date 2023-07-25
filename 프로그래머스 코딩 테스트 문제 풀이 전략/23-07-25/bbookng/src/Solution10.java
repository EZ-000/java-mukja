// 이진 변환 반복하기
public class Solution10 {
    private int countZeros(String s) {
        int zeros = 0;
        // String s를 문자열 배열로 만들고 순환
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }
        return zeros;
    }

    public int[] solution(String s) {
        int loop = 0;
        int removed = 0;

        // s가 1이 될 때까지 반복하며 loop, removed 누적
        while (!s.equals("1")) {
            // s 변환하며 loop, removed 누적
            int zeros = countZeros(s);
            loop += 1;
            removed += zeros;

            // 문자열 s 변환
            // 1. x의 모든 0을 제거합니다.
            // 2. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }

        return new int[]{loop, removed};
    }
}
