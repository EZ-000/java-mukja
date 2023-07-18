class P_12932 {
    public int[] solution(long n) {
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Character.getNumericValue(arr[i]);
        }
        return result;
    }
}