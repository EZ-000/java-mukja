import java.util.Arrays;

public class P25 {
    private boolean isValid(int[] citations, int h) {
        int index = citations.length - h;
        return h <= citations[index];
    }
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int h = citations.length; 1 <= h; h--) {
            if (isValid(citations, h)) return h;
        }
        return 0;
    }
}
