public class P10 {
    // 내 풀이
    public int[] solution1(String s) {
        int changeCnt = 0;
        int zeroCnt = 0;
        while (!s.equals("1")) {
            changeCnt += 1;

            String newS = s.replace("0", "");
            zeroCnt += s.length() - newS.length();

            s = Integer.toString(newS.length(), 2);
        }

        return new int[] {changeCnt, zeroCnt};
    }

    // 책 답안
    private int countZeros(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }
        return zeros;
    }

    public int[] solution2(String s) {
        int loop = 0;
        int removed = 0;
        while (!s.equals("1")) {
            int zeros = countZeros(s);
            loop += 1;
            removed += zeros;

            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }

        return new int[] {loop, removed};
    }
}
