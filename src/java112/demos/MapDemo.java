package java112.demos;

import java.util.*;
import java.io.*;

/** Demonstrate the use of the Map interface, specifically the HashMap class.
 *
 *  @author pawaite
 */

 public class MapDemo {
     /** Start the Map demo.
      *
      * @param args command line arguments (not used in this demo)
      */
     public static void main(String[] args) {
         MapDemo demo = new MapDemo();
         demo.run();
     }

     /** Create a HashMap object, add some key/values, and display the map
      *  to the console.
      */
     public void run() {

        // Create a HashMap object
        Map<Integer, String> myMap = new HashMap<Integer, String>();

        // add some key/values
        myMap.put(2, "two");
        myMap.put(1, "hello");
        myMap.put(10, "goodbye");

        System.out.println(myMap);

        // for each "thing" in my "list" ... do something
        // for (String myString : listOfStrings)... do something

        // entrySet returns a Set of Map.Entry (which is a key:value pair)
        for (Map.Entry<Integer, String> entry : myMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
            
        }











     }
 }
