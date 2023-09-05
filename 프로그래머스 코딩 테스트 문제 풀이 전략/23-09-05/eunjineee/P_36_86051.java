package PGS_BOOK.CH09;

import java.util.HashSet;
import java.util.Set;

public class P_36_86051 {

    // 45라는 최대 숫자에서 numbers의 숫자들만 빼주는 방식으로 하면
    // 매번 0-9까지 안돌아도 되니 시간 단축되지않을까! 라는 생각
    public static int solution(int[] numbers) {
        int answer = 45;
        Set<Integer> arr = new HashSet<>();
        for (int i : numbers){
            arr.add(i);
        }

        for (int j : arr){
            answer -= j;
        }

        return answer;
    }

    // HashSet에도 Integer로 타입지정해주기
    public int book_solution(int[] numbers) {
        Set<Integer> set = new HashSet<Integer>();
        for (int v : numbers) {
            set.add(v);
        }

        // 0부터 9까지 돌면서 확인하기
        int sum = 0;
        for (int n = 0; n <= 9; n++) {
            if (set.contains(n)) continue;
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] int_arr = {1,2,3,4,6,7,8,0};
        System.out.println(solution(int_arr));
    }

}
