package captain.studio.lambda;

import javax.xml.transform.sax.SAXResult;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class MapForEach {
    public static void main(final String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("firstname", "Nisdar");
        map.put("lastname","Fazilla");

        Function<String, String> function = String::toLowerCase;
        System.out.println(function.apply("HAKIM"));

        map.forEach((key, value) -> System.out.println(value));

        Consumer<String> getName = name -> {
            Optional.ofNullable(name)
                    .map(value -> value.toUpperCase())
                    .ifPresent( value -> System.out.print("Hello " + value));
        };

        Function<String, Integer> countVocal = value ->{
            int counter = 0;
            value = value.toLowerCase();
            for(char x : value.toCharArray()){
                if(x == 'a' || x == 'i' || x == 'u' || x == 'e' || x == 'o')
                    counter++;
            }
            return counter;
        };

        System.out.println(countVocal.apply("hakim"));
        System.out.println(countVocal.apply("NisdAr"));


        getName.accept("Nisdar");

    }
}
