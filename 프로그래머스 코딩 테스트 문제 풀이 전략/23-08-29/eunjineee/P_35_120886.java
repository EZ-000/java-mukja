package PGS_BOOK.CH09;

import java.util.HashMap;
import java.util.Map;

public class P_35_120886 {
    //처음 생각했던 방법이었으나, replace를 잘못 사용함
    public static Integer solution(String before, String after){
        for (char b : before.toCharArray()){
            if (after.contains(String.valueOf(b))) {
                after.replace(b,' ');
            } else {
                return 0;
            }
        }
        for (char a : after.toCharArray()){
            if (a != ' '){
                return 0;
            }
        }
        return 1;
    }

    // hashmap을 dictionary로 사용하는 방법
    public static Map<Character, Integer> toMap (String word){
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    public static Integer book_solution(String before, String after) {
        return toMap(before).equals(toMap(after)) ? 1:0;
    }

    public static void main(String[] args) {
        System.out.println(book_solution("olleh","hello"));
        System.out.println(book_solution("allpe","apple"));
    }
}
