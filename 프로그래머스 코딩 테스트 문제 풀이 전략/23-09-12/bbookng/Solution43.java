import java.util.*;

class Solution43 {
        public static Stack<Character> stack;

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (check(s)) {
                answer++;
            }
            s = s.substring(1) + s.charAt(0);
        }

        return answer;
    }

    public static boolean check(String s) {
        stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || !stack.pop().equals('(')) return false;
            } else if (c == '}') {
                if (stack.isEmpty() || !stack.pop().equals('{')) return false;
            } else if (c == ']') {
                if (stack.isEmpty() || !stack.pop().equals('[')) return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }


}