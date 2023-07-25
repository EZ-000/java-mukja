package PGS_BOOK.CH04;

public class P_68935 {
    public static int solution(int n) {
        StringBuilder rev_str = new StringBuilder();
        rev_str.append(Integer.toString(n,3));
        rev_str.reverse();
        int answer = Integer.parseInt(rev_str.toString(), 3);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));
    }

    public int book_solution(int n) {
        String str = Integer.toString(n, 3);
        String reversed = new StringBuilder(str).reverse().toString();  // 압축에 압축 ~.,~
        return Integer.valueOf(reversed, 3);
    }
}
