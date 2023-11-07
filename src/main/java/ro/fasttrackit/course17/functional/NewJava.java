package ro.fasttrackit.course17.functional;

import java.util.function.Function;

public class NewJava {
    public static void main(String[] args) {
        // 1000 lines of code
        String s = "Alex";
        System.out.println(transformString(s, String::toUpperCase));
        System.out.println(transformString(s, String::toLowerCase));
        System.out.println(transformString(s, NewJava::customTransform));
        String modifiedString = transformString(s, str -> str.toUpperCase());
    }

    public static String transformString(String s, Function<String, String> transformer) {
        // s.toUppercase
        return transformer.apply(s);
    }

    private static String customTransform(String word) {
        return word.substring(0, word.length() / 2).toUpperCase()
                + word.substring(word.length() / 2).toLowerCase();
    }

    public int doubleValue(int a) {
        return a * 2;
    }

    public Function<Integer, Integer> doubleFunction() {
        return this::doubleValue;
    }
}
