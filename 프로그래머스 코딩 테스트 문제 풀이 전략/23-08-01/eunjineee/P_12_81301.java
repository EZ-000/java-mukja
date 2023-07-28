// 책에서 딕셔너리 사용할 것 같아서 하나하나 replace 해봤음
// s = s.replace로 s에 저장해줘야 한다
package PGS_BOOK.CH04.CH04_02;

public class P_12_81301 {
    public static int solution(String s) {
        s = s.replace("zero","0");
        s = s.replace("one","1");
        s = s.replace("two","2");
        s = s.replace("three","3");
        s = s.replace("four","4");
        s = s.replace("five","5");
        s = s.replace("six","6");
        s = s.replace("seven","7");
        s = s.replace("eight","8");
        s = s.replace("nine","9");
        return Integer.parseInt(s);
    }

    private static final String[] words = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
    };

    public static int book_solution(String s){
        for (int i=0; i < words.length; i++){
            s = s.replace(words[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
        System.out.println(book_solution("one4seveneight"));
        System.out.println(book_solution("23four5six7"));
        System.out.println(book_solution("2three45sixseven"));
        System.out.println(book_solution("123"));
    }
}
