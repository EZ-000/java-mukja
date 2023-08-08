package PGS_BOOK.CH06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_19_42842 {
    public static ArrayList getAnswer(int yellow){
        ArrayList answer = new ArrayList<>();
        for (int i = (int) Math.sqrt(yellow); i > 0; i--){
            if (yellow % i == 0){
                answer.add(new int[] {i, yellow/i});
            }
        }
        return answer;
    }

    public static int[] solution(int brown, int yellow){
        ArrayList answer = getAnswer(yellow);
        List<Integer> total = new ArrayList<>();
        for (Object obj : answer){
            // 이 과정이 왜 있어야하는지 모르겠음
            int[] arr = (int[]) obj;
            ////////////////////////
            int a = arr[0];
            int b = arr[1];
            if ((a+b)*2+4 == brown){
                total.add(b+2);
                total.add(a+2);
            }
        }
        return total.stream().mapToInt(i -> i).toArray();
    }

    // 책에서 단계 나누는거 좋아하는거 같아서
    // 그렇게 했는데 책은 단순화되어 있을 때의 마음은..?ㅎ
    public int[] book_solution(int brown, int yellow){
        // 가로세로 3이상이라는 조건하에 시작
        // 완전탐색으로 진행
        for (int width = 3; width <= 5000; width++){
            for (int height = 3; height <= width; height++){
                int boundary = (width + height -2) * 2;
                int center = width * height -boundary;
                if (brown == boundary && yellow == center){
                    return new int[] {width, height};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10,2)));
        System.out.println(Arrays.toString(solution(8,1)));
        System.out.println(Arrays.toString(solution(24,24)));
    }
}
