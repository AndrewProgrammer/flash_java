import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner userInput = new Scanner(System.in);
    //static double myPI = 3.14159; // Class Variable
    static int randomNumber; // Class Variable

    public static void main(String[] args)
    {
        //System.out.println("c = " + addThem(1,2));
        //System.out.println("Global " + myPI);

        /*int d = 5;
        tryToChange(d);

        System.out.println("main d = " + d); // original d*/

        System.out.println("random number from method : " + getRandomNum());

        int guessResult = 1;
        int randomGuess = 0;

        while(guessResult != -1) // true
        {
            System.out.println("Guess a number between 0 and 50: ");
            
            randomGuess = userInput.nextInt();

            guessResult = checkGuess(randomGuess);
        }

        System.out.println("Yes the random number is " + randomGuess);

    }

    public static int getRandomNum() {
        randomNumber = (int) (Math.random() * 50);
        return randomNumber;
    }

    public static int checkGuess(int guess)
    {
        if(guess == randomNumber)
        {
            return -1;
        }
        else
        {
            return guess;
        }
    }

    /*public static  void tryToChange (int d)
    {
        d+=1;
        System.out.println("tryToChange version of d = " + d); // local d
    }*/

    /*public static int addThem(int a, int b)
    {
        *//*double localPI = 3.140; // Local Variable

        myPI += 3.0;

        System.out.println("Local " + myPI);*//*

        int c = a + b;

        return c;
    }*/
}
