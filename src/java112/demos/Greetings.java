package java112.demos;

/**
 * @author Eric Knapp
 * class Greetings
 */
public class Greetings implements GreetingInterface {

        /**
         * Run this demo.
         * @param arguments The command line arguments.
         */
        public static void main(String[] arguments) {
            Greetings greeting = new Greetings();
            System.out.println(greeting.createGreeting("John Smith", "Hello"));
        }

}
