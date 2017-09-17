import java.util.Scanner;

public class JavaLessonTwo
{
    static Scanner userInput = new Scanner(System.in);

    public static  void main(String[] args)
    {
        System.out.print("Your favorite number: ");

        if(userInput.hasNextInt())
        {
            int numberEntered = userInput.nextInt();

            System.out.println("You entered " + numberEntered);

            int numEnteredTimes2 = numberEntered + numberEntered;
            System.out.println(numberEntered + " + " + numberEntered + " = " + numEnteredTimes2);

            int numEnteredMinus2 = numberEntered - 2;
            System.out.println(numberEntered + " - 2  = " +  numEnteredMinus2);

            int numEnteredTimesSelf = numberEntered * numberEntered;
            System.out.println(numberEntered + " + " + numberEntered + " = " + numEnteredTimesSelf);

            int numEnteredDivide2 = numberEntered / 2;
            System.out.println(numberEntered + " / 2  = " + numEnteredDivide2);

            int numEnteredRemainder = numberEntered % 2;
            System.out.println(numberEntered + " % 2  = " + numEnteredRemainder);

            numberEntered += 2;
            numberEntered -= 2;

            numberEntered *= 2;
            numberEntered /= 2;

            numberEntered %=2;

            numberEntered--;
            numberEntered++;

            int numberABS = Math.abs(numberEntered);
            int whicIsBigger = Math.max(5,7); // 7
            int whicIsSmaller = Math.min(5, 7); // 5

            double numSqrt = Math.sqrt(5.23); // Sqrt() Root

            int numCeiling = (int) Math.ceil(5.23); // 6 around to high

            int numFloor = (int) Math.floor(5.23); // 5 around to low

            int numRound = (int) Math.round(5.63); // Simple round

            int randomNumber = (int) (Math.random() * 11); // randoming number

            System.out.println("Random Number = " + randomNumber);
            System.out.println("Number which is Bigger = " + whicIsBigger);
            System.out.println("Number which is Smaller = " + whicIsSmaller);
            System.out.println("Sqrt = " + numSqrt);
            System.out.println("Ceiling = " + numCeiling);
            System.out.println("Floor = " + numFloor);
            System.out.println("Rounded number = " + numRound);
            System.out.println("ABS = " + numberABS);



        }else
        {
            System.out.println("Enter an integer next time");
        }

    }
}