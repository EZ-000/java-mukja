import java.util.Arrays;
import java.util.List;

public class Solution25 {
    public int solution(int[] citations) {
       Arrays.sort(citations);
        for (int i = citations.length; i > 0; i--) {
            int idx = citations.length - i;
            if (citations[idx] >= i) return i;
        }
        return 0;
    }
}
