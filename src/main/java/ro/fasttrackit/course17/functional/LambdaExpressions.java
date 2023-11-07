package ro.fasttrackit.course17.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExpressions {
    public static void main(String[] args) {
        Function<Integer, Double> function = LambdaExpressions::myMethod;
        System.out.println(function.apply(2));
        System.out.println("=============================================");

        tryFunction(a -> a + 1);
        tryFunction(a -> a * 10);

        trySupplier(() -> "Hello");
//        trySupplier(() -> {
//            Scanner scanner = new Scanner(System.in);
//            return scanner.nextLine();
//        });

        tryPredicate(i -> i < 10);
        tryPredicate(i -> i % 2 == 0);

        tryConsumer(LambdaExpressions::validateString);

        NewJava newJava = new NewJava();

        Function<Integer, Integer> testFunction = newJava::doubleValue;
    }

    public static void tryConsumer(Consumer<String> consumer) {
        // 100 lines of code
        String s = "test";
        consumer.accept(s);
    }

    public static void tryPredicate(Predicate<Integer> tester) {
        // 100 lines of code
        int a = 10;
        if (tester.test(a)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        // 100 lines of code
    }

    public static void trySupplier(Supplier<String> stringSupplier) {
        String s = stringSupplier.get();
        // 100 lines of code that use the supplied string
        System.out.println(s);
    }

    public static void tryFunction(Function<Integer, Integer> incrementer) {
        // 100 lines of code
        int i = 4;
        System.out.println(incrementer.apply(i));
        // 100 lines of code
    }

    private static double myMethod(Integer a) {
        a = a + 1;
        return a * 2;
    }

    private static void validateString(String s) {
        if (s.equalsIgnoreCase("hello")) {
            throw new RuntimeException();
        }
    }
}
