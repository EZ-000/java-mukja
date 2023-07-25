// 문자열 압축
public class Solution8 {
    public static int alzip(String string, int start, int size) {
        if (start + size * 2 <= string.length() && string.substring(start, start + size).equals(string.substring(start + size, start + size * 2))) {
            return alzip(string, start + size, size) + 1;
        } else {
            return 1;
        }
    }
    public int solution(String s) {
        int answer = s.length();
        for (int size = 1; size < s.length() / 2 + 2; size++) {
            int idx = 0;
            int length = 0;
            while (idx + size < s.length()) {
                int n = alzip(s, idx, size);
                if (n > 1) {
                    idx += size * n;
                    length += size + String.valueOf(n).length();
                } else {
                    idx += size;
                    length += size;
                }
            }
            length += s.length() - idx;
            if (length < answer) {
                answer = length;
            }
        }

        return answer;
    }
}
