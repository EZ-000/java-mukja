public class P6 {
    public String solution1(String s, int n) {
        String caesarCipher = "";
        for (int index = 0; index < s.length(); index++) {
            char nowChar = s.charAt(index);
            char newChar = (char) ((nowChar == ' ') ? ' ' : nowChar + n);
            if (64 < nowChar && nowChar < 91) {
                if (90 < newChar) {
                    newChar = (char) (newChar % 91 + 65);
                }
            } else if (96 < nowChar && nowChar < 123) {
                if (122 < newChar) {
                    newChar = (char) (newChar % 123 + 97);
                }
            }
            caesarCipher += newChar;
        }
        return caesarCipher;
    }

    public String solution2(String s, int n) {
        String caesarCipher = "";
        for (int index = 0; index < s.length(); index++) {
            char nowChar = s.charAt(index);
            char newChar = (char) ((nowChar == ' ') ? ' ' : nowChar + n);
            if ('A' <= nowChar && nowChar <= 'Z') {
                if ('Z' < newChar) {
                    newChar = (char) (newChar % ('Z' + 1) + 'A');
                }
            } else if ('a' <= nowChar && nowChar <= 'z') {
                if ('z' < newChar) {
                    newChar = (char) (newChar % ('z' + 1) + 'a');
                }
            }
            caesarCipher += newChar;
        }
        return caesarCipher;
    }

    private char push(char c, int n) {
        if (!Character.isAlphabetic(c)) return c;

        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }

    public String solution3(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            builder.append(push(c, n));
        }
        return builder.toString();
    }
}
