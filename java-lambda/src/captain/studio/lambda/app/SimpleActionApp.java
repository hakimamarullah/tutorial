package captain.studio.lambda.app;

import captain.studio.lambda.SimpleAction;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleActionApp {
    public static void main(String[] args) {
        Consumer<String> a = (name) -> System.out.printf(name);
        Predicate<Integer> b = number -> number % 2 == 0;
        Function<String, Boolean> c = value -> {
            for(int i=0; i<value.length()/2; i++){
                if(value.charAt(i) != value.charAt(value.length()- i - 1)){
                    return false;
                }
            }
            return true;
        };

        System.out.println(c.apply("a"));
        a.accept("Hakim Nisdar");
    }


}
