package PGS_BOOK.CH05;

import java.util.Arrays;

public class P_15_68936 {
    // 미리 카운트 클래스를 만들고 시작
    // add를 만드는 것도 개발할 때 파일을 나눠서 하던게 생각이 났다
    // 알고 문제풀때도 다르게 접근해야겠다
    private static class Count{
        public final int zero;
        public final int one;

        public Count(int zero, int one){
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other){
            return new Count(zero + other.zero, one + other.one);
        }
    }

    private static Count count(int offsetX, int offsetY, int size, int[][] arr){
        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++){
            for (int y = offsetY; y < offsetY + size; y++){
                if (arr[y][x] != arr[offsetY][offsetX]){
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY+ h, h, arr));
                }
            }
        }
        if (arr[offsetY][offsetX] == 1){
            return new Count(0,1);
        }
        return new Count(1,0);
    }


    public static int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }

    // 배열 입력 방법
    // int[ ] 출력하는 방법
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
