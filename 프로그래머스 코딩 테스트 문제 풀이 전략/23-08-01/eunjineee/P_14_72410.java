package PGS_BOOK.CH04.CH04_02;

public class P_14_72410 {
    public static String solution(String s){
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9\\-_.]","");
        s = s.replaceAll("\\.+",".");
        s = s.replaceAll("^\\.","");
        s = s.replaceAll("\\.$","");
        if (s.length() == 0){
            s = "a";
        } else if (s.length() >= 16) {
            s = s.substring(0,15);
            s = s.replaceAll("\\.$", "");
        }
        while (s.length() < 3){
            s += s.substring(s.length()-1,s.length());
        }
        return s;
    }

    // 정규표현식에서도 | 를 사용해서 and로 사용할 수 있음!
    // _, . 등은 \\로 감싸서 escape sequence 역할을 해 주어야 함
    public String book_solution(String newId) {
        newId = newId.toLowerCase();
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
        newId = newId.replaceAll("\\.+", ".");
        newId = newId.replaceAll("^\\.+|\\.+$", "");
        if (newId.isEmpty()) newId = "a";
        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("\\.+$", "");
        }
        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() - 1);
        }

        return newId;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }
}
