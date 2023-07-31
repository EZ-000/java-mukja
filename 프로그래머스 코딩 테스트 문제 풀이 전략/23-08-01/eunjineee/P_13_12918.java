package PGS_BOOK.CH04.CH04_02;

public class P_13_12918 {
    public static Boolean solution(String s){
        boolean answer = false;
        if (s.length() == 4 || s.length() == 6){
            answer = s.matches("[0-9]*");
            Boolean answer2 = s.matches("[0-9]*");
            System.out.println(answer2);
        }
        return answer;
    }

    // 4,6자리인 경우도 {}를 사용할 수 있음
    // return 값을 따로 저장하지 않고 바로 return 할 수 있음
    public boolean book_solution(String s) {
        return s.matches("[0-9]{4}|[0-9]{6}");
    }

    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }
}
