import java.util.Arrays;
import java.util.List;

/**
 * Created by bandi on 1/7/2016.
 */
public class MyList  {
    public static void main(String[] args){
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//In Java 8:
        features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach((String n) -> System.out.println(n));

        System.out.println("*******************************************************");
// Even better use Method reference feature of Java 8
// method reference is denoted by :: (double colon) operator
// looks similar to score resolution operator of C++
        features.forEach(System.out::println);


//        Read more: http://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html#ixzz3waAWLqBU

    }
}
