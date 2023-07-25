// 3진법 뒤집기

public class Solution9 {
    public int solution(int n) {
        String std = Integer.toString(n, 3);
        String reversed = new StringBuilder(std).reverse().toString();
        return Integer.valueOf(reversed, 3);
    }
}
