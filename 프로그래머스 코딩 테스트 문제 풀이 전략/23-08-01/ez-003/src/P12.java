public class P12 {
    // 내 풀이
    public int solution1(String s) {
        s = s.replace("zero","0");
        s = s.replace("one","1");
        s = s.replace("two","2");
        s = s.replace("three","3");
        s = s.replace("four","4");
        s = s.replace("five","5");
        s = s.replace("six","6");
        s = s.replace("seven","7");
        s = s.replace("eight","8");
        s = s.replace("nine","9");
        return Integer.valueOf(s);
    }

    // 책 답안
    private static final String[] words = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    public int solution2(String s) {
        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
