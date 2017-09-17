public class Main {
    public static void main(String[] args)
    {
        int randomNumber = (int) (Math.random() * 50);

        /* Relational Operators:
         * Java has 6 relational operators
         * > : Greater Than
         * < : Less Than
         * == : Equal To
         * != : Not Equal To
         * >= : Greater Than or Equal To
         * <= : Less Than or Equal To
         */

        if(randomNumber < 25)
        {
            System.out.println("The random number is less than 25");
        }
        else if(randomNumber > 40)
        {
            System.out.println("The random number is greater than 40");
        }
        else if(randomNumber == 18)
        {
            System.out.println("The random number is eqial to 18");
        }
        else if(randomNumber != 40)
        {
            System.out.println("The random number is not equal to 40");
        }
        else if(randomNumber <= 40)
        {
            System.out.println("The random number is less than or equal to 40");
        }
        else if(randomNumber >= 18)
        {
            System.out.println("The random number is greater than or equal to 18");
        }
        else
        {
            System.out.println("Nothink Worked");
        }

        /* Logical Operators:
         * Java has 6 logical operators
         * ! : Converts the boolean value to its right to its opposite form ie. true to false
         * & : Returns true if boolean value on the right and left are both true (Always evaluates both boolean values)
         * && : Returns true if boolean value on the right and left are both true (Stops evaluating after first false)
         * | : Returns true if either boolean value on the right or left are true (Always evaluates both boolean values)
         * || : Returns true if either boolean value on the right or left are true (Stops evaluating after first true)
         * ^ : Returns true if there is 1 true and 1 false boolean value on the right or left
         */

        if(!(false))
        {
            System.out.println("\nI turned false into true");
        }

        if((false) && (true))
        {
            System.out.println("Both are true"); // not true because of false and true together
        }
        if((true) | (true))
        {
            System.out.println("One is true"); // not true because of false and true together
        }
        if((false) ^ (true))
        {
            System.out.println("One is true"); // not true because of false and true together
        }
        System.out.println("The random number is = " + randomNumber);

        //Ternary operator
        int valueOne = 1;
        int valueTwo = 2;
        //Ternary operator
        int biggestValue = (valueOne > valueTwo) ? valueOne : valueTwo;

        System.out.println(biggestValue);

        //switch
        char theGrade = 'b';

        switch (theGrade)
        {
            case 'a':
            case 'A':
                System.out.println("Great job");
                break;
            case 'b':
            case 'B':
                System.out.println("Good job");
                break;
            case 'c':
            case 'C':
                System.out.println("Ok job");
                break;
            case 'd':
            case 'D':
                System.out.println("Bad");
                break;
            default:
                System.out.println("You Failed");
                break;

        }
    }
}
