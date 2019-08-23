package java112.demos;

import java.io.*;

/** Demonstrate writing a file
 *
 * @author pwaite
 */

public class WriteDemo {
    /** create a file, write to the file
     *
     * @param args command line args
     */
    public static void main(String[] args) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            writer.println("A first line in my new file");
            writer.println("A second line in my new file");
        } catch (IOException iOException) {
            System.out.println("There was a problem writing the file");
            iOException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem...");
            exception.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

}
