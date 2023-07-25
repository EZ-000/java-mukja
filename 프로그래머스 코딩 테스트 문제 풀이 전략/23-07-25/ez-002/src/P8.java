import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class P8 {
    // 내 풀이
    private int getCompressedLength(String s, int u) {
        StringBuilder builder = new StringBuilder();
        String now = s.substring(0, u);
        int cnt = 1;
        for (int index = u; index < s.length() + 1; index += u) {
            int end = (s.length() <= index + u) ? s.length() : index + u;
            String next = s.substring(index, end);
            if (now.equals(next)) {
                cnt += 1;
            } else {
                if (cnt == 1) {
                    builder.append(now);
                } else {
                    builder.append(cnt + "" + now);
                }
                cnt = 1;
            }
            now = next;
        }
        builder.append(now);
        return builder.length();
    }

    public int solution1(String s) {
        int answer = 1001;
        for (int unit = 1; unit <= s.length(); unit++) {
            int compressedLength = getCompressedLength(s, unit);
            if (compressedLength < answer) {
                answer = compressedLength;
            }
        }
        return answer;
    }

    // 책 답안
    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex < source.length()) endIndex = source.length();
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }

    private int compress(String source, int length) {
        StringBuilder builder = new StringBuilder();

        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (1 < count) builder.append(count);
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        if (1 < count) builder.append(count);
        builder.append(last);

        return builder.length();
    }

    public int solution2(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length(); length++) {
            int compressed = compress(s, length);
            if (compressed < min) {
                min = compressed;
            }
        }
        return min;
    }
}
