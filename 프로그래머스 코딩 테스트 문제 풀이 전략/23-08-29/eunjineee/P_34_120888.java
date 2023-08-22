package PGS_BOOK.CH09;

import java.util.HashSet;
import java.util.Set;

public class P_34_120888 {
    public static String solution(String my_string){
        Set<Character> strings = new HashSet<>();   //HashSet에 모으고, string으로도 같이 출력
        String new_string = "";
        for (char c : my_string.toCharArray()){
            if (!strings.contains(c)){
                strings.add(c);
                new_string += c;
            }
        }
        return new_string;
    }

    //책과 거의 동일한 방식
    //StringBuilder를 사용하면 더 편리함
    public static String book_solution(String myString){
        Set<Character> used = new HashSet<>();

        StringBuilder builder = new StringBuilder();
        for (char c : myString.toCharArray()){
            if (used.contains(c)) continue;
            used.add(c);
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("We are the world"));
        System.out.println(book_solution("We are the world"));
    }
}
