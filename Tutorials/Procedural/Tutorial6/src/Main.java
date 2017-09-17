import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.*;
import java.lang.RuntimeException;
import java.lang.Exception;
//Exceptions in Java that exist:
//1 ArithmeticException
//2 ClassNotFoundException
//3 IllegalArgumentException
//4 IndexOutOfBoundsExceptions // Goind from Bounds of Array
//5 InputMismatchException - // Not correct inputed type of value
//6 IOException  - //create File that already exists
public class Main {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        //divideByZero(2);

       /* System.out.print("How old are you? ");
        int age = checkValidAge();

        if(age != 0)
        {
            System.out.println("You are" + age + " yeats old");
        }*/

        // ( 1 )
        try
        {
            getAFile("./somestuff.txt"); // Simple file that doesn`t exists

        } catch (IOException e)
        {
            System.out.println("An IO Error Occured");
        }


    }
    // when we add in Signature of method throws and Types of Exception,
    // it hits method in main, tries to give you information that it won`t work
    // and because of that we use block of try and catch in main ( 1 )
    public static void getAFile(String fileName) throws IOException, FileNotFoundException
    {

        FileInputStream file = new FileInputStream(fileName);

    }
   /* public static void getAFile(String fileName)
    {
        try
        {
            FileInputStream file = new FileInputStream(fileName); // Buffer that inputs file
        }
        catch (FileNotFoundException e) // specific expection
        {
            System.out.println("Sorry can`t find that file");
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

        catch (IOException e) // exactly expection that we need
        {
            System.out.println("Unknown IO Error");
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        //catch (ClassNotFoundException | IOException e ) {} // method Exception catch only in Java 7,
        // that give you access to use 2 Exceptions in one catch by symbol |

        catch(Exception e) // Exception that catch all errors
        {
            System.out.println("Some error occured");
        }
        finally // Clean-up. Exit Exception
        {
            System.out.println("All Files and Threads of dates are closed");
        }
    }*/
    /*public static int checkValidAge()
    {
        try
        {
            return  userInput.nextInt();
        }
        catch (InputMismatchException e) // e - object for exception itself
        {
            userInput.next();
            System.out.println("That isn`t a whole number");
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }*/
    /*public static void divideByZero(int a)
    {
        try
        {
            System.out.println(a / 0);
        }
        catch (ArithmeticException e)
        {
            System.out.println("You can`t divide by zero");

            System.out.println(e.getMessage()); // Java Message of Exception

            System.out.println(e.toString()); //really good comment

            e.printStackTrace(); // Output error, like not an exception
        }
    }*/
}
