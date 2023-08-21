import java.util.Arrays;
import java.util.stream.Collectors;

public class P28 {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((n1, n2) -> {
                    int original = Integer.parseInt(n1 + n2);
                    int reversed = Integer.parseInt(n2 + n1);
                    return reversed - original;
                })
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0");
    }
}
