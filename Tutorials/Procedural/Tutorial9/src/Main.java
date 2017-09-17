import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        int[] randomArray; // Simple Array

        int[] numberArray = new int[10]; // Array created with size 10

        randomArray = new int[20];
        randomArray[1] = 2;


        String[] stringArray = {"just" , "random" , "words"};
        //random numbers from Array
        for(int i = 0; i < numberArray.length; i++)
        {
            numberArray[i] = i;
        }
        //Creating box by Arrays
        //Bound
        int k = 1;
        while( k <= 41)
        {
            System.out.print('-');
            k++;
        }
        System.out.println();

        // Bound like '|'
        for(int j = 0; j < numberArray.length;j++)
        {
            System.out.print("| " + j + " ");
        }
        System.out.println("|");

        String[][] multiArray = new String[10][10];

        // how long is row
        for(int i = 0; i < multiArray.length; i++)
        {
            // how long is column
            for(int j = 0; j < multiArray[i].length;j++)
            {
                multiArray[i][j] = i + " " + j;
            }
        }
        k = 1;
        while( k <= 61)
        {
            System.out.print('-');
            k++;
        }
        System.out.println();

        //Output 2x Array
        // how long is row
        for(int i = 0; i < multiArray.length; i++)
        {
            // how long is column
            for (int j = 0; j < multiArray[i].length; j++)
            {
                System.out.print("|" + multiArray[i][j] + " ");
            }
            System.out.println();
        }

        k = 1;
        while( k <= 61)
        {
            System.out.print('-');
            k++;
        }
        System.out.println();
        //Default Array Output
        for(int row : numberArray)
        {
            System.out.print(row);
        }
        System.out.println("\n");

        for (String[] rows : multiArray) // Creating Rows
        {
            for (String column : rows) // creating 0 1 , 0 2
            {
                System.out.print("| " + column + " ");
            }
            System.out.println("|");
        }

        int[] numberCopy = Arrays.copyOf(numberArray, 5);
        //Default Array Output
        for(int row : numberCopy)
        {
            System.out.print(row);
        }
        System.out.println("\n");

        //Arrays.copyOfRange(numberArray,3,6);

        System.out.println(Arrays.toString(numberCopy));

        int[] moreNumbers = new int[100];
        Arrays.fill(moreNumbers, 2);

        /*char[][] boardGame = new char[10][10];
        for(char[] row : boardGame)
        {
            Arrays.fill(row, '*');
        }*/

        int[] numsToSort = new int[10];

        for(int i = 0; i < 10; i++)
        {
            numsToSort[i] = (int) (Math.random() * 101);
        }
        Arrays.sort(numsToSort);
        System.out.println(Arrays.toString(numsToSort));

        int whereIs50 = Arrays.binarySearch(numsToSort,50);

        System.out.println(whereIs50);
    }
}