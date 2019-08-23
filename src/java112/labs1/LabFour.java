package java112.labs1;

import java.io.*;
/**
*  The main class file for Lab Four
*  @author lbusch
*/
public class LabFour{
    /**
    *  This is the main method
    *
    *  @param args - the command line arguments
    */
    public static void main(String[] args){

        // a LabFour object so I can call the run method
        LabFour lab = new LabFour();

        int arrayLength = args.length;
        System.out.println("Number of command line args: " + arrayLength);

        // check the number of command line arguments
        if(args.length == 1) {

            lab.run(args[0]);

        } else {
            System.out.println("Please restart the program and enter exactly one command line argument.");
            // print out a message that there needs to be one argument, then exit the program
        }
    }
    /**
    *   The main processing method of the class
    *
    *   @param argument the name of the file to examine
    */
    private void run(String argument) {
        // print out the value passed to the method for verification
        System.out.println("Passed to the run method: " + argument);

        BufferedReader inputReader = null;

        try {
            // open the input file
            inputReader = new BufferedReader(new FileReader("in.txt"));
            // loop through the lines of the input file, read them in and print them out

            while(inputReader.ready()){
                System.out.println(inputReader.readLine());
            }
            // close the input file after all lines are written
        } catch (FileNotFoundException fileNotFound){
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception generalException) {
            generalException.printStackTrace();
        } finally {
            try {
                if (inputReader != null) {
                    inputReader.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } // end finally

    } // end run()

} // end class LabFour
