public class Solution12 {
    public int solution(String s) {
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replace(strings[i], numbers[i]);
        }
        System.out.println(s);
        return Integer.parseInt(s);
    }
}
