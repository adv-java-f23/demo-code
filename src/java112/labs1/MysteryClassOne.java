package java112.labs1;

/** Mystery Class One provides practice with TDD.  The class will display a number.
 *
 * @author pwaite
 */

public class MysteryClassOne {
    /** Instantiate MysteryClassOne and output the result of the mysteryMethodOne
     *  @parm args command line arguments
     */
    public static void main(String[] args) {
        MysteryClassOne lab = new MysteryClassOne();
        System.out.println("The method returned: " + lab.mysteryMethodOne());

    }

    /* return a number specified by the unit tests
     * @return single digit value may be a mystery
     */
    public int mysteryMethodOne() {
        return 1;
    }

}
