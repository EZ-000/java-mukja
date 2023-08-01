public class Solution14 {
    // 3자 이상 15자 이하
    // 소문자, 숫자, -, _, .
    // .는 처음과 끝에 그리고 연속으로 사용 안 됨
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");
        new_id = new_id.replaceAll("\\.+", ".");
        new_id = new_id.replaceAll("^\\.+|\\.+$", "");
        if (new_id.isEmpty()) new_id = "a";
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.+$", "");
        }
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        return new_id;
    }
}
