public class Solution19 {
    public int[] solution(int brown, int yellow) {
        for (int i = 3; i <= 5000; i++) {
            for (int j = 3; j <= i; j++) {
                int std = (i + j - 2) * 2;
                if (brown == std && yellow == (i * j) - std) return new int[]{i, j};
            }
        }
        return null;
    }
}
