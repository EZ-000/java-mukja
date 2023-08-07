public class P13 {
    // 내 풀이 - 부정 조건 때문에 가독성이 떨어짐
    public boolean solution1(String s) {
        boolean answer = true;
        if (!(s.length() == 4 || s.length() == 6) || !s.matches("[0-9]+")) answer = false;
        return answer;
    }

    // 책 답안
    public boolean solution2(String s) {
        return s.matches("[0-9]{4}|[0-9]{6}");
    }

    public boolean solution3(String s) {
        if (s.length() != 4 && s.length() != 6) return false;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        return true;
    }

    // 다른 사람의 풀이
    public boolean solution4(String s) {
        if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
        return false;
    }
}
