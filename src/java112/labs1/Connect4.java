/*
 *  TODO 1. Where do these comments end up?
 *  Class: Connect4
 *  Author: Your Name Here
 *  Create date: 1/20/2009
 *  Description: This class creates a command line connect 4 game.
 */

package java112.labs1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/** TODO 2. Where does this comment show up in the javadoc. What about this comment?
  * And this one?
  * @author TODO 3. how/when/where is this used?
  * @created TODO 4. is this valid?
  * @param TODO 5. how/when/where is this used? What is the proper format, i.e.,
  *          should I include variable type, name?
  * @return TODO 6. how/when/where is this used? What is the proper format?
  * @throws TODO 7. how/when/where is this used? What is the proper format?
  * @see TODO 8. how/when/where is this used? What is the proper format?
  * @since TODO 9. how/when/where is this used? What is the proper format?
  *
  * TODO 10. Where does this comment (below the tags) appear?
  * TODO 11. Add some html tags within your comments above to improve formatting and readibility
  */

public class Connect4
/** TODO 12. How does this comment affect the javadoc? */
{
    final static int GRID_WIDTH=7;
    final static int GRID_HEIGHT=5;

    public static boolean GAME_OVER=false;
    public static boolean NoughtGo = true;
    public static String tTeam = "Nought";
    public static int[][] aGrid = new int[GRID_WIDTH][GRID_HEIGHT];
    public static boolean COMPUTER_GO = false;
    public static int TURN_NUMBER=0;

    public static int X=0; //The actual X co-ordinate on the board (1-7)
    public static int Y=0; //The actual Y co-ordinate on the board
    public static boolean VALID=false;

	/** TODO 13. Write proper javadoc for this method. Think about What exceptions should be javadoc'd here?**/
    public static void main(String[] pArgs) throws IOException
    {
		/** TODO 14. How does this comment affect the javadoc? */
        for (int rows=0; rows < GRID_HEIGHT; rows++){
            for (int columns=0; columns < GRID_WIDTH; columns++){
                aGrid[columns][rows] = 0;
            }
        }
        printgrid(aGrid);


        while (!GAME_OVER){

            VALID=false;
            GetMove();

            if (Y==-1){
                GAME_OVER=true;
                System.exit(1);
            }

            if (FindY(X-1)) {
                System.out.println("Find X " + FindY(X-1) + " " + X);


                if (NoughtGo){
                    aGrid[X-1][Y-1]=-1;
                    NoughtGo=false;
                    tTeam = "Cross";
                }
                else{
                    aGrid[X-1][Y-1]=1;
                    NoughtGo=true;
                    tTeam="Nought";

                }
                printgrid(aGrid);
                checkmove(aGrid);

                TURN_NUMBER++;
                if (TURN_NUMBER == (GRID_WIDTH*GRID_HEIGHT)){
                    System.out.println("Game Over - It's a Draw");
                    System.exit(1);
                }

            }else{
                System.out.println("Illegal move - try again " + X + "," + Y);
            }

        }

        if(GAME_OVER){
            GameOverProc();
        }
    }

	/** TODO 15. Write proper javadoc for this method. Should any exceptions be documented here?**/
 
    public static void printgrid(int[][] aGrid)
    {
        for (int rows=GRID_HEIGHT-1; rows>=0; rows--){
            System.out.print("* ");
            for (int columns=0; columns<GRID_WIDTH; columns++){
                if ((aGrid[columns][rows]) == -1)
                {
                    System.out.print(" 0");
                }
                else if((aGrid[columns][rows]) == 1)
                {
                    System.out.print(" X");
                }
                else{
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
        System.out.println("   1 2 3 4 5 6 7");
    }


    public static void checkmove(int[][] aGrid)
    {
        //Check Rows
        for (int rows=0; rows < GRID_HEIGHT; rows++){
            for (int columns=0; columns < GRID_WIDTH-3; columns++){
                int tCheck = (aGrid[columns][rows]) + (aGrid[columns+1][rows]) + (aGrid[columns+2][rows]) + (aGrid[columns+3][rows]);
                if (tCheck == -4 || tCheck == 4)
                {
                    System.out.println("A Winner!");
                    System.exit(1);
                }
            }
        }


        //Check Columns
        for (int rows=0; rows < GRID_HEIGHT-3; rows++){
            for (int columns=0; columns < GRID_WIDTH; columns++){
                int tCheck = (aGrid[columns][rows]) + (aGrid[columns][rows+1]) + (aGrid[columns][rows+2]) + (aGrid[columns][rows+3]);
                if (tCheck == -4 || tCheck == 4)
                {
                    System.out.println("A Winner!");
                    System.exit(1);
                }
            }
        }


        //Check Diagonals (SW-NE)
        for (int rows=0; rows < GRID_HEIGHT-3; rows++){
            for (int columns=0; columns < GRID_WIDTH-3; columns++){
                int tCheck = (aGrid[columns][rows]) + (aGrid[columns+1][rows+1]) + (aGrid[columns+2][rows+2]) + (aGrid[columns+3][rows+3]);
                if (tCheck == -4 || tCheck == 4)
                {
                    System.out.println("A Winner!");
                    System.exit(1);
                }
            }
        }


        //Check Diagonals (NW-SE)
        for (int rows=0; rows < GRID_HEIGHT-3; rows++){
            for (int columns=0; columns < GRID_WIDTH-3; columns++){
                int tCheck = (aGrid[columns][rows]) + (aGrid[columns+1][rows+1]) + (aGrid[columns+2][rows+2]) + (aGrid[columns+3][rows+3]);
                if (tCheck == -4 || tCheck == 4)
                {
                    System.out.println("A Winner!");
                    System.exit(1);
                }
            }
        }


        //Check Diagonals (NE-SW)
        for (int rows=0; rows < GRID_HEIGHT-3; rows++){
            for (int columns=3; columns < GRID_WIDTH; columns++){
                int tCheck = (aGrid[columns][rows]) + (aGrid[columns-1][rows+1]) + (aGrid[columns-2][rows+2]) + (aGrid[columns-3][rows+3]);
                if (tCheck == -4 || tCheck == 4)
                {
                    System.out.println("A Winner!");
                    System.exit(1);
                }
            }
        }
    }



    public static void GameOverProc()
    {
        System.out.println("Game Over " + tTeam + " Won!");
    }


    //I never got time to add the code for the computer to make a move
    public static void ComputerMove()
    {

        for (int rows=0; rows<3; rows++){
            for (int columns=0; columns<3; columns++){
            }
        }
    }

	/** TODO 16. Write proper javadoc for this method. Should any exceptions be documented here?**/
    public static void GetMove() throws IOException
    {
        while (!VALID){
            try{
                String tInput = NeilClass.GetInputString("Where do you want to put your " + tTeam + " eg(2)");
                final BufferedReader tKeyboard = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer tTokensOnLine = new StringTokenizer(tInput, ",");

                String tThisToken = tTokensOnLine.nextToken();
                X = new Integer(tThisToken).intValue();

                if (X<=GRID_WIDTH || X==-1){
                    VALID=true;
                }
                else{
                    GetMove();
                }

            }
            catch(NumberFormatException e){
                System.out.println("Invalid Co-ordinate");

            }
            catch(NoSuchElementException e){
                System.out.println("Invalid Co-ordinate");
            }
        }
    }

	/** TODO 17. Write proper javadoc for this method. Should any exceptions be documented here?**/
    public static boolean FindY(int X)
    {
        boolean FOUND=false;
        boolean RETURN_VALUE=false;
        int rows=0;

        while (!FOUND){
            if (rows==GRID_HEIGHT)
            {
                RETURN_VALUE=false;
                FOUND=true;
            }
            else{
                if ((aGrid[X][rows]) == 0)
                {
                    System.out.println(rows);
                    Y = rows+1;
                    FOUND=true;
                    RETURN_VALUE=true;
                }
                rows++;
            }
        }
        return RETURN_VALUE;
    }
}










