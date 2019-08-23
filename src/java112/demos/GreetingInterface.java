package java112.demos;

/**
 * @author Eric Knapp
 */
public interface GreetingInterface {

    default String createGreeting(String person, String greeting) {
        return greeting + ", " + person + "!";
    }

}
