package PGS_BOOK.CH09;

import java.util.HashMap;
import java.util.Map;

public class P_37_42576 {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();

        for (String s: participant){
            count.putIfAbsent(s, 0);
            count.put(s, count.get(s)+1);
        }

        for (String c: completion){
            int v = count.get(c) -1;
            count.put(c,v);
            if (v==0) count.remove(c);
        }
        // HashMap의 마지막 원소를 가져오는 방법
        return count.keySet().iterator().next();
    }

    public static void main(String[] args) {
        String[] p = {"leo", "kiki", "eden"};
        String[] c = {"eden", "kiki"};
        System.out.println(solution(p,c));
    }
}
