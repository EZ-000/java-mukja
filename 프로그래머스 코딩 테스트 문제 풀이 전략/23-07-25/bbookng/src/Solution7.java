// 이상한 문자 만들기
public class Solution7 {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;

        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                builder.append(c);
                toUpper = true;
            } else {
                if (toUpper) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        return builder.toString();
    }
}
