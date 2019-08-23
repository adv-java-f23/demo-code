package java112.demos;

import java.io.*;

/** Demonstrate reading a text file and displaying each file line
 * to the console
 *
 * @author pwaite
 */

public class ReadDemo {

    /** Use BufferedReader to read a file line by line
     *  and output each line to the console
     * @param args command line arguments
     */
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            //FileReader reader = new FileReader("input.txt");
            //BufferedReader bufferedReader = new BufferedReader(reader);
            //line below is the equivalent of the two lines above
            reader = new BufferedReader(new FileReader("input.txt"));

            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (FileNotFoundException fileNotFoundExeption) {   // cup
            System.out.println("File was not found.");
            fileNotFoundExeption.printStackTrace();
        } catch (IOException iOException) {    // bowl
            System.out.println("File could not be read.");
            iOException.printStackTrace();
        } catch (Exception exception) {  //bucket
            System.out.println("There was problem.");
            exception.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception exception) {
                System.out.println("There was problem closing the file.");
                exception.printStackTrace();
            }

        }
    }

}
