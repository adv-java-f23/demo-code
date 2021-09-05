package java112.demos;

import java.util.*;

/** Demonstrate using the Set Interface and Hashset concrete class.
 *
 * @author pwaite
 */

public class SetDemo {

    /** Create a set, add strings to the set, and display the set.
     */

     public void run() {
         Set<String> set = new HashSet<String>();

         set.add("one");
         set.add("one");
         set.add("one");
         set.add("abc");
         set.add("123");
         set.add("three");
         set.add("three");
         set.add("one");

         System.out.println(set);

         for (String element : set) {
             System.out.println("The element is: " + element);
         }
     }



    /** Instantiate the Demo class and start it running.
     *
     * @param args command line arguments (not used in this case)
     */
     public static void main(String[] args) {
         SetDemo demo = new SetDemo();
         demo.run();
     }
}
