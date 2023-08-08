public class P19 {
    // 내 풀이
    public int[] solution1(int brown, int yellow) {
        int[] answer = new int[2];
        int plus = (brown + 4) / 2;
        int multi = brown + yellow;

        for (int w = 3; w < multi; w++) {
            int h = multi / w;
            if (multi % w == 0 & w == plus - h) {
                answer[0] = (h < w) ? w : h;
                answer[1] = (h < w) ? h : w;
            }
        }
        return answer;
    }

    // 책 답안
    public int[] solution2(int brown, int yellow) {
        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                int boundary = (width + height - 2) * 2;
                int center = width * height - boundary;
                if (brown == boundary & yellow == center) {
                    return new int[] {width, height};
                }
            }
        }
        return null;
    }

}
