package java112.labs1;

/** Another lab to practice with TDD. This class ensures the user types a single
 *  argument at the command line and then outputs that argument at the console
 *
 *@author pwaite
 */
public class LabThree {

    /**
     * Verifies a single argument is entered at the command line, and if not, outputs
     * a message to the user. If a single argument is entered, a method is called to
     * output the entered argument.
     *
     *@param args command line arguments
     */
    public static void main(String[] args) {
        LabThree lab = new LabThree();

        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            lab.run(args[0]);
        }
    }

    /** Outputs the parameter preceded by "input: ".
     *@param input user input value
     */
    public void run(String input) {
        System.out.println("input: " + input);
    }
}
