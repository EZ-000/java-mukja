public class P9 {
    // 내 풀이
    public int solution1(int n) {
        String ternary = Integer.toString(n, 3);
        StringBuilder builder = new StringBuilder();
        builder.append(ternary).reverse();

        return Integer.parseInt(builder.toString(), 3);
    }
    
    // 책 답안
    public int solution2(int n) {
        String ternary = Integer.toString(n, 3);
        String reversed = new StringBuilder(ternary).reverse().toString();
        return Integer.valueOf(reversed, 3);
    }
}
