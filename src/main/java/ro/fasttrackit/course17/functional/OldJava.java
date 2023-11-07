package ro.fasttrackit.course17.functional;

public class OldJava {
    // public static void doSomething(String s) {
    // 1000 lines code
    // a custom piece of code:
    // --> 1. s = s.toLowercase();
    // --> 2. s = s.toUppercase();
    // 1000 lines of code
    // }

    // public static void doSomething(String s) {
    // 1000 lines code
    // s = s.toLowercase();
    // 1000 lines of code
    // }

    // public static void doSomething(String s) {
    // 1000 lines code
    // s = s.toUppercase();
    // 1000 lines of code
    // }

    public static void main(String[] args) {
        // 1000 lines of code
        String s = "Alex";
        System.out.println(transformString(s, new ToLowerCaseTransformer()));
        System.out.println(transformString(s, new ToUpperCaseTransformer()));

        System.out.println(transformString(s, new StringTransformer() {
            @Override
            public String transform(String s) {
                return s.substring(0, s.length() / 2).toUpperCase() + s.substring(s.length() / 2).toLowerCase();
            }
        }));
    }

    public static String transformString(String s, StringTransformer transformer) {
        return transformer.transform(s);
    }
}

interface StringTransformer {
    String transform(String s);
}

class ToUpperCaseTransformer implements StringTransformer {
    public String transform(String s) {
        return s.toUpperCase();
    }
}

class ToLowerCaseTransformer implements StringTransformer {
    public String transform(String s) {
        return s.toLowerCase();
    }
}
