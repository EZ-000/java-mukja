package PGS_BOOK.CH11;

import java.util.Stack;

public class P_42_12909 {

    public static boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (c == '('){
                stack.add(0);
            }else{
                if (stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }


    // 스택 단윈인데,, 스택을 쓰지 않아도 된다고 알려주심ㅎㅋㅋㅋㅋ
    public static boolean book_solution(String s) {
        int cnt = 0;

        for (char c : s.toCharArray()){
            switch (c){
                case '(' -> cnt++;
                case ')' -> {
                    if (cnt-- == 0) return false;
                }
            }
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
//        System.out.println(solution("()()"));
//        System.out.println(solution("(())()"));
//        System.out.println(solution(")()("));
//        System.out.println(solution("(()("));

        System.out.println(book_solution("()()"));
        System.out.println(book_solution("(())()"));
        System.out.println(book_solution(")()("));
        System.out.println(book_solution("(()("));
    }
}
