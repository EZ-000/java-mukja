public class Solution11 {
    boolean solution(String s) {
        String str = s.toUpperCase();
        int pCount = 0;
        int yCount = 0;

        for (char c : str.toCharArray()) {
            if (c == 'P') pCount += 1;
            if (c == 'Y') yCount += 1;
        }

        return pCount == yCount;
    }
}
