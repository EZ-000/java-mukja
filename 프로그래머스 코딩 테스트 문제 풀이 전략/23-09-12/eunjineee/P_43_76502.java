package PGS_BOOK.CH11;

import java.util.Stack;

public class P_43_76502 {
    public static boolean ifAnswer(char[] str){
        Stack<Character> stack = new Stack<>();

        for (char c: str){
            switch (c){
                case '[' -> stack.add(']');
                case '{' -> stack.add('}');
                case '(' -> stack.add(')');
                case ']', '}', ')' -> {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != c) return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 하나씩 돌아서 문자열 만드는 함수 생성
    public static char[] CharToBack(char[] chars){
        if (chars.length <= 1) {
            return chars;
        }

        char firstChar = chars[0];

        for (int i = 0; i < chars.length - 1; i++) {
            chars[i] = chars[i + 1];
        }

        chars[chars.length - 1] = firstChar;
        return chars;
    }

    public static int solution(String s) {
        char[] str = s.toCharArray();
        int answer = 0;
        for (int i=0; i < s.length(); i++){
            if (ifAnswer(str)){
                answer += 1;
            }
            str = CharToBack(str);
        }

        return answer;
    }

    private boolean isCorrect(char[] str, int offset) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            char c = str[(offset + i) % str.length];
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')', '}', ']' -> {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != c) return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public int book_solution(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        for (int offset = 0; offset < str.length; offset++) {
            if (isCorrect(str, offset)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }
}
