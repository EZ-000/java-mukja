// 시저 암호
public class Solution6 {
    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            // c를 n만큼 민 문자를 builder에 이어 붙이기
            builder.append(push(c, n));
        }
        System.out.println(builder);
        return builder.toString();
    }

    private char push(char c, int n) {
        if (!Character.isAlphabetic(c)) return c;
        // c를 n만큼 밀어 반환

        // 대문자이면 offset이 'A' 의 아스키코드인 65, 소문자이면 'a' 의 아스키코드인 97
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;

        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }
}
