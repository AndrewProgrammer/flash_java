import Monster.Monster;

import java.util.Scanner;

public class Main {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        Monster Frank = new Monster();// new Object of constructor method

        Frank.name = "Frank"; // name is public;

        System.out.println(Frank.name + "has an attack of" + Frank.getAttack());
        //Doesn`t work because of simple private field
        //without public getter to attack
         //System.out.println(Frank.attack); // private field because mian is inside of class
    }
}