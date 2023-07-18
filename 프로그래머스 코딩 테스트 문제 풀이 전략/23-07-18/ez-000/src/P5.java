public class P5 {
    public int[] solution1(long n) {
        String strN = n + "";
        char[] numbers = strN.toCharArray();

        int length = numbers.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = numbers[length - i - 1] - 48;
        }
        return result;
    }

    public int[] solution2(long n) {
        String strN = n + "";
        String[] numbers = strN.split("");

        int length = numbers.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = Integer.valueOf(numbers[length - i - 1]);
        }
        return result;
    }

    public int[] solution3(long n) {
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();

        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i] - '0';
        }
        return result;
    }
}
