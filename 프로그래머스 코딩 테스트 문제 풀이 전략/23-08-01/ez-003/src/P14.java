public class P14 {
    // 내 풀이 - 2단계는 모르겠어서 책 확인
    public String solution1(String newId) {
        // 1단계
        newId = newId.toLowerCase();
        // 2단계
        newId = newId.replaceAll("[^a-z0-9\\-_.]","");
        // 3단계
        newId = newId.replaceAll("\\.{2,}",".");
        // 4단계
        newId = newId.replaceAll("^\\.|\\.$","");
        // 5단계
        newId = (newId.isEmpty()) ? "a" : newId;
        // 6단계
        newId = (16 <= newId.length()) ? newId.substring(0, 15) : newId;
        newId = newId.replaceAll("\\.$","");
        // 7단계
        int length = newId.length();
        String last = String.valueOf(newId.charAt(length - 1));
        newId = (length < 3) ? newId + last.repeat(3 - length) : newId;
        return newId;
    }

    // 책 답안
    public String solution2(String newId) {
        newId = newId.toLowerCase();
        newId = newId.replaceAll("[^a-z0-9\\-_.]","");
        newId = newId.replaceAll("\\.+",".");
        newId = newId.replaceAll("^\\.+|\\.+$","");
        if (newId.isEmpty()) newId = "a";
        if (16 <= newId.length()) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("\\.+$","");
        }
        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() - 1);
        }
        return newId;
    }

    // 다른 사람의 풀이
    public String solution3(String newId) {
        return new KakaoId(newId)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();
    }

    private static class KakaoId {
        private String s;

        KakaoId(String s) {
            this.s = s;
        }

        private KakaoId replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KakaoId filter() {
            s = s.replaceAll("[^a-z0-9._-]","");
            return this;
        }

        private KakaoId toSingleDot() {
            s = s.replaceAll("[.]{2,}",".");
            return this;
        }

        private KakaoId noStartEndDot() {
            s = s.replaceAll("^\\.|\\.$","");
            return this;
        }

        private KakaoId noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KakaoId noGreaterThan16() {
            if (16 <= s.length()) {
                s = s.substring(0, 15);
                s = s.replaceAll("[.]$","");
            }
            return this;
        }

        private KakaoId noLessThan2() {
            while (s.length() < 3) {
                s += s.charAt(s.length() - 1);
            }
            return this;
        }

        private String getResult() {
            return s;
        }
    }
}
