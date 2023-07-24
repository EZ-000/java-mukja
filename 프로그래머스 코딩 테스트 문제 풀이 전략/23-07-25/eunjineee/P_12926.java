package PGS_BOOK.CH04;

public class P_12926 {
    private static char push(char c, int n) {
        // 공백인 경우
        if (!Character.isAlphabetic(c)) return c;
        // 대문자인지 소문자인지 확인
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        // 대소문자에 상관없이 계산 후
        int position = c - offset;
        // ('Z' - 'A' + 1) == 26로 나눈 나머지만 더해주기
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position); // 숫자끼리 더하고 냅다 (char) 붙이면 문자로 바뀜 > 오히려 쉬워 조아~
    }

    public static String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();   //StringBuilder의 사용법 잘 알아두기!
        for (char c : s.toCharArray()) {
            builder.append(push(c, n));
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("AB",1));
    }
}
