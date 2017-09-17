package MonsterTwo;

import java.util.Arrays;

// Basic class definition
// public means this class can be used by other classes
// Class names should begin with a capital letter
// A file can't contain two public classes. It can contain classes that are not public
// If you place class files in the same folder the java compiler will be able to find them

public class MonsterTwo
{

    static char[][] battleBoard = new char[10][10];

    public static void buildBattleBoard()
    {
        for(char[] row : battleBoard)
        {
            Arrays.fill(row,'*');
        }
    }

    public static void redrowBoard()
    {
        //Bound Up
       int k = 1;
       while (k <= 30)
       {
           System.out.print('-');
           k++;
       }
        System.out.println();
       // Our Main field with stars and Bounds ( * and | )
       for(int i = 0; i < battleBoard.length; i++)
       {
           for(int j = 0; j < battleBoard[i].length; j++) // number of spaces in each row so it is battleBoard[i]
           {
               System.out.print("|" + battleBoard[i][j] + "|");
           }
           System.out.println();
       }
       // Bound Below
        k = 1;
        while (k <= 30)
        {
            System.out.print('-');
            k++;
        }
        System.out.println();

    }

    public final  String TOMBSTONE = "Here Lies a Dead monster"; // final = const , so it is constant String

    private int health = 500;
    private int attack = 20;
    private int movement = 2;
    private boolean alive = true;

    public String name = "Big Monster";
    public char nameChar1 = 'B'; // name of Monster by 1 symbol
    public int xPosition = 0;
    public int yPosition = 0;

    public  static int numberOfMonsters = 0;

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getMovement() {
        return movement;
    }

    public boolean isAlive() {
        return alive;
    }

    // Overloading
    // You can create multiple versions using the same method name
    // Now setHealth can except an attack that contains decimals
    // When overloading a method you can't just change the return type
    // Focus on creating methods that except different parameters

    public  void setHealth(int decreaseHealth)
    {
        health -= decreaseHealth;
        if(health < 0)
        {
            alive = false;
        }
    }
    // Overloading
    public void setHealth(double decreaseHealth)
    {
        int intDecreaseHealth = (int) decreaseHealth;
        health -= intDecreaseHealth;
        if(health < 0)
        {
            alive = false;
        }
    }

     /* The Constructor
     * Code that is executed when an object is created from this class definition
     * The method name is the same as the class
     * The constructor is only executed once per object
     * The constructor can't return a value
     */

    //Parametrized Constructor - name of Constructor is the same like name of Class
    public MonsterTwo (int health, int attack , int movement, String name)
    {
        this.health = health;
        this.attack = attack;
        this.movement = movement;
        this.name = name;

         /* If the attributes had the same names as the class health, attack, movement
         * You could refer to the objects fields by proceeding them with this
         * this.health = health;
         * this.attack = attack;
         * objectFieldName = attributeFieldName;
         */

         int maxXBoardSpace = battleBoard.length - 1; // Max x coordinate by row
         int maxYBoardSpace = battleBoard[0].length - 1; // Max Y coordinate by column [9,9]

         int randNumX, randNumY; // variables of coordinates where monsters will be spawn

         do {
             randNumX =(int)(Math.random() * maxXBoardSpace);
             randNumY = (int)(Math.random() * maxYBoardSpace);
         }while(battleBoard[randNumX][randNumY] != '*'); // allow monster to be spawned only on *;

        this.xPosition = randNumX;
        this.yPosition = randNumY;

        this.nameChar1 = this.name.charAt(0); // Function that allows you to use only first letter of name.
        //So first letter of name 'B' is equal to first letter of nameChar1 'B'

        battleBoard[this.yPosition][this.xPosition] = this.nameChar1; // spawn Monster with letter

        numberOfMonsters++;

    }
    //Default Constructor that we have createad by ourselves
    public MonsterTwo()
    {
        numberOfMonsters++;
    }

    public static void main(String[] args)
    {
        /*MonsterTwo Frank = new MonsterTwo(); // new Object of constructor method

        System.out.println(Frank.attack); // private field because mian is inside of class*/
    }

}
