// 코드를 참고하면서 문제를 풀었는데
// 더 간결하고 가독성 좋게 문제 푸는 것이 중요할 듯!!
package PGS_BOOK.CH04;

public class P_70129 {

    public static int ZeroDelete(String s){
        int zero_num = 0;
        for (char c: s.toCharArray()){
            if (c == '0') zero_num ++;
        }
        return zero_num;
    }

    public static int[] solution(String s) {
        int repeat = 0;
        int zero = 0;
        while (!s.equals("1")){
            zero += ZeroDelete(s);
            s = Integer.toString(s.length()-ZeroDelete(s), 2);
            repeat += 1;
        }
        return new int[] {repeat, zero};
    }


    private static int countZeros(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }
        return zeros;
    }
    // 책 코드가 간결해보임 노력 할 것!
    public static int[] book_solution(String s) {
        int loop = 0;
        int removed = 0;
        while (!s.equals("1")) {
            int zeros = countZeros(s);
            loop += 1;
            removed += zeros;
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }
        return new int[] {loop, removed};
    }

    public static void main(String[] args) {
        System.out.println(solution("110010101001"));
        System.out.println(book_solution("110010101001"));
    }
}
