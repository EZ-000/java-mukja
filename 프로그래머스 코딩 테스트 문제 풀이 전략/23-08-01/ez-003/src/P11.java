public class P11 {
    // 내 풀이
    boolean solution1(String s) {
        int cntP = 0;
        int cntY = 0;

        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == 'P' || s.charAt(index) == 'p') cntP += 1;
            else if (s.charAt(index) == 'Y' || s.charAt(index) == 'y') cntY += 1;
        }

        return (cntP == cntY) ? true : false;
    }

    // 책 답안
    boolean solution2(String s) {
        s = s.toLowerCase();

        int ps = s.length() - s.replace("p","").length();
        int ys = s.length() - s.replace("y","").length();

        return ps == ys;
    }

    boolean solution3(String s) {
        int ps = 0;
        int ys = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'P', 'p' -> ps++;
                case 'Y', 'y' -> ys++;
            }
        }

        return ps == ys;
    }

    // 다른 사람의 풀이
    boolean solution4(String s) {
        int count = 0;

        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == 'P' || s.charAt(index) == 'p') count += 1;
            else if (s.charAt(index) == 'Y' || s.charAt(index) == 'y') count -= 1;
        }

        return (count == 0) ? true : false;
    }
}
