import  java.util.Scanner;
public class Main {

    static  Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {

        int i = 1;

        while(i <= 20)
        {
            //Statement that skips 3
            if(i == 3)
            {
                i+=2;
                continue; // jumps back to the condition with while
            }
            System.out.println(i);
            i++;
            if((i%2) == 0)  // uneven number like( 1,5,7 ...)
            {
                i++;
            }

            if(i > 10)
            {
                break; // break(terminate) loop
            }

        }

        System.out.println();

        //3.14 number Pi
        double myPi = 4.0;
        double j = 3.0;

        // 4 - 4/3 + 4/5 - 4/7
        // calculating myPi

        while (j < 10001)
        {
            myPi = myPi - (4/j) + (4/(j+2));
            j+=4;
            System.out.println(myPi);
        }
        System.out.println("Value of PI: " + Math.PI);

        String contYorN = "Y";

        int h = 1;

        while (contYorN.equalsIgnoreCase("y"))
        {
            System.out.println(h);
            System.out.println("Continue y or n? ");
            contYorN = userInput.nextLine();
            h++;
        }

        int k = 10001;
        //Print 10 for sure
        do
        {
            System.out.println(k);
            k++;
        }while (k < 250);
        System.out.println();
        //for (declare iterator; conditional statement; change iterator

        for(int l = 10; l >= 1; l--)
        {
            System.out.println(l);
        }
        System.out.println();
        int m , n;

        for(m = 1, n = 2; m <= 9; m+=2, n+=2)

        {
            System.out.println(m + "\n" + n);
        }
    }
}
