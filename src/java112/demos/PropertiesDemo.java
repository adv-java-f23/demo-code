package java112.demos;

import java.util.*;
import java.io.*;

/** Demonstrate the use of the Properties class.
 *
 *  @author pawaite
 */

 public class PropertiesDemo {
     /** Start the properties demo.
      *
      * @param args command line arguments (not used in this demo)
      */
     public static void main(String[] args) {
         PropertiesDemo demo = new PropertiesDemo();
         demo.run();
     }

     /** Create a properties object, load properties, and display the properties
      *  to the console.
      */
     public void run() {
         //instantiate a Properties object
         Properties properties = new Properties();

         // read in the file (loading up the key value pairs from the file)
         try {
            properties.load(this.getClass().getResourceAsStream("/demo.properties"));

            // write out the author property
            System.out.println("Author property is: " + properties.getProperty("author"));

            // get all the properties
            Set<String> propertyNames = properties.stringPropertyNames();

            // display those Properties
            System.out.println("The set of property names: " + propertyNames);
            System.out.println();

            // display the key-value pairs (property name and its corresponding value)
            for (String key : propertyNames) {
                System.out.println("The key is: " + key + ". The value is " +
                        properties.getProperty(key));

            }



        } catch (IOException ioException) {
            System.out.println("There was a problem reading the properties file");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem...");
            exception.printStackTrace();
        }




     }

 }
