package PGS_BOOK.CH04;

public class P_12930 {

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        for (char so : s.toCharArray()) {
            if (so == ' ') {
                index = 0;
                answer.append(' ');
            }else{
                // 인덱스가 단어의 홀수 짝수를 결정
                // 인덱스는 0부터, 0은 짝수
                if (index%2 == 0) {
                    answer.append(Character.toUpperCase(so));
                } else {
                    answer.append(Character.toLowerCase(so));
                }
                index += 1;
            }

        }
        return answer.toString();
    }

    public static String book_solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean toUpper = true;                       // 내 코드랑 차이점

        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {        // 알파벳이 아니면,
                answer.append(c);
                toUpper = true;
            }else{
                if (toUpper) {
                    answer.append(Character.toUpperCase(c));
                } else {
                    answer.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;                    // boolean 잘 쓰는 법!!
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
        System.out.println(book_solution("try hello world"));
    }
}
