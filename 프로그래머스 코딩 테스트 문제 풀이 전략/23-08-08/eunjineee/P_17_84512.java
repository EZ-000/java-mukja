package PGS_BOOK.CH05;


// (5 + 5**2 + 5**3 + 5**4 + 5**5)*5 = 19525회
// 1초 (1억 회)에 한참 못 미치는 작은 수치
// 완전 탐색해도 괜찮음

import java.util.ArrayList;
import java.util.List;

public class P_17_84512 {
    private static final char[] CHARS = "AEIOU".toCharArray();

    // 하나로 묶여있지 않는데도 인덱스로 순서를 뽑아오는게 맞는지
    // return으로 계속 날리는 방법이 신박함
    private static List<String> generate(String word){
        List<String> words = new ArrayList<>();
        words.add(word);
        if (word.length() == 5) return words;
        for (char c : CHARS){
            words.addAll(generate(word + c));
        }
        System.out.println(words);
        return words;
    }

    public static int book_solution(String word){
        return generate("").indexOf(word);
    }

    // 최적화된 방법
    private static void generate2(String word, List<String> words){
        words.add(word);

        if (word.length() == 5) return;
        for (char c : CHARS){
            generate2(word + c, words);
        }
    }

    public static int book_solution2(String word){
        List<String> words = new ArrayList<>();
        generate2("",words);
        return words.indexOf(word);
    }

    public static void main(String[] args) {
        System.out.println(book_solution("AAAAE"));
        System.out.println(book_solution("AAAE"));
        System.out.println(book_solution("I"));
        System.out.println(book_solution("EIO"));
        System.out.println(book_solution2("AAAAE"));
        System.out.println(book_solution2("AAAE"));
        System.out.println(book_solution2("I"));
        System.out.println(book_solution2("EIO"));
    }
}