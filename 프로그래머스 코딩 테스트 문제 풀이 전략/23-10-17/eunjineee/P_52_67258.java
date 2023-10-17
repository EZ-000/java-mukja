package PGS_BOOK.CH11.CH11_03;

import java.util.*;

public class P_52_67258 {
    // 풀었던 파이썬 코드 자바로 변환
    // 왜 안되는지 잘 모르겠음!
    public static int[] solution(String[] gems){
        int N = gems.length;
        int[] answer = new int[]{0, N-1};
        int kind = 0;
        Map<String, Integer> dic = new HashMap<>();
        int s=0, e=0;

        while (s < N && e < N) {
            if (dic.size() < kind) {
                e++;
                if (e == N) {
                    break;
                }
                dic.put(gems[e], dic.getOrDefault(gems[e], 0) + 1);
            } else {
                if (e - s + 1 < answer[1] - answer[0] + 1) {
                    answer[0] = s;
                    answer[1] = e;
                }
                if (dic.get(gems[s]) == 1) {
                    dic.remove(gems[s]);
                } else {
                    dic.put(gems[s], dic.get(gems[s]) - 1);
                }
                s++;
            }
        }
        answer[0]++;
        answer[1]++;
        return answer;
    }

    public static int[] book_solution(String[] gems) {
        int start = 0;
        int end = gems.length - 1;

        Set<String> gemSet = new HashSet<>(List.of(gems));

        int s = 0;
        int e = s;
        Map<String, Integer> includes = new HashMap<>();
        includes.put(gems[s], 1);

        while (s < gems.length) {
            if (includes.keySet().size() == gemSet.size()) {
                if (e - s < end - start) {
                    start = s;
                    end = e;
                }

                includes.put(gems[s], includes.get(gems[s]) - 1);
                if (includes.get(gems[s]) == 0) {
                    includes.remove(gems[s]);
                }
                s++;
            } else if (e < gems.length - 1) {
                e++;
                includes.put(gems[e], includes.getOrDefault(gems[e], 0) + 1);
            } else {
                break;
            }
        }

        return new int[] {start + 1, end + 1};
    }

    public static void main(String[] args) {
        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString((book_solution(gems1))));
    }
}
