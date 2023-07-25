public class P7 {
    // 내 풀이
    public String solution1(String s) {
        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            String nowChar = String.valueOf(s.charAt(i));
            if (nowChar.equals(" ")) {
                builder.append(nowChar);
                flag = true;
            } else if (flag) {
                builder.append(nowChar.toUpperCase());
                flag = false;
            } else {
                builder.append(nowChar.toLowerCase());
                flag = true;
            }
        }
        return builder.toString();
    }

    // 책 답안
    public String solution2(String s) {
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                builder.append(c);
                toUpper = true;
            } else {
                if (toUpper) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        return builder.toString();
    }

    // 다른 사람의 풀이
    public String solution3(String s) {
        String answer = "";
        int index = 0;
        String[] chars = s.split("");

        for (String c : chars) {
            index = c.equals(" ") ? 0 : index + 1;
            answer += (index % 2 == 0) ? c.toLowerCase() : c.toUpperCase();
        }

        return answer;
    }

    public String solution4(String s) {
        char[] chars = s.toCharArray();
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') index = 0;
            else chars[i] = (index++ % 2 == 0)
                    ? Character.toUpperCase(chars[i])
                    : Character.toLowerCase(chars[i]);
        }
        return String.valueOf(chars);
    }
}
