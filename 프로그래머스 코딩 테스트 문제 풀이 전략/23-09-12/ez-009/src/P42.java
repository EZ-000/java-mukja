import java.util.Stack;

public class P42 {
    // 12909. 올바른 괄호 - Level 2
    // 내 풀이
    boolean try1(String s) {
        Stack<String> stack = new Stack<>();

        for (String c : s.split("")) {
            if (stack.empty() & c.equals(")")) return false;
            if (c.equals("(")) stack.push(c);
            else if (c.equals(")")) {
                if (stack.pop().equals(")")) return false;
            }
        }
        if (stack.empty()) return true;
        else return false;
    }
    /*
    효율성  테스트
    테스트 1 〉	실패 (시간 초과)
    테스트 2 〉	실패 (시간 초과)
    */

    // String -> Character, split -> toCharArray
    boolean try2(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (stack.empty() & c == ')') return false;
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.pop() == ')') return false;
            }
        }
        return stack.empty();
    }
    /*
    효율성  테스트
    테스트 1 〉	통과 (20.99ms, 53MB)
    테스트 2 〉	실패 (시간 초과)
    */

    // empty -> isEmpty, Character -> char
    boolean solution1(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    /*
    정확성  테스트
    테스트 1 〉	통과 (0.21ms, 72.6MB)
    테스트 2 〉	통과 (0.09ms, 75.5MB)
    테스트 3 〉	통과 (0.15ms, 76.1MB)
    테스트 4 〉	통과 (0.18ms, 77.3MB)
    테스트 5 〉	통과 (0.19ms, 72.7MB)
    테스트 6 〉	통과 (0.16ms, 71.8MB)
    테스트 7 〉	통과 (0.26ms, 77.1MB)
    테스트 8 〉	통과 (0.24ms, 72.2MB)
    테스트 9 〉	통과 (0.21ms, 73.4MB)
    테스트 10 〉	통과 (0.18ms, 73.7MB)
    테스트 11 〉	통과 (0.23ms, 78.2MB)
    테스트 12 〉	통과 (0.33ms, 78.4MB)
    테스트 13 〉	통과 (0.28ms, 78.1MB)
    테스트 14 〉	통과 (0.30ms, 76.8MB)
    테스트 15 〉	통과 (0.26ms, 76MB)
    테스트 16 〉	통과 (0.21ms, 74.6MB)
    테스트 17 〉	통과 (0.24ms, 76.4MB)
    테스트 18 〉	통과 (0.26ms, 84.6MB)
    효율성  테스트
    테스트 1 〉	통과 (17.12ms, 53.8MB)
    테스트 2 〉	통과 (15.77ms, 53.5MB)
    */

    // toCharArray -> charAt
    boolean solution2(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    /*
    정확성  테스트
    테스트 1 〉	통과 (0.22ms, 76MB)
    테스트 2 〉	통과 (0.11ms, 75.6MB)
    테스트 3 〉	통과 (0.11ms, 79.5MB)
    테스트 4 〉	통과 (0.22ms, 75.1MB)
    테스트 5 〉	통과 (0.24ms, 74.6MB)
    테스트 6 〉	통과 (0.10ms, 74.9MB)
    테스트 7 〉	통과 (0.18ms, 72.5MB)
    테스트 8 〉	통과 (0.19ms, 74.6MB)
    테스트 9 〉	통과 (0.19ms, 76.8MB)
    테스트 10 〉	통과 (0.25ms, 72.9MB)
    테스트 11 〉	통과 (0.26ms, 77.1MB)
    테스트 12 〉	통과 (0.22ms, 77.8MB)
    테스트 13 〉	통과 (0.24ms, 82.9MB)
    테스트 14 〉	통과 (0.21ms, 71.6MB)
    테스트 15 〉	통과 (0.23ms, 73.1MB)
    테스트 16 〉	통과 (0.24ms, 75MB)
    테스트 17 〉	통과 (0.23ms, 76.7MB)
    테스트 18 〉	통과 (0.23ms, 77.5MB)
    효율성  테스트
    테스트 1 〉	통과 (31.10ms, 54MB)
    테스트 2 〉	통과 (17.95ms, 52.9MB)
    */

    // 책 답안
    boolean solution3(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(c);
                case ')' -> {
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
